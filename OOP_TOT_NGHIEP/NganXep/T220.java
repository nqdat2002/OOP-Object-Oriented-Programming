package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class T220 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            int n = s.length();
            Stack<Integer> st = new Stack<>();
            String res = "";
            for(int i = 0; i <= n; ++i){
                st.add(i + 1);
                if(i == n || s.charAt(i) == 'I'){
                    while(st.size() > 0){
                        res += "" + Integer.toString(st.peek());
                        st.pop();
                    }
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}
