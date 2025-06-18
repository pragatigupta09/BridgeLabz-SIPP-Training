import java.util.Scanner;

public class UnitConverter {
    public static double convertKmToMiles(double km) { return km * 0.621371; }
    public static double convertMilesToKm(double miles) { return miles * 1.60934; }
    public static double convertMetersToFeet(double meters) { return meters * 3.28084; }
    public static double convertFeetToMeters(double feet) { return feet * 0.3048; }
    public static double convertYardsToFeet(double yards) { return yards * 3; }
    public static double convertFeetToYards(double feet) { return feet * 0.333333; }
    public static double convertMetersToInches(double meters) { return meters * 39.3701; }
    public static double convertInchesToMeters(double inches) { return inches * 0.0254; }
    public static double convertInchesToCm(double inches) { return inches * 2.54; }
    public static double convertFahrenheitToCelsius(double f) { return (f - 32) * 5 / 9; }
    public static double convertCelsiusToFahrenheit(double c) { return (c * 9 / 5) + 32; }
    public static double convertPoundsToKg(double p) { return p * 0.453592; }
    public static double convertKgToPounds(double kg) { return kg * 2.20462; }
    public static double convertGallonsToLiters(double g) { return g * 3.78541; }
    public static double convertLitersToGallons(double l) { return l * 0.264172; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();
        System.out.println("Miles: " + UnitConverter.convertKmToMiles(km));

        System.out.print("Enter miles: ");
        double miles = sc.nextDouble();
        System.out.println("Kilometers: " + UnitConverter.convertMilesToKm(miles));

        System.out.print("Enter meters: ");
        double meters = sc.nextDouble();
        System.out.println("Feet: " + UnitConverter.convertMetersToFeet(meters));

        System.out.print("Enter feet: ");
        double feet = sc.nextDouble();
        System.out.println("Meters: " + UnitConverter.convertFeetToMeters(feet));

        System.out.print("Enter yards: ");
        double yards = sc.nextDouble();
        System.out.println("Feet: " + UnitConverter.convertYardsToFeet(yards));

        System.out.print("Enter feet to convert to yards: ");
        feet = sc.nextDouble();
        System.out.println("Yards: " + UnitConverter.convertFeetToYards(feet));

        System.out.print("Enter meters to convert to inches: ");
        meters = sc.nextDouble();
        System.out.println("Inches: " + UnitConverter.convertMetersToInches(meters));

        System.out.print("Enter inches to convert to meters: ");
        double inches = sc.nextDouble();
        System.out.println("Meters: " + UnitConverter.convertInchesToMeters(inches));

        System.out.print("Enter inches to convert to centimeters: ");
        inches = sc.nextDouble();
        System.out.println("Centimeters: " + UnitConverter.convertInchesToCm(inches));

        System.out.print("Enter Fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        System.out.println("Celsius: " + UnitConverter.convertFahrenheitToCelsius(fahrenheit));

        System.out.print("Enter Celsius: ");
        double celsius = sc.nextDouble();
        System.out.println("Fahrenheit: " + UnitConverter.convertCelsiusToFahrenheit(celsius));

        System.out.print("Enter pounds: ");
        double pounds = sc.nextDouble();
        System.out.println("Kilograms: " + UnitConverter.convertPoundsToKg(pounds));

        System.out.print("Enter kilograms: ");
        double kg = sc.nextDouble();
        System.out.println("Pounds: " + UnitConverter.convertKgToPounds(kg));

        System.out.print("Enter gallons: ");
        double gallons = sc.nextDouble();
        System.out.println("Liters: " + UnitConverter.convertGallonsToLiters(gallons));

        System.out.print("Enter liters: ");
        double liters = sc.nextDouble();
        System.out.println("Gallons: " + UnitConverter.convertLitersToGallons(liters));
    }
}
