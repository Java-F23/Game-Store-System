# Game Store System

The Game Store System is a Java-based a digital store application, designed to manage and store information about games, players, administrators, and their interactions. This system is particularly useful for game stores to organize game data, player profiles, and perform administrative tasks.



## Table of Contents

- [Features](#features)
- [Classes](#classes)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

The Game Store System provides the following features:

- Game Management: Add, remove, edit, and display detailed information about games.
- Player Management: View player statistics, including purchased games and wallet balance.
- Administrator Access: Administrators can log in, add, edit, and remove games, and generate reports.
- Reviews and Ratings: Players can provide reviews and ratings for games.
- Tag-Based Searches: Search for games based on genre tags.
- Year and Month-Based Searches: Search for games released in a specific year or month.

## Classes

The system consists of several Java classes that facilitate the functionality of the application. Here is an overview of the key classes:

- `Game`: Represents information about a game, including its name, description, ratings, reviews, release date, developer, and more. It also handles adding and removing genre tags and applying discounts.
- `Rate`: Represents a player's rating for a game, including the rating value and the player's name.
- `Review`: Represents a player's review for a game, including the review text and the player's name.
- `Player`: Represents a player in the system, including their username, password, email, purchased games, and wallet balance.
- `Administrator`: Extends the `User` class and represents an administrator with additional capabilities like adding, editing, and removing games, generating reports, and more.
- `AdministratorDB`: Manages the list of administrators, provides signup and login functionality, and searches for administrators by name.
- `GamesDB`: Manages the list of games, allows searches, and provides various game-related functionalities.

## Getting Started

To get started with the Game Store System, you need to set up a Java development environment. You should have the following prerequisites:

- Java Development Kit (JDK)
- An integrated development environment (IDE) like IntelliJ IDEA or Eclipse

## Usage
You can use the Game Store System to manage games, players, and administrators within your game store. Below are some common usage scenarios:

1- Game Management: Add, remove, or edit game details using the Game class. You can also apply discounts and view game reviews and ratings.

2- Player Statistics: Access player statistics, including purchased games and wallet balance, with the Player class.

3- Administrator Control: Use the Administrator class to log in as an administrator, add, edit, or remove games, and generate reports on game sales and player statistics.

4- Search and Filter: Perform searches based on genre tags, years, and months using the GamesDB class to help players discover games in your store.

5- Review and Rate Games: Players can leave reviews and ratings for games using the Review and Rate classes.

## Contributing
By Mahmoud Matar, ID: 900193415, Section: 1

Clone the repository to your local machine:

```bash
git clone https://github.com/Java-F23/Game-Store-System.git



