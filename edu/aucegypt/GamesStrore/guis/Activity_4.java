/**
 * The `Activity_4` class represents the Admin window of the application, handling Admin tasks.
 * It includes methods to open the Admin window, create radio buttons for reports, and edit game details.
 */
package edu.aucegypt.GamesStrore.guis;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import edu.aucegypt.GamesStrore.users.Administrator;

public class Activity_4 {

    private static ActionListener adminHandler;
    protected static JFrame adminFrame;
    protected static JFrame editDetailsFrame;

    protected static JTextField gameNameField;
    protected static JTextField descriptionField;
    protected static JTextField releaseDateField;
    protected static JTextField developerField;
    protected static JTextField publisherField;
    protected static JTextField originalPriceField;
    protected static JTextField priceField;
    protected static JTextField discountField;
    protected static JTextField genreTagsField;

    /**
     * Opens the Admin window.
     * 
     * @param administrator The Administrator object associated with the Admin window.
     */
    public static void openAdminWindow(Administrator administrator) {
        adminHandler = new Activity_4Controller();

        adminFrame = new JFrame("Admin Window");
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

        addGameMenuItem.setActionCommand("addGameMenuItem");
        addGameMenuItem.addActionListener(adminHandler);

        removeGameMenuItem.setActionCommand("removeGameMenuItem");
        removeGameMenuItem.addActionListener(adminHandler);

        applyDiscountMenuItem.setActionCommand("applyDiscountMenuItem");
        applyDiscountMenuItem.addActionListener(adminHandler);

        editGameDetailsMenuItem.setActionCommand("editGameDetailsMenuItem");
        editGameDetailsMenuItem.addActionListener(adminHandler);

        JMenuItem logout = new JMenuItem("Logout");
        logout.setActionCommand("logout");
        logout.addActionListener(adminHandler);

        editGamesMenu.add(addGameMenuItem);
        editGamesMenu.add(removeGameMenuItem);
        editGamesMenu.add(editGameDetailsMenuItem);
        editGamesMenu.add(applyDiscountMenuItem);

        // Reports menu options
        reportsMenu.add(createRadioButtons(administrator));

        menuBar.add(editGamesMenu);
        menuBar.add(reportsMenu);
        menuBar.add(logout);

        adminFrame.setJMenuBar(menuBar);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);
    }

    /**
     * Creates a panel with radio buttons for different reports.
     * 
     * @param administrator The Administrator object associated with the Admin window.
     * @return A JPanel containing radio buttons for reports.
     */
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

        gameRates.setActionCommand("gameRates");
        gameRates.addActionListener(adminHandler);

        gameReviews.setActionCommand("gameReviews");
        gameReviews.addActionListener(adminHandler);

        generateReports.setActionCommand("generateReports");
        generateReports.addActionListener(adminHandler);

        radioPanel.add(gameRates);
        radioPanel.add(gameReviews);
        radioPanel.add(generateReports);

        return radioPanel;
    }

    /**
     * Opens a frame to edit game details.
     * 
     * @param administrator The Administrator object associated with the Admin window.
     * @param gameTitle      The title of the game to be edited.
     */
    protected static void editGame(Administrator administrator, String gameTitle) {
        editDetailsFrame = new JFrame("Edit Game Details");
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

        confirmButton.setActionCommand("confirmButton");
        confirmButton.addActionListener(adminHandler);

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
}
