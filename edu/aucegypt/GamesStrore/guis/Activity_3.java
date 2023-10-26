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

//Log in Activity
public class Activity_3 
{
    private static JCheckBox userTypeCheckBox;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JTextField emailField;

    
    public static void openLogInFrame() {
        // Create the main frame
        JFrame LoginFrame = new JFrame(Strings.activity3Name);
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginFrame.setSize(800, 800);
        LoginFrame.setLayout(new GridLayout(6, 2));

        // Create components for the login form
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
        JButton logInButton = new JButton(Strings.loginButtonLabel);
        logInButton.setActionCommand("Button1");

        JButton cancelButton = new JButton(Strings.cancelButtonLabel);
        cancelButton.setActionCommand("Button2");

        // Add action listener to the Sign Up button
        ActionListener buttonHandler = new ButtonHandler(LoginFrame);
        logInButton.addActionListener(buttonHandler);

        // Add action listener to the Cancel button
        cancelButton.addActionListener(buttonHandler);

        // Add components to the frame
        LoginFrame.add(userTypeLabel);
        LoginFrame.add(userTypeCheckBox);
        LoginFrame.add(usernameLabel);
        LoginFrame.add(usernameField);
        LoginFrame.add(passwordLabel);
        LoginFrame.add(passwordField);
        LoginFrame.add(emailLabel);
        LoginFrame.add(emailField);
        LoginFrame.add(logInButton);
        LoginFrame.add(cancelButton);

        // Center the frame on the screen
        LoginFrame.setLocationRelativeTo(null);

        // Show the registration frame
        LoginFrame.setVisible(true);
    }

    static class ButtonHandler implements ActionListener 
    {
        private JFrame logInFrame;

        public ButtonHandler(JFrame logInFrame) {
            this.logInFrame = logInFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Button1":
                    System.out.println("Button 1 was clicked.");

                    String[] credentials = GUI.extractCredentials(usernameField,passwordField,emailField);
                    boolean isPlayer = GUI.checkCheckBos(userTypeCheckBox);
                    
                    logIn(credentials, isPlayer);
                    logInFrame.dispose();
                    Activity_1.openMainFrame();

                    break;
                case "Button2":
                    System.out.println("Button 2 was clicked.");
                    // Add your specific action for Button 2 here.
                    logInFrame.dispose();
                    Activity_1.openMainFrame();
                    break;
                default:
                    System.out.println("Unknown action command: ");
                    break;
            }
        }

        
    }

    private static void logIn(String[] credentials,boolean isPlayer )
    {
        if(isPlayer)
        {
            Player player = new Player(credentials[0],credentials[1],credentials[2]);
            player.logIn();
            System.out.println("player loggedin");

        }
        else
        {
            Administrator administrator = new Administrator(credentials[0],credentials[1],credentials[2]);
            administrator.logIn();
            System.out.println("admin loggedin");
        }
    }
    
}
