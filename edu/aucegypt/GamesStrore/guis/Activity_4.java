package edu.aucegypt.GamesStrore.guis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.users.Administrator;

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
                // Open a new JFrame for editing game details
                JFrame editDetailsFrame = new JFrame("Edit Game Details");
                editDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                editDetailsFrame.setSize(400, 300);
                // Add components and functionality for editing game details here
                editDetailsFrame.setVisible(true);
            }
        });

        editGamesMenu.add(addGameMenuItem);
        editGamesMenu.add(removeGameMenuItem);
        editGamesMenu.add(editGameDetailsMenuItem);
        editGamesMenu.add(applyDiscountMenuItem);

        // Reports menu options
        reportsMenu.add(createRadioButtons());

        menuBar.add(editGamesMenu);
        menuBar.add(reportsMenu);

        adminFrame.setJMenuBar(menuBar);
        adminFrame.setVisible(true);
    }

    private static JPanel createRadioButtons() {
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        JRadioButton option1 = new JRadioButton("Report Option 1");
        JRadioButton option2 = new JRadioButton("Report Option 2");
        JRadioButton option3 = new JRadioButton("Report Option 3");

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Report Option 1 was clicked.");
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Report Option 2 was clicked.");
            }
        });

        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Report Option 3 was clicked.");
            }
        });

        radioPanel.add(option1);
        radioPanel.add(option2);
        radioPanel.add(option3);

        return radioPanel;
    }
}
