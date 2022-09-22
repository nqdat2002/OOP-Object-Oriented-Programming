package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class S226 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            String r = "";
            for(int i = 0; i < s.length(); ++i){
                if(s.charAt(i) == ')' || s.charAt(i) == '(')
                    r += s.charAt(i);
            }
            if(!check(r)){
                System.out.println(-1);
                continue;
            }
            int cnt = 0, res = 0;
            for(int i = 0; i < r.length(); ++i){
                if(r.charAt(i) == '('){
                    cnt ++;
                    res = Math.max(res, cnt);
                }
                else cnt --;
            }
            System.out.println(res);
        }
        sc.close();
    }

    public static boolean check(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(') st.add(s.charAt(i));
            else{
                if(st.size() == 0){
                    return false;
                }
                st.pop();
            }
        }
        return st.size() == 0;
    }
}
