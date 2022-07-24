package OOPs.VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class J07002 {
    public static void main(String [] args) throws FileNotFoundException{
        File f = new File("DATA.in");
        Scanner sc = new Scanner(f);
        Vector<String> st = new Vector<>();
        while(sc.hasNext()){
            String a = sc.next();
            st.add(a);
        }
        long sum = 0;
        for (String s: st) {
            if(isInteger(s)) sum += Integer.valueOf(s);
        }
        System.out.println(sum);
        sc.close();
    }
    public static boolean isInteger(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') ++cnt;
        }
        return cnt == s.length() && s.length() <= 9;
    }
}
