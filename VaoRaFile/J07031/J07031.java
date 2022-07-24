package OOPs.VaoRaFile.J07031;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07031 {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        // check Prime
        boolean[] check=new boolean[1000001];
        for(int i=0;i<1000000;i++)check[i]=true;
        for(int i=2;i<1000000;i++){
            if(check[i]==true)
                for(int j=2*i;j<1000000;j+=i)
                    check[j]=false;
        }



        boolean [] vs = new boolean[1000005];
        for(int i = 0; i < 1000005; ++i) { vs[i] = false;}
        SortedSet<Integer> st = new TreeSet<>();
        SortedSet <Integer> stt = new TreeSet<>();
        
        try{
            FileInputStream sc = new FileInputStream("DATA1.in");
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<Integer> array = new ArrayList<>(); readStream.readObject();// false
            //ArrayList<Integer> array =  (ArrayList<Integer>) readStream.readObject(); // true
            for (Integer it : array) {
                if(check[it]){
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
                if(check[it]){
                    stt.add(it);
                }
            }
            readStreamm.close();
            scc.close();

        } catch (Exception e) {
            
        }
        for(Integer it: st){
            if(it < 1000000 - it && st.contains(1000000 - it) && !stt.contains(it) && !stt.contains(1000000 - it) && !vs[it] && !vs[1000000 - it]){
                System.out.println(it + " " + (1000000 - it));
                vs[it] = true;
                vs[1000000 - it] = true;
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