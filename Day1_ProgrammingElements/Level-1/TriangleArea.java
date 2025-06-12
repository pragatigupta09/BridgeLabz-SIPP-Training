import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base (cm): ");
        double base = input.nextDouble();
        System.out.print("Enter height (cm): ");
        double height = input.nextDouble();
        double areaCm = 1/2 * base * height;
        double areaInches = areaCm / 6.4516; 
        System.out.println("Area: " + areaCm + " cm² and " + areaInches + " in²");
    }
}
