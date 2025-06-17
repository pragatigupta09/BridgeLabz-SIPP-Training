import java.util.Scanner;

public class SpringSeason {
    public static boolean isSpring(int month, int day) {
        return (month == 3 && day >= 20) ||
               (month == 4) ||
               (month == 5) ||
               (month == 6 && day <= 20);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month and day: ");
        int month = sc.nextInt();
        int day = sc.nextInt();
        if (isSpring(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
