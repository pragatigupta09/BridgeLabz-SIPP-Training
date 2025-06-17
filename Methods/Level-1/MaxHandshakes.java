import java.util.*;

public class MaxHandshakes {
    public static int handshakeCalculator(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students");
        int numberOfStudents = sc.nextInt();
        int handshakes = MaxHandshakes.handshakeCalculator(numberOfStudents);
        System.out.println("Maximum number of handshakes: " + handshakes);
    }
}