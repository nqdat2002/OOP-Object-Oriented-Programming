package OOPs.XauKyTu;

import java.util.Scanner;
import java.util.Vector;
// chuan hoa xau ho ten 2
public class J03005 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String a = ip.nextLine();
            a.toLowerCase();
            // String[] S = a.split(" "); -> String -> Array of String
            a = a.trim();
            Vector<String> st = new Vector<>();
            String res = "";
            a = a + " ";
            a = a.toLowerCase();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == ' ' && res.length() > 0) {
                    res = res.toLowerCase();
                    st.add(res);
                    res = "";
                } else if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z')
                    res += a.charAt(i);
            }
            for (int i = 1; i < st.size(); ++i) {
                String y = st.get(i);
                System.out.print(Std(y));
                if (i != st.size() - 1) {
                    System.out.print(" ");
                } else
                    System.out.print(", ");
            }
            System.out.print(st.get(0).toUpperCase());
            System.out.println();
        }
        ip.close();
    }

    public static String Std(String s) {
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i == 0) {
                res += Character.toUpperCase(c);
            } else
                res += c;
        }
        return res;
    }
}