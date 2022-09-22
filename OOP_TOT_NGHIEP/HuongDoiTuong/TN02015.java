package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class TN02015 {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        WordSet ws = new WordSet(input);
        System.out.println(ws);
    }
}
class WordSet{
    private SortedSet<String> ts = new TreeSet<>();

    public WordSet(){
        this.ts.clear();
    }
    public WordSet(Scanner sc){
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

    @Override
    public String toString(){
        String ans = "";
        for (String s : this.ts) {
            ans += (s + "\n");
        }
        return ans;
    }
}
