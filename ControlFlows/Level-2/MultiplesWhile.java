import java.util.Scanner;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number < 100: ");
        int number = input.nextInt();

        int i = 1;
        System.out.println("Multiples of " + number + " below 100:");
        while (i < 100) {
            if (i % number == 0)
                System.out.print(i + " ");
            i++;
        }
    }
}
