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

import edu.aucegypt.GamesStrore.Helpers.GUI;
import edu.aucegypt.GamesStrore.resources.Strings;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;


public class Activity_2 
{
    private static JCheckBox userTypeCheckBox;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JTextField emailField;

    
    public static void openSignUpFrame() {
        // Create the main frame
        JFrame signUpFrame = new JFrame(Strings.activityName);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setSize(800, 800);
        signUpFrame.setLayout(new GridLayout(6, 2));

        // Create components for the registration form
        JLabel userTypeLabel = new JLabel(Strings.checkBoxLabel);
        userTypeCheckBox = new JCheckBox(); // 1 is player 0 is admin
        userTypeCheckBox.setToolTipText(Strings.checkBoxTip); // Add a tooltip

        JLabel usernameLabel = new JLabel(Strings.userNameFieldLabel);
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel(Strings.userPassFieldLabel);
        passwordField = new JPasswordField();

        JLabel emailLabel = new JLabel(Strings.userMailFieldLabel);
        emailField = new JTextField();

        // Create buttons
        JButton signUpButton = new JButton(Strings.signUpButtonLabel);
        signUpButton.setActionCommand("Button1");

        JButton cancelButton = new JButton(Strings.cancelButtonLabel);
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

                    String[] credentials = GUI.extractCredentials(usernameField,passwordField,emailField);
                    boolean isPlayer = GUI.checkCheckBos(userTypeCheckBox);
                    
                    signUp(credentials, isPlayer);
                    signUpFrame.dispose();
                    Activity_1.openMainFrame();

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

    private static void signUp(String[] credentials,boolean isPlayer )
    {
        if(isPlayer)
        {
            Player player = new Player(credentials[0],credentials[1],credentials[2]);
            player.signUp();
            System.out.println("player signedup");

        }
        else
        {
            Administrator administrator = new Administrator(credentials[0],credentials[1],credentials[2]);
            administrator.signUp();
            System.out.println("admin signedup");
        }
    }

}
