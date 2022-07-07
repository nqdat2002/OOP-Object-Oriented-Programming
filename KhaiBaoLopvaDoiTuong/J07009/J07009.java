package OOPs.KhaiBaoLopvaDoiTuong.J07009;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class J07009 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
class IntSet{
    private SortedSet<Integer> ts = new TreeSet<>();

    public IntSet(){
        this.ts.clear();
    }
    public IntSet(int a[]){
        int n = a.length;
        for(int i = 0; i < n; ++i)
            this.ts.add(a[i]);
    }
    public IntSet union(IntSet a){
        for (Integer i : a.ts) {
            this.ts.add(i);
        }
        return this;
    }
    public IntSet intersection(IntSet a){
        IntSet res = new IntSet();
        for (Integer it : this.ts) {
            if(a.ts.contains(it)){
                res.ts.add(it);
            }
        }
        return res;
    }
    
    @Override
    public String toString(){
        String ans = "";
        for (Integer i : this.ts) {
            ans += i + " ";
        }
        return ans;
    }
}