# Game Store System

The Game Store System is a Java-based a digital store application, designed to manage and store information about games, players, administrators, and their interactions. This system is particularly useful for game stores to organize game data, player profiles, and perform administrative tasks.



## Table of Contents

- [Release Notes](#release-notes)
- [Features](#features)
- [Classes](#classes)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Refactoring](#Refactoring-Reasoning)
- [Contributing](#contributing)


## Release Notes
Release Notes Version 3.0

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
- `Player`: Represents a player in the system, including their username, password, email, purchased games, and wallet balance.
- `Administrator`: Extends the `User` class and represents an administrator with additional capabilities like adding, editing, and removing games, generating reports, and more.
- `AdministratorDB`: Manages the list of administrators, provides signup and login functionality, and searches for administrators by name.
- `GamesDB`: Manages the list of games, allows searches, and provides various game-related functionalities.
- `Activity_1`: Serves as the different Autentications window
- `Activity_2`: Serves as the Signup window
- `Activity_3`: Serves as the Login window
- `Activity_4`: Serves as the Admin controll windown
- `Activity_5`: Serves as the Player window
- `Activity_XController`: for each of the above activities, they have there own controllers to support the MVC design pattern

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

## Refactoring
- Updated the databases:
    - while using files as a database would be more effiecent, due to time constrains,they remained as data structures
    - The data structures where updated to linked list to encource and encourge fast inserion and deletion of object
- Used Maps instead of the hand-made  key-value objects (Rate, Review class) due to surving the same purpose + more utiliy methods
- Minimized the loops in the porject and subsituied them with lambda functions and streams for proficiency.
- Implemented the MVC desgin pattern for ease of future refactoring, modularity, and seperation of concerns. 

## Contributing
By:
- Mahmoud Matar, ID: 900193415, Section: 1
- ChatGPT: https://chat.openai.com/share/6e041e90-18a7-4cbb-a6fc-78e686a96f6b

Clone the repository to your local machine:

```bash
git clone https://github.com/Java-F23/Game-Store-System.git



