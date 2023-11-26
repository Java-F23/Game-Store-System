/**
 * The `Activity_5Controller_Friends` class is a controller for handling actions related to the Friends menu
 * in the Player window.
 *
 * It implements the ActionListener interface to respond to user actions.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import edu.aucegypt.GamesStrore.users.Player;

/**
 * Controller class for handling actions related to the Friends menu in the Player window.
 */
public class Activity_5Controller_Friends implements ActionListener {
    private Player player;

    /**
     * Constructor for the controller class.
     *
     * @param player The associated Player object.
     */
    public Activity_5Controller_Friends(Player player) {
        this.player = player;
    }

    /**
     * Responds to actionPerformed events triggered by user actions in the Friends menu.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) {
            case "View Friends List":
                // Retrieve the player's friends list and display it
                ArrayList<String> friendlist = player.getFriendsList();
                StringBuilder list = new StringBuilder();
                for (String friend : friendlist) {
                    list.append(friend).append("\n");
                }
                System.out.println(friendlist);
                JOptionPane.showMessageDialog(null, list.toString());
                break;
            case "Add a Friend":
                // Prompt the user to enter the name of the friend to add
                input = JOptionPane.showInputDialog("Enter the name of the friend you want to add");

                // Add the friend and display a corresponding message
                if (player.addFriend(input)) {
                    JOptionPane.showMessageDialog(null, input + " is added", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Remove a Friend":
                // Prompt the user to enter the name of the friend to remove
                input = JOptionPane.showInputDialog("Enter the name of the friend you want to remove");

                // Remove the friend and display a corresponding message
                if (player.removeFriend(input)) {
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
