package OOPs.VaoRaFile.J07032;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07032 {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        int [] count = new int[1000005];
        boolean [] vs = new boolean[1000005];
        for(int i = 0; i < 1000005; ++i) { vs[i] = false; count[i] = 0;}
        SortedSet<Integer> st = new TreeSet<>();
        SortedSet <Integer> stt = new TreeSet<>();
        
        try{
            FileInputStream sc = new FileInputStream("DATA1.in");
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<Integer> array = new ArrayList<>(); readStream.readObject();// false
            //ArrayList<Integer> array =  (ArrayList<Integer>) readStream.readObject(); // true
            for (Integer it : array) {
                if(IsReversible(it)){
                    count[it]++;
                    st.add(it);
                }
            }
            readStream.close();
            sc.close();
        }catch(ClassNotFoundException e){
            
        }
        try {
            FileInputStream scc = new FileInputStream("DATA2.in");
            ObjectInputStream readStreamm = new ObjectInputStream(scc);
            ArrayList<Integer> arrayy = new ArrayList<>(); readStreamm.readObject(); // false
            // ArrayList<Integer> arrayy =  (ArrayList<Integer>) readStreamm.readObject();  // true
            for (Integer it : arrayy) {
                if(IsReversible(it)){
                    count[it]++;
                    stt.add(it);
                }
            }
            readStreamm.close();
            scc.close();

        } catch (Exception e) {
            
        }
        int cnt = 0;
        for(Integer it: st){
            if(cnt == 10) break;
            if(stt.contains(it) && !vs[it]){
                System.out.println(it + " " + count[it]);
                vs[it] = true;
                ++cnt;
            }
        }
    }
    public static boolean IsReversible(int n){
        String m = Integer.toString(n);
        if(m.length() % 2 == 0 || m.length() == 1)
            return false;
        int cnt = 0;
        boolean ok = true;
        for(int i = 0; i < m.length() / 2; ++i){
            if(m.charAt(i) != m.charAt(m.length() - i - 1)){
                ok = false;
                return false;
            }
        }
        for(int i = 0; i < m.length(); ++i){
            if(m.charAt(i) % 2 == 1){
                cnt++;
            }
        }
        return cnt == m.length() && ok == true;
    }
}