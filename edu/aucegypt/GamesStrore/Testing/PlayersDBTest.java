package edu.aucegypt.GamesStrore.Testing;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.aucegypt.GamesStrore.users.Player;
import edu.aucegypt.GamesStrore.users.PlayersDB;

public class PlayersDBTest 
{

    @BeforeEach
    void setUp()
    {
        PlayersDB.setPlayerList(new ArrayList<>());
    }

    @Test
    public void testSignUpWithValidPlayer() {
        Player player = new Player("TestUser", "TestPassword", "test@example.com");
        assertEquals("successful signup", PlayersDB.signUp(player));
        assertEquals(1,PlayersDB.getPlayerList().size());
    }

    @Test
    public void testSignUpWithDuplicateEmail() {
        Player player1 = new Player("User1", "Password1", "test@example.com");
        Player player2 = new Player("User2", "Password2", "test@example.com");
        PlayersDB.signUp(player1);
        assertEquals("matching credentials", PlayersDB.signUp(player2));
    }

    @Test
    public void testSignUpWithDuplicateUsername() {
        Player player1 = new Player("User1", "Password1", "test1@example.com");
        Player player2 = new Player("User1", "Password2", "test2@example.com");
        PlayersDB.signUp(player1);
        assertEquals("matching credentials", PlayersDB.signUp(player2));
    }

    

    @Test
    public void testSignUpWithNullEmail() {
        Player player = new Player(null, "TestPassword", "test@example.com");
        assertEquals("invalid credentials", PlayersDB.signUp(player));
    }

    @Test
    public void testSignUpWithEmptyPassword() {
        Player player = new Player("TestUser", "", "test@example.com");
        assertEquals("invalid credentials", PlayersDB.signUp(player));
    }

    @Test
    public void testSignUpWithNullUsername() {
        Player player = new Player("TestUser", "TestPassword", null);
        assertEquals("invalid credentials", PlayersDB.signUp(player));
    }

    @Test
    public void testLogInWithCorrectCredentials() {
        Player player = new Player("TestUser", "TestPassword", "test@example.com");
        PlayersDB.signUp(player);
        assertTrue(PlayersDB.logIn(player));
    }

    @Test
    public void testLogInWithIncorrectUsername() {
        Player player = new Player("TestUser", "TestPassword", "test@example.com");
        PlayersDB.signUp(player);
        Player incorrectPlayer = new Player("WrongUser", "TestPassword", "test@example.com");
        assertFalse(PlayersDB.logIn(incorrectPlayer));
    }

    @Test
    public void testLogInWithIncorrectPassword() {
        Player player = new Player("TestUser", "TestPassword", "test@example.com");
        PlayersDB.signUp(player);
        Player incorrectPlayer = new Player("TestUser", "WrongPassword", "test@example.com");
        assertFalse(PlayersDB.logIn(incorrectPlayer));
    }

    @Test
    public void testLogInWithEmptyList() {
        Player player = new Player("TestUser", "TestPassword", "test@example.com");
        assertFalse(PlayersDB.logIn(player));
    }

    @Test
    public void testSearchByNameWithExistingPlayer() {
        Player player = new Player("TestUser", "TestPassword", "test@example.com");
        PlayersDB.signUp(player);
        Player foundPlayer = PlayersDB.searchByname("TestUser");
        assertNotNull(foundPlayer);
        assertEquals("TestUser", foundPlayer.getUsername());
    }

    @Test
    public void testSearchByNameWithNonExistingPlayer() {
        Player player = new Player("TestUser", "TestPassword", "test@example.com");
        PlayersDB.signUp(player);
        Player notFoundPlayer = PlayersDB.searchByname("NonExistingUser");
        assertNull(notFoundPlayer);
    }

    @Test
    public void testSearchByNameWithEmptyName() {
        Player notFoundPlayer = PlayersDB.searchByname("");
        assertNull(notFoundPlayer);
    }

    @Test
    public void testSearchByNameWithNullName() {
        Player notFoundPlayer = PlayersDB.searchByname(null);
        assertNull(notFoundPlayer);
    }
}
