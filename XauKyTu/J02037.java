package OOPs.XauKyTu;

import java.util.Scanner;

// day uu the
public class J02037 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String s = ip.nextLine();
            int b = 0, c = 0;	
            s = s + " ";
            for (int i = 0; i < s.length() - 1; i++){ 
                if (s.charAt(i) != ' ' && s.charAt(i+1) == ' ') {
                    if (s.charAt(i) % 2 == 0) 
                        c++;
                    b++; 
                }
            }
            if ( b % 2 == 0 && b - c < c){
                System.out.println("YES");
                continue;
            }
            if ( b % 2 != 0 && b - c > c) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
        ip.close();
    }

    public static String Check(String s) {
        int n = s.length(), cnt = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') cnt++;
            if(c % 2 == 0) cnt1++;
            if(c % 2 == 1) cnt2++;
        }
        if(cnt < n || s.charAt(0) == '0') 
            return "INVALID";
        if(cnt1 % 2 == 0 && cnt == n && cnt1 > cnt2 || cnt2 % 2 == 1 && cnt == n && cnt2 > cnt1)
            return "YES";
        return "NO";
    }
} 