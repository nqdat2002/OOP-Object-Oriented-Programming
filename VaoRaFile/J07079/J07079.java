package OOPs.VaoRaFile.J07079;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class J07079 {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        FileInputStream sc = new FileInputStream("DATA.in");
        try{
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<String> array =  new ArrayList<>(); readStream.readObject(); // this is false;
            //ArrayList<String> array = (ArrayList<String>) readStream.readObject(); // this is true;
            for (String it : array) {
                String s = "";
                for(int i = 0; i < it.length(); ++i){
                    if(it.charAt(i) == '0' || it.charAt(i) == '1') s += it.charAt(i);
                }
                System.out.println(s + " " + Long.parseLong(s, 2));
            }
            readStream.close();
        }catch(ClassNotFoundException e){
            
        }
        sc.close();
    }
}

