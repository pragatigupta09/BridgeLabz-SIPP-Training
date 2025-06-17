import java.util.Scanner;

public class WindChill {
    public static double calculateWindChill(double temp, double windSpeed) {
        return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature and wind speed: ");
        double temp = sc.nextDouble(), windSpeed = sc.nextDouble();
        System.out.printf("Wind Chill: %.2f\n", calculateWindChill(temp, windSpeed));
    }
}
