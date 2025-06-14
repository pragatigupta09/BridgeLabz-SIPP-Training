import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Amar's age and height: ");
        int age1 = input.nextInt();
        int height1 = input.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int age2 = input.nextInt();
        int height2 = input.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int age3 = input.nextInt();
        int height3 = input.nextInt();

        if (age1 <= age2 && age1 <= age3)
            System.out.println("Amar is the youngest.");
        else if (age2 <= age1 && age2 <= age3)
            System.out.println("Akbar is the youngest.");
        else
            System.out.println("Anthony is the youngest.");

        if (height1 >= height2 && height1 >= height3)
            System.out.println("Amar is the tallest.");
        else if (height2 >= height1 && height2 >= height3)
            System.out.println("Akbar is the tallest.");
        else
            System.out.println("Anthony is the tallest.");
    }
}
