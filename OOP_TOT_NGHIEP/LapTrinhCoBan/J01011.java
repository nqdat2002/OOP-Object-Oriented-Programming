package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class J01011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(BSCNN(a, b) + " " + USCLN(a, b));
        }
        sc.close();

    }

    public static long USCLN(long a, long b) {
        if (b == 0)
            return a;
        return USCLN(b, a % b);
    }

    public static long BSCNN(long a, long b) {
        return (a * b) / USCLN(a, b);
    }
}
