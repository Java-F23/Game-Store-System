package edu.aucegypt.GamesStrore.guis;

import javax.swing.*;

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
    private static int recomendationsNextGridYStop;

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
        
        recomendationsNextGridYStop = gbc.gridy;

        listContent(player.getRecommendations(), true);
        for (int i = 1; i <= 6; i++) {
            JLabel recommendation = new JLabel("Recommendation Example " + i);
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
        listContent(player.getGames(),false);
        for (int i = 1; i <= 10; i++) {
            JLabel game = new JLabel("Store Game Example " + i);
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
            ArrayList<JMenuItem> items = GamesHandler(gameItems,player);
            for(JMenuItem item : items)
            {
                menu.add(item);
            }

        } else if (menuName.equals("Friends")) 
        {
            String[] friendsItems = {"View Friends List", "Add a Friend", "Remove a Friend"};
            ArrayList<JMenuItem> items = FriendsHandler(friendsItems,player);
            for(JMenuItem item : items)
            {
                menu.add(item);
            }
            
        } else if (menuName.equals("Favorites")) 
        {
            String[] favoritesItems = {"View Favorites List", "Add a game to Favorites List", "Remove a game from Favorites List"};
            ArrayList<JMenuItem> items = FavoritesHandler(favoritesItems,player);
            for(JMenuItem item : items)
            {
                menu.add(item);
            }

        } else if (menuName.equals("Feedback")) 
        {
            String[] feedbackItems = {"Add your rating to a game", "Remove your rating for a game", "Add your review to a game", "Remove your review from a game"};
            ArrayList<JMenuItem> items = FeedbackHandler(feedbackItems,player);
            for(JMenuItem item : items)
            {
                menu.add(item);
            }

        } else if (menuName.equals("Search")) 
        {
            String[] searchItems = {"Search games by genres", "Search games by release year", "Search games by release month", "View game details"};
            ArrayList<JMenuItem> items = SearchHandler(searchItems,player);
            for(JMenuItem item : items)
            {
                menu.add(item);
            }

        } else if (menuName.equals("Wallet"))
        {
            String[] walletItems = {"View Wallet", "Add Money to Wallet"};
            ArrayList<JMenuItem> items = WalletHandler(walletItems, player);
            for(JMenuItem item : items)
            {
                menu.add(item);
            }
        }

        return menu;
    }

    private static ArrayList<JMenuItem> GamesHandler(String[] gameItems, Player player)
    {
        ArrayList<JMenuItem> list = new ArrayList<>();
        Activity_5Controller_Games gamesListener = new Activity_5Controller_Games(player);

        for (String item : gameItems) 
        {
            JMenuItem menuItem = new JMenuItem(item);
            
            switch (item) 
            {
                case "Play Game":
                    menuItem.setActionCommand("Play Game");
                    break;
                case "Purchase Game":
                    menuItem.setActionCommand("Purchase Game");
                    break;
                case "Refund Game":
                    menuItem.setActionCommand("Refund Game");
                    break;
                case "View Purchased Games":
                    menuItem.setActionCommand("View Purchased Games");
                    break;
                default:
                    System.out.println("Invalid game item: " + item);
            }
            menuItem.addActionListener(gamesListener);
            //JMenuItem menuItem = createMenuItem(item, player);
            list.add(menuItem);
        }

        return list;
    }

    private static ArrayList<JMenuItem> FriendsHandler(String[] friendsItems, Player player)
    {
        ArrayList<JMenuItem> list = new ArrayList<>();
        Activity_5Controller_Friends friendsListener = new Activity_5Controller_Friends(player);

        for (String item : friendsItems) 
        {
            JMenuItem menuItem = new JMenuItem(item);

            switch (item) 
            {
                case "View Friends List":
                    menuItem.setActionCommand("View Friends List");
                    break;
                case "Add a Friend":
                    menuItem.setActionCommand("Add a Friend");
                    break;
                case "Remove a Friend":
                    menuItem.setActionCommand("Remove a Friend");
                    break;
                default:
                    System.out.println("Invalid friends item: " + item);
            }

            //JMenuItem menuItem = createMenuItem(item, player);
            menuItem.addActionListener(friendsListener);
            list.add(menuItem);
        }
        
        return list;
    }

    private static ArrayList<JMenuItem> FavoritesHandler(String[] favoritesItems, Player player)
    {
        ArrayList<JMenuItem> list = new ArrayList<>();
        Activity_5Controller_Favorites favoritesListener = new Activity_5Controller_Favorites(player);

        for (String item : favoritesItems) 
        {
            JMenuItem menuItem = new JMenuItem(item);

            switch (item) 
            {
                case "View Favorites List":
                    menuItem.setActionCommand("View Favorites List");
                    break;
                case "Add a game to Favorites List":
                    menuItem.setActionCommand("Add a game to Favorites List");
                    break;
                case "Remove a game from Favorites List":
                    menuItem.setActionCommand("Remove a game from Favorites List");
                    break;
                default:
                    System.out.println("Invalid favorites item: " + item);
            }

            //JMenuItem menuItem = createMenuItem(item, player);
            menuItem.addActionListener(favoritesListener);
            list.add(menuItem);
        }
        
        return list;
    }

    private static ArrayList<JMenuItem> FeedbackHandler(String[] feedbackItems, Player player)
    {
        ArrayList<JMenuItem> list = new ArrayList<>();
        Activity_5Controller_FeedBack feedBackListener = new Activity_5Controller_FeedBack(player);


        for (String item : feedbackItems) 
        {
            JMenuItem menuItem = new JMenuItem(item);

            switch (item) 
            {
                case "Add your rating to a game":
                    menuItem.setActionCommand("Add your rating to a game");
                    break;
                case "Remove your rating for a game":
                    menuItem.setActionCommand("Remove your rating for a game");
                    break;
                case "Add your review to a game":
                    menuItem.setActionCommand("Add your review to a game");
                    break;
                case "Remove your review from a game":
                    menuItem.setActionCommand("Remove your review from a game");
                    break;
                default:
                    System.out.println("Invalid feedback item: " + item);
            }
    
            
            //JMenuItem menuItem = createMenuItem(item, player);
            menuItem.addActionListener(feedBackListener);

            list.add(menuItem);
        }
        
        return list;
    }

    private static ArrayList<JMenuItem> SearchHandler(String[] searchItems, Player player)
    {
        ArrayList<JMenuItem> list = new ArrayList<>();
        Activity_5Controller_Search searchListener = new Activity_5Controller_Search(player);

        for (String item : searchItems) 
        {
            JMenuItem menuItem = new JMenuItem(item);
            switch (item) 
            {
                case "Search games by genres":
                    menuItem.setActionCommand("Search games by genres");
                    break;
                case "Search games by release year":
                    menuItem.setActionCommand("Search games by release year");
                    break;
                case "Search games by release month":
                    menuItem.setActionCommand("Search games by release month");
                    break;
                case "View game details":
                    menuItem.setActionCommand("View game details");
                    break;
                default:
                    System.out.println("Invalid search item: " + item);
            }
    
            //JMenuItem menuItem = createMenuItem(item, player);

            menuItem.addActionListener(searchListener);
            list.add(menuItem);
        }
        
        return list;
    }

    private static ArrayList<JMenuItem> WalletHandler(String[] walletItems, Player player)
    {
        ArrayList<JMenuItem> list = new ArrayList<>();
        Activity_5Controller_Wallet walletListener = new Activity_5Controller_Wallet(player);


        for (String item : walletItems) 
        {
            JMenuItem menuItem = new JMenuItem(item);
            switch (item) 
            {
                case "View Wallet":
                    menuItem.setActionCommand("View Wallet");
                    break;
                case "Add Money to Wallet":
                    menuItem.setActionCommand("Add Money to Wallet");
                    break;
                default:
                    System.out.println("Invalid wallet item: " + item);
            }
    
            //JMenuItem menuItem = createMenuItem(item, player);

            menuItem.addActionListener(walletListener);
            list.add(menuItem);
        }
        
        return list;
    }


    // a list of helper functions
    protected static void listContent(ArrayList<String> content, boolean listReccomendation)
    {
        if(listReccomendation)
        {
            gbc.gridy = recomendationsNextGridYStop;
        }
        for (String string : content) 
        {
            JLabel game = new JLabel(string);
            contentPanel.add(game, gbc);
            gbc.gridy++;
        }
        if(listReccomendation)
        {
            recomendationsNextGridYStop = gbc.gridy;
        }

    }
}
