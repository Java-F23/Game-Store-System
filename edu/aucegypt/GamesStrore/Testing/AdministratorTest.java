package edu.aucegypt.GamesStrore.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.GamesDB;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.AdministratorDB;

public class AdministratorTest 
{
     private Administrator administrator;

    @BeforeEach
    public void setUp() 
    {
        administrator = new Administrator("AdminUser", "AdminPassword", "admin@example.com");
        GamesDB.setGameList(new ArrayList<>());
        AdministratorDB.setAdministratorList(new ArrayList<>());
    }

    @Test
    public void testEditGameWithExistingGame() 
    {
        Game game1 = new Game("GameTitle");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setPrice(new BigDecimal(100));
        game1.setReleaseDate(new String());

        GamesDB.addGame(game1);

        boolean status = administrator.editGame("GameTitle", "NewName", "NewDescription", new String(),
                "NewDeveloper", "NewPublisher", null,
                null, null, 200, new ArrayList<>());

        assertTrue(status);
        assertEquals("NewName", game1.getGameName());
        assertEquals("NewDescription", game1.getGameDescription());
        assertEquals(BigDecimal.valueOf(100),game1.getPrice());
    }

    @Test
    public void testEditGameWithNonExistingGame() {
        boolean status = administrator.editGame("NonExistingGame", "NewName", "NewDescription", new String(),
                "NewDeveloper", "NewPublisher", BigDecimal.valueOf(59.99),
                BigDecimal.valueOf(49.99), BigDecimal.valueOf(10.00), 200, new ArrayList<>());

        assertFalse(status);
    }

    @Test
    public void testEditGameWithNullGameName() {
        boolean status = administrator.editGame(null, "NewName", "NewDescription", new String(),
                "NewDeveloper", "NewPublisher", BigDecimal.valueOf(59.99),
                BigDecimal.valueOf(49.99), BigDecimal.valueOf(10.00), 200, new ArrayList<>());

        assertFalse(status);
    }

    @Test
    public void testEditGameWithEmptyGameName() {
        boolean status = administrator.editGame("", "NewName", "NewDescription", new String(),
                "NewDeveloper", "NewPublisher", BigDecimal.valueOf(59.99),
                BigDecimal.valueOf(49.99), BigDecimal.valueOf(10.00), 200, new ArrayList<>());

        assertFalse(status);
    }
}
