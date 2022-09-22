package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class DSA07021 {
    static int max(int a, int b) {
        if (a < b)
            return b;
        return a;
    }

    static int Find(String t) {
        int len = t.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (t.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty() == false) {
                    res = max(res, i - stack.peek());
                } else
                    stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        String[] input = new String[test];
        for (int i = 0; i < test; i++) {
            String t;
            t = sc.next();
            input[i] = t;
        }
        for (int i = 0; i < test; i++) {

            System.out.println(Find(input[i]));
        }
        sc.close();
    }
}
