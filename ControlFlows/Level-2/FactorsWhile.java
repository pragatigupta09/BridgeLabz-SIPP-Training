import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        int i = 1;
        System.out.println("Factors of " + number + ":");
        while (i <= number) {
            if (number % i == 0)
                System.out.print(i + " ");
            i++;
        }
    }
}
