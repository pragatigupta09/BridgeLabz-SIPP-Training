import java.util.*;
public class SimpleInterestCalculator {
    public static double simpleInterest(double principal, double rate, double time) {
        return (principal*rate*time)/100;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter principal amount");
        double principal=sc.nextDouble();
        System.out.println("Enter value of rate");
        double rate=sc.nextDouble();
        System.out.println("Enter time period");
        double time=sc.nextDouble();
        double interest = simpleInterest(principal, rate, time);
        System.out.printf("The Simple interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f",interest,principal,rate,time);
    }
}
