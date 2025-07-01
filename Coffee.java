import java.util.Scanner;

public class Coffee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String coffeeType;
        double gstRate = 0.05;

        while (true) {
            System.out.print("Enter coffee type (or type 'exit' to quit): ");
            coffeeType = sc.next();

            if (coffeeType.equals("exit")) {
                System.out.println("Thank you for visiting!");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            double price = 0;

            switch (coffeeType) {
                case "espresso":
                    price = 100;
                    break;
                case "latte":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 130;
                    break;
                default:
                    System.out.println("Sorry, we don't serve that coffee.");
                    continue;
            }

            double subTotal = price * quantity;
            double gst = subTotal * gstRate;
            double totalBill = subTotal + gst;

            System.out.printf("Subtotal: Rs %.2f\n", subTotal);
            System.out.printf("Total Bill: Rs %.2f\n", totalBill);
            
        }

    }
}