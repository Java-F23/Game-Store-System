/**
 * The `Activity_2` class represents the sign-up window, serving as the second frame
 * of the application.
 * It extends the `Authentication` class to reuse authentication-related functionalities.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import edu.aucegypt.GamesStrore.resources.Strings;

public class Activity_2 extends Authentication {

    /**
     * Opens the sign-up frame, setting up the necessary components.
     */
    protected static void openSignUpFrame() {
        JFrame signUpFrame = new JFrame(Strings.activity2Name);
        JButton signUpButton = new JButton(Strings.signUpButtonLabel);
        ActionListener listener = new Activity_2Controller();

        // Set authentication frame, button, and handler
        setAuthFrame(signUpFrame);
        setAuthButton(signUpButton);
        setActivityHandler(listener);

        // Open the authentication frame
        openAuthFrame();
    }
}
