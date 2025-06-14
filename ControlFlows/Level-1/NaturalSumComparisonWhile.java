import java.util.Scanner;

public class NaturalSumComparisonWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n > 0) {
            int i = 1, sum = 0;
            while (i <= n) {
                sum += i;
                i++;
            }
            int formulaSum = n * (n + 1) / 2;
            System.out.println("Sum using while loop: " + sum);
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Are both sums equal? " + (sum == formulaSum));
        } else {
            System.out.println(n + " is not a natural number.");
        }
    }
}
