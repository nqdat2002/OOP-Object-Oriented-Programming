package OOPs.Collections;

import java.util.Scanner;
import java.util.Stack;

public class J08020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String x = sc.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String s = sc.nextLine();
            boolean ok = true;
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    st.add(c);
                } else if (c == '}') {
                    if (st.size() == 0) {
                        ok = false;
                        break;
                    } else if (st.peek() == '{') {
                        st.pop();
                    }
                } else if (c == ']') {
                    if (st.size() == 0) {
                        ok = false;
                        break;
                    } else if (st.peek() == '[') {
                        st.pop();
                    }
                } else if (c == ')') {
                    if (st.size() == 0) {
                        ok = false;
                        break;
                    } else if (st.peek() == '(') {
                        st.pop();
                    }
                }
            }
            if (st.size() > 0)
                ok = false;
            if (ok == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}
