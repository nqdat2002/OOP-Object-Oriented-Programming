package OOPs.XauKyTu;

import java.util.Arrays;
import java.util.Scanner;

// Xau day du
public class J03031 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while(t-->0){
            String s = ip.next();
            int k = ip.nextInt();
            int[] M = new int[200];
            Arrays.fill(M, 0);
            for(int i = 0; i < s.length(); i++)
                M[s.charAt(i)]++;
            int a=0;
            for(int i = 'a'; i <= 'z';i++)
                if(M[i]>0) a++;
            if(k + a >= 26 && s.length() >= 26) 
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
        ip.close();
    }
}