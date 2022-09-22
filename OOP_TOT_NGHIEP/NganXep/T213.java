package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class T213 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while(t -- > 0){
            String s = sc.nextLine();
            Stack<Character> st = new Stack<>();
            int n = s.length(), cnt = 0;
            for (int i = 0; i < n; ++i) {
                if(s.charAt(i) == ')' && !st.isEmpty()){
                    if(st.peek() == '(') st.pop();
                    else st.add(s.charAt(i));
                }
                else st.add(s.charAt(i));
            }
            n = st.size();
            while(!st.isEmpty() && st.peek() == '('){
                cnt ++;
                st.pop();
            }
            System.out.println((n / 2 + cnt % 2));
        }
        sc.close();
    }
}
