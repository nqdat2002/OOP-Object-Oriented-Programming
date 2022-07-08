package OOPs.Collections;

import java.util.Scanner;
import java.util.Stack;

public class J08023 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long [] a = new long[n];
            for(int i = 0; i < n; ++i) a[i] = sc.nextLong();
            Stack<Integer> st = new Stack<>();
            long res = Long.MIN_VALUE;
            int i = 0;
            while(i < n){
                if(st.empty() || a[i] >= a[st.peek()]) {
                    st.push(i);
                    ++i;
                }
                else{
                    int id = st.peek();
                    st.pop();
                    if(st.empty()) res = Math.max(res, i * a[id]);
                    else res = Math.max(res, (i - st.peek() - 1) * a[id]);
                }
            }
            while(!st.empty()){
                int id = st.peek();
                st.pop();
                if(st.empty()) res = Math.max(res, i * a[id]);
                else res = Math.max(res, (i - st.peek() - 1) * a[id]);
            }
            System.out.println(res);
        }
        sc.close();
    }
}
