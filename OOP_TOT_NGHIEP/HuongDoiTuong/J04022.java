package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class J04022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
        in.close();
    }
}
class WordSet{
    private SortedSet<String> ts = new TreeSet<>();

    public WordSet(){
        this.ts.clear();
    }
    public WordSet(String s){
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

    @Override
    public String toString(){
        String ans = "";
        for (String s : this.ts) {
            ans += s + " ";
        }
        return ans;
    }
}
