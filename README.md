# Cyber-security-Virtual-Intership-
Cyber security Virtual Intership of https://www.programiz.com/java-programming/online-compiler/
import java.util.Scanner;

public class PasswordStrengthAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      PASSWORD STRENGTH ANALYZER");
        System.out.println("==========================================");

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
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class VulnerabilityScanner {

    // Common ports to scan
    static int[] ports = {21, 22, 23, 25, 53, 80, 110, 135, 139, 143, 443, 445, 3306, 3389, 8080};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("      VULNERABILITY SCANNER");
        System.out.println("=========================================");

        System.out.print("Enter Target IP or Website: ");
        String host = sc.nextLine();

        System.out.println("\nScanning Open Ports...\n");

        for (int port : ports) {
            if (isPortOpen(host, port)) {
                System.out.println("[OPEN] Port " + port);
            } else {
                System.out.println("[CLOSED] Port " + port);
            }
        }

        System.out.println("\nChecking Software Versions...\n");

        checkSoftware("Apache", "2.4.29", "2.4.58");
        checkSoftware("OpenSSL", "1.0.2", "3.0.13");
        checkSoftware("MySQL", "5.6", "8.4");
        checkSoftware("PHP", "7.2", "8.3");

        System.out.println("\n=========================================");
        System.out.println("      VULNERABILITY REPORT");
        System.out.println("=========================================");

        System.out.println("Target: " + host);
        System.out.println("Port Scan Completed.");
        System.out.println("Software Version Check Completed.");

        System.out.println("\nRecommendations:");
        System.out.println("✔ Close unused ports.");
        System.out.println("✔ Update outdated software.");
        System.out.println("✔ Enable Firewall.");
        System.out.println("✔ Use Strong Passwords.");
        System.out.println("✔ Enable HTTPS.");
        System.out.println("✔ Keep Antivirus Updated.");

        System.out.println("\nScan Finished Successfully.");

        sc.close();
    }

    // Port Scanner
    public static boolean isPortOpen(String host, int port) {

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 300);
            socket.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Software Version Checker (Demo)
    public static void checkSoftware(String software, String installed, String latest) {

        System.out.println("Software : " + software);
        System.out.println("Installed Version : " + installed);
        System.out.println("Latest Version    : " + latest);

        if (!installed.equals(latest)) {
            System.out.println("Status : OUTDATED");
            System.out.println("Recommendation : Update Immediately\n");
        } else {
            System.out.println("Status : UP TO DATE\n");
        }
    }
}
