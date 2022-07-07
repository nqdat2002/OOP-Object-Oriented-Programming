package OOPs.XauKyTu;

import java.util.*;

// dia chi email 1
public class J03010 {
    static String solve(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                return ans;
            }
            ans += s.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        Set<String> st = new HashSet<>();

        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.trim();
            Vector<String> v = new Vector<>();
            String res = "";
            s = s + " ";
            s = s.toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ' && res.length() > 0) {
                    res = res.toLowerCase();
                    v.add(res);
                    res = "";
                } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    res += s.charAt(i);
            }
            String ans = "";
            ans += v.get(v.size() - 1);
            v.remove(v.size() - 1);
            for (String tmp : v) {
                ans += tmp.charAt(0);
            }
            if (st.isEmpty() || !st.contains(ans)) {
                st.add(ans);
                ans += "@ptit.edu.vn";
                System.out.println(ans);
                continue;
            }
            int cnt = 2;
            while (st.contains(ans)) {
                ans = ans + String.valueOf(cnt);
                if (!st.contains(ans)) {
                    cnt = 2;
                    st.add(ans);
                    break;
                }
                cnt++;
                ans = solve(ans);
            }
            ans += "@ptit.edu.vn";
            System.out.println(ans);
        }
        sc.close();
    }
}
