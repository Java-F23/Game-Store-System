package edu.aucegypt.GamesStrore.users;

/**
 * The `User` class represents a basic user with username, password, and email attributes.
 */
public class User {
    private String username; // User's username
    private String password; // User's password
    private String email;    // User's email

    /**
     * Creates a new User object with the given username, password, and email.
     *
     * @param username The user's username.
     * @param password The user's password.
     * @param email    The user's email.
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Default constructor for the User class.
     */
    public User() {
        // This constructor is empty, as it's used for creating instances with default values.
    }

    /**
     * Get the user's username.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the user's username.
     *
     * @param username The new username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user's password.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user's email.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email.
     *
     * @param email The new email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
