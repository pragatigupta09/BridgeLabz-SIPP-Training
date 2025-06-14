import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer to count digits: ");
        int number = input.nextInt();

        int count = 0;
        int original = number;

        if (number == 0) {
            count = 1; 
        } else {
            while (number != 0) {
                number = number / 10; 
                count++;
            }
        }

        System.out.println("Number of digits in " + original + " is: " + count);
    }
}
