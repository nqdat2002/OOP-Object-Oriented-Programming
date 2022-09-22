package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class TN01033 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        int mx = -100000;
        for (int i = 0; i < n; ++i){
            a[i] = sc.nextInt();
            mx = Math.max(a[i], mx);
        }
        int res = -1, cnt = 0;
        for (int i = 0; i < n; ++i){
            if(a[i] == mx){
                cnt += 1;
            }
            else cnt = 0;
            res = Math.max(cnt, res);
        }
        System.out.println(res);

        sc.close();
    }
}
