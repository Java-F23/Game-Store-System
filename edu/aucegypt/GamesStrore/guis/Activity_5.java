package edu.aucegypt.GamesStrore.guis;

import javax.swing.*;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.users.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Player window
//A class to handel the player tasks
 class Activity_5 
 {
    private static JPanel contentPanel;
    private static GridBagConstraints gbc;

    // a method that displays the player window
    public static void openPlayerWindow(Player player) 
    {
        // Create the main frame
        JFrame playerFrame = new JFrame("Player Window");
        playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerFrame.setSize(800, 600);

        // Create a horizontal menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create and add menus to the menu bar
        String[] menuNames = {"Games", "Friends", "Favorites", "Feedback", "Search", "Wallet"};
        for (String menuName : menuNames) {
            menuBar.add(createMenu(menuName, player));
        }

        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerFrame.dispose();
                Activity_3.openLogInFrame();
            }
        });
        menuBar.add(logout);

        // Set the menu bar for the frame
        playerFrame.setJMenuBar(menuBar);

        // Create a scroll pane to hold the content
        JScrollPane scrollPane = new JScrollPane();

        // Create a panel for the content
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());

        // Create the Recommendations section
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel recommendationsLabel = new JLabel("<html><font color='#31906E'>Recommendations</font></html>");
        contentPanel.add(recommendationsLabel, gbc);
        gbc.gridy++;

        // Add  recommendations

        listContent(player.getRecommendations());
        for (int i = 1; i <= 6; i++) {
            JLabel recommendation = new JLabel("Recommendation " + i);
            contentPanel.add(recommendation, gbc);
            gbc.gridy++;
        }

        // Create the Browse Games section
        gbc.gridx = 0;
        gbc.gridy++;

        JLabel browseGamesLabel = new JLabel("<html><font color='#357EC7'>Browse Games</font></html>");
        contentPanel.add(browseGamesLabel, gbc);
        gbc.gridy++;

        // Add games
        listContent(player.getGames());
        for (int i = 1; i <= 100; i++) {
            JLabel game = new JLabel("Game " + i);
            contentPanel.add(game, gbc);
            gbc.gridy++;
        }

        // Add the content panel to the scroll pane
        scrollPane.setViewportView(contentPanel);

        // Set the layout for the player frame
        playerFrame.setLayout(new BorderLayout());

        // Add the scroll pane to the frame
        playerFrame.add(scrollPane, BorderLayout.CENTER);

        // Center the frame on the screen
        playerFrame.setLocationRelativeTo(null);

        // Show the player frame
        playerFrame.setVisible(true);
    }

    // a method that creates the different menu items
    private static JMenu createMenu(String menuName, Player player) {
        JMenu menu = new JMenu(menuName);

        if (menuName.equals("Games")) 
        {
            String[] gameItems = {"Play Game", "Purchase Game", "Refund Game", "View Purchased Games"};
            for (String item : gameItems) {
                menu.add(createMenuItem(item, player));
            }
        } else if (menuName.equals("Friends")) 
        {
            String[] friendsItems = {"View Friends List", "Add a Friend", "Remove a Friend"};
            for (String item : friendsItems) {
                menu.add(createMenuItem(item, player));
            }
        } else if (menuName.equals("Favorites")) 
        {
            String[] favoritesItems = {"View Favorites List", "Add a game to Favorites List", "Remove a game from Favorites List"};
            for (String item : favoritesItems) {
                menu.add(createMenuItem(item, player));
            }
        } else if (menuName.equals("Feedback")) 
        {
            String[] feedbackItems = {"Add your rating to a game", "Remove your rating for a game", "Add your review to a game", "Remove your review from a game"};
            for (String item : feedbackItems) {
                menu.add(createMenuItem(item, player));
            }
        } else if (menuName.equals("Search")) 
        {
            String[] searchItems = {"Search games by genres", "Search games by release year", "Search games by release month", "View game details"};
            for (String item : searchItems) {
                menu.add(createMenuItem(item, player));
            }
        } else if (menuName.equals("Wallet"))
        {
            String[] walletItems = {"View Wallet", "Add Money to Wallet"};
            for (String item : walletItems) {
                menu.add(createMenuItem(item, player));
            }
        }

        return menu;
    }

    // a method the handels the menue actions
    private static JMenuItem createMenuItem(String item, Player player) {
        JMenuItem menuItem = new JMenuItem(item);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input;
                String input2;
                int num;

                switch (item) 
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
                        for (String s : purList) {
                            pur.append(s).append("\n");
                        }
                        System.out.println(purList);
                        JOptionPane.showMessageDialog(null, pur.toString());

                    break;
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
                        // Handle favorites-related actions
                        System.out.println("Favorites Item Selected: " + item);
                        break;
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
                        // Handle favorites-related actions
                        System.out.println("FeedBack Item Selected: " + item);
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
                        // Handle favorites-related actions
                        System.out.println("FeedBack Item Selected: " + item);
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
                        // Handle favorites-related actions
                        System.out.println("FeedBack Item Selected: " + item);
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
                        // Handle favorites-related actions
                        System.out.println("FeedBack Item Selected: " + item);
                        break;
                    case "Search games by genres":
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
                        System.out.println("Unknown Item Selected: " + item);
                        break;
                }
                
            }
        });
        return menuItem;
        
    }

    // a list of helper functions
    private static void listContent(ArrayList<String> content)
    {
        
        for (String string : content) 
        {
            JLabel game = new JLabel(string);
            contentPanel.add(game, gbc);
            gbc.gridy++;
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
