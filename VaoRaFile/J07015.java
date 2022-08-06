package OOPs.VaoRaFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07015 {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        int [] cnt = new int[100005], a = new int[100005];
        boolean [] vs = new boolean[100005];
        for(int i = 0; i < 100005; ++i) { vs[i] = false; cnt[i] = 0; }
        SortedSet<Integer> st = new TreeSet<>();
        int id = 0;
        FileInputStream sc = new FileInputStream("SONGUYEN.in");
        try{
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<Integer> array =  new ArrayList<>(); readStream.readObject(); // this is false;
            //ArrayList<Integer> array = (ArrayList<Integer>) readStream.readObject(); // this is true;
            
            for (Integer it : array) {
                if(Prime(it)){
                    a[id] = it;
                    cnt[a[id]]++;
                    st.add(a[id]);
                    id++;
                }
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
    public static boolean Prime(int n){
        if(n < 2)
            return false;
        for(int i = 2; i <= Math.sqrt(n); ++i){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}

