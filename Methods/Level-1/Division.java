import java.util.Scanner;

public class Division {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number and divisor: ");
        int number = sc.nextInt();
        int divisor = sc.nextInt();
        int[] result = Division.findRemainderAndQuotient(number, divisor);
        System.out.println("Quotient: " + result[0] + ", Remainder: " + result[1]);
    }
}
