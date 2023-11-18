package edu.aucegypt.GamesStrore.guis;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Activity_1Controller 
{
    public static void WelcomeMsg() 
    {
        Activity_1.WelcomeMsg();
    }
}

// a method for serves as a collection of handlers for different buttons
class ButtonHandler implements ActionListener 
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
                Activity_3Controller.openLogInFrame();
                break;
            case "Button2":
                System.out.println("Button 2 was clicked.");
                welcomeFrame.dispose();
                Activity_2Controller.openSignUpFrame();
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
