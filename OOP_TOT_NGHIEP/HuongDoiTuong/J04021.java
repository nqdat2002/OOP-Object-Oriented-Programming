package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
public class J04021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
        sc.close();
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
    @Override
    public String toString(){
        String ans = "";
        for (Integer i : this.ts) {
            ans += i + " ";
        }
        return ans;
    }
}
