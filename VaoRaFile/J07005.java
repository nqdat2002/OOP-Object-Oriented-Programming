package OOPs.VaoRaFile;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07005 {
    public static void main(String [] args) throws IOException{
        DataInputStream sc = new DataInputStream(new FileInputStream("DATA.IN"));

        int [] cnt = new int[1005], a = new int[100005];
        boolean [] vs = new boolean[1005];
        for(int i = 0; i < 1005; ++i) {vs[i] = false; cnt[i] = 0; }
        SortedSet<Integer> st = new TreeSet<>();
        int id = 0;
        try {
            while(true){
                a[id] = (int)sc.readInt();
                cnt[a[id]]++;
                st.add(a[id]);
                id++;
            }
        } catch (EOFException ignored) {
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

