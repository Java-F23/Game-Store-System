package edu.aucegypt.GamesStrore.games;

/**
 * The `Review` class represents a player's review for a game in the game store system. It includes the review text
 * and the name of the player who wrote the review.
 */
public class Review {
    private String review;       // The text of the review provided by the player.
    private String playerName;   // The name of the player who wrote the review.

    /**
     * Constructs a `Review` object with the specified review text and player's name.
     *
     * @param review     The text of the review provided by the player.
     * @param playerName The name of the player who wrote the review.
     */
    public Review(String review, String playerName) {
        this.review = review;
        this.playerName = playerName;
    }

    /**
     * Get the text of the review provided by the player.
     *
     * @return The review text.
     */
    public String getReview() {
        return review;
    }

    /**
     * Set the text of the review provided by the player.
     *
     * @param review The new review text to set.
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Get the name of the player who wrote the review.
     *
     * @return The player's name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Set the name of the player who wrote the review.
     *
     * @param playerName The new player's name to set.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Returns a string representation of the `Review` object in the format "Review [review=<review>, playerName=<playerName>]".
     *
     * @return A string representation of the `Review` object.
     */
    @Override
    public String toString() {
        return "Review [review=" + review + ", playerName=" + playerName + "]";
    }
}

