package OOPs.VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class J07021 {
    public static void main(String [] args) throws FileNotFoundException{
        File f = new File("DATA.in");
        Scanner ip = new Scanner(f);
        while(ip.hasNext()){
            String a = ip.nextLine();
            if(a.compareTo("END") == 0)
                break;
            a.toLowerCase();
            //String[] S = a.split(" ");
            a = a.trim();
            Vector<String> st = new Vector<>();
            String res = "";
            a = a + " ";
            a = a.toLowerCase();
            for(int i=0 ; i< a.length() ; i++){
                if(a.charAt(i) == ' ' && res.length() > 0){
                    res = res.toLowerCase();
                    st.add(res);
                    res = "";
                }
                else if(a.charAt(i) >= 'a' && a.charAt(i) <= 'z') res += a.charAt(i);
            }
            for(int i = 0; i < st.size(); ++i){
                String y = st.get(i);
                System.out.print(Std(y) + " ");
            }
            System.out.println();
        }
        ip.close();
    }
    public static String Std(String s){
        String res = "";
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(i == 0){
                res += Character.toUpperCase(c);
            }
            else res += c;
        }
        return res;
    }
}
