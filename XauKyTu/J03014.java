package OOPs.XauKyTu;

import java.math.BigInteger;
import java.util.Scanner;

// tong so nguyen lon 2
public class J03014 {
    static String addStrings(String num1, String num2) {
        while (num1.length() < num2.length())
            num1 = "0" + num1;
        while (num2.length() < num1.length())
            num2 = "0" + num2;
        String c = "";
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int sum = ((int) (num1.charAt(i) - '0') + (int) (num2.charAt(i) - '0') + carry);
            c = (char) (sum % 10 + '0') + c;
            carry = sum / 10;
        }
        if (carry > 0) {
            c = (char) (carry + '0') + c;
        }
        while (c.charAt(0) == '0')
            c = c.substring(0);
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        // System.out.println(addStrings(s, s1));
        BigInteger a1 = new BigInteger(s);
        BigInteger a2 = new BigInteger(s1);
        System.out.print(a1.add(a2));
        sc.close();
    }
}