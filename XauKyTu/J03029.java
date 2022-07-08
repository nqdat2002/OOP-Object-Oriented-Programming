package OOPs.XauKyTu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

// Chuan hoa cau 
public class J03029 {
    public static String convert(String a){
        a = a.trim();
        Vector<String> st = new Vector<>();
        String res = "";
        a = a + " ";
        a = a.toLowerCase();
        for(int i=0 ; i < a.length() ; i++){
            if(a.charAt(i) == ' ' && res.length() > 0){
                res = res.toLowerCase();
                st.add(res);
                res = "";
            }
            else if(a.charAt(i) == '.' || a.charAt(i) == '?' || a.charAt(i) == '!' || 
            a.charAt(i) == ':' || a.charAt(i) == ',' || (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') ||
            (a.charAt(i) >= '0' && a.charAt(i) <= '9')) res += a.charAt(i);
        }
        res = "";
        for(int i = 0; i < st.size() - 1; ++i){
            res += (st.get(i) + " ");
        }
        res += st.get(st.size() - 1);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> array = new ArrayList<>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.isEmpty()) break;
            String res = convert(s);
            if(res.charAt(res.length() - 1) != '!' && res.charAt(res.length() - 1) != '?' &&  res.charAt(res.length() - 1) != '.')
                res = res + '.';
            while(res.charAt(res.length() - 2) == ' ')
                res = res.substring(0, res.length() - 2) + res.charAt(res.length() - 1);
            char c = res.charAt(0);
            c = Character.toUpperCase(c);
            res = c + res.substring(1);
            array.add(res);
        }
        for(String x: array) {
            System.out.println(x);
        }
        sc.close();
    }
}