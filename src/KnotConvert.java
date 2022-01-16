import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class KnotConvert extends JFrame {

    //The following variables rely on the JPanel class
    private JPanel mainPanel;
    private JPanel buttonPanel;

    private JLabel knotLabel; // Variable name for SeaKnotConvert text field
    private JTextField knotField;  // SeaKnotConvert text box

    // Button
    private JButton convertButton;
    //Constants, name and the field where the result is displayed
    private JLabel convertedLabel;
    private JTextField convertedField;

    public KnotConvert() {                   //Constructor
        super("Wind speed convertor");  // Call the JFrame constructor and give it a name
        setLocationRelativeTo(null);         // Set the opening of the main window to the center of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Set an action on the close button
        setLayout(new BorderLayout());       // Create a break border for the contents of the panel

        buildMainPanel();                    // Build the main and button panel
        buildButtonPanel();

        add(mainPanel, BorderLayout.CENTER);   // Adding the button and main panel into one
        add(buttonPanel, BorderLayout.SOUTH);

        pack();                                // then we pack this content and make it visible
        setVisible(true);

        JRootPane rootPane = SwingUtilities.getRootPane(convertButton); //Makes the button the default button (pressing Enter)
        rootPane.setDefaultButton(convertButton);
    }

    private void buildMainPanel() {   // The buildMainPanel method adds titles and text fields to the main panel mainPanel
        knotLabel = new JLabel("Enter the wind speed kn/h");
        knotField = new JTextField(3);

        mainPanel = new JPanel();                                // Create a panel containing titles and text fields
        mainPanel.setLayout(new GridLayout(3, 3));    // Create a grid with 3 rows and 3 columns


        mainPanel.add(knotLabel);                                // Add title and text field to mainPanel
        mainPanel.add(knotField);

        // Adding empty space around panels with titles and fields
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 1, 10));
    }

    private void buildButtonPanel() {       //the buildButtonPanel method creates and adds the Convert button to the main and its button panel
        convertButton = new JButton("Convert");   // create convertButton.
        convertButton.addActionListener(new ConvertButtonListener());   // Register an event listener for convertButton
        buttonPanel = new JPanel();        // create buttons panel (Buttons panels)
        buttonPanel.setLayout(new BorderLayout(5, 5));
        buttonPanel.add(convertButton, BorderLayout.CENTER);   // Adding a button to the button bar (buttonPanel)
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10)); // Adding empty space (border) around panels

    }

    //Private inner class (a class that handles button clicks Convert)
    private class ConvertButtonListener implements ActionListener {
        String input;          // To hold the users input
        double knotSpeed;     // Declaration of variable used in calculations

        @Override
        public void actionPerformed(ActionEvent e) {
            knotSpeed = Double.parseDouble(knotField.getText());   // Get Input Data the user entered in the text fields.
            double convertedSpeed = knotSpeed * 0.51;

            JOptionPane.showMessageDialog(null,             // Display the Converted message box.
                    "Converted to h/sec: " + "\n" + new DecimalFormat("0.00").format(convertedSpeed));
        }

    }

    // The main method creates an instance of the KnotConvert class
    public static void main(String[] args) {
        new KnotConvert();
    }
}
