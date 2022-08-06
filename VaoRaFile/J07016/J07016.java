package OOPs.VaoRaFile.J07016;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07016 {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        // check Prime
        boolean[] check=new boolean[100001];
        for(int i=0;i<100000;i++)check[i]=true;
        for(int i=2;i<100000;i++){
            if(check[i]==true)
                for(int j=2*i;j<100000;j+=i)
                    check[j]=false;
        }
        int [] cnt1 = new int[10005], cnt2 = new int[10005];
        boolean [] vs = new boolean[10005];
        for(int i = 0; i < 10005; ++i) { vs[i] = false; cnt1[i] = 0; cnt2[i] = 0;}
        SortedSet<Integer> st = new TreeSet<>();
        SortedSet <Integer> stt = new TreeSet<>();
        
        try{
            FileInputStream sc = new FileInputStream("DATA1.in");
            ObjectInputStream readStream = new ObjectInputStream(sc);
            ArrayList<Integer> array = new ArrayList<>(); readStream.readObject();// false
            //ArrayList<Integer> array =  (ArrayList<Integer>) readStream.readObject(); // true
            for (Integer it : array) {
                if(Prime(it)){
                    st.add(it);
                    cnt1[it]++;
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
            //ArrayList<Integer> arrayy =  (ArrayList<Integer>) readStreamm.readObject();  // true
            for (Integer it : arrayy) {
                if(Prime(it)){
                    stt.add(it);
                    cnt2[it]++;
                }
            }
            readStreamm.close();
            scc.close();

        } catch (Exception e) {
            
        }
        for(Integer it: st){
            if(!vs[it] && stt.contains(it)){
                System.out.println(it + " " + cnt1[it] + " " + cnt2[it]);
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