/**
 * The `Activity_1Controller` class serves as the controller for the actions performed in Activity_1.
 * It implements the ActionListener interface to handle button clicks and other events.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Activity_1Controller implements ActionListener {

    /**
     * Invokes the WelcomeMsg method in the Activity_1 class.
     */
    public static void WelcomeMsg() {
        Activity_1.WelcomeMsg();
    }

    /**
     * Handles button clicks and other events triggered in Activity_1.
     *
     * @param e The ActionEvent representing the action performed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Button1":
                System.out.println("Button 1 was clicked.");
                Activity_1.mainFrame.dispose();
                Activity_3Controller.openLogInFrame();
                break;
            case "Button2":
                System.out.println("Button 2 was clicked.");
                Activity_1.mainFrame.dispose();
                Activity_2Controller.openSignUpFrame();
                break;
            case "Button3":
                System.out.println("Button 3 was clicked.");
                System.exit(0);
                break;
            case "Timer":
                Activity_1.welcomeFrame.dispose();
                Activity_1.openMainFrame();
                break;
            default:
                System.out.println("Unknown action command: " + command);
                break;
        }
    }
}
