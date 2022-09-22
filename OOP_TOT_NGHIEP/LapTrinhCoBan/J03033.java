package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.math.BigInteger;
import java.util.Scanner;

public class J03033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger x = new BigInteger(sc.next()), y = new BigInteger(sc.next());
            BigInteger res = x.multiply(y);
            BigInteger ans = x.gcd(y);
            System.out.println(res.divide(ans));
        }
        sc.close();
    }
}