import java.util.Scanner;

public class ToLowerCompare {
    public static String toLowerManual(String text) {
        String lower = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lower += (char)(ch + 32);
            } else {
                lower += ch;
            }
        }
        return lower;
    }

    public static boolean compare(String a, String b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String manual = toLowerManual(text);
        String builtIn = text.toLowerCase();

        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtIn);
        System.out.println("Are equal: " + compare(manual, builtIn));
    }
}
