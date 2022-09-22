package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class TN30 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while(t-- > 0){
            Stack<Integer> st = new Stack<>();
            String s = sc.nextLine();
            int n = s.length(), res = 0;
            for(int i = 0; i < n; ++i){
                if(s.charAt(i) == '[') st.add(i);
                else{
                    int index = i;
                    if(st.size() == 0){
                        while(s.charAt(index) == ']') ++index;
                        char c = s.charAt(i), d = s.charAt(index);
                        s = s.substring(0, i) + d + s.substring(i + 1, index) + c + s.substring(index + 1);
                        res += index - i;
                        st.add(i);
                    }
                    else st.pop();
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}
