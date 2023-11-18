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


public class Authentication 
{
    protected static JFrame authFrame;
    protected static JCheckBox userTypeCheckBox;
    protected static JTextField usernameField;
    protected static JPasswordField passwordField;
    protected static JTextField emailField;
    protected static ActionListener ActivityHandler;
    protected static JButton authButton;


    

    protected static void openAuthFrame() 
    {
        // Create the main frame
        authFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        authFrame.setSize(400, 400); // Reduced frame size
        authFrame.setLayout(new GridBagLayout());

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
        //JButton authButton = new JButton(Strings.signUpButtonLabel);
        authButton.setActionCommand("Button1");

        JButton cancelButton = new JButton(Strings.cancelButtonLabel);
        cancelButton.setActionCommand("Button2");

        // Add action listener to the Sign Up button
        //ActionListener buttonHandler = new Activity_2Controller(authFrame, userTypeCheckBox, usernameField, passwordField, emailField);
        authButton.addActionListener(ActivityHandler);

        // Add action listener to the Cancel button
        cancelButton.addActionListener(ActivityHandler);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonPanel.add(authButton, constraints);

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
        authFrame.add(mainPanel);

        // Center the frame on the screen
        authFrame.setLocationRelativeTo(null);

        // Show the registration frame
        authFrame.setVisible(true);
    }

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
        //ActionListener closeDirectingListener = new Activity_2Controller(authFrame, userTypeCheckBox, usernameField, passwordField, emailField);
        Timer timer = new Timer(2000, ActivityHandler);
        timer.setActionCommand("Timer");
        timer.setRepeats(false); // Run the timer only once
        timer.start();
    }


    public static JFrame getAuthFrame() {
        return authFrame;
    }
    public static void setAuthFrame(JFrame authFrame) {
        Authentication.authFrame = authFrame;
    }
    public static JCheckBox getUserTypeCheckBox() {
        return userTypeCheckBox;
    }
    public static void setUserTypeCheckBox(JCheckBox userTypeCheckBox) {
        Authentication.userTypeCheckBox = userTypeCheckBox;
    }
    public static JTextField getUsernameField() {
        return usernameField;
    }
    public static void setUsernameField(JTextField usernameField) {
        Authentication.usernameField = usernameField;
    }
    public static JPasswordField getPasswordField() {
        return passwordField;
    }
    public static void setPasswordField(JPasswordField passwordField) {
        Authentication.passwordField = passwordField;
    }
    public static JTextField getEmailField() {
        return emailField;
    }
    public static void setEmailField(JTextField emailField) {
        Authentication.emailField = emailField;
    }
    public static ActionListener getActivityHandler() {
        return ActivityHandler;
    }
    public static void setActivityHandler(ActionListener activityHandler) {
        ActivityHandler = activityHandler;
    }
    public static JButton getAuthButton() {
        return authButton;
    }
    public static void setAuthButton(JButton authButton) {
        Authentication.authButton = authButton;
    }
    

    
}
