package Datastructure_lab_2016.view;

import Datastructure_lab_2016.algo.*;
import Datastructure_lab_2016.util.*;
import static javax.swing.JOptionPane.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 * The application window aka. User Interface
 * <p>
 * @author Markus J. Auvo 2016
 */
public class GUI extends JFrame
{
    // Instance variables
    StringTool ST;

    // Application properties
    private final int APP_FIXED_WIDTH = 320;
    private final int APP_FIXED_HEIGHT = 165;
    private final int ENC = 0;
    private final int DEC = 1;

    private final String APP_TITLE = "Data Encryption Standard";
    private final Image APP_ICON = Toolkit.getDefaultToolkit().createImage("resources/logo_HY.jpg");

    private final String DEFAULT_DIR = "data/";     // Default dir for demo purposes
    private File selectedFile;
    private String selectedFileName;
    private String selectedFilePath;
    private String selectedMethodName;
    private String encFilePath;
    private String decFilePath;

    // Menu bar components
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuBar menuBar;
    private JMenuItem itemOpen;
    private JMenuItem itemExit;
    private JMenuItem itemInstructions;
    private JMenuItem itemAbout;
    private final ImageIcon iconOpen = new ImageIcon("resources/icon-open-file_16x16.png");
    private final ImageIcon iconExit = new ImageIcon("resources/icon_exit_16x16.png");
    private final ImageIcon iconInstruction = new ImageIcon("resources/icon_instruction_16x16.png");
    private final ImageIcon iconAbout = new ImageIcon("resources/icon_about_16x16.png");

    // Application area components
    private JLabel fileLabel;
    private JLabel methodLabel;
    private JTextField fileName;
    private JComboBox<String> methodName;
    private JButton buttonGo;
    private final ImageIcon iconExecute = new ImageIcon("resources/icon_start_16x16.png");

    // File functionality
    private final JFileChooser FILE_CHOOSER;
    private final FileFilter JPG_FILTER;

    /**
     * Constructor
     */
    public GUI() {
        ST = new StringTool();
        FILE_CHOOSER = new JFileChooser();
        FILE_CHOOSER.setCurrentDirectory(new File(DEFAULT_DIR));
        JPG_FILTER = new FileNameExtensionFilter("JPG image file", "jpg", "jpeg");
        FILE_CHOOSER.addChoosableFileFilter(JPG_FILTER);
        selectedFile = null;
        selectedFileName = "none";
        selectedFilePath = null;
        encFilePath = null;
        decFilePath = null;
        selectedMethodName = null;
        initApplicationWindow(APP_TITLE);
    }

    /**
     * Displays an 'Open file' dialog box when the user
     * chooses 'File -> Open file' from the menu bar.
     */
    public void showOpenFile() {
        int result = FILE_CHOOSER.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = FILE_CHOOSER.getSelectedFile();
            selectedFileName = selectedFile.getName();
            selectedFilePath = selectedFile.getPath();
            selectedMethodName = getEncryptionMethod();

            if (!selectedFileName.contains("ORIGINAL")) {
                String msg = "Please, choose an ORIGINAL unprocessed file!";
                showWarning(msg);
            }
            else {
                fileName.setText(selectedFileName);
                encFilePath = ST.getEncFileName(selectedFilePath, selectedMethodName);
                decFilePath = ST.getDecFileName(selectedFilePath, selectedMethodName);
            }
        }
    }

    /**
     * Returns the name of the selected DES
     * implementation in the combo box.
     * 
     * @return The name of the selected DES implementation
     */
    public String getEncryptionMethod() {
        String currMethod = methodName.getSelectedItem().toString();
        return currMethod;
    }

    /**
     * Displays a warning dialog box with a given message.
     * 
     * @param msg Warning message to be displayed
     */
    public void showWarning(String msg) {
        JLabel warning = new JLabel(msg);
        warning.setForeground(Color.red);
        showMessageDialog(null, warning, "Attention!!", WARNING_MESSAGE);
    }

    /**
     * Displays a information dialog box with a given message.
     * 
     * @param msg Success message to be displayed
     */
    public void showSuccess(String msg) {
        JLabel success = new JLabel(msg);
        success.setForeground(new Color(0,150,0));
        showMessageDialog(null, success, "Success!!", INFORMATION_MESSAGE);
    }

    /**
     * Displays an 'Instructions' dialog box when the user
     * chooses 'Help -> Instructions' from the menu bar.
     */
    public void showInstructions() {
        String msg = "<html>";
        msg += "<p>Please name your source files according to following convention:<br>";
        msg += "<span style='color: #009600'>&lt;<i>name</i>&gt;.ORIGINAL.jpg</span></p>";
        msg += "<br>";
        msg += "<p>Select a source file and select a DES method from the dropdown menu.<br>";
        msg += "Then execute the encryption process by pressing GO!</p>";
        msg += "<br>";
        msg += "<p>The encrypted and decrypted file are stored in the same folder<br>";
        msg += "as the original source file</p>";
        msg += "</html>";
        showMessageDialog(null, new JLabel(msg), "Instructions", INFORMATION_MESSAGE);
    }

    /**
     * Displays an 'About' dialog box when the user
     * chooses 'Help -> About' from the menu bar.
     */
    public void showAbout() {
        String msg = "<html>";
        msg += "<center><span style='color: #009600'>";
        msg += "Datastructure Lab Assignment 2016";
        msg += "</center></span><br>";
        msg += "<p>Markus J. Auvo.</p>";
        msg += "</html>";
        showMessageDialog(null, new JLabel(msg), "About", INFORMATION_MESSAGE);
    }

    /**
     * Creates and initialises an individual
     * 'Open file' menu item for the menu bar.
     */
    public void buildItemOpen() {
        itemOpen = new JMenuItem("Open file...", iconOpen);
        itemOpen.addActionListener((ActionEvent event) -> {
            showOpenFile();
        });
    }

    /**
     * Creates and initialises an individual
     * 'Exit' menu item for the menu bar.
     */
    public void buildItemExit() {
        itemExit = new JMenuItem("Exit", iconExit);
        itemExit.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
    }

    /**
     * Creates and initialises an individual
     * 'Instructions' menu item for the menu bar.
     */
    public void buildItemInstructions() {
        itemInstructions = new JMenuItem("Instructions", iconInstruction);
        itemInstructions.addActionListener((ActionEvent event) -> {
            showInstructions();
        });
    }

    /**
     * Creates and initialises an individual
     * 'About' menu item for the menu bar.
     */
    public void buildItemAbout() {
        itemAbout = new JMenuItem("About", iconAbout);
        itemAbout.addActionListener((ActionEvent event) -> {
            showAbout();
        });
    }

    /**
     * Builds the individual menu items.
     */
    public void buildMenuItems() {
        buildItemOpen();
        buildItemExit();
        buildItemInstructions();
        buildItemAbout();
    }

    /**
     * Creates and initialises individual menus for menu bar.
     */
    public void buildMenus() {
        buildMenuItems();

        // Create the menus
        menuFile = new JMenu("File");
        menuHelp = new JMenu("Help");

        // Add items to the menus
        menuFile.add(itemOpen);
        menuFile.add(itemExit);
        menuHelp.add(itemInstructions);
        menuHelp.add(itemAbout);
    }

    /**
     * Creates and initialises the application menu bar.
     */
    public void buildMenuBar() {
        this.buildMenus();

        // Create the menu bar
        menuBar = new JMenuBar();

        // Add the menus to the menu bar
        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        // Voilá!!
        setJMenuBar(menuBar);
    }

    /**
     * Creates and initialises the 'Selected file' label.
     */
    public void buildLabelSelectedFile() {
        fileLabel = new JLabel();
            fileLabel.setText("Selected file");
            fileLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            fileLabel.setMaximumSize(new java.awt.Dimension(80, 15));
            fileLabel.setMinimumSize(new java.awt.Dimension(80, 15));
            fileLabel.setPreferredSize(new java.awt.Dimension(80, 15));
    }

    /**
     * Creates and initialises the 'Selected file' text field.
     */
    public void buildFieldSelectedFile() {
        fileName = new JTextField();
            fileName.setText(selectedFileName);
            fileName.setEnabled(true);
            fileName.setEditable(false);
            fileName.setMinimumSize(new java.awt.Dimension(30, 20));
            fileName.setFont(new Font("Serif", Font.PLAIN, 12));
    }

    /**
     * Creates and initialises the 'Selected method' label.
     */
    public void buildLabelSelectedMethod() {
        methodLabel = new JLabel();
            methodLabel.setText("Selected method");
            methodLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            methodLabel.setMaximumSize(new java.awt.Dimension(80, 15));
            methodLabel.setMinimumSize(new java.awt.Dimension(80, 15));
            methodLabel.setPreferredSize(new java.awt.Dimension(80, 15));
    }

    /**
     * Creates and initialises the 'Selected method' combo box.
     */
    public void buildComboSelectedMethod() {
        methodName = new JComboBox<>();
            methodName.setModel(new javax.swing.DefaultComboBoxModel<>
                (new String[] { "MyDES", "JavaDES" }));
            methodName.addActionListener((ActionEvent event) -> {
                selectedMethodName = getEncryptionMethod();
                selectedFileName = fileName.getText();
                if (!selectedFileName.equals("none")) {
                    encFilePath = ST.getEncFileName(selectedFilePath, selectedMethodName);
                    decFilePath = ST.getDecFileName(selectedFilePath, selectedMethodName);
                    //displayFileInfo();
                }
            });
    }

    /**
     * Creates and initialises the 'GO!' button.
     */
    public void buildButtonGo() {
        buttonGo = new JButton("G O ", iconExecute);
        buttonGo.setVerticalTextPosition(SwingConstants.CENTER);
        buttonGo.setHorizontalTextPosition(SwingConstants.LEFT);
        buttonGo.addActionListener((ActionEvent event) -> {
            selectedFileName = fileName.getText();
            if (selectedFileName.contains("none")) {
                String msg = "Please, choose a file!";
                showWarning(msg);
            }
            else {
                try {
                    System.out.println("\n\nINPUT FILE:\t" + selectedFileName);
                    System.out.println("ENCRYPTED FILE:\t" + ST.getEncFileName(selectedFileName, selectedMethodName));
                    System.out.println("DECRYPTED FILE:\t" + ST.getDecFileName(selectedFileName, selectedMethodName));
                    doCipher(selectedMethodName, encFilePath, decFilePath);
                }
                catch (Exception ex) {
                }
            }
        });
    }

    /**
     * Executes the encryption/decryption process
     * when the user presses 'GO!' button.
     * 
     * @param method Chosen DES implementation
     * @param encFile The name of the encrypted file
     * @param decFile The name of the decrypted file
     * @throws Exception 
     */
    public void doCipher(String method, String encFile, String decFile) throws Exception {
        if (method.equals("MyDES")) {
            MyDES MyWay = new MyDES();
            MyWay.execute(ENC, selectedFilePath, encFilePath);
            MyWay.execute(DEC, encFilePath, decFilePath);
            String msg = "File '" + selectedFileName + "' was encrypted and decrypted successfully using " + method;
            showSuccess(msg);
        }
        else if (method.equals("JavaDES")) {
            JavaDES JavaWay = new JavaDES();
            JavaWay.encryptImage(selectedFilePath, encFilePath);
            JavaWay.decryptImage(encFilePath, decFilePath);
            String msg = "File '" + selectedFileName + "' was encrypted and decrypted successfully using " + method;
            showSuccess(msg);
        }
    }

    /**
     * Creates and initialises the application area.
     */
    public void buildAppArea() {
        buildLabelSelectedFile();
        buildFieldSelectedFile();
        buildLabelSelectedMethod();
        buildComboSelectedMethod();
        buildButtonGo();
    }

    /**
     * Sets up the application area layout.
     */
    public void buildAppLayout() {
        org.jdesktop.layout.GroupLayout mainLayout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(mainLayout);

        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap()
                .add(mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, mainLayout.createSequentialGroup()
                .add(10,10,10)
                .add(mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(methodLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(fileLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(buttonGo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .add(mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(methodName, 0, 180, Short.MAX_VALUE)
                        .add(fileName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(10, 10, 10)
            )
        );

        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainLayout.createSequentialGroup()
                .addContainerGap()
                .add(mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(fileLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fileName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(methodLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(methodName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(buttonGo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .addContainerGap()
            )
        );
    }

    /**
     * Creates and initialises the application window.
     * 
     * @param appTitle The name of the application in the title bar
     */
    public void initApplicationWindow(String appTitle) {
        // Set application window properties
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(appTitle);
        setIconImage(APP_ICON);
        setSize(new java.awt.Dimension(APP_FIXED_WIDTH, APP_FIXED_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);

        // Build application window components
        buildMenuBar();
        buildAppArea();

        // Build application layout
        buildAppLayout();

        // Finally, display the application window
        setVisible(true);
    }
}
