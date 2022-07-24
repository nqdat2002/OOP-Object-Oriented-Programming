package OOPs.VaoRaFile;

import java.util.Scanner;
import java.util.Stack;

public class J07077 {
    
    public static long Calculate(long a, long b, Character c){
        if(c == '+') return a + b;
        if(c == '-') return a - b;
        if(c == '*') return a * b;
        return a / b;
    }

    public static int Priority(Character c){
        if(c == '+' || c == '-')
            return 1;
        if(c == '*' || c == '/')
            return 2;
        return 0;
    }

    public static Long Infix(String s){
        Stack<Character> ops = new Stack<>();
        Stack<Long> val = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                ops.push(s.charAt(i));
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                long x = 0;
                while (i < n  && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    x = (x * 10) + (s.charAt(i) - '0');
                    ++i;
                }
                if (s.charAt(i) < '0' || s.charAt(i) > '9') --i;
                val.push(x);
            }
            else if (s.charAt(i) == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    long x1 = val.peek(); val.pop();
                    long x2 = val.peek(); val.pop();
                    char y = ops.peek(); ops.pop();
                    val.push(Calculate(x2, x1, y));
                }
                if (!ops.isEmpty())
                    ops.pop();
            }
            else {
                while (!ops.isEmpty() && Priority(ops.peek()) >= Priority(s.charAt(i))) {
                    long x1 = val.peek(); val.pop();
                    long x2 = val.peek(); val.pop();
                    char y = ops.peek(); ops.pop();
                    val.push(Calculate(x2, x1, y));
                }
                ops.push(s.charAt(i));
            }
        }
        while (!ops.isEmpty()) {
            long x1 = val.peek(); val.pop();
            long x2 = val.peek(); val.pop();
            char y = ops.peek(); ops.pop();
            val.push(Calculate(x2, x1, y));
        }
        return val.peek();
    }

    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
        String x = sc.nextLine();
        int t = Integer.valueOf(x);
        x.isEmpty();
        while(t-- > 0){
            System.out.println(Infix(sc.nextLine()));
        }
        sc.close();
    }
}
