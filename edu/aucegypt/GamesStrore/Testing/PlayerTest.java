package edu.aucegypt.GamesStrore.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.GamesDB;
import edu.aucegypt.GamesStrore.users.Player;
import edu.aucegypt.GamesStrore.users.PlayersDB;

public class PlayerTest 
{
    private Player player;

    @BeforeEach
    public void setUp() 
    {
        player = new Player("TestUser", "TestPassword", "test@example.com");
        GamesDB.setGameList(new ArrayList<>());
        PlayersDB.setPlayerList(new ArrayList<>());
    }

    @Test
    public void testGetSetUsername() {
        assertEquals("TestUser", player.getUsername());
        player.setUsername("NewUser");
        assertEquals("NewUser", player.getUsername());
    }

    @Test
    public void testGetSetPassword() {
        assertEquals("TestPassword", player.getPassword());
        player.setPassword("NewPassword");
        assertEquals("NewPassword", player.getPassword());
    }

    @Test
    public void testGetSetEmail() {
        assertEquals("test@example.com", player.getEmail());
        player.setEmail("new@example.com");
        assertEquals("new@example.com", player.getEmail());
    }

    @Test
    public void testGetSetWallet() {
        BigDecimal initialWallet = player.getWallet();
        BigDecimal newWallet = new BigDecimal("100.00");
        player.setWallet(newWallet);
        assertEquals(newWallet, player.getWallet());
        assertNotEquals(initialWallet, player.getWallet());
    }

    @Test
    public void testGetSetFavoritesList() {
        ArrayList<String> initialFavoritesList = player.getfavoritesList();
        ArrayList<String> newFavoritesList = new ArrayList<>();
        newFavoritesList.add("Game1");
        player.setfavoritesList(newFavoritesList);
        assertEquals(newFavoritesList, player.getfavoritesList());
        assertNotEquals(initialFavoritesList, player.getfavoritesList());
    }

    @Test
    public void testGetSetPurchasedGames() {
        ArrayList<String> initialPurchasedGames = player.getPurchasedGames();
        ArrayList<String> newPurchasedGames = new ArrayList<>();
        newPurchasedGames.add("Game1");
        player.setPurchasedGames(newPurchasedGames);
        assertEquals(newPurchasedGames, player.getPurchasedGames());
        assertNotEquals(initialPurchasedGames, player.getPurchasedGames());
    }

    @Test
    public void testGetSetFriendsList() {
        ArrayList<String> initialFriendsList = player.getFriendsList();
        ArrayList<String> newFriendsList = new ArrayList<>();
        newFriendsList.add("Friend1");
        player.setFriendsList(newFriendsList);
        assertEquals(newFriendsList, player.getFriendsList());
        assertNotEquals(initialFriendsList, player.getFriendsList());
    }


    @Test
    public void testPlayGameWithNull() {
        assertFalse(player.playGame(null));
    }

    @Test
    public void testPlayGameWithEmptyTitle() {
        assertFalse(player.playGame(""));
    }

    @Test
    public void testPlayGameWithNonExistentGame() {
        assertFalse(player.playGame("NonExistentGame"));
    }

    @Test
    public void testPlayOwnedGame() {
        player.getPurchasedGames().add("OwnedGame");
        assertTrue(player.playGame("OwnedGame"));
    }

    

    @Test
    public void testPurchaseGameWithNullTitle() {
        player.setWallet(new BigDecimal("100.00"));

        assertEquals("invalid gameTitle", player.purchaseGame(null));
    }

    @Test
    public void testPurchaseGameWithEmptyTitle() {
        player.setWallet(new BigDecimal("100.00"));
        assertEquals("invalid gameTitle", player.purchaseGame(""));
    }

    @Test
    public void testPurchaseGameWithNonExistentGame() {
        player.setWallet(new BigDecimal("100.00"));
        assertEquals("no such game", player.purchaseGame("NonExistentGame"));
    }

    @Test
    public void testPurchaseGameWithInsufficientFunds() {
        player.setWallet(new BigDecimal(10.00));

        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);

        
        assertEquals("no money", player.purchaseGame("GameTitle"));
    }

    @Test
    public void testPurchaseGameSuccessfully() {
        player.setWallet(new BigDecimal(500.00));
        
        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);

        assertEquals("add to library", player.purchaseGame("GameTitle"));
        assertEquals(BigDecimal.valueOf(400),player.getWallet());
    }

    // @Test
    // public void testRefundGame() {
    //     assertEquals("invalid wallet", player.refundGame(null));
    // }

    @Test
    public void testRefundGameWithNullTitle() {
        assertEquals("invalid gameTitle", player.refundGame(null));
    }

    @Test
    public void testRefundGameWithEmptyTitle() {
        player.setWallet(new BigDecimal("100.00"));
        assertEquals("invalid gameTitle", player.refundGame(""));
    }

    @Test
    public void testRefundGameWithNonExistentGame() {
        player.setWallet(new BigDecimal("100.00"));
        assertEquals("game not available", player.refundGame("NonExistentGame"));
    }

    @Test
    public void testRefundNonPurchasedGame() {
        player.setWallet(new BigDecimal("100.00"));
        
        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);

        assertEquals("game not purchased", player.refundGame("GameTitle"));
    }

    @Test
    public void testRefundGameSuccessfully() {
        player.setWallet(new BigDecimal(100.0));
        
        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);

        player.purchaseGame("GameTitle");
        assertEquals(BigDecimal.valueOf(0),player.getWallet());
        assertEquals("game refunded", player.refundGame("GameTitle"));
        assertEquals(BigDecimal.valueOf(100), player.getWallet());
    }

    @Test
    public void testAddFriendWithNullName() {
        assertFalse(player.addFriend(null));
    }

    @Test
    public void testAddFriendWithEmptyName() {
        assertFalse(player.addFriend(""));
    }

    @Test
    public void testAddNonExistentFriendinDB() 
    {
    
        assertFalse(player.addFriend("FriendUser"));
    }

    @Test
    public void testAddNonExistentFriend() 
    {
        Player friend = new Player("FriendUser", "FriendPassword", "friend@example.com");
        ArrayList<Player> temp = new ArrayList<>();
        temp.add(friend);
        PlayersDB.setPlayerList(temp);

        assertTrue(player.addFriend("FriendUser"));
        assertEquals(1,player.getFriendsList().size());
    }

    @Test
    public void testAddExistingFriend() {
        Player friend = new Player("FriendUser", "FriendPassword", "friend@example.com");
        ArrayList<Player> temp = new ArrayList<>();
        temp.add(friend);
        PlayersDB.setPlayerList(temp);
        player.addFriend("FriendUser");
        assertFalse(player.addFriend("FriendUser"));
    }

    @Test
    public void testRemoveFriendWithNullName() {
        assertFalse(player.removeFriend(null));
    }

    @Test
    public void testRemoveFriendWithEmptyName() {
        assertFalse(player.removeFriend(""));
    }

    @Test
    public void testRemoveNonExistentFriendinDB() 
    {
    
        assertFalse(player.removeFriend("FriendUser"));
    }

    @Test
    public void testRemoveNonExistentFriend() {
        Player friend = new Player("FriendUser", "FriendPassword", "friend@example.com");
        ArrayList<Player> temp = new ArrayList<>();
        temp.add(friend);
        PlayersDB.setPlayerList(temp);

        assertFalse(player.removeFriend("FriendUser"));
    }

    @Test
    public void testRemoveExistingFriend() {
        Player friend = new Player("FriendUser", "FriendPassword", "friend@example.com");
        ArrayList<Player> temp = new ArrayList<>();
        temp.add(friend);
        PlayersDB.setPlayerList(temp);
        player.addFriend("FriendUser");
        assertTrue(player.removeFriend("FriendUser"));
        assertEquals(0,player.getFriendsList().size());

    }

    @Test
    public void testAddMoneyWithPositiveAmount() {
        assertTrue(player.addMoney(50.0));
        assertEquals((BigDecimal.valueOf(50.0)),player.getWallet());
        assertTrue(player.addMoney(50.0));
        assertEquals(BigDecimal.valueOf(100.0),player.getWallet());
    }

    @Test
    public void testAddMoneyWithZeroAmount() {
        assertFalse(player.addMoney(0.0));
    }

    @Test
    public void testAddMoneyWithNegativeAmount() {
        assertFalse(player.addMoney(-10.0));
    }

    @Test
    public void testAddToFavoritesListWithExistingGame() {
        player.setWallet(new BigDecimal(500.00));
        
        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);


        player.purchaseGame("GameTitle");
        assertTrue(player.addToFavoritesList("GameTitle"));
        assertEquals(1,player.getfavoritesList().size());
    }

    @Test
    public void testAddToFavoritesListWithExistingGameinList() {
        player.setWallet(new BigDecimal(500.00));
        
        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);


        player.purchaseGame("GameTitle");
        player.addToFavoritesList("GameTitle");
        assertFalse(player.addToFavoritesList("GameTitle"));
        assertEquals(1,player.getfavoritesList().size());
    }

    @Test
    public void testAddToFavoritesListWithNonExistingGameInLibrary() {
        
        assertFalse(player.addToFavoritesList("Game3"));
    }

    @Test
    public void testAddToFavoritesListWithNullGameTitle() {
        assertFalse(player.addToFavoritesList(null));
    }

    @Test
    public void testAddToFavoritesListWithEmptyGameTitle() {
        assertFalse(player.addToFavoritesList(""));
    }

    @Test
    public void testRemoveFromFavoritesListWithExistingGame() {
        player.setWallet(new BigDecimal(500.00));
        
        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);


        player.purchaseGame("GameTitle");
        player.addToFavoritesList("GameTitle");
        assertTrue(player.removeFromFavoritesList("GameTitle"));
        assertEquals(0,player.getfavoritesList().size());
    }

    @Test
    public void testRemoveFromFavoritesListWithNonExistingGame() {
        assertFalse(player.removeFromFavoritesList("Game3"));
    }

    @Test
    public void testRemoveFromFavoritesListWithNullGameTitle() {
        assertFalse(player.removeFromFavoritesList(null));
    }

    @Test
    public void testRemoveFromFavoritesListWithEmptyGameTitle() {
        assertFalse(player.removeFromFavoritesList(""));
    }

    @Test
    public void testAddRatingWithValidGameTitleAndValidRate() {
        Game game = new Game("Game1");
        GamesDB.addGame(game);
        assertTrue(player.addRating("Game1", 4));
        assertEquals(1,GamesDB.getGameList().get(0).getRatings().size());
    }

    @Test
    public void testAddRatingWithInvalidGameTitle() {
        assertFalse(player.addRating(null, 4));
    }

    @Test
    public void testAddRatingWithEmptyGameTitle() {
        assertFalse(player.addRating("", 4));
    }

    @Test
    public void testAddRatingWithValidGameTitleAndInvalidRate() {
        Game game = new Game("Game2");
        GamesDB.addGame(game);
        assertFalse(player.addRating("Game2", 6));
    }

    @Test
    public void testAddRatingWithValidGameTitleAndInvalidRateNeg() {
        Game game = new Game("Game2");
        GamesDB.addGame(game);
        assertFalse(player.addRating("Game2", -5));
    }

    @Test
    public void testRemoveRatingWithValidGameTitleAndRatingFound() {
        Game game = new Game("Game1");
        GamesDB.addGame(game);
        player.addRating("Game1", 4);
        assertEquals(1,GamesDB.getGameList().get(0).getRatings().size());
        assertEquals("rating removed", player.removeRating("Game1"));
        assertEquals(0,GamesDB.getGameList().get(0).getRatings().size());

    }

    @Test
    public void testRemoveRatingWithValidGameTitleAndRatingNotFound() {
        Game game = new Game("Game2");
        GamesDB.addGame(game);
        assertEquals("rating no found", player.removeRating("Game2"));
    }

    @Test
    public void testRemoveRatingWithInvalidGameTitle() {
        assertEquals("null argument", player.removeRating(null));
    }

    @Test
    public void testRemoveRatingWithEmptyGameTitle() {
        assertEquals("null argument", player.removeRating(""));
    }

    @Test
    public void testRemoveRatingWithNonExistingGame() {
        assertEquals("no such game", player.removeRating("GameO"));
    }

    @Test
    public void testAddReviewWithValidGameTitleAndReview() {
        Game game = new Game("Game1");
        GamesDB.addGame(game);
        assertEquals(true, player.addReview("Game1", "This is a great game!"));
        assertEquals(1,GamesDB.getGameList().get(0).getReviews().size());
    }

    @Test
    public void testAddReviewWithValidGameTitleAndNullReview() {
        Game game = new Game("Game2");
        GamesDB.addGame(game);
        assertEquals(false, player.addReview("Game2", null));
    }

    @Test
    public void testAddReviewWithValidGameTitleAndEmptyReview() {
        Game game = new Game("Game3");
        GamesDB.addGame(game);
        assertEquals(false, player.addReview("Game3", ""));
    }

    @Test
    public void testAddReviewWithInvalidGameTitle() {
        assertEquals(false, player.addReview(null, "This is a great game!"));
    }

    @Test
    public void testAddReviewWithEmptyGameTitle() {
        assertEquals(false, player.addReview("", "This is a great game!"));
    }

    @Test
    public void testAddReviewWithNonExistingGameTitle() {
        assertEquals(false, player.addReview("GameO", "This is a great game!"));
    }

    @Test
    public void testRemoveReviewWithValidGameTitleAndReviewExists() {
        Game game = new Game("Game1");
        GamesDB.addGame(game);
        player.addReview("Game1", "This is a great game!");
        assertEquals(1,GamesDB.getGameList().get(0).getReviews().size());
        assertEquals("review removed", player.removeReview("Game1"));
        assertEquals(0,GamesDB.getGameList().get(0).getReviews().size());

    }

    @Test
    public void testRemoveReviewWithValidGameTitleAndReviewNotExists() {
        Game game = new Game("Game2");
        GamesDB.addGame(game);
        assertEquals("review no found", player.removeReview("Game2"));
    }

    @Test
    public void testRemoveReviewWithInvalidGameTitle() {
        assertEquals("null argument", player.removeReview(null));
    }

    @Test
    public void testRemoveReviewWithEmptyGameTitle() {
        assertEquals("null argument", player.removeReview(""));
    }

    @Test
    public void testRemoveReviewWithNonExistingGameTitle() {
        assertEquals("no such game", player.removeReview("GameO"));
    }
}
