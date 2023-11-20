package edu.aucegypt.GamesStrore.guis;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import edu.aucegypt.GamesStrore.users.Player;

public class Activity_5Controller_Favorites implements ActionListener  
{
    private Player player;


    public Activity_5Controller_Favorites(Player player) {
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) 
        {
            case "View Favorites List":
                ArrayList<String> favouritelist = player.getfavoritesList();
                StringBuilder favlist = new StringBuilder();
                for (String fav : favouritelist) {
                    favlist.append(fav).append("\n");
                }
                System.out.println(favouritelist);
                JOptionPane.showMessageDialog(null, favlist.toString());
                break;
            case "Add a game to Favorites List":
                input = JOptionPane.showInputDialog("Enter the name of the game you want to add to favourites");
                
                if(player.addToFavoritesList(input))
                {
                    JOptionPane.showMessageDialog(null, input + "is added", "success", JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
                break;
            case "Remove a game from Favorites List":
                input = JOptionPane.showInputDialog("Enter the name of the game you want to remove to favourites");
                
                if(player.removeFromFavoritesList(input))
                {
                    JOptionPane.showMessageDialog(null, input + "is removed", "success", JOptionPane.INFORMATION_MESSAGE);

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
