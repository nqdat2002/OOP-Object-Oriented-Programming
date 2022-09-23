package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JP007 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Set<String> st = new TreeSet<>();
        while(sc.hasNextLine()){
            st.add(sc.nextLine().toLowerCase());
        }
        for (String string : st) {
            System.out.println(string);
        }
        sc.close();
    }
}
