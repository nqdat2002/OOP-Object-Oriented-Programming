package OOPs.XauKyTu;

import java.util.Scanner;

// tong so nguyen lon 1
public class J03012 {
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
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            String s1 = sc.next();
            System.out.println(addStrings(s, s1));
        }
        sc.close();
    }
}