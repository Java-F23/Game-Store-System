package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.aucegypt.GamesStrore.Helpers.GUI;
import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;


public class Activity_4Controller implements ActionListener 
{
    private static Administrator administrator;
    String gameTitle = new String();

    public static void openAdminWindow(Administrator admin)
    {
        administrator = admin;
        Activity_4.openAdminWindow(admin);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        //String gameTitle = new String();
        Game game;
        switch (command) {
            case "addGameMenuItem":

                System.out.println("Button 1 was clicked.");
                gameTitle = JOptionPane.showInputDialog("Enter the title of the game to add:");
                game = new Game(gameTitle);

                if(!administrator.addGame(game))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                break;

            case "removeGameMenuItem":

                gameTitle = JOptionPane.showInputDialog("Enter the title of the game to remove:");
                

                if(!administrator.removeGame(gameTitle))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
                
                
                break;

            case "applyDiscountMenuItem":

                gameTitle = JOptionPane.showInputDialog("Enter the title of the game to apply a discount:");
                if(!administrator.applyDiscount(gameTitle))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
                

                break;

            case "editGameDetailsMenuItem":

                gameTitle = JOptionPane.showInputDialog("Enter the title of the game to edit:");

                game = administrator.fetchGameByTitle(gameTitle);
                if(game == null)
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Activity_4.editGame(administrator,gameTitle);
                }
                
                break;

            case "confirmButton":
                boolean status = confirmeEdit(administrator, gameTitle, Activity_4.gameNameField,
                                              Activity_4.descriptionField, Activity_4.releaseDateField,
                                               Activity_4.developerField, Activity_4.publisherField,
                                                Activity_4.originalPriceField, Activity_4.priceField,
                                                 Activity_4.discountField, Activity_4.genreTagsField);
                if(!status)
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, gameTitle + " has been updated", "Update", JOptionPane.INFORMATION_MESSAGE);
                }
                Activity_4.editDetailsFrame.dispose();
                break;

            case "logout":
                Activity_4.adminFrame.dispose();
                Activity_3.openLogInFrame();

                break;

            case "gameRates":

                if(!displayGameRatings(administrator))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;

            case "gameReviews":

                if(!displayGameReviews(administrator))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;

            case "generateReports":

                generateStoreReprots(administrator);
                break;
            default:

                System.out.println("Unknown action command: ");
                break;
        }
    }

    private static boolean confirmeEdit(Administrator administrator, String gameTitle, JTextField gameNameField,JTextField descriptionField,JTextField releaseDateField,
                                        JTextField developerField,JTextField publisherField,
                                        JTextField originalPriceField,JTextField priceField,
                                        JTextField discountField,JTextField genreTagsField) 
    {
        String[] edits = GUI.extractNewGameDetails(gameNameField, descriptionField, releaseDateField, developerField, publisherField, originalPriceField, priceField, discountField, genreTagsField);

        ArrayList<String> tags = null;

        if(edits[8] != null)
        {
            String commaSeparatedString = edits[8]; 

            String[] parts = commaSeparatedString.split(",");

            tags = new ArrayList<>();

            for (String part : parts) {
                tags.add(part);
            }
        }

        BigDecimal newOriginalPrice = null;
        if(edits[5] != null)
        {
            newOriginalPrice = new BigDecimal(edits[5]);
        }
        
        BigDecimal newPrice = null;
        if(edits[6] != null)
        {
            newPrice = new BigDecimal(edits[6]);
        }

        BigDecimal newDiscount = null;
        if(edits[7] != null)
        {
            newDiscount = new BigDecimal(edits[7]);
        }


        return administrator.editGame(gameTitle, edits[0], edits[1], edits[2], edits[3], edits[4], newOriginalPrice, newPrice, newDiscount, -1, tags);

    
    }


    private static boolean displayGameRatings(Administrator administrator)
    {
        String gameTitle = JOptionPane.showInputDialog("Enter the title of the game to view its ratings:");
        Game game = administrator.fetchGameByTitle(gameTitle);
        if(game == null)
        {
            return false;
        }
        else
        {
            LinkedList<Map<String, Integer>> ratings = game.getRatings();
            StringBuilder ratingsTable = new StringBuilder();
            ratingsTable.append("Ratings for ").append(game.getGameName()).append(":\n");
            for (Map<String, Integer> rating : ratings) {
                for (Map.Entry<String, Integer> entry : rating.entrySet()) {
                    String playerName = entry.getKey();
                    Integer rate = entry.getValue();
                    ratingsTable.append("Player: ").append(playerName).append("\tRate: ").append(rate).append("\n");
                }
            }
            
            JOptionPane.showMessageDialog(null, ratingsTable.toString());

            return true;
        }
        
    }

    private static boolean displayGameReviews(Administrator administrator)
    {
        String gameTitle = JOptionPane.showInputDialog("Enter the title of the game to view its reviews:");
        Game game = administrator.fetchGameByTitle(gameTitle);
        if(game == null)
        {
            return false;
        }
        else
        {
            LinkedList<Map<String, String>> reviews = game.getReviews();
            StringBuilder reviewsTable = new StringBuilder();
            reviewsTable.append("Reviews for ").append(game.getGameName()).append(":\n");
            for (Map<String, String> review : reviews) {

                    for (Map.Entry<String, String> entry : review.entrySet()) 
                    {
                    String playerName = entry.getKey();
                    String rev = entry.getValue();
                    reviewsTable.append("Player: ").append(playerName).append("\tReview: ").append(rev).append("\n");
                }

                //reviewsTable.append("Player: ").append(review.getPlayerName()).append("\tRate: ").append(review.getReview()).append("\n");
            }

            JOptionPane.showMessageDialog(null, reviewsTable.toString());

            return true;
        }
        
    }
    
    private static void generateStoreReprots(Administrator administrator)
    {
        LinkedList<Game> games  = administrator.fetchGamesDB();
        LinkedList<Player> players = administrator.fetchPlayersDB();

        // Create a JTextArea to display the reports
        JTextArea reportTextArea = new JTextArea();
        reportTextArea.setWrapStyleWord(true);
        reportTextArea.setLineWrap(true);
        reportTextArea.setEditable(false);

        // Create a JScrollPane to make the JTextArea scrollable
        JScrollPane scrollPane = new JScrollPane(reportTextArea);

        // Add the JScrollPane to a new JFrame
        JFrame reportFrame = new JFrame("Store Reports");
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.add(scrollPane);

        // Add the game sales report to the JTextArea
        reportTextArea.append("Game Sales Report:\n");
        for (Game game : games) {
            reportTextArea.append(game.getGameName() +
                " - Downloads: " + game.getNumberOfDownloads() +
                " - Number of ratings: " + game.getNumberOfRatings() +
                " - Number of reviews: " + game.getNumberOfReviews() + "\n");
        }

        // Add a separator between the two reports
        reportTextArea.append("\n");

        // Add the player statistics report to the JTextArea
        reportTextArea.append("Player Statistics Report:\n");
        for (Player player : players) {
            reportTextArea.append(player.getUsername() +
                " Own " + player.getPurchasedGames().size() + " games " +
                " - Wallet Balance: " + player.getWallet() + "\n");
        }

        // Set the size and make the frame visible
        reportFrame.setSize(400, 400);
        reportFrame.setVisible(true);


    }

}
