package edu.aucegypt.GamesStrore.guis;

import javax.swing.JOptionPane;

import edu.aucegypt.GamesStrore.users.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Activity_5Controller_Games implements ActionListener 
{
    private Player player;


    public Activity_5Controller_Games(Player player) {
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) 
        {
            case "Play Game":

                input = JOptionPane.showInputDialog("Enter the title of the game you want to play");
                
                if(player.playGame(input))
                {
                    JOptionPane.showMessageDialog(null, input + " is launching", "launching", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Game Title or game not owned", "Error", JOptionPane.ERROR_MESSAGE);
                }
                        
                break;

            case "Purchase Game":

                input = JOptionPane.showInputDialog("Enter the title of the game you want to purchase");
                
                if(player.purchaseGame(input).equals("add to library"))
                {
                    Activity_5.listContent(player.getRecommendations(),true);
                    JOptionPane.showMessageDialog(null, input + " add to library", "success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, " insufficient amount of money or invalid gameTitle", "Error", JOptionPane.ERROR_MESSAGE);
                }
        
                break;

            case "Refund Game":

                input = JOptionPane.showInputDialog("Enter the title of the game you want to refund");
                
                if(player.refundGame(input).equals("game refunded"))
                {
                    JOptionPane.showMessageDialog(null, input + "refunded", "success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "View Purchased Games":

                ArrayList<String> purList = player.getPurchasedGames();
                StringBuilder pur = new StringBuilder();
                for (String s : purList) 
                {
                    pur.append(s).append("\n");
                }
                System.out.println(purList);
                JOptionPane.showMessageDialog(null, pur.toString());
                break;
 
            default:

                System.out.println("Unknown action command: ");
                break;
        }
    }

    
}
