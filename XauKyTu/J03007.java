package OOPs.XauKyTu;

import java.util.Scanner;

// so dep 2
public class J03007 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t > 0) {
            t--;
            String s = ip.nextLine();
            if (Check(s))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        ip.close();
    }

    public static boolean Check(String s) {
        int n = s.length(), cnt = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt += c;
        }
        for (int i = 0; i < n / 2; i++) {
            char c = s.charAt(i);
            char d = s.charAt(n - i - 1);
            if (c == d)
                cnt2++;
        }
        return (s.charAt(0) == '8' && s.charAt(n - 1) == '8') && cnt2 == n / 2 && ((cnt - 48 * n) % 10) == 0;
    }
}