package edu.aucegypt.GamesStrore.games;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The `GamesDB` class represents a database of video games in the game store system. It provides methods to manage and
 * retrieve information about the games in the database, such as searching by tags, filtering by release year, and more.
 */
public class GamesDB {
    private static LinkedList<Game> gameList = new LinkedList<>();

    /**
     * Get the list of games stored in the database.
     *
     * @return A LinkedList of Game objects.
     */
    public static LinkedList<Game> getGameList() {
        return gameList;
    }

    /**
     * Set the list of games in the database to a new list.
     *
     * @param gameList The new LinkedList of Game objects to replace the existing list.
     */
    public static void setGameList(LinkedList<Game> gameList) {
        GamesDB.gameList = gameList;
    }

    

    /**
     * Search for games based on a list of genre tags.
     *
     * @param genreTags The list of genre tags to search for.
     * @return A LinkedList of Game objects if the search is successful, null if the provided genre tags are invalid.
     */
    public static LinkedList<Game> tagsBasedSearchGUI(ArrayList<String> genreTags) {
        try {
            if (genreTags == null || genreTags.isEmpty()) {
                throw new IllegalArgumentException("Invalid genreTags, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        LinkedList<Game> filtered = filterGamesByGenres(genreTags);

        return filtered;
    }

    /**
     * Search for games released in a specific year.
     *
     * @param year The release year to search for.
     * @return A LinkedList of Game objects if the search is successful, null if the provided year is invalid.
     */
    public static LinkedList<Game> yearBasedSearchGUI(int year) {
        try {
            if (year < 0) {
                throw new IllegalArgumentException("Invalid year, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return filterGamesByYear(year);
    }

    /**
     * Search for games released in a specific month.
     *
     * @param month The release month to search for.
     * @return A LinkedList of Game objects if the search is successful, null if the provided month is invalid.
     */
    public static LinkedList<Game> monthBasedSearchGUI(int month) {
        try {
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Invalid month, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return filterGamesByMonth(month);
    }

    /**
     * Filter a list of games based on a set of genre tags.
     *
     * @param genreTags The genre tags to filter games by.
     * @return A LinkedList of Game objects that match the specified genre tags.
     */
    public static LinkedList<Game> filterGamesByGenres(ArrayList<String> genreTags) {
        try {
            if (genreTags == null || genreTags.isEmpty()) {
                throw new IllegalArgumentException("Invalid genreTags, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        ArrayList<Game> filteredGames = new ArrayList<>();
        for (Game game : GamesDB.gameList) {
            for (String tag : genreTags) {
                if (game.getGenreTags().contains(tag) && !filteredGames.contains(game)) {
                    filteredGames.add(game);
                }
            }
        }

        return new LinkedList<>(filteredGames);
    }

    /**
     * Filter a list of games based on the release year.
     *
     * @param year The release year to filter games by.
     * @return A LinkedList of Game objects that were released in the specified year.
     */
    public static LinkedList<Game> filterGamesByYear(int year) {
        try {
            if (year < 0) {
                throw new IllegalArgumentException("Invalid year, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        LinkedList<Game> filteredGames = new LinkedList<>();

        for (Game game : GamesDB.gameList) {
            ArrayList<String> dateParts = new ArrayList<>();
            String[] parts = game.getReleaseDate().toString().split("-");
            for (String part : parts) {
                dateParts.add(part);
            }

            if (Integer.parseInt(dateParts.get(0)) == year) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    /**
     * Filter a list of games based on the release month.
     *
     * @param month The release month to filter games by.
     * @return A LinkedList of Game objects that were released in the specified month.
     */
    public static LinkedList<Game> filterGamesByMonth(int month) {
        try {
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Invalid month, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        LinkedList<Game> filteredGames = new LinkedList<>();

        for (Game game : GamesDB.gameList) {
            ArrayList<String> dateParts = new ArrayList<>();
            String[] parts = game.getReleaseDate().toString().split("-");
            for (String part : parts) {
                dateParts.add(part);
            }

            if (Integer.parseInt(dateParts.get(1)) == month) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    /**
     * Search for a game by its title in the database.
     *
     * @param gameTitle The title of the game to search for.
     * @return The Game object matching the provided title or null if no match is found.
     */
    public static Game searchByTitle(String gameTitle) {
        try {
            if (gameTitle == null || gameTitle.isEmpty()) {
                throw new IllegalArgumentException("Invalid game name, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        for (Game game : gameList) {
            if (game.getGameName().equalsIgnoreCase(gameTitle)) {
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
    public static boolean editGame(int index, Game game) {
        try {
            if (game == null) {
                throw new IllegalArgumentException("Invalid game, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        try {
            if (index < 0 || index > gameList.size() - 1) {
                throw new IllegalArgumentException("Invalid index, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
    public static boolean addGame(Game game) {
        try {
            if (game == null) {
                throw new IllegalArgumentException("Invalid game, please re-enter");
            }

            if (game.getGameName() == null || game.getGameName().isEmpty()) {
                throw new IllegalArgumentException("Invalid game title, please re-enter");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        if (gameList.stream().anyMatch(g -> g.getGameName().equalsIgnoreCase(game.getGameName()))) {
            System.out.println("Game is already in the database");
            return false;
        } else {
            gameList.add(game);
            System.out.println("Game added to database");
            return true;
        }
    }

    /**
     * Remove a game from the database by its title.
     *
     * @param gameTitle The title of the game to be removed.
     * @return true if the game is successfully removed, false if the game with the provided title is not found.
     */
    public static boolean removeGame(String gameTitle) {
        try {
            if (gameTitle == null || gameTitle.isEmpty()) {
                throw new IllegalArgumentException("Invalid game title, please re-enter");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        Game game = searchByTitle(gameTitle);
        if (game != null && gameList.contains(game)) {
            System.out.println("Game removed");
            gameList.remove(game);
            return true;
        } else {
            System.out.println("Game with the provided title not found");
            return false;
        }
    }
}
