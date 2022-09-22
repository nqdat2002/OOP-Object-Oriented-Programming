package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class DSA07019 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            // int n = sc.nextInt();
            // int [] a = new int[n];
            // for(int i = 0; i < n; ++i) a[i] = sc.nextInt();
            // Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>();
            // int [] r = new int[n], l = new int[n];
            // st1.add(n - 1);
            // for(int i = n - 1; i >= 0; --i){
            //     while (st1.size() > 0 && a[i] <= a[st1.peek()]) st1.pop();
            //     if(st1.size() > 0) r[i] = st1.peek() - 1;
            //     else r[i] = n - 1;
            //     st1.add(i);
            // }

            // for(int i = 0; i < n; ++i){
            //     while (st2.size() > 0 && a[i] <= a[st2.peek()]) st2.pop();
            //     if(st2.size() > 0) l[i] = st2.peek() + 1;
            //     else l[i] = 0;
            //     st2.add(i);
            // }
            // long res = -1;
            // for(int i = 0; i < n; ++i){
            //     res = Math.max(res, (long)((r[i] - l[i] + 1) * a[i]));
            // }
            // System.out.println(res);
            // int res = Integer.MIN_VALUE;
            // int i = 0;
            // while(i < n){
            //     if(st.empty() || a[i] >= a[st.peek()]) {
            //         st.push(i);
            //         ++i;
            //     }
            //     else{
            //         int id = st.peek();
            //         st.pop();
            //         if(st.empty()) res = Math.max(res, i * a[id]);
            //         else res = Math.max(res, (i - st.peek() - 1) * a[id]);
            //     }
            // }
            // while(!st.empty()){
            //     int id = st.peek();
            //     st.pop();
            //     if(st.empty()) res = Math.max(res, i * a[id]);
            //     else res = Math.max(res, (i - st.peek() - 1) * a[id]);
            // }
            // System.out.println(res);


            int n = sc.nextInt();
            long res = 0;
            long[] a = new long[n];
            Stack<Integer> b = new Stack<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                if (b.empty()) {
                    b.push(i);
                    continue;
                }
                if (a[b.peek()] <= a[i]) {
                    b.push(i);
                    continue;
                }
                int temp = b.pop();
                if (b.empty()) {
                    res = Math.max(res, a[temp] * i);
                } else
                    res = Math.max(res, a[temp] * (i - b.peek() - 1));
                i--;
            }
            
            while (!b.empty()) {
                int temp = b.pop();
                if (b.empty()) {
                    res = Math.max(res, a[temp] * n);
                } else
                    res = Math.max(res, a[temp] * (n - b.peek() - 1));
            }
            System.out.println(res);
        }
        sc.close();
    }
}


            // int n = in.nextInt();
            // long res = 0;
            // long[] a = new long[n];
            // Stack<Integer> b = new Stack<>();
            // for (int i = 0; i < n; i++) {
            //     a[i] = in.nextLong();
            // }
            // for (int i = 0; i < n; i++) {
            //     if (b.empty()) {
            //         b.push(i);
            //         continue;
            //     }
            //     if (a[b.peek()] <= a[i]) {
            //         b.push(i);
            //         continue;
            //     }
            //     int temp = b.pop();
            //     if (b.empty()) {
            //         res = Math.max(res, a[temp] * i);
            //     } else
            //         res = Math.max(res, a[temp] * (i - b.peek() - 1));
            //     i--;
            // }
            
            // while (!b.empty()) {
            //     int temp = b.pop();
            //     if (b.empty()) {
            //         res = Math.max(res, a[temp] * n);
            //     } else
            //         res = Math.max(res, a[temp] * (n - b.peek() - 1));
            // }
            // System.out.println(res);