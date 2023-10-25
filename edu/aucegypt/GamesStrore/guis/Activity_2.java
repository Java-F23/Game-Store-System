package edu.aucegypt.GamesStrore.guis;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


//TODO:
// Make the strings.java for activity 2
// extract the info to sign up
// check for a smooth transition

public class Activity_2 
{
    public static void openSignUpFrame() {
        // Create the main frame
        JFrame signUpFrame = new JFrame("User Registration");
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setSize(800, 800);
        signUpFrame.setLayout(new GridLayout(6, 2));

        // Create components for the registration form
        JLabel userTypeLabel = new JLabel("Are you a player or an administrator?");
        JCheckBox userTypeCheckBox = new JCheckBox();
        userTypeCheckBox.setToolTipText("Check the box if you are a player"); // Add a tooltip

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        // Create buttons
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setActionCommand("Button1");

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Button2");

        // Add action listener to the Sign Up button
        ActionListener buttonHandler = new ButtonHandler(signUpFrame);
        signUpButton.addActionListener(buttonHandler);

        // Add action listener to the Cancel button
        cancelButton.addActionListener(buttonHandler);

        // Add components to the frame
        signUpFrame.add(userTypeLabel);
        signUpFrame.add(userTypeCheckBox);
        signUpFrame.add(usernameLabel);
        signUpFrame.add(usernameField);
        signUpFrame.add(passwordLabel);
        signUpFrame.add(passwordField);
        signUpFrame.add(emailLabel);
        signUpFrame.add(emailField);
        signUpFrame.add(signUpButton);
        signUpFrame.add(cancelButton);

        // Center the frame on the screen
        signUpFrame.setLocationRelativeTo(null);

        // Show the registration frame
        signUpFrame.setVisible(true);
    }
    
    static class ButtonHandler implements ActionListener 
    {
        private JFrame signUpFrame;

        public ButtonHandler(JFrame signUpFrame) {
            this.signUpFrame = signUpFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Button1":
                    System.out.println("Button 1 was clicked.");
                    // Add your specific action for Button 1 here.
                    break;
                case "Button2":
                    System.out.println("Button 2 was clicked.");
                    // Add your specific action for Button 2 here.
                    signUpFrame.dispose();
                    Activity_1.openMainFrame();
                    break;
                default:
                    System.out.println("Unknown action command: ");
                    break;
            }
        }
    }

}
