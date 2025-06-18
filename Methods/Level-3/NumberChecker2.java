import java.util.*;

public class NumberChecker2 {
    public static int countDigits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static int[] storeDigits(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        int index = count - 1;
        while (num != 0) {
            digits[index--] = num % 10;
            num /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshad(int num, int[] digits) {
        int sum = sumOfDigits(digits);
        return num % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2]; 
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }
        for (int digit : digits) {
            freq[digit][1]++;
        }
        return freq;
    }

    public static int[] reverseArray(int[] digits) {
        int[] rev = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            rev[i] = digits[digits.length - 1 - i];
        }
        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int[] digits) {
        return arraysEqual(digits, reverseArray(digits));
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;
        while (square != 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    public static boolean isSpy(int[] digits) {
        int sum = 0, prod = 1;
        for (int d : digits) {
            sum += d;
            prod *= d;
        }
        return sum == prod;
    }

    public static boolean isAutomorphic(int num) {
        int square = num * num;
        return Integer.toString(square).endsWith(Integer.toString(num));
    }

    public static boolean isBuzz(int num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum == num;
    }

    public static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum > num;
    }

    public static boolean isDeficient(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return sum < num;
    }

    public static boolean isStrong(int num) {
        int original = num;
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = storeDigits(number);

        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        System.out.println("Is Harshad: " + isHarshad(number, digits));

        int[][] freq = digitFrequency(digits);
        System.out.println("Digit Frequencies:");
        for (int[] row : freq) {
            if (row[1] > 0)
                System.out.println("Digit " + row[0] + ": " + row[1] + " times");
        }

        System.out.println("Reversed array: " + Arrays.toString(reverseArray(digits)));
        System.out.println("Is Palindrome: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Neon: " + isNeon(number));
        System.out.println("Is Spy: " + isSpy(digits));
        System.out.println("Is Automorphic: " + isAutomorphic(number));
        System.out.println("Is Buzz: " + isBuzz(number));
        System.out.println("Is Perfect: " + isPerfect(number));
        System.out.println("Is Abundant: " + isAbundant(number));
        System.out.println("Is Deficient: " + isDeficient(number));
        System.out.println("Is Strong: " + isStrong(number));

    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
