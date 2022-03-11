import java.util.*;

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        int tries = 3;
        String keyword = "HOME";
        char [] word = keyword.toCharArray();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Guess the 4-letter word!");
        System.out.println("You have " + tries + " tries.");

        while (counter < 3) {
            String guess = myObj.nextLine();
            String uppercaseGuess = guess.toUpperCase();
            char [] guessWord = uppercaseGuess.toCharArray();
            System.out.println("You typed:");
            for (int i = 0; i< guessWord.length; i++) {
                System.out.println("--> " + guessWord[i]);
            }
            if (uppercaseGuess.equals(keyword)) {
                System.out.println("Congratulations! "+ uppercaseGuess + " is the correct word!");
                return;
            }
                for (int i = 0; i < guessWord.length; i++) {
                    for (int j = 0; j < word.length; j++) {
                        if (guessWord[i]==(word[j]) && i==j) System.out.println(guessWord[i] + " exists in the word and is in the correct place!");
                        else if(guessWord[i]==(word[j]) && i!=j) System.out.println(guessWord[i] + " exists in the word but is in the wrong place.");
                    }
                }
                counter++;
            System.out.println((tries-counter) + " tries/try remaining.");
        }
        System.out.println("You ran out of tries. Game over!");
    }
}
