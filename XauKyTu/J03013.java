package OOPs.XauKyTu;

import java.math.BigInteger;
import java.util.Scanner;

// hieu so nguyen lon 1
public class J03013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String y = sc.nextLine();
        y.isEmpty();
        while (t-- > 0) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            BigInteger x = a.subtract(b);
            x = x.abs();
            String s = x.toString();
            String m = a.toString();
            String n = b.toString();
            int maxx = Math.max(m.length(), n.length());
            while (s.length() < maxx) {
                s = "0" + s;
            }
            System.out.println(s);
        }
        sc.close();
    }

    static String subtractStrings(String num1, String num2) {
        while (num1.length() < num2.length())
            num1 = "0" + num1;
        while (num2.length() < num1.length())
            num2 = "0" + num2;
        if (num1.compareTo(num2) == -1) {
            String c = num1;
            num1 = num2;
            num2 = c;
        }
        String c = "";
        int tmp = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int sum = ((int) (num1.charAt(i) - '0') - (int) (num2.charAt(i) - '0') - tmp);
            if (sum < 0) {
                c = (char) (sum + 10 + '0') + c;
                tmp = 1;
            } else {
                c = (char) (sum + '0') + c;
                tmp = 0;
            }
        }
        return c;
    }

    public static int mmax(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

}