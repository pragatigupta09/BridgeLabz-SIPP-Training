import java.util.Scanner;

public class Multiplication6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] result = new int[4];

        for (int i = 6; i <= 9; i++) {
            result[i - 6] = number * i;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + result[i]);
        }
    }
}
