package edu.aucegypt.GamesStrore.games;

/**
 * The `Rate` class represents a player's rating for a game in the game store system. It includes the rating value and
 * the player's name who provided the rating.
 */
public class Rate {
    private int rate;            // The rating value given by the player.
    private String playerName;    // The name of the player who provided the rating.

    /**
     * Constructs a `Rate` object with the specified rating value and player's name.
     *
     * @param rate       The rating value given by the player.
     * @param playerName The name of the player who provided the rating.
     */
    public Rate(int rate, String playerName) {
        this.rate = rate;
        this.playerName = playerName;
    }

    /**
     * Get the rating value provided by the player.
     *
     * @return The rating value.
     */
    public int getRate() {
        return rate;
    }

    /**
     * Set the rating value provided by the player.
     *
     * @param rate The new rating value to set.
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * Get the name of the player who provided the rating.
     *
     * @return The player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Set the name of the player who provided the rating.
     *
     * @param playerName The new player's name to set.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Returns a string representation of the `Rate` object in the format "Rate [rate=<rating>, playerName=<playerName>]".
     *
     * @return A string representation of the `Rate` object.
     */
    @Override
    public String toString() {
        return "Rate [rate=" + rate + ", playerName=" + playerName + "]";
    }
}

