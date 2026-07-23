import java.util.Scanner;

public class PasswordStrengthAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("   PASSWORD STRENGTH ANALYZER");
        System.out.println("===========================================");

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        int score = 0;

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;

        int length = password.length();

        for (int i = 0; i < length; i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch))
                upper = true;
            else if (Character.isLowerCase(ch))
                lower = true;
            else if (Character.isDigit(ch))
                digit = true;
            else
                special = true;
        }

        if (length >= 8) score += 25;
        if (upper) score += 20;
        if (lower) score += 20;
        if (digit) score += 20;
        if (special) score += 15;

        System.out.println("\n========== PASSWORD ANALYSIS ==========");
        System.out.println("Length              : " + length);
        System.out.println("Contains Uppercase  : " + (upper ? "Yes" : "No"));
        System.out.println("Contains Lowercase  : " + (lower ? "Yes" : "No"));
        System.out.println("Contains Number     : " + (digit ? "Yes" : "No"));
        System.out.println("Contains Special    : " + (special ? "Yes" : "No"));
        System.out.println("Security Score      : " + score + "/100");

        if (score >= 90)
            System.out.println("Strength            : VERY STRONG");
        else if (score >= 70)
            System.out.println("Strength            : STRONG");
        else if (score >= 50)
            System.out.println("Strength            : MEDIUM");
        else
            System.out.println("Strength            : WEAK");

        System.out.println("\nSuggestions:");
        if (length < 8) System.out.println("- Increase password length to at least 8 characters.");
        if (!upper) System.out.println("- Add uppercase letters.");
        if (!lower) System.out.println("- Add lowercase letters.");
        if (!digit) System.out.println("- Add numeric digits.");
        if (!special) System.out.println("- Add special characters like @ # $ % & *");

        if (score >= 90)
            System.out.println("- Excellent! Your password is highly secure.");

        String suggestion = "A@" + (length + 2026) + "Secure#" + (int)(Math.random()*999);
        System.out.println("\nSuggested Strong Password:");
        System.out.println(suggestion);

        sc.close();
    }
}
