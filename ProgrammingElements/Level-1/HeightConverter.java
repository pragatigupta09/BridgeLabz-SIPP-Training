import java.util.*;
public class HeightConverter  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        double cm = input.nextDouble();

        double totalInches = cm / 2.54;
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        System.out.println("Your height in cm is " + cm + " while in feet is " + feet + " and inches is " + inches);
    }
}
