package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class DSA10006 {
    class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        public Pair() {
            this.first = null;
            this.second = null;
        }

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return first;
        }

        public void setFirst(T1 first) {
            this.first = first;
        }

        public T2 getSecond() {
            return second;
        }

        public void setSecond(T2 second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }
    private int n, m, k;
    private boolean[] vt = new boolean[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public Vector<Pair<Integer, Integer> > res = new Vector<>();
    public void khoitao() {
        Arrays.fill(vt, false);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            ds.add(tmp);
        }
        for (int i = 1; i <= m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            ds.get(u).add(v);
            ds.get(v).add(u);
        }
    }

    public void DFS(int u) {
        vt[u] = true;
        for (int os : ds.get(u)) {
            if (vt[os] == false){
                res.add(new Pair<>(u, os));
                DFS(os);
            }
        }
    }

    public void Processing() {
        khoitao();
        DFS(k);
        if(res.size() == n - 1){
            for(Pair<Integer, Integer> p : res)
                System.out.println(p);
        }
        else System.out.print(-1);
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            new DSA10006().Processing();
        }
    }
}
