package edu.aucegypt.GamesStrore.users;

import java.util.LinkedList;


/**
 * The `PlayersDB` class is responsible for managing the player database and providing
 * methods to search for players, sign up new players, and handle player logins.
 */
public class PlayersDB {

    // Database of players
    private static LinkedList<Player> playerList = new LinkedList<>();

    /**
     * Get the list of players in the database.
     *
     * @return A LinkedList containing all the registered players.
     */
    public static LinkedList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Set the list of players in the database.
     *
     * @param playerList The LinkedList of players to set as the database.
     */
    public static void setPlayerList(LinkedList<Player> playerList) {
        PlayersDB.playerList = playerList;
    }   
    
    /**
     * Search for a player by their username.
     *
     * @param playerName The username of the player to search for.
     * @return The Player object if found, or null if not found.
     */
    public static Player searchByName(String playerName) {
        try {
            if (playerName == null) {
                throw new IllegalArgumentException("Null reference player name");
            }

            if (playerName.isEmpty()) {
                throw new IllegalArgumentException("No player name");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid player name, please re-enter");
            return null;
        }

        Player foundPlayer = PlayersDB.playerList.stream()
                .filter(player -> player.getUsername().equals(playerName))
                .findFirst()
                .orElse(null);

        return foundPlayer;
    }

    /**
     * Register a new player in the database.
     *
     * @param player The Player object representing the new player to sign up.
     * @return A status message indicating the outcome of the sign-up process.
     */
    public static String signUp(Player player) {
        String status = null;

        if (player.getEmail() == null || player.getPassword().length() == 0 || player.getUsername() == null) {
            System.out.println("Invalid credentials");
            status = "invalid credentials";
        } else {
            for (Player temp : playerList) {
                if (temp.getEmail().equals(player.getEmail()) || temp.getUsername().equals(player.getUsername())) {
                    System.out.println("Matching credentials");
                    status = "matching credentials";
                    return status;
                }
            }

            System.out.println("Successful signup");
            status = "successful signup";
            PlayersDB.playerList.add(player);
        }
        return status;
    }

    /**
     * Perform a login for an existing player in the database.
     *
     * @param player The Player object representing the player attempting to log in.
     * @return true if the login is successful, false if the credentials are incorrect.
     */
    public static boolean logIn(Player player) {
        boolean status = false;
        boolean found = false;

        for (Player temp : PlayersDB.playerList) {
            if (temp.getUsername().equals(player.getUsername()) && temp.getPassword().equals(player.getPassword())) {
                System.out.println("Correct credentials, logging in....");
                status = true;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid credentials");
            status = false;
        }

        return status;
    }
}
