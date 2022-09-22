package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class TN04007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while (t-- > 0) {
            StringTokenizer stk = new StringTokenizer(sc.nextLine());
            String s = "";
            while (stk.hasMoreTokens()) {
                s += stk.nextToken();
            }
            Stack<String> st = new Stack<>(), res = new Stack<>();
            for (int i = 0; i < s.length(); ++i) {
                String tmp = "";
                tmp += "" + s.charAt(i);
                if (tmp.compareTo("+") == 0 ||
                        tmp.compareTo("-") == 0 ||
                        tmp.compareTo("(") == 0)
                    st.add(tmp);
                else if (tmp.compareTo("A") >= 0 &&
                        tmp.compareTo("Z") <= 0)
                    res.add(tmp);
                else if (tmp.compareTo(")") == 0) {
                    while (true) {
                        String c = st.peek();
                        st.pop();
                        if (c.compareTo("(") == 0) {
                            if (!st.isEmpty() && st.peek().compareTo("-") == 0) {
                                String b = res.peek();
                                if (b.length() >= 2) {
                                    res.pop();
                                    b = "(" + b + ")";
                                    res.add(b);
                                }
                            }
                            break;
                        }
                        String x = res.peek();
                        res.pop();
                        String y = res.peek();
                        res.pop();
                        res.add(y + c + x);
                    }
                }
            }
            while (!st.isEmpty()) {
                String c = st.peek();
                st.pop();
                String x = res.peek();
                res.pop();
                String y = res.peek();
                res.pop();
                res.add(y + c + x);
            }
            System.out.println(res.peek());
        }
        sc.close();
    }
}
