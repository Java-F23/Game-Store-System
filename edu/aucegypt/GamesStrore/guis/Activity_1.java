/**
 * The `Activity_1` class represents the welcome activity and the first window of the project.
 * It includes methods for displaying a welcome message and generating the main frame with buttons.
 */
package edu.aucegypt.GamesStrore.guis;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import edu.aucegypt.GamesStrore.resources.Strings;

public class Activity_1 {

    // The frame for the welcome message
    protected static JFrame welcomeFrame;

    // The frame for the main activity
    protected static JFrame mainFrame;

    /**
     * Displays a welcome message using a JFrame.
     */
    protected static void WelcomeMsg() {
        // Create a JFrame for the welcome message
        welcomeFrame = new JFrame(Strings.storeName);
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
        ActionListener closeWelcomeListener = new Activity_1Controller();
        Timer timer = new Timer(2000, closeWelcomeListener);
        timer.setActionCommand("Timer");
        timer.setRepeats(false); // Run the timer only once
        timer.start();
    }

    /**
     * Generates the main frame with buttons for login, signup, and quitting the application.
     */
    protected static void openMainFrame() {
        // Create a new JFrame for the main frame
        mainFrame = new JFrame(Strings.welcomeLabel + "!");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));

        // Create buttons with unique ActionCommands
        JButton loginButton = new JButton(Strings.loginButton);
        loginButton.setActionCommand("Button1");

        JButton signupButton = new JButton(Strings.signupButton);
        signupButton.setActionCommand("Button2");

        JButton quitButton = new JButton(Strings.quitButton);
        quitButton.setActionCommand("Button3");

        // Create a single ActionListener
        ActionListener buttonHandler = new Activity_1Controller();

        // Add the ActionListener to all buttons
        loginButton.addActionListener(buttonHandler);
        signupButton.addActionListener(buttonHandler);
        quitButton.addActionListener(buttonHandler);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Add vertical spacing
        buttonPanel.add(Box.createVerticalStrut(20));

        // Add login button
        buttonPanel.add(loginButton);

        // Add vertical spacing
        buttonPanel.add(Box.createVerticalStrut(10));

        // Add signup button
        buttonPanel.add(signupButton);

        // Add vertical spacing
        buttonPanel.add(Box.createVerticalStrut(10));

        // Add Quit button
        buttonPanel.add(quitButton);

        // Add vertical spacing
        buttonPanel.add(Box.createVerticalStrut(20));

        // Create a panel to hold the button panel and center it vertically
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        // Add the center panel to the main frame
        mainFrame.add(centerPanel, BorderLayout.CENTER);

        mainFrame.pack();

        // Set the size, make the main frame non-resizable, and center it on the screen
        mainFrame.setSize(350, 200);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
