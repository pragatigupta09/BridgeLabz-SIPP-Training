import java.util.Scanner;

public class SubstringCompare {
    public static String substringByChar(String str, int start, int end) {
        String sub = "";
        for (int i = start; i < end; i++) {
            sub += str.charAt(i);
        }
        return sub;
    }

    public static boolean compareCharByChar(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String str = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userSub = substringByChar(str, start, end);
        String builtInSub = str.substring(start, end);

        System.out.println("User-defined substring: " + userSub);
        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Are both substrings equal: " + compareCharByChar(userSub, builtInSub));
    }
}
