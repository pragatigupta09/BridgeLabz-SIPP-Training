import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int greatestFactor = 1;

        int i = number - 1;
        while (i >= 1) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
            i--;
        }

        System.out.println("Greatest factor (besides itself): " + greatestFactor);
    }
}
