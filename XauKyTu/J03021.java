package OOPs.XauKyTu;

import java.util.Scanner;

// loai bo 100
public class J03021 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String a = ip.nextLine();
            String res = "";
            a = a.toLowerCase();
            for (int i = 0; i < a.length(); ++i) {
                char c = a.charAt(i);
                if (c >= 'a' && c <= 'c')
                    res += "2";
                if (c >= 'd' && c <= 'f')
                    res += "3";
                if (c >= 'g' && c <= 'i')
                    res += "4";
                if (c >= 'j' && c <= 'l')
                    res += "5";
                if (c >= 'm' && c <= 'o')
                    res += "6";
                if (c >= 'p' && c <= 's')
                    res += "7";
                if (c >= 't' && c <= 'v')
                    res += "8";
                if (c >= 'w' && c <= 'z')
                    res += "9";
            }
            System.out.println(rev(res));
        }
        ip.close();
    }

    public static String rev(String s) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return "NO";
        }
        return "YES";
    }
}