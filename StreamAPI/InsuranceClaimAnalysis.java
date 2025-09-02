package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {
    
    static class Claim {
        private String type;
        private double amount;
        
        public Claim(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
        
        public String getType() { return type; }
        public double getAmount() { return amount; }
    }
    
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Auto", 5000.0),
            new Claim("Home", 8000.0),
            new Claim("Auto", 3000.0),
            new Claim("Health", 12000.0),
            new Claim("Home", 6000.0)
        );
        
        Map<String, Double> averageClaims = claims.stream()
            .collect(Collectors.groupingBy(
                Claim::getType,
                Collectors.averagingDouble(Claim::getAmount)
            ));
        
        System.out.println("Average Claim Amount by Type:");
        averageClaims.forEach((type, avg) -> 
            System.out.println(type + ": $" + String.format("%.2f", avg)));
    }
}