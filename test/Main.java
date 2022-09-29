package test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream obj=new ObjectInputStream(new FileInputStream("DATA.in"));
        // ArrayList<Pair> a=(ArrayList<Pair>)obj.readObject();
        ArrayList<Pair> a= new ArrayList<>();
        Collections.sort(a);
        Set<String> set=new HashSet<>();
        for(Pair x:a){
            String s=String.valueOf(x.getFirst())+"-"+String.valueOf(x.getSecond());
            if(x.getFirst()<x.getSecond()&&!set.contains(s) && gcd(x.getFirst(), x.getSecond()) == 1){
                set.add(s);
                System.out.println(x);
            }
        }
        obj.close();
    }
    public static long gcd(int x, int y){
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
