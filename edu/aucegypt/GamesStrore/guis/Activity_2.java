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

//Sign up Activity
public class Activity_2 
{
    private static JCheckBox userTypeCheckBox;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JTextField emailField;

    
public static void openSignUpFrame() {
    // Create the main frame
    JFrame signUpFrame = new JFrame(Strings.activity2Name);
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
    ActionListener buttonHandler = new ButtonHandler(signUpFrame);
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
                    boolean isPlayer = GUI.checkCheckBox(userTypeCheckBox);
                    
                    if(signUp(credentials, isPlayer))
                    {
                        signUpFrame.dispose();
                        reDirectMsg();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Matching or Invalid Credentials, re-enter", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    

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

    private static boolean signUp(String[] credentials,boolean isPlayer )
    {
        String result;
        if(isPlayer)
        {
            Player player = new Player(credentials[0],credentials[1],credentials[2]);

             result = player.signUp();

            
            System.out.println("player signedup");

        }
        else
        {
            Administrator administrator = new Administrator(credentials[0],credentials[1],credentials[2]);
             result = administrator.signUp();
            System.out.println("admin signedup");
        }

        if (result.equals("invalid credentials") || result.equals("matching credentials"))
        {
            return false;
        }

        if(result.equals("successful signup"))
        {
            return true;
        }
        return false;
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
        private JFrame signUpFrame;

        public CloseDirectingListener(JFrame signUpFrame) {
            this.signUpFrame = signUpFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            signUpFrame.dispose(); // Close the welcome frame
            Activity_1.openMainFrame(); // Open the main frame with buttons
        }
    }

}
