package OOPs.Mang;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class J02006 {
   public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Set<Integer> st = new TreeSet<>();
        for (int i = 0; i < n + m; ++i) st.add(sc.nextInt());
        for(Integer x: st) System.out.print(x + " ");
        sc.close();
    }
}
