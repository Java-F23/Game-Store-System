package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.aucegypt.GamesStrore.users.Player;

public class Activity_5Controller_FeedBack implements ActionListener 
{
        private Player player;


    public Activity_5Controller_FeedBack(Player player) {
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String input = new String();
        String input2 = new String();
        int num;
        String command = e.getActionCommand();
        switch (command) 
        {
            case "Add your rating to a game":
                input = JOptionPane.showInputDialog("Enter the name of the game you want to add a rating for");
                input2 = JOptionPane.showInputDialog("Enter the rating between 1-5");
                num = Integer.parseInt(input2);
                if(player.addRating(input, num))
                {
                    JOptionPane.showMessageDialog(null, "Rating is added", "success", JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
                break;
            case "Remove your rating for a game":
                input = JOptionPane.showInputDialog("Enter the name of the game you want to remove your rating for");
                if(player.removeRating(input).equals("rating removed"))
                {
                    JOptionPane.showMessageDialog(null, "rating is removed", "success", JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
                break;
            case "Add your review to a game":
                input = JOptionPane.showInputDialog("Enter the name of the game you want to add a review for");
                input2 = JOptionPane.showInputDialog("Enter the review");
                if(player.addReview(input, input2))
                {
                    JOptionPane.showMessageDialog(null, "review is added", "success", JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
                break;
            case "Remove your review from a game":
                // Handle feedback-related actions
                input = JOptionPane.showInputDialog("Enter the name of the game you want to remove your review for");
                if(player.removeReview(input).equals("review removed"))
                {
                    JOptionPane.showMessageDialog(null, "review is removed", "success", JOptionPane.INFORMATION_MESSAGE);

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
