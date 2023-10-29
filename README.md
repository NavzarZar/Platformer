# Platformer Game Read Me

## Introduction
Welcome to our Platformer Game project, developed as a part of our Challenge-Based Learning (CBL) project for our Programming course (2IP90). This game is a simple 2D platformer written in Java. The main focus of this project was to learn and implement game physics (collision, gravity, and map generation) and version control using Git. We hope you enjoy playing our game and find this project informative.

### Team Members
- Razvan Craciun (1987143)
- Stefan Avram (1923897)

## Learning Goals
As part of this project, we had two primary learning goals:

1. **Game Physics**
   - *Collision*: Understanding and implementing collision detection and response mechanisms to ensure our player interacts with the game environment correctly.
   - *Gravity*: Implementing gravity to provide a realistic and engaging player experience.
   - *Map Generation*: Creating multiple levels but also making them easily customizable by us, while still making sure that the physics work.

2. **Version Control with Git**
   - Learning how to use Git for version control in a collaborative programming project.
   - Managing code changes, resolving conflicts, and maintaining a history of our project development.
   - We have also sent the .git file, so you can check our version control.

## DISCLAIMER
The Code Runner extension in VS Code does not recognize the packages with the classes. Instead of running the program
with the "Run Code" mode, run it with "Run or Debug" -> "Run Java".
Otherwise, just run from console as described below.

## Getting Started
To run the project, follow these steps:

1. Clone this repository to your local machine using Git or download the project as a ZIP file:
   ```sh
   git clone [repository_url]
   ```

2. Make sure you have [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed on your system.

3. Navigate to the project directory:
   ```sh
   cd [project_directory]
   ```

4. Run the game by executing the Main.java file in the `game` package:
   ```sh
   javac game/Main.java
   java game/Main
   ```

5. Make sure you check the Controls before playing!
   ```
   The controls can be found in the Main Menu of the game, by pressing the "Controls" button.
   ```

## Project Structure
The project structure is organized with 6 packages. Here's a brief overview of the directory structure:

- `game`: Contains the Java source code for the game.
- `levels`: Contains the Java source code for the levels.
- `menus`: Contains the Java source code for the menus.
- `inputs`: Contains the Java source code for the inputs.
- `physics`: Contains the Java source code for the physics of the game.
- `images`: Contains the images used.

Enjoy playing our Platformer Game! 🎮