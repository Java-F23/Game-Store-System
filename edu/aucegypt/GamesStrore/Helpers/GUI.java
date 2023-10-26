package edu.aucegypt.GamesStrore.Helpers;


import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GUI 
{
    public static String[] extractCredentials(JTextField usernameField,JPasswordField passwordField,JTextField emailField)
    {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
        String[] credentials = {username,password,email};

        System.out.println(credentials[0] + credentials[1] + credentials[2]);
        return credentials;
    }

    public static boolean checkCheckBos(JCheckBox checkBox) {

        System.out.println(checkBox.isSelected());
        return checkBox.isSelected();
    }

    
}
