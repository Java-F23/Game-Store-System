package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.aucegypt.GamesStrore.users.Player;


public class Activity_5Controller_Friends implements ActionListener  
{
    private Player player;


    public Activity_5Controller_Friends(Player player) {
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) 
        {
            case "View Friends List":
                ArrayList<String> friendlist = player.getFriendsList();
                StringBuilder list = new StringBuilder();
                for (String friend : friendlist) {
                    list.append(friend).append("\n");
                }
                System.out.println(friendlist);
                JOptionPane.showMessageDialog(null, list.toString());
                break;
            case "Add a Friend":
                input = JOptionPane.showInputDialog("Enter the name of the friend you want to add");
                
                if(player.addFriend(input))
                {
                    JOptionPane.showMessageDialog(null, input + "is added", "success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "Remove a Friend":
                 input = JOptionPane.showInputDialog("Enter the name of the friend you want to add");
                
                if(player.removeFriend(input))
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
