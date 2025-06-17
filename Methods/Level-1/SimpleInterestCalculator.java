import java.util.*;;
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
        System.out.printf("Simple interest is:%.2f",interest);
    }
}
