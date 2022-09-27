package OOP_TOT_NGHIEP.DoThi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class DSA10008 {
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

    private int n, m, start;
    final int oo = 1000 * 1000 * 1000;
    private boolean[] vt = new boolean[1005];
    private int[] parent = new int[1005];
    private int[] Dis = new int[1005];
    public static Scanner sc = new Scanner(System.in);
    public Vector<Vector<Pair<Integer, Integer>>> list = new Vector<>();
    public PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparing(Pair::getSecond));

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, -1);
        Arrays.fill(Dis, oo);
        list.clear();
        q.clear();
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        for (int i = 0; i <= 1005; i++) {
            Vector<Pair<Integer, Integer>> tmp = new Vector<>();
            list.add(tmp);
        }
        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list.get(u).add(new Pair<>(w, v));
            list.get(v).add(new Pair<>(w, u));
        }
    }

    public void Dijkstra(int st){
        // for (int u = 1; u <= n; ++u){
        //     Dis[u] = oo;
        //     parent[u] = -1;
        // }
        Dis[st] = 0;
        q.add(new Pair<>(0, st));
        while(!q.isEmpty()){
            int u = q.peek().getSecond(); q.poll();
            for (int i = 0; i < list.get(u).size(); i++){
                int v = list.get(u).get(i).getSecond();
                int d_u_v = list.get(u).get(i).getFirst();
                if(Dis[u] + d_u_v < Dis[v]){
                    Dis[v] = Dis[u] + d_u_v;
                    parent[v] = u;
                    q.add(new Pair<>(Dis[v], v));
                }
            }
        }
        for(int u = 1; u <= n; ++u)
            System.out.print(Dis[u] + " ");
    }

    public void Processing() {
        khoitao();
        Dijkstra(start);
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            new DSA10008().Processing();
        }
    }
}
