import java.util.Scanner;

public class CharArrayComparison {
    public static char[] toCharArrayManual(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char[] manual = toCharArrayManual(str);
        char[] builtIn = str.toCharArray();

        System.out.println("Are both char arrays equal: " + compareArrays(manual, builtIn));
    }
}
