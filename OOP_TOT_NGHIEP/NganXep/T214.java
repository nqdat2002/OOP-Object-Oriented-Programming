package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class T214 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            int n = s.length();
            Stack<String> st = new Stack<>();
            for (int i = n - 1; i >= 0; --i) {
                char c = s.charAt(i);
                if (isOperator(c)) {
                    String x = st.peek();
                    st.pop();
                    String y = st.peek();
                    st.pop();
                    st.push(x + y + c);

                } else {
                    char[] arr = { c };
                    String tmp = new String(arr);
                    st.add(tmp);
                }
            }
            System.out.println(st.peek());
        }
        sc.close();
    }

    public static boolean isOperator(char x) {
        return x == '+' || x == '-' || x == '*' || x == '/';
    }
}
