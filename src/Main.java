import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File theWordHangman = new File("src/HangmanWord");

        Scanner scanOrHang = new Scanner(theWordHangman);

        String theWord = scanOrHang.nextLine();

        System.out.println("WELCOME TO HANGMAN");
        System.out.println("See if you can hit the top chubi!");

        char[] alphaJohnny = "abcdefghijklmnopqrstuvwxyzæøå".toCharArray();

        Scanner riften = new Scanner(System.in);

        char[] guessedLetters = new char[theWord.length()];
        Arrays.fill(guessedLetters, '_');

        int guesses = 0;

        Set<Character> usedLetters = new HashSet<>();

        while (guesses < 6) {

            System.out.println(new String(guessedLetters));

            String input = riften.nextLine().toLowerCase();
            char yourGuess = input.charAt(0);

            if (!Character.isLetter(yourGuess)) {
                System.out.println("Only letters Tønke");
                continue;
            }

            if (usedLetters.contains(yourGuess)) {
                System.out.println("Already guessed letter!");
                continue;
            }

            usedLetters.add(yourGuess);

            int index = new String(alphaJohnny).indexOf(String.valueOf(yourGuess));

            if (index >= 0) {
                alphaJohnny[index] = ' ';
                System.out.println("You now have these letters " + Arrays.toString(alphaJohnny) + " remaining");
            }

            if (theWord.toLowerCase().contains(String.valueOf(yourGuess))) {
                System.out.println("You guessed correct");

                //if (index >= 0) {
                    //alphaJohnny[index] = ' ';
                    //System.out.println("You now have these letters " + Arrays.toString(alphaJohnny) + " remaining");

                    for (int i = 0; i < theWord.length(); i++) {
                        if (yourGuess == theWord.toLowerCase().charAt(i)) {
                            guessedLetters[i] = theWord.charAt(i);
                        }
                    }
                //}
            } else {
                System.out.println("You is dogshit!");
                guesses++;
            }

            if (!new String(guessedLetters).contains("_")) {
                System.out.println("Congratulations, you won!");
                break;
            }
        }

        if (guesses == 6) {
            System.out.println("You lost, the word was " + theWord);
        }
    }
}

