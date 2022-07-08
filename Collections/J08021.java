package OOPs.Collections;

import java.util.Scanner;
import java.util.Stack;

public class J08021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String x = sc.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String s = sc.nextLine();
            Stack<Integer> st = new Stack<>();
            int res = 0;
            st.add(-1);
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(')
                    st.add(i);
                else {
                    st.pop();
                    if (!st.isEmpty())
                        res = mmax(res, i - st.peek());
                    else
                        st.add(i);
                }
            }
            System.out.println(res);

        }
        sc.close();
    }

    public static int mmax(int x, int y) {
        if (x > y)
            return x;
        return y;
    }
}
