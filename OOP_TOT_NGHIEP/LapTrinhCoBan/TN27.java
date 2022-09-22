package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class TN27 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.next(), y = sc.next();
        String z = "" + x, t = "" + y;
        x = x.replaceAll("6", "5");
        y = y.replaceAll("6", "5");
        z = z.replaceAll("5", "6");
        t = t.replaceAll("5", "6");
        System.out.println((Integer.valueOf(x) + Integer.valueOf(y) + " " + (Integer.valueOf(z) + Integer.valueOf(t))));
        sc.close();
    }
}
