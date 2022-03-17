# Guess the Word Game

## General info

This is a simple yet fun "Guess the Word" game.

I used the [words.txt](https://github.com/aristeidis-drivas/Guess-the-Word/words.txt) file, which has well over 4000 english words, as a dictionary.

Once the program starts, scanner goes through the [words.txt](https://github.com/aristeidis-drivas/Guess-the-Word/words.txt) file. 
Words that contain punctuation marks and digits are purged and the valid ones are split into arraylists based on their number of letters.
These arraylists are mapped in order to give the user the option to select how many letters the word can have.

User can also choose the difficulty of the game by selecting the number of tries. Each word the user types is checked if it has the correct length in characters and is a valid one, meaning it is in the dictionary. Guesses from the user are compared to the secret word character by character and hints are given.
User needs to find the secret word before (user) runs out of tries.
Lastly, play again option is implemented.

Note: The project is under development. Updates are comming!

## Technologies & Tools
* Java 11
* IntelliJ Community Edition IDE

## Setup & Run
To run this project, you just need to simply download it.
Via command line:
```
$ cd  ../where_you_want_it_to_be_saved
$ git clone https://github.com/aristeidis-drivas/Guess-the-Word.git
```
Or download manually.

Import it in a programming environment (i.e. IntelliJ Community Edition IDE) or execute via command line.

## License
 The application is under the MIT license.
 
