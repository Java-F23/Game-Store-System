package edu.aucegypt.GamesStrore.guis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import edu.aucegypt.GamesStrore.resources.Strings;

//Sign up Activity
// a class that serves as the second frame of the application, the sign up window
public class Activity_2 
{
    private static JFrame signUpFrame;
    private static JCheckBox userTypeCheckBox;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JTextField emailField;

    //A method to open the sign up window
    public static void openSignUpFrame() 
    {
        // Create the main frame
        signUpFrame = new JFrame(Strings.activity2Name);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setSize(400, 400); // Reduced frame size
        signUpFrame.setLayout(new GridBagLayout());

        // Create constraints for the layout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // Padding around components

        // Create components for the registration form
        JLabel usernameLabel = new JLabel(Strings.userNameFieldLabel);
         usernameField = new JTextField(15); // Reduced text field size

        JLabel passwordLabel = new JLabel(Strings.userPassFieldLabel);
         passwordField = new JPasswordField(15);

        JLabel emailLabel = new JLabel(Strings.userMailFieldLabel);
         emailField = new JTextField(15);

        JLabel userTypeLabel = new JLabel(Strings.checkBoxLabel);
         userTypeCheckBox = new JCheckBox(); // 1 is player, 0 is admin
        userTypeCheckBox.setToolTipText(Strings.checkBoxTip); // Add a tooltip

        // Create a panel for the user type components
        JPanel userTypePanel = new JPanel();
        userTypePanel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        userTypePanel.add(userTypeLabel, constraints);

        constraints.gridx = 1;
        userTypePanel.add(userTypeCheckBox, constraints);

        // Create buttons
        JButton signUpButton = new JButton(Strings.signUpButtonLabel);
        signUpButton.setActionCommand("Button1");

        JButton cancelButton = new JButton(Strings.cancelButtonLabel);
        cancelButton.setActionCommand("Button2");

        // Add action listener to the Sign Up button
        ActionListener buttonHandler = new Activity_2Controller(signUpFrame, userTypeCheckBox, usernameField, passwordField, emailField);
        signUpButton.addActionListener(buttonHandler);

        // Add action listener to the Cancel button
        cancelButton.addActionListener(buttonHandler);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonPanel.add(signUpButton, constraints);

        constraints.gridx = 1;
        buttonPanel.add(cancelButton, constraints);

        // Create a panel to hold all components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        mainPanel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        mainPanel.add(emailLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(emailField, constraints);

        
        constraints.gridy++;
        mainPanel.add(userTypePanel, constraints);

        constraints.gridy++;
        mainPanel.add(buttonPanel, constraints);

        // Add the main panel to the frame
        signUpFrame.add(mainPanel);

        // Center the frame on the screen
        signUpFrame.setLocationRelativeTo(null);

        // Show the registration frame
        signUpFrame.setVisible(true);
    }
        
    
    // a small transation between frames 
    protected static void reDirectMsg()
    {
        // Create a JFrame for the welcome message
        JFrame reDirectingFrame = new JFrame("Redirecting");
        reDirectingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel for the welcome message
        JLabel label1 = new JLabel("Please wait.Redirecting.....");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        reDirectingFrame.add(label1);

        // Set the size and make the welcome frame visible
        reDirectingFrame.setSize(300, 100);
        reDirectingFrame.setLocationRelativeTo(null);
        reDirectingFrame.setVisible(true);

        // Schedule a Timer to close the welcome frame after 10 seconds
        ActionListener closeDirectingListener = new Activity_2Controller(signUpFrame, userTypeCheckBox, usernameField, passwordField, emailField);
        Timer timer = new Timer(2000, closeDirectingListener);
        timer.setActionCommand("Timer");
        timer.setRepeats(false); // Run the timer only once
        timer.start();
    }

    

}
