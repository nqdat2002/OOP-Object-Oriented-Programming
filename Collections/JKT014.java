package OOPs.Collections;

import java.util.Scanner;
import java.util.Stack;

public class JKT014 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int [] a = new int[n];
            for(int i = 0; i < n; ++i) a[i] = sc.nextInt();
            int [] r = new int[n];
            r[0] = 1;
            Stack<Integer> st = new Stack<>();
            st.push(0);
            for (int i = 1; i < n; i++) {
                while (!st.empty() && a[st.peek()] <= a[i])
                    st.pop();
                if (st.empty())
                    r[i] = i + 1;  
                else 
                    r[i] = i - st.peek();
                st.push(i);
            }
            for(int i = 0; i < n; ++i) {
                System.out.print(r[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
