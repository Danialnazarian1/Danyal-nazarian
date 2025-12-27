import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordGame game = new WordGame();
        game.startGame();
    }
}

class WordGame {

    String[] words = {"apple", "book", "car", "student", "computer"};
    String[] hints = {
        "noei miveh",
        "baraye motalee estefade mishavad",
        "vasilei baraye harekat",
        "fardi ke dar daneshgah dars mikhanad",
        "noe vasile digital"
    };

    public void startGame() {
        Random random = new Random();

        String guess;
        int score = 0;
        int attempts = 4;

        System.out.println("Bazie hads kalame shoru shod. Shoma " + attempts + " bar hagh hads darid.");

        boolean[] used = new boolean[words.length];

        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 1; i <= attempts; i++) {
                int index = random.nextInt(words.length);

                while (used[index]) {
                    index = random.nextInt(words.length);
                }

                used[index] = true;

                String secretWord = words[index];
                String secretHint = hints[index];

                System.out.println("Rahnamayi: " + secretHint);
                System.out.print("Hads " + i + ": ");

                guess = scanner.nextLine();

                if (guess.equalsIgnoreCase(secretWord)) {
                    System.out.println("Dorost hads zadi!");
                    score++;
                } else {
                    System.out.println("Eshtebah ast. Dobare talash kon.");
                }
            }

        }

        System.out.println("Emtiaz shoma: " + score);

        if (score > 2) {
            System.out.println("Tabrik! Shoma barande shodid.");
        } else {
            System.out.println("Emtiaz kam bod. Dafe badi behtar talash kon.");
        }
    }
}
