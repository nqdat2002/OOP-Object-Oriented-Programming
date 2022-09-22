package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class TN04003 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int [] a = new int[n], r = new int[n];
            for(int i = 0; i < n; ++i) {a[i] = sc.nextInt();}
            Stack<Integer> st = new Stack<>();
            st.add(0);
            r[0] = 1;
            for(int i = 1; i < n; ++i){
                while (st.size() > 0 && a[st.peek()] <= a[i]) st.pop();
                if(st.size() == 0) r[i] = i + 1;
                else r[i] = i - st.peek();
                st.add(i);
            }
            for(int i = 0; i < n; ++i){
                System.out.print(r[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
