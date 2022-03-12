import java.util.*;

public class Main {

    public static void main(String[] args) {
        int counter = 0;
        int tries = 3;
        Scanner myObj = new Scanner(System.in);
        Scanner myWord = new Scanner(System.in);
        System.out.println("Welcome to the Guess the Word Game!");
        System.out.println("Press 4 to guess a 4-letter word or 5 for a 5-letter word.");
        int pick = myObj.nextInt();
        String randomWord = keyword(pick);
        while (randomWord.equals("null")) {
            pick = myObj.nextInt();
            randomWord = keyword(pick);
        }
        System.out.println(randomWord);
        char [] word = randomWord.toCharArray();
        System.out.println("You have " + tries + " tries.");

        while (counter < tries) {
            String guess = myWord.nextLine();
            String uppercaseGuess = guess.toUpperCase();
            char [] guessWord = uppercaseGuess.toCharArray();
            System.out.println("You typed:");
            for (int i = 0; i< guessWord.length; i++) {
                System.out.println("--> " + guessWord[i]);
            }
            if (uppercaseGuess.equals(randomWord)) {
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

    public static String keyword(int numberOfLetters) {
        Scanner scanner = new Scanner(System.in);
        String word;
        switch (numberOfLetters) {
            case 4:
                String [] fourLetterWord = {"AREA", "BABY", "BALL", "BODY", "CARD", "DESK", "FORK", "MENU", "SAND", "WARD"};
                word = fourLetterWord[(int) (Math.random()*10)];
                break;
            case 5:
                String [] fiveLetterWord = {"ADULT", "APPLE", "BEACH", "CREAM", "FLASH", "GRASS", "HOUSE", "METAL", "SCORE", "TRACK"};
                word = fiveLetterWord[(int) (Math.random()*10)];
                break;
            default:
                System.out.println("Wrong number. Choose between 4-5.");
                word = "null";
        }
        return word;
    }
}
