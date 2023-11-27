package edu.aucegypt.GamesStrore.games;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/**
 * The `Game` class represents a video game in the game store system. It stores information about the game, such as its name,
 * description, ratings, reviews, release date, developer, publisher, genre tags, pricing, and download statistics.
 */
public class Game {
    private StringBuilder gameName = new StringBuilder();
    private StringBuilder gameDescription = new StringBuilder();
    private int numberOfRatings;
    private LinkedList<Map<String, Integer>> ratings;
    private int numberOfReviews;
    private LinkedList<Map<String, String>> reviews;
    private StringBuilder releaseDate = new StringBuilder(); // YY-MM-DD
    private StringBuilder developer = new StringBuilder();
    private StringBuilder publisher = new StringBuilder();
    private ArrayList<String> genreTags;
    private BigDecimal originalPrice;
    private BigDecimal price;
    private BigDecimal discount;
    private int numberOfDownloads;

    // Constructors
    public Game() 
    {
        this.gameName = new StringBuilder();
        this.gameDescription = new StringBuilder();
        this.developer = new StringBuilder();
        this.publisher = new StringBuilder();
        
        this.numberOfRatings = 0;
        this.numberOfReviews = 0;
        this.numberOfDownloads = 0;

        this.ratings = new LinkedList<>();
        this.reviews = new LinkedList<>();
        this.genreTags = new ArrayList<>();
        this.releaseDate = new StringBuilder(); 
        this.originalPrice = BigDecimal.ZERO; 
        this.price = BigDecimal.ZERO;
        this.discount = BigDecimal.ZERO;
    }

    public Game(String gameName) 
    {
        this.gameName.append(gameName);
        this.gameDescription = new StringBuilder();
        this.developer = new StringBuilder();
        this.publisher = new StringBuilder();
        this.numberOfRatings = 0;
        this.numberOfReviews = 0;
        this.numberOfDownloads = 0;

        this.ratings = new LinkedList<>();
        this.reviews = new LinkedList<>();
        this.genreTags = new ArrayList<>();
        this.releaseDate = new StringBuilder(); 
        this.originalPrice = BigDecimal.ZERO; 
        this.price = BigDecimal.ZERO;
        this.discount = BigDecimal.ZERO;
    }

    public Game(String gameName, String gameDescription, int numberOfRatings, LinkedList<Map<String, Integer>> ratings,
            int numberOfReviews, LinkedList<Map<String, String>> reviews, String releaseDate, String developer, String publisher,
            ArrayList<String> genreTags, BigDecimal originalPrice, BigDecimal price, BigDecimal discount, int numberOfDownloads) {
        this.gameName.append(gameName);
        this.gameDescription.append(gameDescription);
        this.numberOfRatings = numberOfRatings;
        this.ratings = ratings;
        this.numberOfReviews = numberOfReviews;
        this.reviews = reviews;
        this.releaseDate.append(releaseDate);
        this.developer.append(developer);
        this.publisher.append(publisher);
        this.genreTags = genreTags;
        this.originalPrice = originalPrice;
        this.price = price;
        this.discount = discount;
        this.numberOfDownloads = numberOfDownloads;
    }

    // setters and getters
    public String getGameName() {
        return gameName.toString();
    }

    public void setGameName(String gameName) {
        this.gameName.delete(0, this.gameName.length());
        this.gameName.append(gameName);
    }

    public String getGameDescription() {
        return gameDescription.toString();
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription.delete(0, this.gameDescription.length());
        this.gameDescription.append(gameDescription);
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public LinkedList<Map<String, Integer>> getRatings() {
        return ratings;
    }

    public void setRatings(LinkedList<Map<String, Integer>> ratings) {
        this.ratings = ratings;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public LinkedList<Map<String, String>> getReviews() {
        return reviews;
    }

    public void setReviews(LinkedList<Map<String, String>> reviews) {
        this.reviews = reviews;
    }

    public String getReleaseDate() {
        return releaseDate.toString();
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.delete(0, this.releaseDate.length());
        this.releaseDate.append(releaseDate);
    }

    public String getDeveloper() {
        return developer.toString();
    }

    public void setDeveloper(String developer) {
        this.developer.delete(0, this.developer.length());
        this.developer.append(developer);
    }

    public String getPublisher() {
        return publisher.toString();
    }

    public void setPublisher(String publisher) {
        this.publisher.delete(0, this.publisher.length());
        this.publisher.append(publisher);
    }

    public ArrayList<String> getGenreTags() {
        return genreTags;
    }

    public void setGenreTags(ArrayList<String> genreTags) {
        this.genreTags = genreTags;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getNumberOfDownloads() {
        return numberOfDownloads;
    }

    public void setNumberOfDownloads(int numberOfDownloads) {
        this.numberOfDownloads = numberOfDownloads;
    }

    /**
     * Add a genre tag to the game's list of genre tags.
     *
     * @param genreTag The genre tag to be added.
     * @return true if the genre tag is added successfully, false if the provided genre tag is invalid.
     */
    public boolean addGenreTag(String genreTag) {
        try {
            if (genreTag == null) {
                throw new IllegalArgumentException("Null reference for game tag");
            }

            if (genreTag.isEmpty()) {
                throw new IllegalArgumentException("Empty game tag");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid genreTag, please re-enter");
            return false;
        }

        genreTags.add(genreTag);
        return true;
    }

    /**
     * Remove a genre tag from the game's list of genre tags.
     *
     * @param genreTag The genre tag to be removed.
     * @return true if the genre tag is removed successfully, false if the provided genre tag is invalid.
     */
    public boolean removeGenreTag(String genreTag) {
        try {
            if (genreTag == null) {
                throw new IllegalArgumentException("Null reference for game tag");
            }

            if (genreTag.isEmpty()) {
                throw new IllegalArgumentException("Empty game tag");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid genreTag, please re-enter");
            return false;
        }
        genreTags.remove(genreTag);
        return true;
    }

    /**
     * Apply a discount to the game's price by subtracting the discount amount from the original price.
     */
    public void applyDiscount() {
        BigDecimal newPrice = this.originalPrice.subtract(this.discount);
        this.setPrice(newPrice);
    }

    /**
     * Remove the discount from the game's price, resetting it to the original price.
     */
    public void removeDiscount() {
        this.setPrice(this.originalPrice);
    }

    /**
     * Generate a string representation of the `Game` object.
     *
     * @return A string containing information about the game.
     */
    @Override
    public String toString() {
        return "Game [gameName=" + gameName + ", gameDescription=" + gameDescription + ", numberOfRatings="
                + numberOfRatings + ", ratings=" + ratings + ", numberOfReviews=" + numberOfReviews + ", reviews="
                + reviews + ", releaseDate=" + releaseDate + ", developer=" + developer + ", publisher=" + publisher
                + ", genreTags=" + genreTags + ", originalPrice=" + originalPrice + ", price=" + price + ", discount="
                + discount + ", numberOfDownloads=" + numberOfDownloads + "]";
    }
}
