package edu.aucegypt.GamesStrore.users;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.GamesDB;

public class Administrator extends User 
{
    
    /**
     * Creates an instance of the Administrator class with the specified username, password, and email.
     *
     * @param username The username of the administrator.
     * @param password The password for the administrator's account.
     * @param email The email address associated with the administrator's account.
     */
    public Administrator(String username, String password, String email) {
        super(username, password, email);
    }

    /**
     * Add a new game to the game database.
     *
     * @param game The Game object to be added to the game database.
     * @return true if the game is successfully added, false otherwise.
     */
    public boolean addGame(Game game) 
    {
        return GamesDB.addGame(game);
    }

    /**
     * Remove a game from the game database by its title.
     *
     * @param gameTitle The title of the game to be removed.
     * @return true if the game is successfully removed, false if the game doesn't exist.
     */
    public boolean removeGame(String gameTitle) 
    {
        return GamesDB.removeGame(gameTitle);
    }

    /**
     * Edit the details of a game in the database.
     *
     * @param gameName The title of the game to be edited.
     * @param newGameName The new name for the game (null to keep the original value).
     * @param newDescription The new description for the game (null to keep the original value).
     * @param newReleaseDate The new release date for the game (null to keep the original value).
     * @param newDeveloper The new developer for the game (null to keep the original value).
     * @param newPublisher The new publisher for the game (null to keep the original value).
     * @param newOriginalPrice The new original price for the game (null to keep the original value).
     * @param newPrice The new price for the game (null to keep the original value).
     * @param newDiscount The new discount for the game (null to keep the original value).
     * @param newDownloads The new number of downloads for the game (use -1 to keep the original value).
     * @param newGenreTags The new genre tags for the game (null to keep the original value).
     * @return true if the game is successfully edited, false if the game doesn't exist.
     */
    public boolean editGame(String gameName, String newGameName,String newDescription, String newReleaseDate,
                         String newDeveloper, String newPublisher, BigDecimal newOriginalPrice, BigDecimal newPrice,
                         BigDecimal newDiscount, int newDownloads, ArrayList<String> newGenreTags) 
    {

        try 
        {
            if(gameName == null)
            {
                throw new IllegalArgumentException("Null refrence game title");
            }

            if(gameName.isEmpty())
            {
                throw new IllegalArgumentException("No game title");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid argument, please re-enter");
            return false;
        }


        Game game = GamesDB.searchByTitle(gameName);
        boolean status = false;
        
        if (game != null) 
        {
            int index = GamesDB.getGameList().indexOf(game);

            if (newGameName != null) 
            {
                game.setGameName(newGameName);
            }
            if (newDescription != null) 
            {
                game.setGameDescription(newDescription);
            }
            if (newReleaseDate != null) 
            {
                game.setReleaseDate(newReleaseDate);
            }
            if (newDeveloper != null) 
            {
                game.setDeveloper(newDeveloper);
            }
            if (newPublisher != null) 
            {
                game.setPublisher(newPublisher);
            }
            if(newOriginalPrice != null)
            {
                game.setOriginalPrice(newOriginalPrice);
            }
            if (newPrice != null) 
            {
                game.setPrice(newPrice);
            }
            if (newDiscount != null) 
            {
                game.setDiscount(newDiscount);
            }
            if (newDownloads >= 0) 
            {
                game.setNumberOfDownloads(newDownloads);
            }
            if (newGenreTags != null) 
            {
                game.setGenreTags(newGenreTags);
            }
            
            System.out.println("Game has been updated.");

            GamesDB.editGame(index, game);

            status = true;
        }
        else
        {
            System.out.println("No such game with that title in the database");
            status = false;
        }
        return status;
    }


    

    /**
     * Apply a discount to a game in the database.
     *
     * @param gameTitle The title of the game to which a discount will be applied.
     * @return true if the discount is successfully applied, false if the game doesn't exist.
     */
    public boolean applyDiscount(String gameTitle)
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
        

        game.applyDiscount();
        return true;
    }

    /**
     * Register a new administrator in the database.
     *
     * @return A status message indicating the outcome of the sign-up process.
     */
    public String signUp()
    {
        return AdministratorDB.signUp(this);
    }

    /**
     * Perform a login for an existing administrator in the database.
     *
     * @return true if the login is successful, false if the credentials are incorrect.
     */
    public boolean logIn()
    {
        return AdministratorDB.logIn(this);
    }

    public Game fetchGameByTitle(String gameTitle)
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
            return null;
        }

        Game game = GamesDB.searchByTitle(gameTitle);

        if(game != null)
        {
            return game;
        }
        else
        {
            System.out.println("No such game with that title in the database");
            return null;
        }
        
    }

    public LinkedList<Game> fetchGamesDB()
    {
        return GamesDB.getGameList();
    }

    public LinkedList<Player> fetchPlayersDB()
    {
        return PlayersDB.getPlayerList();
    }
}

