package edu.aucegypt.GamesStrore.guis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

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

    private static boolean isPlayer;
    private static String[] credentials;

    private static Player player;
    private static Administrator administrator;

    
    public static void openLogInFrame() {
    JFrame LoginFrame = new JFrame(Strings.activity3Name);
    LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    LoginFrame.setSize(400, 400); // Reduced frame size
    LoginFrame.setLayout(new GridBagLayout());

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
    JButton logInButton = new JButton(Strings.loginButtonLabel);
    logInButton.setActionCommand("Button1");

    JButton cancelButton = new JButton(Strings.cancelButtonLabel);
    cancelButton.setActionCommand("Button2");

    // Add action listener to the Sign Up button
    ActionListener buttonHandler = new ButtonHandler(LoginFrame);
    logInButton.addActionListener(buttonHandler);

    // Add action listener to the Cancel button
    cancelButton.addActionListener(buttonHandler);

    // Create a panel for the buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout());

    constraints.gridx = 0;
    constraints.gridy = 0;
    buttonPanel.add(logInButton, constraints);

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
    LoginFrame.add(mainPanel);

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

                    credentials = GUI.extractCredentials(usernameField,passwordField,emailField);
                    isPlayer = GUI.checkCheckBox(userTypeCheckBox);
                    
                    if(logIn())
                    {
                        logInFrame.dispose();
                        reDirectMsg();
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Credentials, re-enter", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    

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

    private static boolean logIn()
    {
        if(isPlayer)
        {
            player = new Player(credentials[0],credentials[1],credentials[2]);

            if(player.logIn())
            {
                System.out.println("player loggedin");
                return true;
            }
            else
            {
                return false;
            }
            
            

        }
        else
        {
            administrator = new Administrator(credentials[0],credentials[1],credentials[2]);

            if(administrator.logIn())
            {
                System.out.println("admin loggedin");
                return true;
            }
            else
            {
                return false;
            }
            
        }
        
    }
    
    private static void reDirectMsg()
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
        ActionListener closeDirectingListener = new CloseDirectingListener(reDirectingFrame);
        Timer timer = new Timer(2000, closeDirectingListener);
        timer.setRepeats(false); // Run the timer only once
        timer.start();
    }

    static class CloseDirectingListener implements ActionListener 
    {
        private JFrame loginFrame;

        public CloseDirectingListener(JFrame loginFrame) {
            this.loginFrame = loginFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            loginFrame.dispose(); // Close the welcome frame

            if(isPlayer)
            {
                Activity_1.openMainFrame(); // Open the main frame with buttons
                // to be changed
            }
            else
            {
                Activity_4.openAdminWindow(administrator);
            }
            
        }
    }
}
