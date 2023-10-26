package edu.aucegypt.GamesStrore.guis;

import javax.swing.*;

import edu.aucegypt.GamesStrore.resources.Strings;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Welcome Activity
public class Activity_1 
{
    public static void WelcomeMsg() {
        // Create a JFrame for the welcome message
        JFrame welcomeFrame = new JFrame(Strings.storeName);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel for the welcome message
        JLabel welcomeLabel = new JLabel(Strings.welcomeLabel + "!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeFrame.add(welcomeLabel);

        // Set the size and make the welcome frame visible
        welcomeFrame.setSize(300, 100);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setVisible(true);

        // Schedule a Timer to close the welcome frame after 10 seconds
        ActionListener closeWelcomeListener = new CloseWelcomeListener(welcomeFrame);
        Timer timer = new Timer(2000, closeWelcomeListener);
        timer.setRepeats(false); // Run the timer only once
        timer.start();
    }

    protected static void openMainFrame() {
        // Create a new JFrame for the main frame
        JFrame mainFrame = new JFrame(Strings.welcomeLabel + "!");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        // Create buttons with unique ActionCommands
        JButton loginButton = new JButton(Strings.loginButton);
        loginButton.setActionCommand("Button1");

        JButton signupButton = new JButton(Strings.signupButton);
        signupButton.setActionCommand("Button2");

        JButton QuitButton = new JButton(Strings.quitButton);
        QuitButton.setActionCommand("Button3");

        // Create a single ActionListener
        ActionListener buttonHandler = new ButtonHandler(mainFrame);

        // Add the ActionListener to all buttons
        loginButton.addActionListener(buttonHandler);
        signupButton.addActionListener(buttonHandler);
        QuitButton.addActionListener(buttonHandler);

        // Add buttons to the frame
        mainFrame.add(loginButton);
        mainFrame.add(signupButton);
        mainFrame.add(QuitButton);

        mainFrame.pack();
        // Set the size and make the main frame visible
        mainFrame.setSize(800, 800);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    static class CloseWelcomeListener implements ActionListener 
    {
        private JFrame welcomeFrame;

        public CloseWelcomeListener(JFrame welcomeFrame) {
            this.welcomeFrame = welcomeFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            welcomeFrame.dispose(); // Close the welcome frame
            Activity_1.openMainFrame(); // Open the main frame with buttons
        }
    }

    static class ButtonHandler implements ActionListener 
    {
        private JFrame welcomeFrame;

        public ButtonHandler(JFrame welcomeFrame) {
            this.welcomeFrame = welcomeFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Button1":
                    System.out.println("Button 1 was clicked.");
                    welcomeFrame.dispose();
                    Activity_3.openLogInFrame();
                    break;
                case "Button2":
                    System.out.println("Button 2 was clicked.");
                    welcomeFrame.dispose();
                    Activity_2.openSignUpFrame();
                    break;
                case "Button3":
                    System.out.println("Button 3 was clicked.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown action command: ");
                    break;
            }
        }
    }
}



