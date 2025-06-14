import java.util.Scanner;

public class MultiplesFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number < 100: ");
        int number = input.nextInt();

        System.out.println("Multiples of " + number + " below 100:");
        for (int i = 1; i < 100; i++) {
            if (i % number == 0)
                System.out.print(i + " ");
        }
    }
}
