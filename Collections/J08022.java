package OOPs.Collections;

import java.util.Scanner;
import java.util.Stack;

public class J08022 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        while (t-- > 0) {
            int n = ip.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = ip.nextInt();
                b[i] = -1;
            }
            Stack<Integer> st = new Stack<>();
            for (int i = n - 1; i >= 0; --i) {
                while (st.size() > 0 && st.peek() <= a[i])
                    st.pop();
                if (st.size() > 0)
                    b[i] = st.peek();
                st.add(a[i]);
            }
            for (int i = 0; i < n; ++i) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
        }

        ip.close();
    }
}