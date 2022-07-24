package OOPs.VaoRaFile.J07004;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07004 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        
        int [] cnt = new int[1005], a = new int[100005];
        boolean [] vs = new boolean[1005];
        for(int i = 0; i < 1005; ++i) {vs[i] = false; cnt[i] = 0; }
        SortedSet<Integer> st = new TreeSet<>();
        int id = 0;
        while(sc.hasNext()){
            a[id] = sc.nextInt();
            cnt[a[id]]++;
            st.add(a[id]);
            id++;
        }
        for (Integer it: st) {
            if(!vs[it]){
                System.out.println(it + " " + cnt[it]);
                vs[it] = true;
            }
        }
        sc.close();
    }
}

