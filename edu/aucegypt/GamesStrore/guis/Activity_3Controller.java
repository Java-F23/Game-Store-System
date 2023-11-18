package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.aucegypt.GamesStrore.Helpers.GUI;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;

public class Activity_3Controller implements ActionListener
{

    private  JFrame  LoginFrame;
    private  JCheckBox userTypeCheckBox;
    private  JTextField usernameField;
    private  JPasswordField passwordField;
    private  JTextField emailField;

    private static boolean isPlayer;
    private static String[] credentials;

    private static Player player;
    private static Administrator administrator;


    public Activity_3Controller(JFrame LoginFrame, JCheckBox userTypeCheckBox,JTextField usernameField,
                          JPasswordField passwordField,JTextField emailField ) 
    {
        this.LoginFrame = LoginFrame;
        this.userTypeCheckBox = userTypeCheckBox;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this. emailField = emailField;
    }

    public static void openLogInFrame()
    {
        Activity_3.openLogInFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Button1":
                System.out.println("Button 1 was clicked.");
                credentials = GUI.extractCredentials(usernameField,passwordField,emailField);
                isPlayer = GUI.checkCheckBox(userTypeCheckBox);
                
                if(logIn())
                {
                    LoginFrame.dispose();
                    Activity_3.reDirectMsg();
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials, re-enter", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Button2":
                System.out.println("Button 2 was clicked.");
                // Add your specific action for Button 2 here.
                LoginFrame.dispose();
                Activity_1.openMainFrame();
                break;

            case "Timer":
                LoginFrame.dispose(); // Close the welcome frame

                if(isPlayer)
                {
                    Activity_5.openPlayerWindow(player);
                }
                else
                {
                    Activity_4.openAdminWindow(administrator);
                }
                break;
            default:
                System.out.println("Unknown action command: ");
                break;
        }
    }
    // a method to handel the login functionality
    private static boolean logIn()
    {
        if(isPlayer)
        {
            player = new Player(credentials[0],credentials[1],credentials[2]);

            if(player.logIn())
            {
                System.out.println("player loggedin");
                return true;
            }
            else
            {
                return false;
            }
            
            

        }
        else
        {
            administrator = new Administrator(credentials[0],credentials[1],credentials[2]);

            if(administrator.logIn())
            {
                System.out.println("admin loggedin");
                return true;
            }
            else
            {
                return false;
            }
            
        }
        
    }

    

}
