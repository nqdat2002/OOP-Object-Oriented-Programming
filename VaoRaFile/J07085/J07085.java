package OOPs.VaoRaFile.J07085;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class J07085 {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        FileInputStream sc = new FileInputStream("DATA.in");
        try{
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<String> array =  new ArrayList<>(); readStream.readObject(); // this is false;
            //ArrayList<String> array = (ArrayList<String>) readStream.readObject(); // this is true;
            for (String it : array) {
                String s = "";
                for(int i = 0; i < it.length(); ++i){
                    if(it.charAt(i) >= '0' && it.charAt(i) <= '9') s += it.charAt(i);
                }
                while(s.charAt(0) == '0' && s.length() > 1)
                    s = s.substring(1);
                System.out.println(s + " " + (long)Sum(s));
            }
            readStream.close();
        }catch(ClassNotFoundException e){
            
        }
        sc.close();
    }
    public static long Sum(String s) {
        long res = 0;
        for(int i = 0; i < s.length(); ++i) res += (s.charAt(i) - 48);
        return res;
    }
}

