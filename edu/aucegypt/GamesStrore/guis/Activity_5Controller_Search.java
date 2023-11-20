package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.users.Player;


public class Activity_5Controller_Search implements ActionListener 
{
    private Player player;


    public Activity_5Controller_Search(Player player) {
        this.player = player;
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) 
        {
            case "Search games by genres":

                input = JOptionPane.showInputDialog("Enter the tags separated by commas");
                String commaSeparatedString = input;
                String[] parts = commaSeparatedString.split(",");
                ArrayList<String> T = new ArrayList<>();
                for (String part : parts) {
                    T.add(part);
                }
                
                ArrayList<Game> tagSearch = player.tagsBasedSearchGUI(T);
                if(tagSearch != null)
                {
                    listSearch(tagSearch);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
                        
                case "Search games by release year":
                    input = JOptionPane.showInputDialog("Enter the target year");
                    ArrayList<Game> yearSearch = player.yearBasedSearchGUI(Integer.parseInt(input));
                    if(yearSearch != null)
                    {
                        listSearch(yearSearch);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "Search games by release month":
                    input = JOptionPane.showInputDialog("Enter the target month");
                    ArrayList<Game> monthSearch = player.monthBasedSearchGUI(Integer.parseInt(input));
                    if(monthSearch != null)
                    {
                        listSearch(monthSearch);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    
                case "View game details":
                    input = JOptionPane.showInputDialog("Enter the game title");
                    Game game = player.fetchGameByTitle(input);
                    if(game != null)
                    {
                        listGame(game);
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

    private static void listSearch(ArrayList<Game> games)
    {
        // Create a JTextArea to display the reports
        JTextArea displayTextArea = new JTextArea();
        displayTextArea.setWrapStyleWord(true);
        displayTextArea.setLineWrap(true);
        displayTextArea.setEditable(false);

        // Create a JScrollPane to make the JTextArea scrollable
        JScrollPane scrollPane = new JScrollPane(displayTextArea);

        // Add the JScrollPane to a new JFrame
        JFrame displayFrame = new JFrame("Prefrence Based Search");
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.add(scrollPane);
        
        // Add the game sales report to the JTextArea
        displayTextArea.append("Games Based on Prefrence search:\n\n");
        for (Game game : games) {
            displayTextArea.append(game.getGameName() +
                " - Release Date: " + game.getReleaseDate() +
                " - price: " + game.getPrice()  + "\n");
        }

        // Add a separator between the two reports
        displayTextArea.append("\n");

        

        // Set the size and make the frame visible
        displayFrame.setSize(400, 400);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(true);
    }

    private static void listGame(Game game)
    {
        // Create a JTextArea to display the reports
        JTextArea displayTextArea = new JTextArea();
        displayTextArea.setWrapStyleWord(true);
        displayTextArea.setLineWrap(true);
        displayTextArea.setEditable(false);

        // Create a JScrollPane to make the JTextArea scrollable
        JScrollPane scrollPane = new JScrollPane(displayTextArea);

        // Add the JScrollPane to a new JFrame
        JFrame displayFrame = new JFrame("Detailed game");
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.add(scrollPane);
        
        // Add the game sales report to the JTextArea
        displayTextArea.append("Game Details:\n \n");
        
        displayTextArea.append(
        " - Name: " + game.getGameName() + "\n" +
        " - Discription: " + game.getGameDescription() + "\n" +
        " - Developer: " + game.getDeveloper() + "\n" +
        " - Publisher: " + game.getPublisher() + "\n" +
        " - Release Date: " + game.getReleaseDate() + "\n" +
        " - price: " + game.getPrice()  + "\n\n"
        );
        

        // Add a separator between the two reports
        displayTextArea.append("\n");

        

        // Set the size and make the frame visible
        displayFrame.setSize(500, 400);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(true);
    }
}
