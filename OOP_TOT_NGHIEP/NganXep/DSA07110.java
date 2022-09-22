package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class DSA07110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {

            String s = sc.nextLine();

            if (KiemTra(s) == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
        sc.close();

    }

    public static boolean KiemTra(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.empty()) {

                    if (s.charAt(i) == ')') {
                        if (stack.peek() != '(') {
                            return false;
                        }
                    }

                    if (s.charAt(i) == '}') {
                        if (stack.peek() != '{') {
                            return false;
                        }
                    }

                    if (s.charAt(i) == ']') {
                        if (stack.peek() != '[') {
                            return false;
                        }
                    }

                    stack.pop();

                } else {
                    return false;
                }
            }

        }
        return stack.empty() == true;

    }
}
