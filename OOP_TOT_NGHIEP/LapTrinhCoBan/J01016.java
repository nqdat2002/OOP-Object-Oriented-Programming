package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class J01016 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = x.length();
        int d4 = 0, d7 = 0;
        for(int i = 0; i < n; ++i){
            char c = x.charAt(i);
            if(c == '4') d4++;
            if(c == '7') d7++;
        }
        if(d4 + d7 == 4 || d4 + d7 == 7) System.out.println("YES");
        else System.out.println("NO");
        sc.close();
    }
}