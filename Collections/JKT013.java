package OOPs.Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class JKT013 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();
        Vector<String> v = new Vector<>();
        q.add("6");
        q.add("8");
        v.add("6");
        v.add("8");
        while(v.size()  <= 100000){
            String s = q.poll(); q.peek();
            q.add(s + "6");
            q.add(s + "8");
            v.add(s + "6");
            v.add(s + "8");
        }
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            Stack<String> st = new Stack<>();
            for (String str : v) {
                if(str.length() <= n){
                    st.push(str);
                }
            }
            System.out.println(st.size());
            while(!st.empty()){
                System.out.print(st.peek() + " ");
                st.pop();
            }
            System.out.println();
        }
        sc.close();
    }
}
