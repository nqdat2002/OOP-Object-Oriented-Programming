package OOPs.XauKyTu;

import java.util.Scanner;

//so uu the
public class J03040 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String s = ip.nextLine();
            if(s.charAt(5) == s.charAt(6) && s.charAt(5) == s.charAt(7) && s.charAt(5) == s.charAt(9) && s.charAt(5) == s.charAt(10))
                System.out.println("YES");
            else if((s.charAt(5) == s.charAt(6) && s.charAt(5) == s.charAt(7)) && s.charAt(9) == s.charAt(10))   // 3dau 2 cuoi
                System.out.println("YES");
            else if((s.charAt(5) == 54 || s.charAt(5) == 56) && (s.charAt(6) == 54 || s.charAt(6) == 56)
            && (s.charAt(7) == 54 || s.charAt(7) == 56) && (s.charAt(9) == 54 || s.charAt(9) == 56 ) && (s.charAt(10) == 54 || s.charAt(10) == 56))
                System.out.println("YES");
            else if(s.charAt(5) < s.charAt(6) && s.charAt(6) < s.charAt(7) && s.charAt(7) < s.charAt(9) && s.charAt(9) < s.charAt(10))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        ip.close();
    }
} 