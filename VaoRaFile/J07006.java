package OOPs.VaoRaFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07006 {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        int [] cnt = new int[1000005], a = new int[1000005];
        boolean [] vs = new boolean[1000005];
        for(int i = 0; i < 1000005; ++i) { vs[i] = false; cnt[i] = 0; }
        SortedSet<Integer> st = new TreeSet<>();
        int id = 0;
        FileInputStream sc = new FileInputStream("DATA.in");
        try{
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<Integer> array =  new ArrayList<>(); readStream.readObject(); // this is false;
            //ArrayList<Integer> array = (ArrayList<Integer>) readStream.readObject(); // this is true;
            
            for (Integer it : array) {
                a[id] = it;
                cnt[a[id]]++;
                st.add(a[id]);
                id++;
            }
            readStream.close();
        }catch(ClassNotFoundException e){
            
        }
        sc.close();
        for(Integer it: st){
            if(!vs[it]){
                System.out.println(it + " " + cnt[it]);
                vs[it] = true;
            }
        }
    }
}

