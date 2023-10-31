package edu.aucegypt.GamesStrore.users;

import java.math.BigDecimal;
import java.util.ArrayList;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.GamesDB;
import edu.aucegypt.GamesStrore.games.Rate;
import edu.aucegypt.GamesStrore.games.Review;

public class Player extends User {

    private BigDecimal wallet; // Player's wallet balance
    private ArrayList<String> favoritesList; // List of favorite games
    private ArrayList<String> purchasedGames; // List of purchased games
    private ArrayList<String> friendsList; // List of friends

    
    // Class Constructors
    public Player(String username, String password, String email) 
    {
        super(username, password, email);
        this.wallet = BigDecimal.ZERO;
        this.favoritesList = new ArrayList<>();
        this.purchasedGames = new ArrayList<>();
        this.friendsList = new ArrayList<>();

    }



    public Player(String username, String password, String email, BigDecimal wallet,
                  ArrayList<String> favoritesList, ArrayList<String> purchasedGames, ArrayList<String> friendsList) 
    {
        super(username, password, email);
        this.wallet = wallet;
        this.favoritesList = favoritesList;
        this.purchasedGames = purchasedGames;
        this.friendsList = friendsList;
    }

    // Class setters & getters
    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public ArrayList<String> getfavoritesList() {
        return favoritesList;
    }

    public void setfavoritesList(ArrayList<String> favoritesList) {
        this.favoritesList = favoritesList;
    }

    public ArrayList<String> getPurchasedGames() {
        return purchasedGames;
    }

    public void setPurchasedGames(ArrayList<String> purchasedGames) {
        this.purchasedGames = purchasedGames;
    }

    public ArrayList<String> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(ArrayList<String> friendsList) {
        this.friendsList = friendsList;
    }


    // Methods for player actions

    /**
     * Allows the player to play a game if they own it.
     *
     * @param gameTitle The title of the game to play.
     * @return true if the player can play the game, false otherwise.
     */
    public boolean playGame(String gameTitle) 
    {
        boolean found = false;

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
        
        if(this.purchasedGames.contains(gameTitle))
        {
            System.out.println(gameTitle + " is launching");
            found = true;
        }
        else
        {
            System.out.println("You don't own the game");
            found = false;
        }
        

        return found;
    }

    /**
     * Allows the player to purchase a game if they have enough funds in their wallet.
     *
     * @param gameTitle The title of the game to purchase.
     * @return A status message indicating the outcome of the purchase.
     */
    public String purchaseGame(String gameTitle) 
    {
        String status;

        

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
            return "invalid gameTitle";
        }

        
         
        Game game = GamesDB.searchByTitle(gameTitle);

        if(game != null)
        {
            int index = GamesDB.getGameList().indexOf(game);
    
            int compareValue = this.wallet.compareTo(game.getPrice());
            if(compareValue >= 0)
            {
                this.wallet = this.wallet.subtract(game.getPrice());
                this.purchasedGames.add(gameTitle);

                game.setNumberOfDownloads(game.getNumberOfDownloads()+1);
                GamesDB.editGame(index, game);

                System.out.println(gameTitle + " added to your library");
    
                status = "add to library";
            }
            else
            {
                System.out.println("You don't have enough money");

                status = "no money";
            }
            
                
        }
        else
        {
            System.out.println("No such game in the store");

            status = "no such game";
        }
    
        
        return status;
        
    }

    /**
     * Allows the player to refund a purchased game and receive a refund to their wallet.
     *
     * @param gameTitle The title of the game to refund.
     * @return A status message indicating the outcome of the refund.
     */
    public String refundGame(String gameTitle) 
    {
        String status;

        
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
            return "invalid gameTitle";
        }

        
        Game game = GamesDB.searchByTitle(gameTitle);
        if(game != null)
        {
            
            
            if(this.purchasedGames.contains(gameTitle))
            {
                this.wallet = this.wallet.add(game.getPrice());
                this.purchasedGames.remove(gameTitle);
                System.out.println(gameTitle + " refunded from your library");

                status = "game refunded";
            }
            else
            {
                System.out.println(gameTitle + " is not purchased");

                status = "game not purchased";

            }
            
        }
        else
        {
            System.out.println(gameTitle + " is not in the store");

            status = "game not available";
        }
        

        return status;
        

    }

    /**
     * Adds a friend to the player's friends list.
     *
     * @param friendName The username of the friend to add.
     * @return true if the friend was added, false otherwise.
     */
    public boolean addFriend(String friendName) 
    {
        boolean found = false;

        try 
        {
            if(friendName == null)
            {
                throw new IllegalArgumentException("Null refrence friend name");
            }

            if(friendName.isEmpty())
            {
                throw new IllegalArgumentException("No friend name");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid argument, please re-enter");
            return false;
        }

        Player player = PlayersDB.searchByname(friendName);

        
        if(player != null)
        {
            if(this.friendsList.contains(friendName))
            {
                System.out.println(friendName + " already in your friend list");
                found = false;
            }
            else
            {
                this.friendsList.add(friendName);
                System.out.println(friendName + " is now in your friend list");
                found = true;
            }
        }
        else
        {
            System.out.println(friendName + " was not found");
            found = false;
        }
        

        return found;
    }

    /**
     * Removes a friend from the player's friends list.
     *
     * @param friendName The username of the friend to remove.
     * @return true if the friend was removed, false otherwise.
     */
    public boolean removeFriend(String friendName) 
    {
        boolean found = false;

        try 
        {
            if(friendName == null)
            {
                throw new IllegalArgumentException("Null refrence friend name");
            }

            if(friendName.isEmpty())
            {
                throw new IllegalArgumentException("No friend name");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid argument, please re-enter");
            return false;
        }

        Player player = PlayersDB.searchByname(friendName);

        
        if(player != null)
        {
            if(this.friendsList.contains(friendName))
            {
                this.friendsList.remove(friendName);
                System.out.println(friendName + " is removed from your friend list");
    
                found = true;
            }
            else
            {
                System.out.println(friendName + " was not found in your friend list");
                found = false;
            }
        }
        else
        {
            System.out.println("No such name in the game");
            found = false;
        }

        

        return found;
        
    }

    /**
     * Adds money to the player's wallet.
     *
     * @param amount The amount of money to add.
     * @return true if money was added, false otherwise (e.g., for invalid amounts).
     */
    public boolean addMoney(double amount) 
    {
        
        boolean  status = false;
        if(amount > 0)
        {
            this.wallet = this.wallet.add(BigDecimal.valueOf(amount));
            System.out.println("money added to the walled");
            status =  true;
        }
        else
        {
            System.out.print("invalid amount of money");
            status = false;
        }

        return status;
    }

    /**
     * Adds a game to the player's list of favorite games.
     *
     * @param gameTitle The title of the game to add to favorites.
     * @return true if the game was added to favorites, false otherwise.
     */
    public boolean addToFavoritesList(String gameTitle) 
    {
        boolean status = false;

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

        
        if(this.favoritesList.contains(gameTitle))
        {
            System.out.println("gameTitle already in the favorites list");
            status = false;
        }
        else
        {
            if(this.purchasedGames.contains(gameTitle))
            {
                this.favoritesList.add(gameTitle);
                System.out.println(gameTitle + "was added to your favorites");
                status = true;
            }
            else
            {
                System.out.println(gameTitle + "does not exist on your library");
                status = false;
            }
        }
        

        return status;
    }

    /**
     * Removes a game from the player's list of favorite games.
     *
     * @param gameTitle The title of the game to remove from favorites.
     * @return true if the game was removed from favorites, false otherwise.
     */
    public boolean removeFromFavoritesList(String gameTitle) 
    {
        boolean status = false;
        
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


        if(this.favoritesList.contains(gameTitle))
        {
            this.favoritesList.remove(gameTitle);
            System.out.println(gameTitle + "was removed from your favorites");
            status = true;
        }
        else
        {
            System.out.println(gameTitle + "does not exist in your favorites");
            status = false;
        }
        

        return status;      
    }

    // Methods to view lists and perform actions

    /**
     * Displays the list of games that the player has purchased.
     */
    public void viewPurchasedGames()
    {
        for(String title : this.purchasedGames)
        {
            System.out.println(title);
        }
    }

    /**
     * Displays the list of games that the player has added to their favorites.
     */
    public void viewFavoritesList()
    {
        for(String title : this.favoritesList)
        {
            System.out.println(title);
        }
    }

    /**
     * Displays the list of friends that the player has in their friends list.
     */
    public void viewFriendsList()
    {
        for(String name : this.friendsList)
        {
            System.out.println(name);
        }
    }

    // Methods to rate and review games

    /**
     * Allows the player to add a rating to a game they have purchased.
     *
     * @param gameTitle The title of the game to rate.
     * @param rate      The rating value (1 to 5).
     * @return true if the rating was added, false otherwise.
     */
    public boolean addRating(String gameTitle, int rate)
    {
        boolean status = false;

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

        try
        {
            if(rate < 1 || rate > 5)
            {
                throw new IllegalArgumentException("invalid rating");
            }
        }
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid rate, please re-enter between 1 and 5");
            return false;
        }

        
        Game game = GamesDB.searchByTitle(gameTitle);

        if(game != null)
        {
            
            int index = GamesDB.getGameList().indexOf(game);
    
            Rate rating = new Rate(rate, this.getUsername());
            ArrayList<Rate> rateList = game.getRatings();
            rateList.add(rating);
            game.setRatings(rateList);
            game.setNumberOfRatings(game.getNumberOfRatings()+1);

    
            GamesDB.editGame(index, game);

            System.out.println("your rating has been registered");

            status = true;
            
            
        }
        else
        {
            System.out.println(gameTitle + "does not exist");
            status = false;
        }
        
        return status;
    }

    /**
     * Allows the player to remove their own rating from a game they have rated.
     *
     * @param gameTitle The title of the game from which to remove the rating.
     * @return A status message indicating the outcome of the rating removal.
     */
    public String removeRating(String gameTitle)
    {

        boolean found = false;
        String status = null;

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
            return "null argument";
        }

        
        Game game = GamesDB.searchByTitle(gameTitle);

        if(game != null)
        {
            int index = GamesDB.getGameList().indexOf(game);
    
            ArrayList<Rate> rateList = game.getRatings();
            for(Rate rate : rateList)
            {
                if(rate.getPlayerName().equals(this.getUsername()))
                {
                    rateList.remove(rate);
                    game.setRatings(rateList);
                    game.setNumberOfRatings(game.getNumberOfRatings()-1);

                    GamesDB.editGame(index, game);
                    System.out.println("your rating was removed");
                    found = true;
                    status = "rating removed";
                    break;
                }
            }
            if(!found)
            {
                System.out.println("no rating was found");
                status = "rating no found";

            }
        }
        else
        {
            System.out.println(gameTitle + "does not exist");
            status = "no such game";
        }
        
        return status;
    }

    /**
     * Allows the player to add a review to a game they have purchased.
     *
     * @param gameTitle The title of the game to review.
     * @param review    The player's review of the game.
     * @return true if the review was added, false otherwise.
     */
    public boolean addReview(String gameTitle, String review)
    {
        boolean status = false;

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

        try 
        {
            if(review == null)
            {
                throw new IllegalArgumentException("Null refrence review");
            }

            if(review.isEmpty())
            {
                throw new IllegalArgumentException("No review");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid review, please re-enter");
            return false;
        }

        Game game = GamesDB.searchByTitle(gameTitle);

        if(game != null)
        {
            int index = GamesDB.getGameList().indexOf(game);
    
            Review rev = new Review(review, this.getUsername());
            ArrayList<Review> reviewList = game.getReviews();
            reviewList.add(rev);
            game.setReviews(reviewList);
            game.setNumberOfReviews(game.getNumberOfReviews()+1);

            GamesDB.editGame(index, game);

            System.out.println("your review has been registered");
            status = true;
        }
        else
        {
            System.out.println(gameTitle + "does not exist");
            status = false;
        }
        
        return status;


    }

    /**
     * Allows the player to remove their own review from a game they have reviewed.
     *
     * @param gameTitle The title of the game from which to remove the review.
     * @return A status message indicating the outcome of the review removal.
     */
    public String removeReview(String gameTitle)
    {

        boolean found = false;
        String status = null;

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
            return "null argument";
        }

        
        Game game = GamesDB.searchByTitle(gameTitle);

        if(game != null)
        {
            int index = GamesDB.getGameList().indexOf(game);
    
            ArrayList<Review> reviewsList = game.getReviews();
            for(Review review : reviewsList)
            {
                if(review.getPlayerName().equals(this.getUsername()))
                {
                    reviewsList.remove(review);
                    game.setReviews(reviewsList);
                    game.setNumberOfReviews(game.getNumberOfReviews()-1);

                    GamesDB.editGame(index, game);
                    System.out.println("your review was removed");
                    found = true;
                    status = "review removed";
                    break;
                }
            }
            if(!found)
            {
                System.out.println("no review was found");
                status = "review no found";

            }
        }
        else
        {
            System.out.println(gameTitle + "does not exist");
            status = "no such game";
        }
        
        return status;
    }

    // Player actions and attributes

    /**
     * Allows the player to sign up in the game store.
     *
     * @return A status message indicating the outcome of the sign-up process.
     */
    public String signUp()
    {
        return PlayersDB.signUp(this);
    }

    /**
     * Allows the player to log in to the game store.
     *
     * @return true if the player successfully logs in, false otherwise.
     */
    public boolean logIn()
    {
        return PlayersDB.logIn(this);
    }

    /**
     * Displays the list of games available in the store.
     */
    public boolean viewGames()
    {
        GamesDB.viewGames();
        return true;
    }

    public ArrayList<String> getGames()
    {
        ArrayList<Game> games = GamesDB.getGameList();
        ArrayList<String> gameNames = new ArrayList<>();

        for (Game game : games) {
            gameNames.add(game.getGameName());
        }

        return gameNames;
        
    }

    /**
     * Allows the player to search for games based on a single genre tag.
     *
     * @param genreTag The genre tag to search for.
     * @return true if the search was successful, false otherwise.
     */
    public boolean tagBasedSearch(String genreTag)
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

        GamesDB.tagBasedSearch(genreTag);

        return true;
    }

    /**
     * Allows the player to search for games based on multiple genre tags.
     *
     * @param genreTags The list of genre tags to search for.
     * @return true if the search was successful, false otherwise.
     */
    public boolean tagsBasedSearch(ArrayList<String> genreTags)
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

        GamesDB.tagsBasedSearch(genreTags);
        return true;
    }

    /**
     * Allows the player to search for games based on multiple genre tags.
     *
     * @param genreTags The list of genre tags to search for.
     * @return true if the search was successful, false otherwise.
     */
    public ArrayList<Game> tagsBasedSearchGUI(ArrayList<String> genreTags)
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

        return GamesDB.tagsBasedSearchGUI(genreTags);
        
    }

    /**
     * Allows the player to search for games based on a specific release year.
     *
     * @param year The release year to search for.
     * @return true if the search was successful, false otherwise.
     */
    public boolean yearBasedSearch(int year)
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

        GamesDB.yearBasedSearch(year);
        return true;
    }

    /**
     * Allows the player to search for games based on a specific release year.
     *
     * @param year The release year to search for.
     * @return true if the search was successful, false otherwise.
     */
    public ArrayList<Game> yearBasedSearchGUI(int year)
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

        return GamesDB.yearBasedSearchGUI(year);
        
    }
    
    /**
     * Allows the player to search for games based on a specific release month.
     *
     * @param month The release month to search for (1 to 12).
     * @return true if the search was successful, false otherwise.
     */
    public boolean monthBasedSearch(int month)
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
        GamesDB.monthBasedSearch(month);   
        return true;
    }

    /**
     * Allows the player to search for games based on a specific release month.
     *
     * @param month The release month to search for (1 to 12).
     * @return true if the search was successful, false otherwise.
     */
    public ArrayList<Game> monthBasedSearchGUI(int month)
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
        return GamesDB.monthBasedSearchGUI(month);   
        
    }

    /**
     * Displays detailed information about a specific game.
     *
     * @param gameTitle The title of the game to display details for.
     * @return true if the game details were displayed, false if the game was not found.
     */
    public boolean displayGameDetailed(String gameTitle)
    {
        boolean found = false;

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
        if(game != null)
        {
            GamesDB.displayGameDetailed(game);
            found = true;
        }
        else
        {
            found = false;
        }
        

        return found;

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


    /**
     * Provides game recommendations to the player based on their purchase history.
     */
    public void viewRecommendations()
    {
        System.out.println("These recommendations are based on your purchacing prefrences");

        ArrayList<String> tags = new ArrayList<>();

        for(Game game : GamesDB.getGameList())
        {
            for(String title : this.purchasedGames)
            {
                if(title.equals(game.getGameName()))
                {
                    tags.addAll(game.getGenreTags());
                }
            }
        }

        

        
        ArrayList<String> cleanedTags = new ArrayList<>();
        for (String tag : tags) {
            if (!cleanedTags.contains(tag)) {
                cleanedTags.add(tag);
            }
        }
        

        for (Game game : GamesDB.getGameList()) 
        {
            
            boolean hasCommonElement = false;

            for (String genre : game.getGenreTags()) {
                if (cleanedTags.contains(genre)) {
                    hasCommonElement = true;
                    break;  
                }
            }

            if (hasCommonElement) {
                System.out.println(game.getGameName());
            }
        }


    }

    public ArrayList<String> getRecommendations()
    {
        ArrayList<String> recommendations =  new ArrayList<>();

        ArrayList<String> tags = new ArrayList<>();

        for(Game game : GamesDB.getGameList())
        {
            for(String title : this.purchasedGames)
            {
                if(title.equals(game.getGameName()))
                {
                    tags.addAll(game.getGenreTags());
                }
            }
        }

        
        ArrayList<String> cleanedTags = new ArrayList<>();
        for (String tag : tags) {
            if (!cleanedTags.contains(tag)) {
                cleanedTags.add(tag);
            }
        }
        

        for (Game game : GamesDB.getGameList()) 
        {
            
            boolean hasCommonElement = false;

            for (String genre : game.getGenreTags()) {
                if (cleanedTags.contains(genre)) {
                    hasCommonElement = true;
                    break;  
                }
            }

            if (hasCommonElement) {
                recommendations.add(game.getGameName());
            }
        }

        return recommendations;
    }


    // Overridden toString method to provide a string representation of the Player object
    @Override
    public String toString() {
        return "Player [username = " + this.getUsername() + " , email = " + this.getEmail() 
                        + " , wallet = " + wallet + " , favoritesList= " + favoritesList + 
                        " , purchasedGames = " + purchasedGames + " , friendsList = " + friendsList + "]";
    }

    
}