package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

// uoc so chung lon nhat cua hai so nguyen lon
public class J03011 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        while (t-- > 0) {
            long a = ip.nextLong();
            String xt = ip.nextLine();
            xt.isEmpty();
            String b = ip.nextLine();
            System.out.println(gcd(a, module_mod(b, a)));
        }
        ip.close();
    }

    public static long module_mod(String s, long mod) {
        long res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            res = res * 10 + c - '0';
            res %= mod;
        }
        return res;
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
