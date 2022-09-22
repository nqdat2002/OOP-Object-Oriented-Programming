package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.math.BigInteger;
import java.util.Scanner;

public class TN01010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while(line.length()>1){
            String a = line.substring(0, line.length()/2);
            String b = line.substring(line.length()/2, line.length());
            BigInteger x = new BigInteger(a);
            BigInteger y = new BigInteger(b);
            BigInteger z = x.add(y);
            System.out.println(z);
            line =z.toString();
        }
        sc.close();
    }
}
