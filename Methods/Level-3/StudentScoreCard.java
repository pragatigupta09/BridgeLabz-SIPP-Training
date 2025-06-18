import java.util.Scanner;

public class StudentScoreCard {
    public static int[][] generateScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3]; 
        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 40 + (int)(Math.random() * 61); 
            }
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        int n = scores.length;
        double[][] results = new double[n][3]; 
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / 3;
            double percentage = ((double) total / 300) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
            "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Percent", "Grade");

        for (int i = 0; i < scores.length; i++) {
            String grade = getGrade(results[i][2]);
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-10.2f %-10s\n",
                (i + 1), scores[i][0], scores[i][1], scores[i][2],
                results[i][0], results[i][1], results[i][2], grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
    }
}
