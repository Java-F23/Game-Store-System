/**
 * The `Activity_5Controller_FeedBack` class is a controller for handling actions related to the Feedback menu
 * in the Player window.
 *
 * It implements the ActionListener interface to respond to user actions.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import edu.aucegypt.GamesStrore.users.Player;

/**
 * Controller class for handling actions related to the Feedback menu in the Player window.
 */
public class Activity_5Controller_FeedBack implements ActionListener {
    private Player player;

    /**
     * Constructor for the controller class.
     *
     * @param player The associated Player object.
     */
    public Activity_5Controller_FeedBack(Player player) {
        this.player = player;
    }

    /**
     * Responds to actionPerformed events triggered by user actions in the Feedback menu.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = new String();
        String input2 = new String();
        int num;
        String command = e.getActionCommand();
        switch (command) {
            case "Add your rating to a game":
                // Prompt the user to enter the name of the game and a rating between 1-5
                input = JOptionPane.showInputDialog("Enter the name of the game you want to add a rating for");
                input2 = JOptionPane.showInputDialog("Enter the rating between 1-5");
                num = Integer.parseInt(input2);

                // Add the rating and display a corresponding message
                if (player.addRating(input, num)) {
                    JOptionPane.showMessageDialog(null, "Rating is added", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Remove your rating for a game":
                // Prompt the user to enter the name of the game to remove their rating for
                input = JOptionPane.showInputDialog("Enter the name of the game you want to remove your rating for");

                // Remove the rating and display a corresponding message
                if (player.removeRating(input).equals("rating removed")) {
                    JOptionPane.showMessageDialog(null, "Rating is removed", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Add your review to a game":
                // Prompt the user to enter the name of the game and a review
                input = JOptionPane.showInputDialog("Enter the name of the game you want to add a review for");
                input2 = JOptionPane.showInputDialog("Enter the review");

                // Add the review and display a corresponding message
                if (player.addReview(input, input2)) {
                    JOptionPane.showMessageDialog(null, "Review is added", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Remove your review from a game":
                // Prompt the user to enter the name of the game to remove their review for
                input = JOptionPane.showInputDialog("Enter the name of the game you want to remove your review for");

                // Remove the review and display a corresponding message
                if (player.removeReview(input).equals("review removed")) {
                    JOptionPane.showMessageDialog(null, "Review is removed", "Success", JOptionPane.INFORMATION_MESSAGE);
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
