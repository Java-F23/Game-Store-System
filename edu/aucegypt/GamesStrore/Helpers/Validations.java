package edu.aucegypt.GamesStrore.Helpers;

import java.util.Scanner;

public class Validations 
{
    static Scanner scanner = new Scanner(System.in);

    public static int getIntUserInput() 
    {
        int number = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a number: ");


            String userInput = scanner.nextLine();

            try 
            {
                 number = Integer.parseInt(userInput);
                validInput = true;
            } catch (NumberFormatException e) 
            {
                System.out.println("Invalid input, You did not enter a valid integer.");
            }
        }

        return number;
    }

    public static String getStringUserInput()
    {
        String input = new String();
        boolean validInput = false;

        final int minLength = 1;
        final int maxLength = 100;

        while(!validInput)
        {
            input = scanner.nextLine();

            if ((input.isEmpty()) || (input.length() < minLength || input.length() > maxLength)) 
            {
                System.out.println("invalid input, please re-enter ");
                validInput = false;
            }
            else
            {
                validInput = true;
            }
        }

        return input;
    }
    
    public static double getNumberUserInput() 
    {

        double number = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a number : ");


            String userInput = scanner.nextLine();

            try 
            {
                number = Double.parseDouble(userInput);
                if(number > 0)
                {
                    validInput = true;
                }
                else
                {
                    System.out.println("Invalid input, You did not enter a valid positive number.");
                }
                
            } catch (NumberFormatException e) 
            {
                System.out.println("Invalid input, You did not enter a valid number.");
            }
        }

        return number;

        
    }

    public static String getDateUserInput()
    {
        String input = new String();
        boolean validInput = false;

        

        int year = -1;
        int month = -1;
        int day = -1;

        while(!validInput)
        {
            input = scanner.nextLine();

            System.out.println("Enter a year");
            year = getIntUserInput();
            System.out.println("Enter a month");
            month = getIntUserInput();
            System.out.println("Enter a day");
            day = getIntUserInput();

            if (year <= 0 || month < 1 || month > 12 || day < 1 || day > 31) 
            {
                System.out.println("invalid input, please re-enter ");
                validInput = false;
            }
            else
            {
                validInput = true;
            }
        }
        input = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);

        return input;
    }
}
