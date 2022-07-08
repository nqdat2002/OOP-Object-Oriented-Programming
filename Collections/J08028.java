package OOPs.Collections;

import java.util.Scanner;
import java.util.Stack;

public class J08028 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while(t-- > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            long [] a = new long[n];
            long [] b = new long[n];
            for(int i = 0; i < n; ++i) a[i] = sc.nextLong();
            for(int i = n - 1; i >= 0; --i){
                b[i] = m - a[i];
            }
            long res = Math.max(Max_area(a, n), Max_area(b, n));
            System.out.println(res);
        }
        sc.close();
    }
    public static long Max_area(long [] a, int n){
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
        return res;
    }
}
