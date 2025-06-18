import java.util.*;

public class EmployeeBonusCalculator {
    public static int[][] generateEmployeeData(int numberOfEmployees) {
        int[][] employeeData = new int[numberOfEmployees][2]; 
        for (int i = 0; i < numberOfEmployees; i++) {
            employeeData[i][0] = 10000 + (int)(Math.random() * 90000); 
            employeeData[i][1] = 1 + (int)(Math.random() * 10); 
        }
        return employeeData;
    }

    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {
        int n = employeeData.length;
        double[][] updatedData = new double[n][2]; 
        for (int i = 0; i < n; i++) {
            double bonusPercent = (employeeData[i][1] > 5) ? 0.05 : 0.02;
            double bonus = employeeData[i][0] * bonusPercent;
            updatedData[i][0] = bonus;
            updatedData[i][1] = employeeData[i][0] + bonus;
        }
        return updatedData;
    }

    public static void printSalarySummary(int[][] employeeData, double[][] updatedData) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "EmpID", "OldSalary", "Years", "Bonus", "NewSalary");
        for (int i = 0; i < employeeData.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10.2f %-10.2f\n", 
                              (i+1), employeeData[i][0], employeeData[i][1], 
                              updatedData[i][0], updatedData[i][1]);

            totalOld += employeeData[i][0];
            totalNew += updatedData[i][1];
            totalBonus += updatedData[i][0];
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("Total     %-10.2f %-10s %-10.2f %-10.2f\n", totalOld, "", totalBonus, totalNew);
    }

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData(10);
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        printSalarySummary(employeeData, updatedData);
    }
}
