package edu.aucegypt.GamesStrore.users;

import java.util.LinkedList;

/**
 * The `AdministratorDB` class manages a database of administrators for the game store system.
 * It provides methods for searching administrators by name, signing up new administrators, and logging in existing administrators.
 */
public class AdministratorDB {

    private static LinkedList<Administrator> administratorList = new LinkedList<>();

    /**
     * Retrieve the list of administrators in the database.
     *
     * @return An ArrayList of Administrator objects representing the administrators in the database.
     */
    public static LinkedList<Administrator> getAdministratorList() {
        return administratorList;
    }

    /**
     * Set the list of administrators in the database.
     *
     * @param administratorList An ArrayList of Administrator objects to set as the database content.
     */
    public static void setAdministratorList(LinkedList<Administrator> administratorList) {
        AdministratorDB.administratorList = administratorList;
    }

    /**
     * Search for an administrator by their username in the database.
     *
     * @param administratorName The username of the administrator to search for.
     * @return The Administrator object if found, or null if not found or if the provided name is invalid.
     */
    public static Administrator searchByname(String adminstratorName)
    {
        try 
        {
            if(adminstratorName == null)
            {
                throw new IllegalArgumentException("Null refrence Administrator name");
            }

            if(adminstratorName.isEmpty())
            {
                throw new IllegalArgumentException("No Administrator name");
            }
            
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid Administrator name, please re-enter");
            return null;
        }

        for(Administrator administrator : AdministratorDB.administratorList)
        {
            if(administrator.getUsername().equals(adminstratorName))
            {
                return administrator;
            }
        }
        return null;
    }
    
    /**
     * Register a new administrator in the database.
     *
     * @param administrator The Administrator object to be registered.
     * @return A status message indicating the outcome of the sign-up process, such as "successful signup" or "invalid credentials."
     */
    public static String signUp(Administrator administrator)
    {
        String status = null;

        

        if(administrator.getEmail() == null || administrator.getPassword().length() == 0 || administrator.getUsername() == null)
        {
            System.out.println("invalid credentials");
            status = "invalid credentials";
            
        }
        else
        {
            for(Administrator temp : AdministratorDB.administratorList)
            {
                if(temp.getEmail().equals(administrator.getEmail()) || temp.getUsername().equals(administrator.getUsername()))
                {
                    System.out.println("matching credentials");
                    status = "matching credentials";
                    return status;
                }
            }

            System.out.println("successful signup");
            status = "successful signup";
            AdministratorDB.administratorList.add(administrator);
        }
        return status;
    }

    /**
     * Perform a login for an existing administrator in the database.
     *
     * @param administrator The Administrator object attempting to log in.
     * @return true if the login is successful, false if the provided credentials are incorrect.
     */
    public static boolean logIn(Administrator administrator)
    {
        boolean status = false;
        boolean found =  false;
        

        for (Administrator temp : AdministratorDB.administratorList) 
        {
            if (temp.getUsername().equals(administrator.getUsername()) && temp.getPassword().equals(administrator.getPassword())) 
            {
                System.out.println("Correct credentials, logging in....");
                status = true;
                found = true;
                break;
            }
        }
        
        if(!found)
        {
            System.out.println("Invalid credentials");
            found =  false;
            status = false;
        }

        return status;
    }
}
