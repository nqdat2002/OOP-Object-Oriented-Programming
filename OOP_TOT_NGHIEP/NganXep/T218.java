package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class T218 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int [] a = new int[n], r = new int[n];
            for(int i = 0; i < n; ++i) {a[i] = sc.nextInt(); r[i] = -1;}
            Stack<Integer> st = new Stack<>();

            for(int i = n - 1; i >= 0; --i){
                while (st.size() > 0 && st.peek() <= a[i]) st.pop();
                if(st.size() > 0) r[i] = st.peek();
                st.add(a[i]);
            }
            for(int i = 0; i < n; ++i){
                System.out.print(r[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
