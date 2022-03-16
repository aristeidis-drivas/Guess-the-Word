import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner myObj = new Scanner(System.in);
        Scanner myWord = new Scanner(System.in);
        Scanner myTry = new Scanner(System.in);
        Scanner myBtn = new Scanner(System.in);
        Scanner txtDb = new Scanner(new File("words.txt"));

        ArrayList<String> threeLetterList = new ArrayList<String>();
        ArrayList<String> fourLetterList = new ArrayList<String>();
        ArrayList<String> fiveLetterList = new ArrayList<String>();
        ArrayList<String> sixLetterList = new ArrayList<String>();
        while (txtDb.hasNextLine()) {
            String check = txtDb.nextLine();
            if (check.contains(".") ||
                    check.contains(",") ||
                    check.contains("-") ||
                    check.contains("'") ||
                    check.contains("&") ||
                    check.contains("/") ||
                    check.contains(":") ||
                    check.matches(".*\\d.*")) {
                continue;
            }
            if (check.length() == 3) threeLetterList.add(check.toUpperCase(Locale.ROOT));
            if (check.length() == 4) fourLetterList.add(check.toUpperCase(Locale.ROOT));
            if (check.length() == 5) fiveLetterList.add(check.toUpperCase(Locale.ROOT));
            if (check.length() == 6) sixLetterList.add(check.toUpperCase(Locale.ROOT));
        }
        txtDb.close();

        LinkedHashMap<Integer, List<String>> numberListMapping = new LinkedHashMap<>();
        numberListMapping.put(3, threeLetterList);
        numberListMapping.put(4, fourLetterList);
        numberListMapping.put(5, fiveLetterList);
        numberListMapping.put(6, sixLetterList);
        boolean gameOn = true;

        while (gameOn) {
            System.out.println("Welcome to the Guess the Word Game!");
            System.out.println("Select the length of the word. Type 3-6.");
            int pick = myObj.nextInt();
            while (pick != 3 && pick != 4 && pick != 5 && pick != 6) {
                System.out.println("Wrong number! Choose between 3 and 6.\"");
                pick = myObj.nextInt();
            }

            Random randomizer = new Random();
            String random = numberListMapping.get(pick).get(randomizer.nextInt(numberListMapping.get(pick).size()));
            //System.out.println(random); # to check the secret word
            char[] word = random.toCharArray();

            int counter = 0;
            System.out.println("How many tries do you want to have?");
            int tries = myTry.nextInt();
            System.out.println("You have " + tries + " tries.");

            while (counter < tries) {
                System.out.println("Type your guess:");
                String guess = myWord.nextLine();
                String uppercaseGuess = guess.toUpperCase();
                char[] guessWord = uppercaseGuess.toCharArray();
                System.out.println("You typed:");
                for (int i = 0; i < guessWord.length; i++) {
                    System.out.println("--> " + guessWord[i]);
                }

                while (guessWord.length != pick || !numberListMapping.get(pick).contains(uppercaseGuess)) {
                    System.out.println("The word must have " + pick + " letters or the word is invalid. Type again: ");
                    guess = myWord.nextLine();
                    uppercaseGuess = guess.toUpperCase();
                    guessWord = uppercaseGuess.toCharArray();
                    System.out.println("You typed:");

                    for (int i = 0; i < guessWord.length; i++) {
                        System.out.println("--> " + guessWord[i]);
                    }
                }

                for (int i = 0; i < guessWord.length; i++) {
                    for (int j = 0; j < word.length; j++) {
                        if (guessWord[i] == (word[j]) && i == j)
                            System.out.println(guessWord[i] + " exists in the word and is in the correct place!");
                        else if (guessWord[i] == (word[j]) && i != j)
                            System.out.println(guessWord[i] + " exists in the word but is in the wrong place.");
                    }
                }

                if (uppercaseGuess.equals(random)) {
                    System.out.println("Congratulations! " + uppercaseGuess + " is the correct word!");
                    System.out.println("Play again? 1 for yes, 2 for no.");
                    int playAgain = myBtn.nextInt();
                    if (playAgain == 1) break;
                    else return;
                }

                counter++;
                System.out.println((tries - counter) + " tries/try remaining.");
                if (tries-counter == 0) {
                    System.out.println("Secret word was: " + random);
                    System.out.println("You ran out of tries. Game over!");
                    System.out.println("Play again? 1 for yes, 2 for no.");
                    int playAgain = myBtn.nextInt();
                    if (playAgain == 1) continue;
                    else return;
                }
            }
        }
    }
}
