public class NumberChecker {
    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] getDigitsArray(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int num, int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == num;
    }

    public static void findTwoLargest(int[] digits) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > max) {
                second = max;
                max = digit;
            } else if (digit > second && digit != max) {
                second = digit;
            }
        }
        System.out.println("Largest: " + max + ", Second Largest: " + second);
    }

    public static void findTwoSmallest(int[] digits) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < min) {
                second = min;
                min = digit;
            } else if (digit < second && digit != min) {
                second = digit;
            }
        }
        System.out.println("Smallest: " + min + ", Second Smallest: " + second);
    }

    public static void main(String[] args) {
        int num = 153;
        int[] digits = getDigitsArray(num);

        System.out.println("Digit Count: " + countDigits(num));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(num, digits));
        findTwoLargest(digits);
        findTwoSmallest(digits);
    }
}
