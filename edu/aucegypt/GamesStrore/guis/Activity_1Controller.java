package edu.aucegypt.GamesStrore.guis;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Activity_1Controller implements ActionListener 
{

    public static void WelcomeMsg() 
    {
        Activity_1.WelcomeMsg();
    }

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
                Activity_1.welcomeFrame.dispose(); // Close the welcome frame
                Activity_1.openMainFrame(); // Open the main frame with buttons
                break;
            default:
                System.out.println("Unknown action command: ");
                break;
        }
    }
}


