import java.util.Scanner;

public class ChocolateDivision {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates and number of children: ");
        int numberOfchocolates  = sc.nextInt();
        int numberOfChildren = sc.nextInt();
        int[] result = ChocolateDivision.findRemainderAndQuotient(numberOfchocolates , numberOfChildren);
        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
