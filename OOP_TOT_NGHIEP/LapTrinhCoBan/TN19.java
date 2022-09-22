package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class TN19 {
    static boolean lapPhuong(long n) {
        long m = (long) Math.pow(n, 1.0 / 3);
        if (Math.pow(m, 3) == n || Math.pow(m + 1, 3) == n)
            return true;
        else
            return false;
    }

    static String tapCon(String s, long[] a) {
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            if (a[i] == 0) {
                s2 += String.valueOf(s.charAt(i));
            }
        }
        return s2;
    }

    static void check(long n) {
        String s = String.valueOf(n);
        long[] a = new long[s.length()];
        for (int i = 0; i < s.length(); i++)
            a[i] = 0;
        long max = -1, soKhoi = Long.parseLong(tapCon(s, a));
        if (lapPhuong(soKhoi))
            max = soKhoi;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (a[i] == 0) {
                a[i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    a[j] = 0;
                }
                if (tapCon(s, a).length() == 0)
                    break;
                soKhoi = Long.parseLong(tapCon(s, a));
                if (lapPhuong(soKhoi) && soKhoi > max)
                    max = soKhoi;
                i = s.length();
            }
        }
        if (max == -1)
            System.out.println(max);
        else
            System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            check(n);
        }
        sc.close();
    }
}
