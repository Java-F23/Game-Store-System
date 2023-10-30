package edu.aucegypt.GamesStrore.guis;

import javax.swing.*;

import edu.aucegypt.GamesStrore.users.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class Activity_5 {

    public static void openPlayerWindow(Player player) {
        // Create the main frame
        JFrame playerFrame = new JFrame("Player Window");
        playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerFrame.setSize(800, 600);

        // Create a horizontal menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create and add menus to the menu bar
        String[] menuNames = {"Games", "Friends", "Favorites", "Feedback", "Search", "Wallet"};
        for (String menuName : menuNames) {
            menuBar.add(createMenu(menuName));
        }

        // Set the menu bar for the frame
        playerFrame.setJMenuBar(menuBar);

        // Create a scroll pane to hold the content
        JScrollPane scrollPane = new JScrollPane();

        // Create a panel for the content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());

        // Create the Recommendations section
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel recommendationsLabel = new JLabel("<html><font color='#31906E'>Recommendations</font></html>");
        contentPanel.add(recommendationsLabel, gbc);
        gbc.gridy++;

        // Add some sample recommendations
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

        // Add some sample games
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

    private static JMenu createMenu(String menuName) {
        JMenu menu = new JMenu(menuName);

        if (menuName.equals("Games")) {
            String[] gameItems = {"Play Game", "Purchase Game", "Refund Game"};
            for (String item : gameItems) {
                menu.add(createMenuItem(item));
            }
        } else if (menuName.equals("Friends")) {
            String[] friendsItems = {"View Friends List", "Add a Friend", "Remove a Friend"};
            for (String item : friendsItems) {
                menu.add(createMenuItem(item));
            }
        } else if (menuName.equals("Favorites")) {
            String[] favoritesItems = {"View Favorites List", "Add a game to Favorites List", "Remove a game from Favorites List"};
            for (String item : favoritesItems) {
                menu.add(createMenuItem(item));
            }
        } else if (menuName.equals("Feedback")) {
            String[] feedbackItems = {"Add your rating to a game", "Remove your rating for a game", "Add your review to a game", "Remove your review from a game"};
            for (String item : feedbackItems) {
                menu.add(createMenuItem(item));
            }
        } else if (menuName.equals("Search")) {
            String[] searchItems = {"Search games by genres", "Search games by release year", "Search games by release month", "View game details"};
            for (String item : searchItems) {
                menu.add(createMenuItem(item));
            }
        }

        return menu;
    }

    private static JMenuItem createMenuItem(String item) {
        JMenuItem menuItem = new JMenuItem(item);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, item + " clicked.");
            }
        });
        return menuItem;
        
    }
}
