package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class TN20 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long p = sc.nextLong(), q = sc.nextLong();
            Solve(p, q);
            System.out.println();
        }
        sc.close();
    }
    public static void Solve(long p, long q){
        if (q % p == 0){
            System.out.print("1/" + q / p);
            return;
        }
        long x = (q / p) + 1;
        System.out.print("1/" + x + " + ");
        Solve(p * x - q, q * x);
    }
}
