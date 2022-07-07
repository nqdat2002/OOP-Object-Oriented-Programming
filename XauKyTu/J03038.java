package OOPs.XauKyTu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// danh dau chu cai
public class J03038 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            String s = ip.nextLine();
            Set<Character> st = new HashSet<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                st.add(c);
            }
            System.out.println(st.size());
        }
        ip.close();
    }

    public static boolean Check(String s) {
        int n = s.length(), cnt = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0)
                cnt += c - '0';
            else
                cnt2 += c - '0';
        }

        return ((cnt - cnt2) % 11 == 0);
    }
}