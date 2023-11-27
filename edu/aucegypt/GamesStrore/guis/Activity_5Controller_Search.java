/**
 * The `Activity_5Controller_Search` class is a controller for handling actions related to the Search menu
 * in the Player window.
 *
 * It implements the ActionListener interface to respond to user actions.
 */
package edu.aucegypt.GamesStrore.guis;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.users.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Controller class for handling actions related to the Search menu in the Player window.
 */
public class Activity_5Controller_Search implements ActionListener {
    private Player player;

    /**
     * Constructor for the controller class.
     *
     * @param player The associated Player object.
     */
    public Activity_5Controller_Search(Player player) {
        this.player = player;
    }

    /**
     * Responds to actionPerformed events triggered by user actions in the Search menu.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = new String();
        String command = e.getActionCommand();
        switch (command) {
            case "Search games by genres":
                // Prompt the user to enter tags separated by commas
                input = JOptionPane.showInputDialog("Enter the tags separated by commas");
                String commaSeparatedString = input;
                String[] parts = commaSeparatedString.split(",");
                ArrayList<String> T = new ArrayList<>();
                for (String part : parts) {
                    T.add(part);
                }

                // Perform a tags-based search and display the results
                LinkedList<Game> tagSearch = player.tagsBasedSearchGUI(T);
                if (tagSearch != null) {
                    listSearch(tagSearch);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Search games by release year":
                // Prompt the user to enter the target year
                input = JOptionPane.showInputDialog("Enter the target year");

                // Perform a year-based search and display the results
                LinkedList<Game> yearSearch = player.yearBasedSearchGUI(Integer.parseInt(input));
                if (yearSearch != null) {
                    listSearch(yearSearch);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Search games by release month":
                // Prompt the user to enter the target month
                input = JOptionPane.showInputDialog("Enter the target month");

                // Perform a month-based search and display the results
                LinkedList<Game> monthSearch = player.monthBasedSearchGUI(Integer.parseInt(input));
                if (monthSearch != null) {
                    listSearch(monthSearch);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "View game details":
                // Prompt the user to enter the game title
                input = JOptionPane.showInputDialog("Enter the game title");

                // Fetch the game details and display them
                Game game = player.fetchGameByTitle(input);
                if (game != null) {
                    listGame(game);
                } else {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            default:
                // Handle unknown action commands
                System.out.println("Unknown action command: " + command);
                break;
        }
    }

    /**
     * Helper method to display search results in a new JFrame.
     *
     * @param games The list of games to display.
     */
    private static void listSearch(LinkedList<Game> games) {
        JTextArea displayTextArea = new JTextArea();
        displayTextArea.setWrapStyleWord(true);
        displayTextArea.setLineWrap(true);
        displayTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayTextArea);

        JFrame displayFrame = new JFrame("Preference-Based Search");
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.add(scrollPane);

        displayTextArea.append("Games Based on Preference Search:\n\n");
        for (Game game : games) {
            displayTextArea.append(game.getGameName() +
                " - Release Date: " + game.getReleaseDate() +
                " - Price: " + game.getPrice() + "\n");
        }

        displayTextArea.append("\n");

        displayFrame.setSize(400, 400);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(true);
    }

    /**
     * Helper method to display detailed game information in a new JFrame.
     *
     * @param game The game to display.
     */
    private static void listGame(Game game) {
        JTextArea displayTextArea = new JTextArea();
        displayTextArea.setWrapStyleWord(true);
        displayTextArea.setLineWrap(true);
        displayTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayTextArea);

        JFrame displayFrame = new JFrame("Detailed Game");
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.add(scrollPane);

        displayTextArea.append("Game Details:\n \n");

        displayTextArea.append(
            " - Name: " + game.getGameName() + "\n" +
            " - Description: " + game.getGameDescription() + "\n" +
            " - Developer: " + game.getDeveloper() + "\n" +
            " - Publisher: " + game.getPublisher() + "\n" +
            " - Release Date: " + game.getReleaseDate() + "\n" +
            " - Price: " + game.getPrice() + "\n\n"
        );

        displayTextArea.append("\n");

        displayFrame.setSize(500, 400);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(true);
    }
}
