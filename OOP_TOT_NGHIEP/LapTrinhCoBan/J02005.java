package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class J02005 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int [] a = new int[1005], b = new int[1005];
        for(int i = 0; i < n; ++i) {
            int x = sc.nextInt();
            a[x]++;
        }
        for(int i = 0; i < m; ++i) {
            int x = sc.nextInt();
            b[x]++;
        }
        for(int i = 0; i < 1005; ++i){
            if(a[i] != 0 && b[i] != 0) System.out.print(i + " ");
        }
        sc.close();

    }
}