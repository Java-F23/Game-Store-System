package edu.aucegypt.GamesStrore.games;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The `GamesDB` class represents a database of video games in the game store system. It provides methods to manage and
 * retrieve information about the games in the database, such as searching by tags, filtering by release year, and more.
 */
public class GamesDB 
{
    private static LinkedList<Game> gameList = new LinkedList<>();

    /**
     * Get the list of games stored in the database.
     *
     * @return An ArrayList of Game objects.
     */
    public static LinkedList<Game> getGameList() {
        return gameList;
    }

    /**
     * Set the list of games in the database to a new list.
     *
     * @param gameList The new ArrayList of Game objects to replace the existing list.
     */
    public static void setGameList(LinkedList<Game> gameList) 
    {
        GamesDB.gameList = gameList;
    }
    
    /**
     * View a summarized list of games in the database, including game title, genres, release date, price, and discount.
     */
    public static void viewGames()
    {
        displayGamesSummarized(GamesDB.gameList);
    }

    public static LinkedList<Game> getGames()
    {
        return GamesDB.gameList;
    }

    /**
     * Search for games based on a single genre tag.
     *
     * @param genreTag The genre tag to search for.
     * @return true if the search is successful, false if the provided genre tag is invalid.
     */
    public static boolean tagBasedSearch(String genreTag)
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

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(genreTag);
        tagsBasedSearch(tempList);
        return true;
    }

    /**
     * Search for games based on a list of genre tags.
     *
     * @param genreTags The list of genre tags to search for.
     * @return true if the search is successful, false if the provided genre tags are invalid.
     */
    public static boolean tagsBasedSearch(ArrayList<String> genreTags)
    {
        try
        {
            if(genreTags == null)
            {
                throw new IllegalArgumentException("Null refrence game tags");
            }

            if(genreTags.isEmpty())
            {
                throw new IllegalArgumentException("No game tags");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid genreTags, please re-enter");
            return false;
        }

        LinkedList<Game> filtered = filterGamesByGenres(genreTags);
        displayGamesSummarized(filtered);
        return true;
    }

    /**
     * Search for games based on a list of genre tags.
     *
     * @param genreTags The list of genre tags to search for.
     * @return true if the search is successful, false if the provided genre tags are invalid.
     */
    public static LinkedList<Game> tagsBasedSearchGUI(ArrayList<String> genreTags)
    {
        try
        {
            if(genreTags == null)
            {
                throw new IllegalArgumentException("Null refrence game tags");
            }

            if(genreTags.isEmpty())
            {
                throw new IllegalArgumentException("No game tags");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid genreTags, please re-enter");
            return null;
        }

        LinkedList<Game> filtered = filterGamesByGenres(genreTags);

        return filtered;
        
    }

    /**
     * Search for games released in a specific year.
     *
     * @param year The release year to search for.
     * @return true if the search is successful, false if the provided year is invalid.
     */
    public static boolean yearBasedSearch(int year)
    {
        try
        {
            if (year < 0) 
            {
                throw new IllegalArgumentException("Invalid year value. Year must be non-negative.");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid year, please re-enter");
            return false;
        }
        LinkedList<Game> filtered = filterGamesByYear(year);
        displayGamesSummarized(filtered);
        return true;
    }

    /**
     * Search for games released in a specific year.
     *
     * @param year The release year to search for.
     * @return true if the search is successful, false if the provided year is invalid.
     */
    public static LinkedList<Game> yearBasedSearchGUI(int year)
    {
        try
        {
            if (year < 0) 
            {
                throw new IllegalArgumentException("Invalid year value. Year must be non-negative.");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid year, please re-enter");
            return null;
        }
        LinkedList<Game> filtered = filterGamesByYear(year);
        
        return filtered;
    }
    
    /**
     * Search for games released in a specific month.
     *
     * @param month The release month to search for.
     * @return true if the search is successful, false if the provided month is invalid.
     */
    public static boolean monthBasedSearch(int month)
    {
        try
        {
            if (month < 1 || month > 12) 
            {
                throw new IllegalArgumentException("Invalid month value. Month must be between 1 and 12.");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid month, please re-enter");
            return false;
        }
        LinkedList<Game> filtered = filterGamesByMonth(month);
        displayGamesSummarized(filtered);
        return true;
    }

    /**
     * Search for games released in a specific month.
     *
     * @param month The release month to search for.
     * @return true if the search is successful, false if the provided month is invalid.
     */
    public static LinkedList<Game> monthBasedSearchGUI(int month)
    {
        try
        {
            if (month < 1 || month > 12) 
            {
                throw new IllegalArgumentException("Invalid month value. Month must be between 1 and 12.");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid month, please re-enter");
            return null;
        }
        LinkedList<Game> filtered = filterGamesByMonth(month);
        return filtered;
    }

    /**
     * Filter a list of games based on a set of genre tags.
     *
     * @param genreTags The genre tags to filter games by.
     * @return An ArrayList of Game objects that match the specified genre tags.
     */
    public static LinkedList<Game> filterGamesByGenres(ArrayList<String> genreTags) 
    {
        try
        {
            if(genreTags == null)
            {
                throw new IllegalArgumentException("Null refrence game tags");
            }

            if(genreTags.isEmpty())
            {
                throw new IllegalArgumentException("No game tags");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid genreTags, please re-enter");
            return null;
        }

        ArrayList<Game> filteredGames = new ArrayList<>();
        for (Game game : GamesDB.gameList) {
            for (String tag : genreTags) {
                if (game.getGenreTags().contains(tag)) {
                    filteredGames.add(game);
                }
            }
        }


        LinkedList<Game> finalFilteredGames = new LinkedList<>();
        for (Game game : filteredGames) {
            if (!finalFilteredGames.contains(game)) {
                finalFilteredGames.add(game);
            }
        }

        return finalFilteredGames;
    }

    /**
     * Filter a list of games based on the release year.
     *
     * @param year The release year to filter games by.
     * @return An ArrayList of Game objects that were released in the specified year.
     */
    public static LinkedList<Game> filterGamesByYear(int year) 
    {
        try
        {
            if (year < 0) 
            {
                throw new IllegalArgumentException("Invalid year value. Year must be non-negative.");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid year, please re-enter");
            return null;
        }

        LinkedList<Game> filteredGames = new LinkedList<>();
        

        for (Game game : GamesDB.gameList) 
        {
            ArrayList<String> dateParts = new ArrayList<>();

            String[] parts = game.getReleaseDate().split("-");
            for (String part : parts) {
                dateParts.add(part);
            }

            

            if(dateParts.get(0).equals(String.valueOf(year)))
            {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    /**
     * Filter a list of games based on the release month.
     *
     * @param month The release month to filter games by.
     * @return An ArrayList of Game objects that were released in the specified month.
     */
    public static LinkedList<Game> filterGamesByMonth(int month) 
    {
        try
        {
            if (month < 1 || month > 12) 
            {
                throw new IllegalArgumentException("Invalid month value. Month must be between 1 and 12.");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid month, please re-enter");
            return null;
        }

        LinkedList<Game> filteredGames = new LinkedList<>();

        for (Game game : GamesDB.gameList) 
        {
            ArrayList<String> dateParts = new ArrayList<>();

            String[] parts = game.getReleaseDate().split("-");
            for (String part : parts) {
                dateParts.add(part);
            }

            
            if(Integer.parseInt(dateParts.get(1))==(month))
            {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    /**
     * Display a summarized list of games, including game title, genres, release date, price, and discount.
     *
     * @param games The list of Game objects to display.
     * @return true if the display is successful, false if the provided game list is invalid.
     */
    public static boolean displayGamesSummarized(LinkedList<Game> games)
    {
        try
        {
            if(games == null)
            {
                throw new IllegalArgumentException("Null refrence game list");
            }

            if(games.isEmpty())
            {
                throw new IllegalArgumentException("No game list");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid game list, please re-enter");
            return false;
        }

        for (Game game : games) {
            System.out.println("Game Title: " + game.getGameName());
            System.out.println("Genres: " + game.getGenreTags());
            System.out.println("Release Date: " + game.getReleaseDate());
            System.out.println("Price: " + game.getPrice() + " After applying: " + game.getDiscount() + "% discount");
            System.out.println("------------------------------");
        }
        return true;
    }

    /**
     * Display detailed information about a specific game, including title, description, release date, price, downloads,
     * ratings, reviews, developer, and publisher.
     *
     * @param game The Game object to display in detail.
     * @return true if the display is successful, false if the provided game is invalid.
     */
    public static boolean displayGameDetailed(Game game)
    {
        try
        {
            if(game == null)
            {
                throw new IllegalArgumentException("Null refrence game ");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid game , please re-enter");
            return false;
        }
        
        System.out.println("Game Title: " + game.getGameName());
        System.out.println("Genres: " + game.getGameDescription());
        System.out.println("Release Date: " + game.getReleaseDate());
        System.out.println("Price: " + game.getPrice() + " After applying: -" + game.getDiscount() + " $ discount");
        System.out.println("Number of downloads: " + game.getNumberOfDownloads());
        System.out.println("Number of ratings: " + game.getNumberOfRatings());
        System.out.println("Number of reviews: " + game.getNumberOfReviews());
        System.out.println("Developer: " + game.getDeveloper());
        System.out.println("Publisher: " + game.getPublisher());
        System.out.println("------------------------------");

        return true;
        
    }

    /**
     * Search for a game by its title in the database.
     *
     * @param gameTitle The title of the game to search for.
     * @return The Game object matching the provided title or null if no match is found.
     */
    public static Game searchByTitle(String gameTitle)
    {
        try
        {
            if(gameTitle == null)
            {
                throw new IllegalArgumentException("Null refrence game name");
            }

            if(gameTitle.isEmpty())
            {
                throw new IllegalArgumentException("No game name");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid game name, please re-enter");
            return null;
        }

        for (Game game : gameList)
        {
            if(game.getGameName().toLowerCase().equals(gameTitle.toLowerCase()))
            {
                return game;
            }
        }
        return null;
    }

    /**
     * Edit a game in the database at the specified index with a new Game object.
     *
     * @param index The index of the game to be edited.
     * @param game  The new Game object to replace the existing game.
     * @return true if the edit is successful, false if the provided index or game is invalid.
     */
    public static boolean editGame(int index, Game game) 
    {
        try
        {
            if(game == null)
            {
                throw new IllegalArgumentException("Null refrence game ");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid game , please re-enter");
            return false;
        }

        try
        {
            if(index < 0 || index  > gameList.size() - 1)
            {
                throw new IllegalArgumentException("index out of boundries ");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid index , please re-enter");
            return false;
        }

        
        gameList.set(index, game);
        System.out.println("Game edited successfully.");

        return true;
        
    }

    /**
     * Add a new game to the database.
     *
     * @param game The Game object to be added to the database.
     * @return true if the game is added successfully, false if the provided game is invalid or already exists in the database.
     */
    public static boolean addGame(Game game)
    {
        boolean status = false;
        boolean found = false;

        try
        {
            if(game == null)
            {
                throw new IllegalArgumentException("Null refrence game ");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid game , please re-enter");
            return false;
        }

        try 
        {
            if(game.getGameName() == null)
            {
                throw new IllegalArgumentException("Null refrence game title");
            }

            if(game.getGameName().isEmpty())
            {
                throw new IllegalArgumentException("No game title");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid argument, please re-enter");
            return false;
        }

        for(Game G : GamesDB.gameList)
        {
            if(G.getGameName().equals(game.getGameName()))
            {
                found = true;
                break;
            }
        }

        if(found)
        {
            System.out.println("game is already in the database");
            status = false;
        }
        else
        {
            
            
            GamesDB.gameList.add(game);
            System.out.println("game added to database");
            status = true;
            
        }

        // if(GamesDB.gameList.contains(game))
        // {
        //     System.out.println("game is already in the database");
        //     status = false;
        // }
        // else
        // {
            
            
        //     GamesDB.gameList.add(game);
        //     System.out.println("game added to database");
        //     status = true;
            
        // }
        return status;
    }

    /**
     * Remove a game from the database by its title.
     *
     * @param gameTitle The title of the game to be removed.
     * @return true if the game is successfully removed, false if the game with the provided title is not found.
     */
    public static boolean removeGame(String gameTitle)
    {
        try 
        {
            if(gameTitle == null)
            {
                throw new IllegalArgumentException("Null refrence game title");
            }

            if(gameTitle.isEmpty())
            {
                throw new IllegalArgumentException("No game title");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid argument, please re-enter");
            return false;
        }

        Game game = GamesDB.searchByTitle(gameTitle);
        try
        {
            if(game == null)
            {
                throw new IllegalArgumentException("Null refrence game ");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid game , please re-enter");
            return false;
        }

        try 
        {
            if(game.getGameName() == null)
            {
                throw new IllegalArgumentException("Null refrence game title");
            }

            if(game.getGameName().isEmpty())
            {
                throw new IllegalArgumentException("No game title");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid argument, please re-enter");
            return false;
        }
        
        boolean status = false;
        if(GamesDB.gameList.contains(game))
        {
            System.out.println("game removed");
            gameList.remove(game);
            status = true;
        }
        else
        {
            status = false;
        }
        return status;
    }
}