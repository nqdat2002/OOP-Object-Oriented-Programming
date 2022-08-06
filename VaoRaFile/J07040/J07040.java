package OOPs.VaoRaFile.J07040;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class J07040 {
    public static void main(String [] args) throws IOException{
        FileInputStream sc = new FileInputStream("NHIPHAN.in");
        try{
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<String> array =  new ArrayList<>(); readStream.readObject(); // this is false;
            //ArrayList<String> array = (ArrayList<String>) readStream.readObject(); // this is true;
            readStream.close();
            Scanner scc = new Scanner(new File("VANBAN.in"));
            String s = "";
            while(scc.hasNext()){
                String a = scc.nextLine();
                if(a.isEmpty()) break;
                a = a.toLowerCase();
                s += (a + " ");
            }
            scc.close();
            ArrayList<String> b = new ArrayList<>();
            String [] a = s.split(" ");
            for(int i = 0; i < a.length; ++i) b.add(a[i]);


            String s1 = "";
            for (String str: array) {
                str = str.toLowerCase();
                s1 += (str + " ");
            }
            ArrayList<String> c = new ArrayList<>();
            String [] d = s1.split(" ");
            for(int i = 0; i < d.length; ++i) c.add(d[i]);

            Set<String> res = new LinkedHashSet<>();

            for (String st : b) {
                if(c.contains(st)) res.add(st);
            }
            for (String st: res) {
                System.out.println(st);
            }

        }catch(ClassNotFoundException e){
            
        }
        sc.close();
    }
}
