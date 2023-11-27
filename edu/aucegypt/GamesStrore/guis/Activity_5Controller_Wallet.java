/**
 * The `Activity_5Controller_Wallet` class is a controller for handling actions related to the Wallet menu
 * in the Player window.
 *
 * It implements the ActionListener interface to respond to user actions.
 */
package edu.aucegypt.GamesStrore.guis;

import javax.swing.JOptionPane;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.aucegypt.GamesStrore.Helpers.Validations;
import edu.aucegypt.GamesStrore.users.Player;

/**
 * Controller class for handling actions related to the Wallet menu in the Player window.
 */
public class Activity_5Controller_Wallet implements ActionListener {
    private Player player;

    /**
     * Constructor for the controller class.
     *
     * @param player The associated Player object.
     */
    public Activity_5Controller_Wallet(Player player) {
        this.player = player;
    }

    /**
     * Responds to actionPerformed events triggered by user actions in the Wallet menu.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) {
            case "View Wallet":
                // Display the player's wallet amount
                JOptionPane.showMessageDialog(null, "Amount is " + player.getWallet(), "Wallet", JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Add Money to Wallet":
                // Prompt the user to enter the amount to add to the wallet
                input = JOptionPane.showInputDialog("Enter the amount to add to the wallet");

                if(!Validations.isValidFloat(input))
                {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);

                }
                else
                {
                    double num2 = Double.parseDouble(input);
    
                    // Add money to the wallet and display the result
                    if (player.addMoney(num2)) {
                        JOptionPane.showMessageDialog(null, "Money is added", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;

            default:
                // Handle unknown action commands
                System.out.println("Unknown action command: " + command);
                break;
        }
    }
}
