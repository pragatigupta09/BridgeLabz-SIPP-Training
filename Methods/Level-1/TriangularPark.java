import java.util.Scanner;

public class TriangularPark {
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three sides of the triangle in meters: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double rounds = TriangularPark.calculateRounds(a, b, c);
        System.out.printf("Rounds needed: %.2f\n", rounds);
    }
}
