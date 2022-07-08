package OOPs.Collections;

import java.util.Scanner;
import java.util.Stack;

public class JKT015 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        Stack<Character> x = new Stack<>(), y = new Stack<>();
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) == '-'){
                if(x.size() > 0) x.pop();
            }
            else if(s.charAt(i) == '<'){
                if(x.size() > 0){
                    char t = x.peek(); x.pop(); y.push(t);
                }
            }
            else if(s.charAt(i) == '>'){
                if(y.size() > 0){
                    char t = y.peek(); y.pop(); x.push(t);
                }
            }
            else x.push(s.charAt(i));
        }
        while(!x.empty()){
            char t = x.peek(); x.pop(); y.push(t);
        }
        while(!y.empty()){
            System.out.print(y.peek() + "");
            y.pop();
        }
        sc.close();
    }
}
