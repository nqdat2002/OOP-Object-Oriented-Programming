package OOPs.Basic;

import java.util.Scanner;

public class J03035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            int n = s1.length();
            int c = 0;
            Boolean c1 = false, c2 = false, cc = false;
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == '?')
                    c++;
            }
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (s1.charAt(i) == '?') {
                        cc = true;
                    } else if (s1.charAt(i) > s2.charAt(i)) {
                        if (cc == false) {
                            c1 = true;
                            break;
                        }
                    } else {
                        if (cc == false) {
                            c2 = true;
                            break;
                        }
                    }
                }
            }
            if (c1) {
                if (c == 0)
                    System.out.println("0");
                else
                    System.out.println((long) Math.pow(10, c));
            } else if (c2) {
                System.out.println("0");
            } else {
                long res = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        if (s1.charAt(i) == '?') {
                            int q = 0;
                            for (int j = i + 1; j < s1.length(); j++) {
                                if (s1.charAt(j) == '?')
                                    q++;
                            }
                            long h = (s2.charAt(i) - '0');
                            res += (9 - h) * (long) Math.pow(10, q);
                        } else if (s1.charAt(i) > s2.charAt(i)) {
                            int q = 0;
                            for (int j = i; j < s1.length(); j++) {
                                if (s1.charAt(j) == '?')
                                    q++;
                            }
                            res += (long) Math.pow(10, q);
                            break;
                        } else
                            break;
                    }
                }
                System.out.println(res);
            }
        }
        sc.close();
    }
}
