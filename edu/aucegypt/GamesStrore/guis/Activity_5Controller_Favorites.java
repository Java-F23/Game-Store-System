/**
 * The `Activity_5Controller_Favorites` class is a controller for handling actions related to the Favorites menu
 * in the Player window.
 *
 * It implements the ActionListener interface to respond to user actions.
 */
package edu.aucegypt.GamesStrore.guis;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import edu.aucegypt.GamesStrore.users.Player;

/**
 * Controller class for handling actions related to the Favorites menu in the Player window.
 */
public class Activity_5Controller_Favorites implements ActionListener {
    private Player player;

    /**
     * Constructor for the controller class.
     *
     * @param player The associated Player object.
     */
    public Activity_5Controller_Favorites(Player player) {
        this.player = player;
    }

    /**
     * Responds to actionPerformed events triggered by user actions in the Favorites menu.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) {
            case "View Favorites List":
                // Get the player's favorites list
                ArrayList<String> favoriteList = player.getfavoritesList();

                // Build a string representation of the favorites list
                StringBuilder favList = new StringBuilder();
                for (String fav : favoriteList) {
                    favList.append(fav).append("\n");
                }

                // Display the favorites list in a JOptionPane
                JOptionPane.showMessageDialog(null, favList.toString());
                break;
            case "Add a game to Favorites List":
                // Prompt the user to enter the name of the game to add to favorites
                input = JOptionPane.showInputDialog("Enter the name of the game you want to add to favorites");

                // Add the game to favorites and display a corresponding message
                if (player.addToFavoritesList(input)) {
                    JOptionPane.showMessageDialog(null, input + " is added", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Remove a game from Favorites List":
                // Prompt the user to enter the name of the game to remove from favorites
                input = JOptionPane.showInputDialog("Enter the name of the game you want to remove from favorites");

                // Remove the game from favorites and display a corresponding message
                if (player.removeFromFavoritesList(input)) {
                    JOptionPane.showMessageDialog(null, input + " is removed", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                // Handle unknown action commands
                System.out.println("Unknown action command: " + command);
                break;
        }
    }
}
