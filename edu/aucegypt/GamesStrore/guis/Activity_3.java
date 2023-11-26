/**
 * The `Activity_3` class represents the login window, serving as the third frame of the application.
 * It extends the `Authentication` class and inherits common authentication features.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.aucegypt.GamesStrore.resources.Strings;

public class Activity_3 extends Authentication {

    /**
     * Opens the login frame.
     */
    protected static void openLogInFrame() {
        JFrame loginFrame = new JFrame(Strings.activity3Name);
        JButton logInButton = new JButton(Strings.loginButtonLabel);
        ActionListener listener = new Activity_3Controller();

        setAuthFrame(loginFrame);
        setAuthButton(logInButton);
        setActivityHandler(listener);

        openAuthFrame();
    }
}
