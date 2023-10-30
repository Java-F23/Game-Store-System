# Game Store System

The Game Store System is a Java-based a digital store application, designed to manage and store information about games, players, administrators, and their interactions. This system is particularly useful for game stores to organize game data, player profiles, and perform administrative tasks.



## Table of Contents

- [Release Notes](#release-notes)
- [Features](#features)
- [Classes](#classes)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Future Plans](#Future-Plans)
- [Contributing](#contributing)


## Release Notes
Release Notes Version 2.0

## Features

The Game Store System provides the following features:

- Game Management: Add, remove, edit, and display detailed information about games.
- Player Management: View player statistics, including purchased games and wallet balance.
- Administrator Access: Administrators can log in, add, edit, and remove games, and generate reports.
- Reviews and Ratings: Players can provide reviews and ratings for games.
- Tag-Based Searches: Search for games based on genre tags.
- Year and Month-Based Searches: Search for games released in a specific year or month.
- Added almost fully functional GUI to the system. 

## Classes

The system consists of several Java classes that facilitate the functionality of the application. Here is an overview of the key classes:

- `Game`: Represents information about a game, including its name, description, ratings, reviews, release date, developer, and more. It also handles adding and removing genre tags and applying discounts.
- `Rate`: Represents a player's rating for a game, including the rating value and the player's name.
- `Review`: Represents a player's review for a game, including the review text and the player's name.
- `Player`: Represents a player in the system, including their username, password, email, purchased games, and wallet balance.
- `Administrator`: Extends the `User` class and represents an administrator with additional capabilities like adding, editing, and removing games, generating reports, and more.
- `AdministratorDB`: Manages the list of administrators, provides signup and login functionality, and searches for administrators by name.
- `GamesDB`: Manages the list of games, allows searches, and provides various game-related functionalities.
- `Activity_1`: Serves as the different Autentications window
- `Activity_2`: Serves as the Signup window
- `Activity_3`: Serves as the Login window
- `Activity_4`: Serves as the Admin controll windown
- `Activity_5`: Serves as the Player window

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

6- Now, you can do all the above, with a GUI

## Future Plans
While some bugs went unseen in the previous version, the 2.0 version managed address these probllems.
However, some were possible to fix, due to the tight time constrains and the adaptation to the swing framework.
The Future Plans are as follows:

1- Fixing the backend issues were found in the 2.0 version

2- Connect the last remaining GUI components to the backend

3- Re-factor the code to polish the frontend and better desing the code

4- Check the TODO.txt file for more info on the remaining tasks for the current version

## Contributing
By:
- Mahmoud Matar, ID: 900193415, Section: 1
- ChatGPT: https://chat.openai.com/share/158c3abb-0a59-40e0-a986-a05df652d274

Clone the repository to your local machine:

```bash
git clone https://github.com/Java-F23/Game-Store-System.git



