package OOPs.VaoRaFile.J07014;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
class WordSet{
    private SortedSet<String> ts = new TreeSet<>();

    public WordSet(){
        this.ts.clear();
    }
    public WordSet(String a) throws FileNotFoundException{
        File f = new File(a);
        Scanner sc = new Scanner(f);
        String s = "";
        while(sc.hasNextLine()){
            s += sc.nextLine() + " ";
        }
        s = s.toLowerCase();
        String array[] = s.split(" ");
        for(int i = 0; i < array.length; ++i) this.ts.add(array[i]);
        sc.close();
    }

    public WordSet union(WordSet s){
        WordSet res = new WordSet();
        for (String st : s.ts) {
            res.ts.add(st);
        }
        for (String st : this.ts) {
            res.ts.add(st);
        }
        return res;
    }
    public WordSet intersection(WordSet s){
        WordSet res = new WordSet();
        for(String x: s.ts){
            if(this.ts.contains(x)){
                res.ts.add(x);
            }
        }
        return res;
    }

    @Override
    public String toString(){
        String ans = "";
        for (String s : this.ts) {
            ans += s + " ";
        }
        return ans;
    }
}
