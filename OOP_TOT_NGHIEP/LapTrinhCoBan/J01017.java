package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class J01017 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String b = sc.nextLine();
        b.isEmpty();
        while(t-- > 0){
            String x = sc.nextLine();
            int n = x.length(), cnt = 0;
            for(int i = 0; i < n - 1; i ++){
                char c = x.charAt(i), d = x.charAt(i + 1);
                if(c - d == 1|| c - d == -1) cnt++;
            }
            if(cnt == n - 1) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}