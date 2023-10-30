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

    public static boolean checkCheckBox(JCheckBox checkBox) {

        System.out.println(checkBox.isSelected());
        return checkBox.isSelected();
    }

    public static String[] extractNewGameDetails(JTextField gameNameField,JTextField descriptionField,JTextField releaseDateField,
                                                    JTextField developerField,JTextField publisherField,
                                                    JTextField originalPriceField,JTextField priceField,
                                                    JTextField discountField,JTextField genreTagsField) 
{
    String gameName = gameNameField.getText();
    String description = descriptionField.getText();
    String releaseDate = releaseDateField.getText();
    String developer = developerField.getText();
    String publisher = publisherField.getText();
    String originalPrice = originalPriceField.getText();
    String price = priceField.getText();
    String discount = discountField.getText();
    String genreTags = genreTagsField.getText();

    String[] gameDetails = {
        gameName,
        description,
        releaseDate,
        developer,
        publisher,
        originalPrice,
        price,
        discount,
        genreTags
    };

    // Print the extracted values for testing
    for (int i = 0; i < gameDetails.length; i++) {
        if (gameDetails[i].equals("")) {
            gameDetails[i] = null;
        }
    }
    for (String detail : gameDetails) 
    {
        if(detail == null)
        {
            System.out.println("XXXXXX");
        }
        else
        {
            System.out.println(detail);
        }
    }

    return gameDetails;
}

}
