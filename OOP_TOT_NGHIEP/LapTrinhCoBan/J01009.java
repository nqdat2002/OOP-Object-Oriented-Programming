package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;
public class J01009 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while(t-- > 0){
            int n = sc.nextInt();
            long tc = 1;
            long res = 0;
            for(int i = 1; i <= n; i ++){
                tc = tc * i;
                res += tc;
            }
            System.out.println(res);
        }
        sc.close();
    }
}
