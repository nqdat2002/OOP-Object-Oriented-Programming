package OOPs.VaoRaFile.J07024;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07024 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
class WordSet{
    private SortedSet<String> ts = new TreeSet<>();

    public WordSet(){
        this.ts.clear();
    }
    public WordSet(String string) throws FileNotFoundException{
        File f = new File(string);
        Scanner sc = new Scanner(f);
        String s = "";
        while(sc.hasNext()){
            String x = sc.nextLine();
            if(x.isEmpty()) break;
            s += (x + " ");
        }
        sc.close();
        s = s.toLowerCase();
        String a[] = s.split(" ");
        for(int i = 0; i < a.length; ++i) this.ts.add(a[i]);
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

    public WordSet difference(WordSet a){
        WordSet x = new WordSet();
        for (String st : this.ts) {
            if(!a.ts.contains(st)) x.ts.add(st);
        }
        return x;
    }

    @Override
    public String toString(){
        String ans = "";
        for (String s : this.ts) {
            ans += (s + " ");
        }
        return ans;
    }
}
