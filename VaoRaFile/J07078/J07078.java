package OOPs.VaoRaFile.J07078;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07078 {
    public static void main(String [] args) throws FileNotFoundException{
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("STRING.in"));
        String x = sc.nextLine();
        int t = Integer.valueOf(x);
        x.isEmpty();
        while(t-- > 0){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int l = s2.length();
            s1 = " " + s1;
            for(int i = 1; i < s1.length() - l + 1; ++i){
                String tmp = s1.substring(i, i + l);
                if(tmp.compareTo(s2) == 0){
                    System.out.print(i + " ");
                } 
            }
            System.out.println();
        }
        sc.close();
    }
}
