import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ":");

            do {
                System.out.print("  Enter weight (kg): ");
                personData[i][1] = sc.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("  Weight must be a positive number.");
                }
            } while (personData[i][1] <= 0);

            do {
                System.out.print("  Enter height (m): ");
                personData[i][0] = sc.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("  Height must be a positive number.");
                }
            } while (personData[i][0] <= 0);
        }

        for (int i = 0; i < number; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n BMI Report ");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n",
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
