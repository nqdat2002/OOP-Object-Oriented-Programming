package OOPs.XauKyTu;

import java.util.Scanner;

// tim so du
public class J03018 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String s = ip.nextLine();
            int res, n = s.length();
            if (n == 1) {
                char c = s.charAt(0);
                res = (c - 48) % 4;
            } else {
                char c = s.charAt(n - 1);
                char d = s.charAt(n - 2);
                res = 10 * (d - 48) + c - 48;
                res %= 4;
            }
            if (res == 0)
                System.out.println(4);
            else
                System.out.println(0);
        }
        ip.close();
    }
}