package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.math.BigInteger;
import java.util.Scanner;

public class TN01007 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String x = sc.nextLine();
        x.isEmpty();
        while(t-- > 0){
            String s = sc.nextLine();
            String [] a = s.split(" ");
            BigInteger m = new BigInteger(a[0]);
            BigInteger n = new BigInteger(a[1]);
            if(m.compareTo(n) < 0){
                BigInteger p = m;
                m = n; 
                n = p;
            }
            BigInteger q = m.divide(n);
            if(m.compareTo(q.multiply(n)) == 0){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
        sc.close();
    }
}
