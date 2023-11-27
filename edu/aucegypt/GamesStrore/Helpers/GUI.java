/**
 * The `GUI` class provides utility methods for handling graphical user interface components.
 */
package edu.aucegypt.GamesStrore.Helpers;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI {

    /**
     * Extracts user credentials from JTextField and JPasswordField.
     *
     * @param usernameField The JTextField containing the username.
     * @param passwordField The JPasswordField containing the password.
     * @param emailField    The JTextField containing the email.
     * @return An array of Strings representing the extracted credentials [username, password, email].
     */
    public static String[] extractCredentials(JTextField usernameField, JPasswordField passwordField, JTextField emailField) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        if(!(Validations.isValidString(email) && Validations.isValidString(username) && Validations.isValidString(password)))
        {
            return null;
        }
        String[] credentials = {username, password, email};

        // Print the extracted values for testing
        System.out.println(credentials[0] + credentials[1] + credentials[2]);

        return credentials;
    }

    /**
     * Checks if a JCheckBox is selected.
     *
     * @param checkBox The JCheckBox to be checked.
     * @return true if the JCheckBox is selected, false otherwise.
     */
    public static boolean checkCheckBox(JCheckBox checkBox) {
        // Print the checkbox status for testing
        System.out.println(checkBox.isSelected());
        return checkBox.isSelected();
    }

    /**
     * Extracts details of a new game from various JTextFields.
     *
     * @param gameNameField      The JTextField containing the game name.
     * @param descriptionField   The JTextField containing the game description.
     * @param releaseDateField   The JTextField containing the game release date.
     * @param developerField     The JTextField containing the game developer.
     * @param publisherField     The JTextField containing the game publisher.
     * @param originalPriceField The JTextField containing the original game price.
     * @param priceField         The JTextField containing the current game price.
     * @param discountField      The JTextField containing the game discount.
     * @param genreTagsField     The JTextField containing the game genre tags.
     * @return An array of Strings representing the extracted game details.
     */
    public static String[] extractNewGameDetails(JTextField gameNameField, JTextField descriptionField,
                                                 JTextField releaseDateField, JTextField developerField,
                                                 JTextField publisherField, JTextField originalPriceField,
                                                 JTextField priceField, JTextField discountField,
                                                 JTextField genreTagsField) {
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
        for (String detail : gameDetails) {
            if (detail == null) {
                System.out.println("XXXXXX");
            } else {
                System.out.println(detail);
            }
        }

        return gameDetails;
    }
}
