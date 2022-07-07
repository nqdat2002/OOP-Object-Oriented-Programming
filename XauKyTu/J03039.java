package OOPs.XauKyTu;

import java.math.BigInteger;
import java.util.Scanner;
// chia het
public class J03039 {
    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while(t-- > 0){
            String s = ip.nextLine();
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
        ip.close();
    }

}