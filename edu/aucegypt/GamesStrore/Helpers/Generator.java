package edu.aucegypt.GamesStrore.Helpers;

import java.math.BigDecimal;
import java.util.ArrayList;

import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.games.GamesDB;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.AdministratorDB;
import edu.aucegypt.GamesStrore.users.Player;
import edu.aucegypt.GamesStrore.users.PlayersDB;

public class Generator 
{
    public static void playerGenerator()
    {
        Player player1 = new Player("mahmoud", "mahmoud", "mahmoud");
        Player player2 = new Player("john_doe", "password123", "john.doe@example.com");
        Player player3 = new Player("alice_smith", "p@ssw0rd", "alice.smith@gmail.com");
        Player player4 = new Player("testuser1", "test123", "test1@example.com");
        Player player5 = new Player("user123", "secret", "user123@mail.com");
        Player player6 = new Player("jane_doe", "mypassword", "jane.doe@example.com");
        Player player7 = new Player("user007", "jamesbond", "user007@mi6.gov");
        Player player8 = new Player("testaccount", "passw0rd", "test.account@test.com");
        Player player9 = new Player("dummyuser", "dummy123", "dummy.user@example.com");
        Player player10 = new Player("player42", "mysecurepassword", "player.42@mail.com");


        ArrayList<Player> list = PlayersDB.getPlayerList();
        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);
        list.add(player5);
        list.add(player6);
        list.add(player7);
        list.add(player8);
        list.add(player9);
        list.add(player10);
        PlayersDB.setPlayerList(list);
    }

    public static void adminGenerator()
    {
        Administrator admin1 = new Administrator("admin", "admin", "admin");
        Administrator admin2 = new Administrator("new_admin2", "new_password2", "new_admin2@example.com");
        Administrator admin3 = new Administrator("new_admin3", "new_password3", "new_admin3@example.com");
        Administrator admin4 = new Administrator("new_admin4", "new_password4", "new_admin4@example.com");
        Administrator admin5 = new Administrator("new_admin5", "new_password5", "new_admin5@example.com");
        Administrator admin6 = new Administrator("new_admin6", "new_password6", "new_admin6@example.com");
        Administrator admin7 = new Administrator("new_admin7", "new_password7", "new_admin7@example.com");
        Administrator admin8 = new Administrator("new_admin8", "new_password8", "new_admin8@example.com");
        Administrator admin9 = new Administrator("new_admin9", "new_password9", "new_admin9@example.com");
        Administrator admin10 = new Administrator("new_admin10", "new_password10", "new_admin10@example.com");

    
        ArrayList<Administrator> list = AdministratorDB.getAdministratorList();
        list.add(admin1);
        list.add(admin2);
        list.add(admin3);
        list.add(admin4);
        list.add(admin5);
        list.add(admin6);
        list.add(admin7);
        list.add(admin8);
        list.add(admin9);
        list.add(admin10);
        AdministratorDB.setAdministratorList(list);
    }

    public static void gameGenrator()
    {
        Game game1 = new Game("The Witcher 3: Wild Hunt", "An open-world RPG", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2023-09-28", "CD Projekt Red", "CD Projekt", new ArrayList<>(), new BigDecimal("59.99"),
            new BigDecimal("59.99"), new BigDecimal("0.00"), 0);

        Game game2 = new Game("Cyberpunk 2077", "A futuristic RPG", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2023-09-29", "CD Projekt Red", "CD Projekt", new ArrayList<>(), new BigDecimal("49.99"),
            new BigDecimal("49.99"), new BigDecimal("0.00"), 0);

        Game game3 = new Game("Red Dead Redemption 2", "An action-adventure game", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2023-09-30", "Rockstar Games", "Rockstar Games", new ArrayList<>(), new BigDecimal("69.99"),
            new BigDecimal("69.99"), new BigDecimal("0.00"), 0);

        Game game4 = new Game("Minecraft", "A sandbox game", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2023-10-01", "Mojang", "Microsoft Studios", new ArrayList<>(), new BigDecimal("29.99"),
            new BigDecimal("29.99"), new BigDecimal("0.00"), 0);

        Game game5 = new Game("Among Us", "A multiplayer game", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2023-10-02", "InnerSloth", "InnerSloth", new ArrayList<>(), new BigDecimal("4.99"),
            new BigDecimal("4.99"), new BigDecimal("0.00"), 0);

        Game game6 = new Game("Fortnite", "A battle royale game", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2023-10-03", "Epic Games", "Epic Games", new ArrayList<>(), new BigDecimal("1.00"),
            new BigDecimal("1.00"), new BigDecimal("0.00"), 0);

        Game game7 = new Game("The Legend of Zelda", "An action-adventure game", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2023-10-04", "Nintendo", "Nintendo", new ArrayList<>(), new BigDecimal("59.99"),
            new BigDecimal("59.99"), new BigDecimal("0.00"), 0);

        Game game8 = new Game("Call of Duty", "A first-person shooter", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2022-10-05", "Infinity Ward", "Activision", new ArrayList<>(), new BigDecimal("1.00"),
            new BigDecimal("1.00"), new BigDecimal("0.00"), 0);

        Game game9 = new Game("Apex Legends", "A battle royale game", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2022-10-06", "Respawn Entertainment", "Electronic Arts", new ArrayList<>(), new BigDecimal("1.00"),
            new BigDecimal("1.00"), new BigDecimal("0.00"), 0);

        Game game10 = new Game("CSGO", "A first-person shooter", 0, new ArrayList<>(), 0, new ArrayList<>(),
            "2022-10-07", "Valve", "Valve", new ArrayList<>(), new BigDecimal("14.99"),
            new BigDecimal("14.99"), new BigDecimal("0.00"), 0);

        ArrayList<Game> list = GamesDB.getGameList();
        list.add(game1);
        list.add(game2);
        list.add(game3);
        list.add(game4);
        list.add(game5);
        list.add(game6);
        list.add(game7);
        list.add(game8);
        list.add(game9);
        list.add(game10);
        GamesDB.setGameList(list);
    }
    
}
