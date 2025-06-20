import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter: high/low/correct)");
            String feedback = sc.nextLine().toLowerCase();
            if (feedback.equals("correct")) break;
            else if (feedback.equals("high")) high = guess - 1;
            else if (feedback.equals("low")) low = guess + 1;
        }
        System.out.println("Hooray! The computer guessed your number.");
        sc.close();
    }

    static int generateGuess(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }
}
