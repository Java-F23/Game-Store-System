/**
 * The `Activity_5Controller_Games` class is a controller for handling actions related to the Games menu
 * in the Player window.
 *
 * It implements the ActionListener interface to respond to user actions.
 */
package edu.aucegypt.GamesStrore.guis;

import javax.swing.JOptionPane;
import edu.aucegypt.GamesStrore.users.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller class for handling actions related to the Games menu in the Player window.
 */
public class Activity_5Controller_Games implements ActionListener {
    private Player player;

    /**
     * Constructor for the controller class.
     *
     * @param player The associated Player object.
     */
    public Activity_5Controller_Games(Player player) {
        this.player = player;
    }

    /**
     * Responds to actionPerformed events triggered by user actions in the Games menu.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) {
            case "Play Game":
                // Prompt the user to enter the title of the game to play
                input = JOptionPane.showInputDialog("Enter the title of the game you want to play");

                // Launch the game if owned and display a corresponding message
                if (player.playGame(input)) {
                    JOptionPane.showMessageDialog(null, input + " is launching", "Launching", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Game Title or game not owned", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Purchase Game":
                // Prompt the user to enter the title of the game to purchase
                input = JOptionPane.showInputDialog("Enter the title of the game you want to purchase");

                // Purchase the game and add it to the library, display recommendations, and show a corresponding message
                if (player.purchaseGame(input).equals("add to library")) {
                    Activity_5.listContent(player.getRecommendations(), true);
                    JOptionPane.showMessageDialog(null, input + " added to library", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient amount of money or invalid game title", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Refund Game":
                // Prompt the user to enter the title of the game to refund
                input = JOptionPane.showInputDialog("Enter the title of the game you want to refund");

                // Refund the game and display a corresponding message
                if (player.refundGame(input).equals("game refunded")) {
                    JOptionPane.showMessageDialog(null, input + " refunded", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "View Purchased Games":
                // Retrieve the player's purchased games list and display it
                ArrayList<String> purList = player.getPurchasedGames();
                StringBuilder pur = new StringBuilder();
                for (String s : purList) {
                    pur.append(s).append("\n");
                }
                System.out.println(purList);
                JOptionPane.showMessageDialog(null, pur.toString());
                break;

            default:
                // Handle unknown action commands
                System.out.println("Unknown action command: " + command);
                break;
        }
    }
}
