package edu.aucegypt.GamesStrore.guis;


import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.aucegypt.GamesStrore.users.Player;

public class Activity_5Controller_Wallet implements ActionListener
{
        private Player player;


    public Activity_5Controller_Wallet(Player player) {
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) 
        {
            case "View Wallet":
                    JOptionPane.showMessageDialog(null, "Amount is" + player.getWallet(), "Wallet", JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Add Money to Wallet":
                input = JOptionPane.showInputDialog("Enter the amount to add to walltet");
                double num2 = Double.parseDouble(input);
                if(player.addMoney(num2))
                {
                    JOptionPane.showMessageDialog(null, "Money is added", "success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:

                System.out.println("Unknown action command: ");
                break;
        }
    }
    
}
