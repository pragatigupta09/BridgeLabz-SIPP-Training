import java.util.Scanner;

public class studentFeeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the total student fee (INR): ");
        double fee = input.nextDouble();

        System.out.print("Enter the university discount percentage: ");
        double discountPercent = input.nextDouble();

        double discountAmount = fee * (discountPercent / 100);
        double finalFee = fee - discountAmount;

        System.out.println("The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
    }
}
