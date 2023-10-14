package edu.aucegypt.GamesStrore.main;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import edu.aucegypt.GamesStrore.Helpers.Generator;
import edu.aucegypt.GamesStrore.Helpers.Terminal;
import edu.aucegypt.GamesStrore.Helpers.Validations;
import edu.aucegypt.GamesStrore.games.Game;
import edu.aucegypt.GamesStrore.users.Administrator;
import edu.aucegypt.GamesStrore.users.Player;


public class GamesStrore_Sys
{

    public static void main(String []args)
    {
        Generator.playerGenerator();
        Generator.adminGenerator();
        Generator.gameGenrator();

        Terminal.clearTerminal();


        while (true) 
        {
            System.out.println("Welocme to MaGaMa Games Store");
            System.out.println("Options:");
            System.out.println("1. Login");
            System.out.println("2. SignUp");
            System.out.println("3. Quit");

            // Read the user's choice
            int choice = Validations.getIntUserInput();

            // Process the user's choice
            switch (choice) 
            {
                case 1:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 1.");
                    logIn();
                    break;

                case 2:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 2.");
                    signUp();
                    break;

                case 3:

                    Terminal.clearTerminal();
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            Terminal.clearTerminal();

        }
    }
    
    private static void signUp()
    {
        boolean back = false;
        while (!back) 
        {
            System.out.println("Are you:");
            System.out.println("1. Player");
            System.out.println("2. Administrator");
            System.out.println("3. Back");
            System.out.println("4. Quit");

            int choice = Validations.getIntUserInput();

            switch (choice) 
            {
                case 1:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 1.");

                    System.out.println("Enter the username:");
                    String player_userName = Validations.getStringUserInput();
                    System.out.println("Enter the password:");
                    String player_password = Validations.getStringUserInput();
                    System.out.println("Enter the email:");
                    String player_email = Validations.getStringUserInput();

                    Player player = new Player(player_userName,player_password,player_email);

                    player.signUp();
                    back = true;
                    break;

                case 2:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 2.");

                    System.out.println("Enter the username:");
                    String Admin_userName = Validations.getStringUserInput();
                    System.out.println("Enter the password:");
                    String Admin_password = Validations.getStringUserInput();
                    System.out.println("Enter the email:");
                    String Admin_email = Validations.getStringUserInput();

                    Administrator administrator = new Administrator(Admin_userName,Admin_password,Admin_email);

                    administrator.signUp();
                    back = true;
                    break;

                case 3:

                    Terminal.clearTerminal();
                    back = true;
                    break;

                case 4:

                    Terminal.clearTerminal();
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            if(back)
            {
                break;
            }
            Terminal.clearTerminal();
        }
    }

    private static void logIn()
    {
        boolean back = false;
        boolean successful;
        while (!back) 
        {
            System.out.println("Are you:");
            System.out.println("1. Player");
            System.out.println("2. Administrator");
            System.out.println("3. Back");
            System.out.println("4. Quit");

            int choice = Validations.getIntUserInput();

            switch (choice) 
            {
                case 1:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 1.");

                    System.out.println("Enter the username:");
                    String player_userName = Validations.getStringUserInput();
                    System.out.println("Enter the password:");
                    String player_password = Validations.getStringUserInput();
                    System.out.println("Enter the email:");
                    String player_email = Validations.getStringUserInput();

                    Player player = new Player(player_userName,player_password,player_email);

                    successful = player.logIn();

                    if(successful)
                    {
                        playerWindow(player);
                        back = true;
                    }
                    break;

                case 2:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 2.");

                    System.out.println("Enter the username:");
                    String Admin_userName = Validations.getStringUserInput();
                    System.out.println("Enter the password:");
                    String Admin_password = Validations.getStringUserInput();
                    System.out.println("Enter the email:");
                    String Admin_email = Validations.getStringUserInput();

                    Administrator administrator = new Administrator(Admin_userName,Admin_password,Admin_email);

                    successful = administrator.logIn();
                    
                    if(successful)
                    {
                        adminWindow(administrator);
                        back = true;
                    }
                    
                    break;

                case 3:
                    back = true;
                    break;
                case 4:
                    
                    Terminal.clearTerminal();
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            if(back)
            {
                break;
            }
            Terminal.clearTerminal();
        }
    }

    private static void playerWindow(Player player)
    {
        boolean back = false;
        String inputString = new String();
        int inputInt;
        while (!back) 
        {
            System.out.println("Choose what you want to do:");
            System.out.println("1. Play a game");
            System.out.println("2. Purchase a game");
            System.out.println("3. Refund a game");
            System.out.println("4. Add a friend to frient list");
            System.out.println("5. Remove a friend to frient list");
            System.out.println("6. Add money to the wallet");
            System.out.println("7. Add a game to favorites list");
            System.out.println("8. Remove a game to favorites list");
            System.out.println("9. View purchased games");
            System.out.println("10. View favorites list");
            System.out.println("11. View friends list");
            System.out.println("12. Add your rating to a game");
            System.out.println("13. Remove your rating for a game");
            System.out.println("14. Add uour review to a game");
            System.out.println("15. Remove your review to a game");
            System.out.println("16. Browse store games");
            System.out.println("17. Search games by genres"); 
            System.out.println("18. Search games by release year");
            System.out.println("19. Search games by release month");
            System.out.println("20. View game details");
            System.out.println("21. View games recomendations");
            System.out.println("22. Back");
            System.out.println("23. Quit");

            int choice = Validations.getIntUserInput();

            switch (choice) {
                case 1:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 1.");

                    System.out.println("Enter the name of the game you want to play");
                    inputString = Validations.getStringUserInput();

                    player.playGame(inputString);
                    
                    break;
            
                case 2:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 2.");

                    System.out.println("Enter the name of the game you want to buy");
                    inputString = Validations.getStringUserInput();

                    player.purchaseGame(inputString);
                    
                    break;
            
                case 3:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 3.");

                    System.out.println("Enter the name of the game you want to refund");
                    inputString = Validations.getStringUserInput();

                    player.refundGame(inputString);
                    
                    break;
            
                case 4:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 4.");

                    System.out.println("Enter the name of the friend you want to add");
                    inputString = Validations.getStringUserInput();

                    player.addFriend(inputString);
                    
                    break;
            
                case 5:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 5.");

                    System.out.println("Enter the name of the friend your want to remove");
                    inputString = Validations.getStringUserInput();

                    player.removeFriend(inputString);
                    
                    break;
            
                case 6:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 6.");

                    System.out.println("Enter the amount wanted to be add to the wallet");
                    double amount = Validations.getNumberUserInput();

                    player.addMoney(amount);
                    
                    break;
            
                case 7:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 7.");
                    
                    System.out.println("Enter the name of the game you want to add to favorites list");
                    inputString = Validations.getStringUserInput();

                    player.addToFavoritesList(inputString);

                    break;
            
                case 8:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 8.");

                    System.out.println("Enter the name of the game you want to remove from favorites list");
                    inputString = Validations.getStringUserInput();

                    player.removeFromFavoritesList(inputString);
                    
                    break;
            
                case 9:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 9.");

                    player.viewPurchasedGames();
                    
                    break;
            
                case 10:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 10.");
                    
                    player.viewFavoritesList();
                    
                    break;
            
                case 11:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 11.");

                    player.viewFriendsList();
                    
                    break;
            
                case 12:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 12.");

                    System.out.println("Enter the name of the game you want to add a rate");
                    inputString = Validations.getStringUserInput();
                    System.out.println("Enter the rate you want");
                    inputInt = Validations.getIntUserInput();

                    player.addRating(inputString, inputInt);
                    
                    break;
            
                case 13:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 13.");

                    System.out.println("Enter the name of the game you want to remove its rate");
                    inputString = Validations.getStringUserInput();

                    player.removeRating(inputString);
                    
                    break;
            
                case 14:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 14.");

                    System.out.println("Enter the name of the game you want to add a review");
                    inputString = Validations.getStringUserInput();

                    String temp = inputString;
                    System.out.println("Enter the review you want");
                    inputInt = Validations.getIntUserInput();

                    player.addReview(temp, inputString);
                    
                    break;
            
                case 15:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 15.");
                    

                    System.out.println("Enter the name of the game you want to remove its review");
                    inputString = Validations.getStringUserInput();

                    player.removeReview(inputString);

                    break;
            
                case 16:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 16.");

                    player.viewGames();
                    
                    break;
            
                case 17:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 17.");
                    
                    System.out.println("Enter the genre tags you want, separted with \"space\" ");
                    inputString = Validations.getStringUserInput();

                    Scanner scanner = new Scanner(inputString);
                    ArrayList<String> arrayList = new ArrayList<>();

                    while (scanner.hasNext()) 
                    {
                        String part = scanner.next();
                        arrayList.add(part);
                    }
                    scanner.close();

                    player.tagsBasedSearch(arrayList);
                    
                    break;
            
                case 18:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 18.");

                    System.out.println("Enter the target year");
                    inputInt = Validations.getIntUserInput();

                    player.yearBasedSearch(inputInt);
                    
                    break;
            
                case 19:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 19.");

                    System.out.println("Enter the target month");
                    inputInt = Validations.getIntUserInput();

                    player.monthBasedSearch(inputInt);
                    
                    break;
            
                case 20:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 20.");
                    
                    System.out.println("Enter the name of the game you want to see its details");
                    inputString = Validations.getStringUserInput();

                    player.displayGameDetailed(inputString);

                    break;
            
                case 21:
                    
                    Terminal.clearTerminal();
                    player.viewRecommendations();
            
                case 22:

                    
                    back = true;
                    break;

                case 23:

                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            if(back)
            {
                break;
            }
            Terminal.clearTerminal();
        }

    }

    private static void adminWindow(Administrator administrator)
    {
        boolean back = false;
        String inputString = new String();
        while (!back) 
        {
            System.out.println("Choose what you want to do:");
            System.out.println("1. Add a game to system");
            System.out.println("2. Remove a game from system");
            System.out.println("3. Edit a game details");
            System.out.println("4. View a game rates");
            System.out.println("5. View a game reviews");
            System.out.println("6. Generate reports about the store");
            System.out.println("7. Apply a discount on a game");
            System.out.println("8. Back");
            System.out.println("9. Quit");

            int choice = Validations.getIntUserInput();

            switch (choice) {
                case 1:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 1.");

                    System.out.println("Enter the game name");
                    inputString = Validations.getStringUserInput();
                    

                    Game game = new Game(inputString);

                    administrator.addGame(game);
                    

                    break;
            
                case 2:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 2.");

                    System.out.println("Enter the name of the game you want to remove");
                    inputString = Validations.getStringUserInput();

                    administrator.removeGame(inputString);
                    
                    
                    break;
            
                case 3:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 3.");

                    editGame(administrator);


                    break;
            
                case 4:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 4.");

                    System.out.println("Enter the name of the game you want to view its rates");
                    inputString = Validations.getStringUserInput();

                    administrator.viewGameRatings(inputString);
                    
                    break;
            
                case 5:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 5.");

                    System.out.println("Enter the name of the game you want to view its reviews");
                    inputString = Validations.getStringUserInput();

                    administrator.viewGameReviews(inputString);
                    
                    break;
            
                case 6:
                    
                    Terminal.clearTerminal();
                    System.out.println("You selected Option 6.");

                    administrator.generateReports();
                    
                    break;
                
                case 7:

                    Terminal.clearTerminal();
                    System.out.println("You selected Option 7.");

                    System.out.println("Enter the name of the game you want to apply its discount");
                    inputString = Validations.getStringUserInput();

                    administrator.applyDiscount(inputString);

                    break;

                case 8:

                    // Additional logic for Option 21
                    back = true;
                    break;

                case 9:

                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            if(back)
            {
                break;
            }
            Terminal.clearTerminal();
        }
    }

    private static void editGame(Administrator administrator)
    {
        boolean done = false;
        int choice;

        String gameName = null;
        String newGameName = null;
        String newDescription = null;
        String newReleaseDate = null; 
        String newDeveloper = null;
        String newPublisher = null;
        BigDecimal newOriginalPrice = null;
        BigDecimal newPrice = null;
        BigDecimal newDiscount = null;
        int newDownloads =  -1;
        ArrayList<String> newGenreTags = null;

        System.out.println("Enter the game name");
        gameName = Validations.getStringUserInput();

        Terminal.clearTerminal();
        
        while(!done)
        {
            System.out.println("Do you want to change the game name?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game name");

                    newGameName =  Validations.getStringUserInput();

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game description?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game description");

                    newDescription =  Validations.getStringUserInput();

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game release date?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game release date");
                    
                    newReleaseDate = Validations.getDateUserInput();

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game developer name?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game developer name");

                    newDeveloper =  Validations.getStringUserInput();

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game publisher name?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game publisher name");

                    newPublisher =  Validations.getStringUserInput();

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game original price?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game original price ");

                    double price =  Validations.getNumberUserInput();

                    newOriginalPrice =  BigDecimal.valueOf(price);

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game  price?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game  price ");

                    double price =  Validations.getNumberUserInput();

                    newPrice =  BigDecimal.valueOf(price);

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game  price?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game  price ");

                    double price =  Validations.getNumberUserInput();

                    newPrice =  BigDecimal.valueOf(price);

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game current discount amount ?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game  discount amount ");

                    double amount =  Validations.getNumberUserInput();

                    newDiscount =  BigDecimal.valueOf(amount);

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;

        Terminal.clearTerminal();
        while(!done)
        {
            System.out.println("Do you want to change the game current genre tage ?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = Validations.getIntUserInput();
             switch (choice) 
             {
                case 1:
                    
                    System.out.println("Enter the new game  genre tags, separated by space");

                    String inputString = Validations.getStringUserInput();

                    Scanner scanner = new Scanner(inputString);
                    newGenreTags = new ArrayList<>();

                    while (scanner.hasNext()) 
                    {
                        String part = scanner.next();
                        newGenreTags.add(part);
                    }
                    scanner.close();

                    done = true;
                    break;
            
                case 2:
                    done = true;
                    break;
                default:
                    done = false;
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        done = false;
        
        administrator.editGame(gameName, newGameName, newDescription, newReleaseDate, newDeveloper,
                                 newPublisher, newOriginalPrice, newPrice, newDiscount, newDownloads,
                                  newGenreTags);

    }
}