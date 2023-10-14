package edu.aucegypt.GamesStrore.games;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * The `Game` class represents a video game in the game store system. It stores information about the game, such as its name,
 * description, ratings, reviews, release date, developer, publisher, genre tags, pricing, and download statistics.
 */
public class Game {
    private String gameName;
    private String gameDescription;
    private int numberOfRatings;
    private ArrayList<Rate> ratings;
    private int numberOfReviews;
    private ArrayList<Review> reviews;
    private String releaseDate; // YY-MM-DD
    private String developer;
    private String publisher;
    private ArrayList<String> genreTags;
    private BigDecimal originalPrice;
    private BigDecimal price;
    private BigDecimal discount;
    private int numberOfDownloads;

    // Constructors
    public Game() 
    {
        this.gameName = new String();
        this.gameDescription =  new String();
        this.developer = new String();
        this.publisher = new String();
        
        this.numberOfRatings = 0;
        this.numberOfReviews = 0;
        this.numberOfDownloads = 0;

        
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.genreTags = new ArrayList<>();
        this.releaseDate = new String(); 
        this.originalPrice = BigDecimal.ZERO; 
        this.price = BigDecimal.ZERO;
        this.discount = BigDecimal.ZERO;
    }

    

    public Game(String gameName) 
    {
        this.gameName = gameName;
        this.gameDescription =  new String();
        this.developer = new String();
        this.publisher = new String();
        this.numberOfRatings = 0;
        this.numberOfReviews = 0;
        this.numberOfDownloads = 0;

        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.genreTags = new ArrayList<>();
        this.releaseDate = new String(); 
        this.originalPrice = BigDecimal.ZERO; 
        this.price = BigDecimal.ZERO;
        this.discount = BigDecimal.ZERO;

    }



    public Game(String gameName, String gameDescription, int numberOfRatings, ArrayList<Rate> ratings,
            int numberOfReviews, ArrayList<Review> reviews, String releaseDate, String developer, String publisher,
            ArrayList<String> genreTags,BigDecimal originalPrice, BigDecimal price, BigDecimal discount, int numberOfDownloads) {
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.numberOfRatings = numberOfRatings;
        this.ratings = ratings;
        this.numberOfReviews = numberOfReviews;
        this.reviews = reviews;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.publisher = publisher;
        this.genreTags = genreTags;
        this.originalPrice = originalPrice;
        this.price = price;
        this.discount = discount;
        this.numberOfDownloads = numberOfDownloads;
    }

    // setters and getters
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public ArrayList<Rate> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rate> ratings) {
        this.ratings = ratings;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
    public boolean addGenreTag(String genreTag) 
    {
        try
        {
            if(genreTag == null)
            {
                throw new IllegalArgumentException("Null refrence game tag");
            }

            if(genreTag.isEmpty())
            {
                throw new IllegalArgumentException("No game tag");
            }
        }
        catch (IllegalArgumentException e) 
        {
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
    public boolean removeGenreTag(String genreTag) 
    {
        try
        {
            if(genreTag == null)
            {
                throw new IllegalArgumentException("Null refrence game tag");
            }

            if(genreTag.isEmpty())
            {
                throw new IllegalArgumentException("No game tag");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid genreTag, please re-enter");
            return false;
        }
        genreTags.remove(genreTag);
        return true;
    }

    /**
     * Apply a discount to the game's price by subtracting the discount amount from the original price.
     */
    public void applyDiscount()
    {
        BigDecimal newPrice = this.originalPrice.subtract(this.discount);
        this.setPrice(newPrice);
    }

    /**
     * Remove the discount from the game's price, resetting it to the original price.
     */
    public void removeDiscount()
    {
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
