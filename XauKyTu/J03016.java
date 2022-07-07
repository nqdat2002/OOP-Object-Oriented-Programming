package OOPs.XauKyTu;

import java.util.Scanner;

// chia het cho 11
public class J03016 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String s = ip.nextLine();
            if (Check(s))
                System.out.println("1");
            else
                System.out.println("0");
        }
        ip.close();
    }

    public static boolean Check(String s) {
        int n = s.length(), cnt = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0)
                cnt += c - '0';
            else
                cnt2 += c - '0';
        }

        return ((cnt - cnt2) % 11 == 0);
    }
}