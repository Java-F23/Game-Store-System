/**
 * The `Activity_3Controller` class manages the actions and events related to the login window.
 * It implements the ActionListener interface to handle button clicks and events.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.aucegypt.GamesStrore.Helpers.GUI;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;

public class Activity_3Controller implements ActionListener {

    private static boolean isPlayer;
    private static String[] credentials;
    private static Player player;
    private static Administrator administrator;

    /**
     * Opens the login frame.
     */
    public static void openLogInFrame() {
        Activity_3.openLogInFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Button1":
                System.out.println("Button 1 was clicked.");
                credentials = GUI.extractCredentials(Authentication.usernameField,
                                                     Authentication.passwordField, Authentication.emailField);
                isPlayer = GUI.checkCheckBox(Authentication.userTypeCheckBox);

                if (credentials != null && logIn()) {
                    Authentication.authFrame.dispose();
                    Activity_3.reDirectMsg();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials, re-enter", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Button2":
                System.out.println("Button 2 was clicked.");
                Authentication.authFrame.dispose();
                Activity_1.openMainFrame();
                break;

            case "Timer":
                Authentication.reDirectingFrame.dispose();

                if (isPlayer) {
                    Activity_5.openPlayerWindow(player);
                } else {
                    Activity_4Controller.openAdminWindow(administrator);
                }
                break;

            default:
                System.out.println("Unknown action command: ");
                break;
        }
    }

    /**
     * Handles the login functionality.
     *
     * @return true if the login is successful, false otherwise.
     */
    private static boolean logIn() {
        if (isPlayer) {
            player = new Player(credentials[0], credentials[1], credentials[2]);

            if (player.logIn()) {
                System.out.println("Player logged in");
                return true;
            } else {
                return false;
            }
        } else {
            administrator = new Administrator(credentials[0], credentials[1], credentials[2]);

            if (administrator.logIn()) {
                System.out.println("Administrator logged in");
                return true;
            } else {
                return false;
            }
        }
    }
}
