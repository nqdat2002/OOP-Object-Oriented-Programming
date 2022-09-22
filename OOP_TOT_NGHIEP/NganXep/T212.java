package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.Stack;

public class T212 {
    static String str;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();
        while (test-- > 0) {
            str = sc.nextLine();
            Try();
        }
        sc.close();

    }

    public static void Try() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            }
            else  {
                if (str.charAt(i) == ')') {
                    char x = stack.pop();
                    if (x == '(') {
                        System.out.println("Yes");
                        return;
                    }
                    while (x != '(') {
                        x = stack.pop();
                    }
                } else {
                    if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                        continue;
                    }
                    stack.push(str.charAt(i));
                }
            }
        }
        System.out.println("No");
    }
}
