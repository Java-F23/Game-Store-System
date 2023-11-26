/**
 * The `Activity_2Controller` class is the controller for the sign-up window (Activity_2).
 * It implements the ActionListener interface to handle button clicks and user interactions.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.aucegypt.GamesStrore.Helpers.GUI;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;

public class Activity_2Controller implements ActionListener {

    /**
     * Constructs an instance of the Activity_2Controller.
     */
    public Activity_2Controller() {
    }

    /**
     * Opens the sign-up frame.
     */
    public static void openSignUpFrame() {
        Activity_2.openSignUpFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Button1":
                System.out.println("Button 1 was clicked.");
                String[] credentials = GUI.extractCredentials(Authentication.usernameField,
                        Authentication.passwordField, Authentication.emailField);
                boolean isPlayer = GUI.checkCheckBox(Authentication.userTypeCheckBox);

                if ( credentials != null && signUp(credentials, isPlayer)) {
                    Authentication.authFrame.dispose();
                    Activity_2.reDirectMsg();
                } else {
                    JOptionPane.showMessageDialog(null, "Matching or Invalid Credentials, re-enter", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "Button2":
                System.out.println("Button 2 was clicked.");
                Authentication.authFrame.dispose();
                Activity_1.openMainFrame();
                break;

            case "Timer":
                Authentication.reDirectingFrame.dispose(); // Close the welcome frame
                Activity_1.openMainFrame(); // Open the main frame with buttons
                break;
            default:
                System.out.println("Unknown action command: ");
                break;
        }
    }

    /**
     * Handles the sign-up functionality for players and administrators.
     *
     * @param credentials The user credentials (username, password, email).
     * @param isPlayer    True if the user is a player, false if an administrator.
     * @return True if the sign-up is successful, false otherwise.
     */
    private static boolean signUp(String[] credentials, boolean isPlayer) {
        String result;
        if (isPlayer) {
            Player player = new Player(credentials[0], credentials[1], credentials[2]);
            result = player.signUp();
            System.out.println("Player signed up");
        } else {
            Administrator administrator = new Administrator(credentials[0], credentials[1], credentials[2]);
            result = administrator.signUp();
            System.out.println("Administrator signed up");
        }

        return result.equals("successful signup");
    }
}
