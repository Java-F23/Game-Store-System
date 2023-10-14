package edu.aucegypt.GamesStrore.Testing;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.GamesDB;

public class GamesDBTest 
{
    
    @BeforeEach
    void setUp()
    {
        GamesDB.setGameList(new ArrayList<>());
    }
    
    @Test
    void testGameList() 
    {
        // Create a test Game object
        Game game = new Game();
        game.setGameName("Test Game");

        // Add the game to the database
        ArrayList<Game> DB = new ArrayList<>();
        DB.add(game);
        GamesDB.setGameList(DB);


        // Retrieve the game from the database and check if it's the same
        assertEquals(DB, GamesDB.getGameList());
    }

    @Test
    public void testSearchByTitle() {
        Game game1 = new Game();
        game1.setGameName("Title 1");
        Game game2 = new Game();
        game2.setGameName("Title 2");
        
        GamesDB.addGame(game1);
        GamesDB.addGame(game2);

        assertEquals(game1, GamesDB.searchByTitle("Title 1"));
        assertEquals(game2, GamesDB.searchByTitle("TITLE 2"));
        assertNull(GamesDB.searchByTitle("Title 3"));
    }

    @Test
    public void testSearchByTitleWithNull() {
        assertNull(GamesDB.searchByTitle(null));
    }

    @Test
    public void testSearchByTitleWithEmptyString() {
        assertNull(GamesDB.searchByTitle(""));
    }

    @Test
    public void testEditGame() {
        Game game = new Game();
        game.setGameName("Title");
        Game newGame = new Game();
        newGame.setGameName("New Title");
        GamesDB.addGame(game);

        assertTrue(GamesDB.editGame(0, newGame));
        assertEquals(newGame.getGameName(),GamesDB.getGameList().get(0).getGameName());
    }

    @Test
    public void testEditGameWithNullGame() {
        assertFalse(GamesDB.editGame(0, null));
    }

    @Test
    public void testEditGameWithInvalidIndex() {
        Game game = new Game();
        game.setGameName("Title");
        assertFalse(GamesDB.editGame(-1, game));
        assertFalse(GamesDB.editGame(10, game));
    }

    @Test
    public void testAddGame() {
        Game game = new Game();
        game.setGameName("Title");

        assertTrue(GamesDB.addGame(game));
    }

    @Test
    public void testAddGameWithNullGame() {
        assertFalse(GamesDB.addGame(null));
    }

    @Test
    public void testAddGameWithNullTitle() {
        Game game = new Game();
        game.setGameName(null);

        assertFalse(GamesDB.addGame(game));
    }

    @Test
    public void testAddGameWithEmptyTitle() {
        Game game = new Game();
        game.setGameName("");

        assertFalse(GamesDB.addGame(game));
    }

    @Test
    public void testAddGameWithDuplicateGame() {
        Game game = new Game();
        game.setGameName("Title");
        GamesDB.addGame(game);

        assertFalse(GamesDB.addGame(game));
    }

    @Test
    public void testRemoveGame() {
        Game game = new Game();
        game.setGameName("Title");
        GamesDB.addGame(game);

        assertTrue(GamesDB.removeGame(game.getGameName()));
    }

    @Test
    public void testRemoveGameWithNullGame() {
        assertFalse(GamesDB.removeGame(null));
    }

    @Test
    public void testRemoveGameWithNullTitle() {
        Game game = new Game();
        game.setGameName(null);
        

        assertFalse(GamesDB.removeGame(game.getGameName()));
    }

    @Test
    public void testRemoveGameWithEmptyTitle() {
        Game game = new Game();
        game.setGameName("");
        GamesDB.addGame(game);

        assertFalse(GamesDB.removeGame(game.getGameName()));
    }

    @Test
    public void testRemoveNonExistentGame() {
        Game game = new Game();
        game.setGameName("Title");

        assertFalse(GamesDB.removeGame(game.getGameName()));
    }


    @Test
    public void testDisplayGamesSummarized() 
    {
         
        Game game1 = new Game("Title 1");
        game1.setGenreTags(new ArrayList<>(List.of("Genre1", "Genre2")));
        game1.setReleaseDate(new String());
        game1.setPrice(new BigDecimal("20.00"));
        game1.setDiscount(new BigDecimal("5.00"));

        Game game2 = new Game("Title 2");
        game2.setGenreTags(new ArrayList<>(List.of("Genre3")));
        game2.setReleaseDate(new String());
        game2.setPrice(new BigDecimal("15.00"));
        game2.setDiscount(new BigDecimal("3.00"));

        GamesDB.addGame(game1);
        GamesDB.addGame(game2);

        assertTrue(GamesDB.displayGamesSummarized(GamesDB.getGameList()));
    }

    @Test
    public void testDisplayGamesSummarizedWithNullList() {
        assertFalse(GamesDB.displayGamesSummarized(null));
    }

    @Test
    public void testDisplayGamesSummarizedWithEmptyList() {
        assertFalse(GamesDB.displayGamesSummarized(new ArrayList<>()));
    }

    @Test
    public void testDisplayGameDetailed() {
        Game game = new Game("Title");
        game.setGameDescription("Description");
        game.setReleaseDate(new String());
        game.setPrice(new BigDecimal("20.00"));
        game.setDiscount(new BigDecimal("5.00"));
        game.setNumberOfDownloads(100);
        game.setNumberOfRatings(50);
        game.setNumberOfReviews(10);
        game.setDeveloper("Developer");
        game.setPublisher("Publisher");

        assertTrue(GamesDB.displayGameDetailed(game));
    }

    @Test
    public void testDisplayGameDetailedWithNullGame() {
        assertFalse(GamesDB.displayGameDetailed(null));
    }

    
    @Test
    public void testFilterGamesByGenres() 
    {
        Game game1 = new Game("Title 1");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setReleaseDate(new String());

        Game game2 = new Game("Title 2");
        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("Genre2");
        temp2.add("Genre3");
        game2.setGenreTags(temp2);
        game2.setReleaseDate(new String());

        Game game3 = new Game("Title 3");
        ArrayList<String> temp3 = new ArrayList<>();
        temp3.add("Genre3");
        game3.setGenreTags(temp3);
        game3.setReleaseDate(new String());

        GamesDB.addGame(game1);
        GamesDB.addGame(game2);
        GamesDB.addGame(game3);

        ArrayList<String> genreTags = new ArrayList<>();
        genreTags.add("Genre2");
        genreTags.add("Genre3");
        ArrayList<Game> filteredGames = GamesDB.filterGamesByGenres(genreTags);

        assertEquals(3, filteredGames.size());
        assertTrue(filteredGames.contains(game1));
        assertTrue(filteredGames.contains(game2));
        assertTrue(filteredGames.contains(game3));
    }


    @Test
    public void testFilterGamesByGenresWithNullTags() {
        assertNull(GamesDB.filterGamesByGenres(null));
    }

    @Test
    public void testFilterGamesByGenresWithEmptyTags() {
        assertNull(GamesDB.filterGamesByGenres(new ArrayList<>()));
    }

    @Test
    public void testFilterGamesByYear() {
        Game game1 = new Game("Title 1");
        


        String y = "2021";
        String m = "1";
        String d = "1";
        String releaseDate = y+"-"+m+"-"+d;

        game1.setReleaseDate(releaseDate);

        Game game2 = new Game("Title 2");
        

        String y2 = "2022";
        String m2 = "3";
        String d2 = "15";
        String releaseDate2 = y2+"-"+m2+"-"+d2;
        game2.setReleaseDate(releaseDate2);

        GamesDB.addGame(game1);
        GamesDB.addGame(game2);

        ArrayList<Game> filteredGames = GamesDB.filterGamesByYear(2021);

        assertEquals(1, filteredGames.size());
        assertTrue(filteredGames.contains(game1));
        assertFalse(filteredGames.contains(game2));
    }

    @Test
    public void testFilterGamesByYearWithNegativeYear() {
        assertNull(GamesDB.filterGamesByYear(-2021));
    }

    @Test
    public void testFilterGamesByMonth() {
        Game game1 = new Game("Title 1");
        

        String y = "2021";
        String m = "1";
        String d = "1";
        String releaseDate = y+"-"+m+"-"+d;

        game1.setReleaseDate(releaseDate);

        Game game2 = new Game("Title 2");
        

        String y2 = "2022";
        String m2 = "4";
        String d2 = "15";
        String releaseDate2 = y2+"-"+m2+"-"+d2;

        game2.setReleaseDate(releaseDate2);

        GamesDB.addGame(game1);
        GamesDB.addGame(game2);

        ArrayList<Game> filteredGames = GamesDB.filterGamesByMonth(Calendar.APRIL + 1);

        assertEquals(1, filteredGames.size());
        assertTrue(filteredGames.contains(game2));
        assertFalse(filteredGames.contains(game1));
    }

    @Test
    public void testFilterGamesByMonthWithInvalidMonth() {
        assertNull(GamesDB.filterGamesByMonth(0));
        assertNull(GamesDB.filterGamesByMonth(13));
    }

    @Test
    public void testTagBasedSearch() {
        Game game1 = new Game("Title 1");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setReleaseDate(new String());

        Game game2 = new Game("Title 2");
        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("Genre2");
        temp2.add("Genre3");
        game2.setGenreTags(temp2);
        game2.setReleaseDate(new String());

        Game game3 = new Game("Title 3");
        ArrayList<String> temp3 = new ArrayList<>();
        temp3.add("Genre3");
        game3.setGenreTags(temp3);
        game3.setReleaseDate(new String());

        GamesDB.addGame(game1);
        GamesDB.addGame(game2);
        GamesDB.addGame(game3);


        assertTrue(GamesDB.tagBasedSearch("Genre1"));
        assertTrue(GamesDB.tagBasedSearch("Genre3"));
        assertTrue(GamesDB.tagBasedSearch("Genre4"));
    }

    @Test
    public void testTagBasedSearchWithNullTag() {
        assertFalse(GamesDB.tagBasedSearch(null));
    }

    @Test
    public void testTagBasedSearchWithEmptyTag() {
        assertFalse(GamesDB.tagBasedSearch(""));
    }

    @Test
    public void testTagsBasedSearch()
    {
        Game game1 = new Game("Title 1");
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Genre1");
        temp.add("Genre2");
        game1.setGenreTags(temp);
        game1.setReleaseDate(new String());

        Game game2 = new Game("Title 2");
        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("Genre2");
        temp2.add("Genre3");
        game2.setGenreTags(temp2);
        game2.setReleaseDate(new String());

        Game game3 = new Game("Title 3");
        ArrayList<String> temp3 = new ArrayList<>();
        temp3.add("Genre3");
        game3.setGenreTags(temp3);
        game3.setReleaseDate(new String());

        GamesDB.addGame(game1);
        GamesDB.addGame(game2);
        GamesDB.addGame(game3);

        ArrayList<String> genreTags = new ArrayList<>();
        genreTags.add("Genre2");
        genreTags.add("Genre3");

        assertTrue(GamesDB.tagsBasedSearch(genreTags));
    }

    @Test
    public void testTagsBasedSearchWithNullTagsList() {
        assertFalse(GamesDB.tagsBasedSearch(null));
    }

    @Test
    public void testTagsBasedSearchWithEmptyTagsList() {
        assertFalse(GamesDB.tagsBasedSearch(new ArrayList<>()));
    }

    @Test
    public void testYearBasedSearch() {
        Game game1 = new Game("Title 1");
        

        Game game2 = new Game("Title 2");
        

        String y = "2021";
        String m = "1";
        String d = "1";
        String releaseDate = y+"-"+m+"-"+d;

        game1.setReleaseDate(releaseDate);

        

        String y2 = "2022";
        String m2 = "3";
        String d2 = "15";
        String releaseDate2 = y2+"-"+m2+"-"+d2;

        game2.setReleaseDate(releaseDate2);
        


        GamesDB.addGame(game1);
        GamesDB.addGame(game2);

        assertTrue(GamesDB.yearBasedSearch(2021));
        assertTrue(GamesDB.yearBasedSearch(2022));
        assertTrue(GamesDB.yearBasedSearch(2020));
    }

    @Test
    public void testYearBasedSearchWithNegativeYear() {
        assertFalse(GamesDB.yearBasedSearch(-2021));
    }

    @Test
    public void testMonthBasedSearch() {
        Game game1 = new Game("Title 1");
        

        Game game2 = new Game("Title 2");
        

        String y = "2021";
        String m = "1";
        String d = "1";
        String releaseDate = y+"-"+m+"-"+d;

        game1.setReleaseDate(releaseDate);

        

        String y2 = "2023";
        String m2 = "3";
        String d2 = "15";
        String releaseDate2 = y2+"-"+m2+"-"+d2;

        game2.setReleaseDate(releaseDate2);

        GamesDB.addGame(game1);
        GamesDB.addGame(game2);

        assertTrue(GamesDB.monthBasedSearch(1));
        assertTrue(GamesDB.monthBasedSearch(3));
        assertTrue(GamesDB.monthBasedSearch(2));
    }

    @Test
    public void testMonthBasedSearchWithInvalidMonth() {
        assertFalse(GamesDB.monthBasedSearch(0));
        assertFalse(GamesDB.monthBasedSearch(13));
    }
}
