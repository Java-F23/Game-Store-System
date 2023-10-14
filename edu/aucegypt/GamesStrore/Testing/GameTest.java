package edu.aucegypt.GamesStrore.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.Rate;
import edu.aucegypt.GamesStrore.games.Review;

public class GameTest 
{
    private Game game;

    @BeforeEach
    void setUp() {
        // Create a new Game object before each test
        game = new Game();
    }

    @Test
    void testGameName() {
        // Test the getter and setter for gameName attribute
        game.setGameName("Test Game");
        assertEquals("Test Game", game.getGameName());
    }

    @Test
    void testGameDescription() {
        // Test the getter and setter for gameDescription attribute
        game.setGameDescription("This is a test game.");
        assertEquals("This is a test game.", game.getGameDescription());
    }

    @Test
    void testNumberOfRatings() {
        // Test the getter and setter for numberOfRatings attribute
        game.setNumberOfRatings(100);
        assertEquals(100, game.getNumberOfRatings());
    }

    @Test
    void testRatings() {
        // Test the getter and setter for ratings attribute
        ArrayList<Rate> ratings = new ArrayList<>();
        Rate rate = new Rate(5, "Test Player");
        ratings.add(rate);
        game.setRatings(ratings);
        assertEquals(ratings, game.getRatings());
    }

    @Test
    void testNumberOfReviews() {
        // Test the getter and setter for numberOfReviews attribute
        game.setNumberOfReviews(50);
        assertEquals(50, game.getNumberOfReviews());
    }

    @Test
    void testReviews() {
        // Test the getter and setter for reviews attribute
        ArrayList<Review> reviews = new ArrayList<>();
        Review review = new Review("Test review", "Test Player");
        reviews.add(review);
        game.setReviews(reviews);
        assertEquals(reviews, game.getReviews());
    }

    @Test
    void testReleaseDate() {
        // Test the getter and setter for releaseDate attribute
        String y = "2001";
        String m = "2";
        String d = "3";
        String releaseDate = y+"-"+m+"-"+d;
        game.setReleaseDate(releaseDate);
        assertEquals(releaseDate, game.getReleaseDate());
    }

    @Test
    void testDeveloper() {
        // Test the getter and setter for developer attribute
        game.setDeveloper("Game Developer");
        assertEquals("Game Developer", game.getDeveloper());
    }

    @Test
    void testPublisher() {
        // Test the getter and setter for publisher attribute
        game.setPublisher("Game Publisher");
        assertEquals("Game Publisher", game.getPublisher());
    }

    @Test
    void testGenreTags() {
        // Test the getter and setter for genreTags attribute
        ArrayList<String> genreTags = new ArrayList<>();
        genreTags.add("Action");
        genreTags.add("Adventure");
        game.setGenreTags(genreTags);
        assertEquals(genreTags, game.getGenreTags());
    }

    @Test
    void testOriginalPrice() {
        // Test the getter and setter for originalPrice attribute
        BigDecimal originalPrice = new BigDecimal("49.99");
        game.setOriginalPrice(originalPrice);
        assertEquals(originalPrice, game.getOriginalPrice());
    }

    @Test
    void testPrice() {
        // Test the getter and setter for price attribute
        BigDecimal price = new BigDecimal("39.99");
        game.setPrice(price);
        assertEquals(price, game.getPrice());
    }

    @Test
    void testDiscount() {
        // Test the getter and setter for discount attribute
        BigDecimal discount = new BigDecimal("10.00");
        game.setDiscount(discount);
        assertEquals(discount, game.getDiscount());
    }

    @Test
    void testNumberOfDownloads() {
        // Test the getter and setter for numberOfDownloads attribute
        game.setNumberOfDownloads(1000);
        assertEquals(1000, game.getNumberOfDownloads());
    }

    @Test
    public void testAddGenreTag() {
        assertTrue(game.addGenreTag("Action"));
        assertTrue(game.addGenreTag("Adventure"));
    }

    @Test
    public void testAddGenreTagWithNull() {
        assertFalse(game.addGenreTag(null));
    }

    @Test
    public void testAddGenreTagWithEmptyString() {
        assertFalse(game.addGenreTag(""));
    }

    @Test
    public void testRemoveGenreTag() {
        game.addGenreTag("Action");
        game.addGenreTag("Adventure");
        assertTrue(game.removeGenreTag("Action"));
        assertFalse(game.getGenreTags().contains("Action"));
    }

    @Test
    public void testRemoveGenreTagWithNull() {
        assertFalse(game.removeGenreTag(null));
    }

    @Test
    public void testRemoveGenreTagWithEmptyString() {
        assertFalse(game.removeGenreTag(""));
    }

    @Test
    public void testApplyDiscount() {
        game.setOriginalPrice(BigDecimal.valueOf(50.0));
        game.setDiscount(BigDecimal.valueOf(10.0));
        game.applyDiscount();
        assertEquals(BigDecimal.valueOf(40.0), game.getPrice());
    }

    @Test
    public void testRemoveDiscount() {
        game.setOriginalPrice(BigDecimal.valueOf(50.0));
        game.setDiscount(BigDecimal.valueOf(10.0));
        game.removeDiscount();
        assertEquals(BigDecimal.valueOf(50.0), game.getPrice());
    }
}
