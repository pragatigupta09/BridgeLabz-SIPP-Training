import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        double salary = input.nextDouble();
        System.out.print("Enter years of service: ");
        int years = input.nextInt();

        if (years > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus amount is: INR " + bonus);
        } else {
            System.out.println("No bonus for service less than or equal to 5 years.");
        }
    }
}
