package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.aucegypt.GamesStrore.Helpers.GUI;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;

public class Activity_2Controller implements ActionListener 
{
    // private  JFrame signUpFrame;
    // private  JCheckBox userTypeCheckBox;
    // private  JTextField usernameField;
    // private  JPasswordField passwordField;
    // private  JTextField emailField;


    public Activity_2Controller() 
    {
        
    }

    // public Activity_2Controller(JFrame signUpFrame, JCheckBox userTypeCheckBox,JTextField usernameField,
    //                       JPasswordField passwordField,JTextField emailField ) 
    // {
    //     this.signUpFrame = signUpFrame;
    //     this.userTypeCheckBox = userTypeCheckBox;
    //     this.usernameField = usernameField;
    //     this.passwordField = passwordField;
    //     this. emailField = emailField;
    // }

    public static void openSignUpFrame() 
    {
        Activity_2.openSignUpFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Button1":
                System.out.println("Button 1 was clicked.");
                String[] credentials = GUI.extractCredentials(Authentication.usernameField,
                                                              Authentication.passwordField,Authentication.emailField);
                boolean isPlayer = GUI.checkCheckBox(Authentication.userTypeCheckBox);
                
                if(signUp(credentials, isPlayer))
                {
                    Authentication.authFrame.dispose();
                    Activity_2.reDirectMsg();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Matching or Invalid Credentials, re-enter", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                break;
            case "Button2":
                System.out.println("Button 2 was clicked.");
                // Add your specific action for Button 2 here.
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

    // a method to handel the signup functionality
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
}


