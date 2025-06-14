import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        double number;

        do {
            System.out.print("Enter a number (0 to stop): ");
            number = input.nextDouble();
            total += number;
        } while (number != 0);

        System.out.println("Total sum is: " + total);
    }
}
