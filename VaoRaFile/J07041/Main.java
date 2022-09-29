package OOPs.VaoRaFile.J07041;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream obj=new ObjectInputStream(new FileInputStream("DATA.in"));
        // ArrayList<Pair> a=(ArrayList<Pair>)obj.readObject(); // NOP = FILE ZIP nha ae _ true
        ArrayList<Pair> a = new ArrayList<>(); // FALSE
        Collections.sort(a);
        Set<String> set=new HashSet<>();
        for(Pair x:a){
            String s=String.valueOf(x.getFirst())+"-"+String.valueOf(x.getSecond());
            if(x.getFirst()<x.getSecond()&&!set.contains(s)){
                set.add(s);
                System.out.println(x);
            }
        }
        obj.close();
    }
}
