package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class TN01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        for (int i = 0; i < a; i++) {
            long n = sc.nextLong();
            tinh(n);
        }
        sc.close();
    }

    public static void tinh(long n) {
        long f0 = 0, f1 = 1, fn = 1;
        if (n == 0 || n == 1) {
            System.out.println("0");
        } else {
            for (int i = 2; i < n; i++) {
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }
            System.out.println("" + fn);
        }

    }
}
