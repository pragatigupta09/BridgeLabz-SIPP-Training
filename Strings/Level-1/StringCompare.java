import java.util.Scanner;

public class StringCompare {
    public static boolean compareCharByChar(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.next();
        System.out.print("Enter second string: ");
        String s2 = sc.next();

        boolean charCompare = compareCharByChar(s1, s2);
        boolean builtInCompare = s1.equals(s2);

        System.out.println("Character by Character Comparison: " + charCompare);
        System.out.println("Built-in equals() Comparison: " + builtInCompare);
    }
}
