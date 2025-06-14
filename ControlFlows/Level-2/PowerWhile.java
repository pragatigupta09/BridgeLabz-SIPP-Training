import java.util.Scanner;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base number: ");
        int number = input.nextInt();
        System.out.print("Enter power: ");
        int power = input.nextInt();

        int result = 1, i = 1;
        while (i <= power) {
            result *= number;
            i++;
        }

        System.out.println(number + " raised to power " + power + " is " + result);
    }
}
