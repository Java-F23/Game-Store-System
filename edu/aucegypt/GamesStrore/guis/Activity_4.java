package edu.aucegypt.GamesStrore.guis;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.aucegypt.GamesStrore.Helpers.GUI;
import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.Rate;
import edu.aucegypt.GamesStrore.games.Review;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;

//Admin window
public class Activity_4 
{

    public static void openAdminWindow(Administrator administrator) 
    {
        JFrame adminFrame = new JFrame("Admin Window");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(600, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu editGamesMenu = new JMenu("Edit Games");
        JMenu reportsMenu = new JMenu("Reports");

        // Edit Games menu options
        JMenuItem addGameMenuItem = new JMenuItem("Add Game");
        JMenuItem removeGameMenuItem = new JMenuItem("Remove Game");
        JMenuItem editGameDetailsMenuItem = new JMenuItem("Edit Game Details");
        JMenuItem applyDiscountMenuItem = new JMenuItem("Apply Discount");

        addGameMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gameTitle = JOptionPane.showInputDialog("Enter the title of the game to add:");
                Game game = new Game(gameTitle);

                if(!administrator.addGame(game))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        removeGameMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gameTitle = JOptionPane.showInputDialog("Enter the title of the game to remove:");
                

                if(!administrator.removeGame(gameTitle))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        applyDiscountMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gameTitle = JOptionPane.showInputDialog("Enter the title of the game to apply a discount:");
                if(!administrator.applyDiscount(gameTitle))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        editGameDetailsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String gameTitle = JOptionPane.showInputDialog("Enter the title of the game to edit:");

                Game game = administrator.fetchGameByTitle(gameTitle);
                if(game == null)
                {
                    JOptionPane.showMessageDialog(null, "Error occured 1", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    editGame(administrator,gameTitle);
                }
                
                
                
            }
        });

        editGamesMenu.add(addGameMenuItem);
        editGamesMenu.add(removeGameMenuItem);
        editGamesMenu.add(editGameDetailsMenuItem);
        editGamesMenu.add(applyDiscountMenuItem);

        // Reports menu options
        reportsMenu.add(createRadioButtons(administrator));

        menuBar.add(editGamesMenu);
        menuBar.add(reportsMenu);

        adminFrame.setJMenuBar(menuBar);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);
    }

    private static JPanel createRadioButtons(Administrator administrator) {
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        JRadioButton gameRates = new JRadioButton("View a game rates");
        JRadioButton gameReviews = new JRadioButton("View a game reviews");
        JRadioButton generateReports = new JRadioButton("Generate reports about the store");

        ButtonGroup group = new ButtonGroup();
        group.add(gameRates);
        group.add(gameReviews);
        group.add(generateReports);

        gameRates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(!displayGameRatings(administrator))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Report Option 1 was clicked.");
                }

            }
        });

        gameReviews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!displayGameReviews(administrator))
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Report Option 2 was clicked.");
                }
            }
        });

        generateReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                generateStoreReprots(administrator);
            }
        });

        radioPanel.add(gameRates);
        radioPanel.add(gameReviews);
        radioPanel.add(generateReports);

        return radioPanel;
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
            ArrayList<Rate> ratings = game.getRatings();
            StringBuilder ratingsTable = new StringBuilder();
            ratingsTable.append("Ratings for ").append(game.getGameName()).append(":\n");
            for (Rate rating : ratings) {
                ratingsTable.append("Player: ").append(rating.getPlayerName()).append("\tRate: ").append(rating.getRate()).append("\n");
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
            ArrayList<Review> reviews = game.getReviews();
            StringBuilder reviewsTable = new StringBuilder();
            reviewsTable.append("Reviews for ").append(game.getGameName()).append(":\n");
            for (Review review : reviews) {
                reviewsTable.append("Player: ").append(review.getPlayerName()).append("\tRate: ").append(review.getReview()).append("\n");
            }

            JOptionPane.showMessageDialog(null, reviewsTable.toString());

            return true;
        }
        
    }
    
    private static void generateStoreReprots(Administrator administrator)
    {
        ArrayList<Game> games  = administrator.fetchGamesDB();
        ArrayList<Player> players = administrator.fetchPlayersDB();

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

    private static void editGame(Administrator administrator, String gameTitle)
    {
        

        JTextField gameNameField;
        JTextField descriptionField;
        JTextField releaseDateField;
        JTextField developerField;
        JTextField publisherField;
        JTextField originalPriceField;
        JTextField priceField;
        JTextField discountField;
        JTextField genreTagsField;

        

        JFrame editDetailsFrame = new JFrame("Edit Game Details");
        editDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editDetailsFrame.setSize(400, 300);

        editDetailsFrame.setLayout(new GridLayout(10, 2));

        JLabel gameNameLabel = new JLabel("New Game Name:");
        gameNameField = new JTextField();

        JLabel descriptionLabel = new JLabel("New Description:");
        descriptionField = new JTextField();

        JLabel releaseDateLabel = new JLabel("New Release Date (YY-MM-DD):");
        releaseDateField = new JTextField();

        JLabel developerLabel = new JLabel("New Developer Name:");
        developerField = new JTextField();

        JLabel publisherLabel = new JLabel("New Publisher Name:");
        publisherField = new JTextField();

        JLabel originalPriceLabel = new JLabel("New Original Price:");
        originalPriceField = new JTextField();

        JLabel priceLabel = new JLabel("New Price:");
        priceField = new JTextField();

        JLabel discountLabel = new JLabel("New Discount Amount:");
        discountField = new JTextField();

        JLabel genreTagsLabel = new JLabel("New Genre Tags (comma-separated):");
        genreTagsField = new JTextField();

        JButton confirmButton = new JButton("Confirm Edit");
        JButton cancelButton = new JButton("Cancel Edit");

        

        editDetailsFrame.add(gameNameLabel);
        editDetailsFrame.add(gameNameField);
        editDetailsFrame.add(descriptionLabel);
        editDetailsFrame.add(descriptionField);
        editDetailsFrame.add(releaseDateLabel);
        editDetailsFrame.add(releaseDateField);
        editDetailsFrame.add(developerLabel);
        editDetailsFrame.add(developerField);
        editDetailsFrame.add(publisherLabel);
        editDetailsFrame.add(publisherField);
        editDetailsFrame.add(originalPriceLabel);
        editDetailsFrame.add(originalPriceField);
        editDetailsFrame.add(priceLabel);
        editDetailsFrame.add(priceField);
        editDetailsFrame.add(discountLabel);
        editDetailsFrame.add(discountField);
        editDetailsFrame.add(genreTagsLabel);
        editDetailsFrame.add(genreTagsField);
        editDetailsFrame.add(confirmButton);
        editDetailsFrame.add(cancelButton);


        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean status = confirmeEdit(administrator, gameTitle, gameNameField, descriptionField, releaseDateField, developerField, publisherField, originalPriceField, priceField, discountField, genreTagsField);
                
                if(!status)
                {
                    JOptionPane.showMessageDialog(null, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, gameTitle + " has been updated", "Update", JOptionPane.INFORMATION_MESSAGE);

                }
                
                editDetailsFrame.dispose();
                
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the frame without making any changes
                editDetailsFrame.dispose();
            }
        });

        editDetailsFrame.setLocationRelativeTo(null);
        editDetailsFrame.setVisible(true);

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
}