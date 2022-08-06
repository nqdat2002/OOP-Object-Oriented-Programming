package OOPs.VaoRaFile.J07041;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Pair implements Serializable, Comparable <Pair> {
    private int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public int getFirst() {return first;}
    public int getSecond() {return second;}
    public int compareTo(Pair o){
        return this.first - o.first;
    }
    public String toString(){
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) throws Exception, ClassNotFoundException{
        
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("DATA.in"));
            ArrayList<Pair> arrP = new ArrayList<>();
            arrP = (ArrayList<Pair>)(inputStream.readObject());
            Collections.sort(arrP);
            Set<Pair> hsP = new HashSet<>();
            for(Pair p : arrP){
                if(!hsP.contains(p) && (p.getFirst() < p.getSecond())){
                    System.out.println(p);
                    hsP.add(p);
                }
            }
            inputStream.close();
        }
        catch(ClassNotFoundException e){
            
        }
    }
}

