package OOP_TOT_NGHIEP.NganXep;
    
import java.util.Scanner;
import java.util.Stack;

public class TN04001 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            Stack<Integer> st = new Stack<>();
            int cnt = 1;
            for (int i = 0; i < s.length(); ++i){
                if(s.charAt(i) == '('){
                    st.add(cnt);
                    System.out.print(cnt + " ");
                    cnt ++;
                }
                else if(s.charAt(i) == ')'){
                    System.out.print(st.peek() + " ");
                    st.pop();
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
