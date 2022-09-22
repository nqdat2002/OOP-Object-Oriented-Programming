package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class T216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            int n = s.length();
            Stack<Long> st = new Stack<>();
            for (int i = 0; i < n; ++i) {
                char c = s.charAt(i);
                if (isOperator(c)) {
                    Long x = st.peek();
                    st.pop();
                    Long y = st.peek();
                    st.pop();
                    st.push(Cal(y, x, c));

                } else {
                    st.add((long)(c - 48));
                }
            }
            System.out.println(st.peek());
        }
        sc.close();
    }

    public static boolean isOperator(char x) {
        return x == '+' || x == '-' || x == '*' || x == '/';
    }

    public static long Cal(long x, long y, char c){
        if(c == '+') return x + y;
        if(c == '-') return x - y;
        if(c == '*') return x * y;
        return x / y;
    }
}
