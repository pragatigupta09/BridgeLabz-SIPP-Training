import java.util.*;

public class FootballTeamHeight {
    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; 
        }

        int sum = findSum(heights);
        double mean = findMean(heights);
        int min = findMin(heights);
        int max = findMax(heights);

        System.out.println("Player Heights: " + Arrays.toString(heights));
        System.out.println("Shortest Player Height: " + min + " cm");
        System.out.println("Tallest Player Height: " + max + " cm");
        System.out.printf("Mean Player Height: %.2f cm\n", mean);
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int height : arr) {
            sum += height;
        }
        return sum;
    }

    public static double findMean(int[] arr) {
        return findSum(arr) / (double) arr.length;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int height : arr) {
            if (height < min) min = height;
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int height : arr) {
            if (height > max) max = height;
        }
        return max;
    }
}
