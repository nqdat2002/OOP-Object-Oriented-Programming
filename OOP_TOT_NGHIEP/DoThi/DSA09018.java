package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSA09018 {
    private int n, m;
    private boolean[] vt = new boolean[20005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public int connect;

    public void khoitao() {
        Arrays.fill(vt, false);
        n = sc.nextInt();
        m = sc.nextInt();
        connect = 0;
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
        System.out.print(u + " ");
        for (int os : ds.get(u)) {
            if (vt[os] == false)
                DFS(os);
        }
    }

    public void BFS(int u) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        while (q.size() > 0) {
            int v = q.peek();
            q.poll();
            vt[v] = true;
            for (int os : ds.get(v)) {
                if (!vt[os]) {
                    q.add(os);
                    vt[os] = true;
                }
            }
        }
    }

    public void Vertex(int u) {
        Arrays.fill(vt, false);
        vt[u] = true;
        int cnt = 0;
        for (int v = 1; v <= n; ++v) {
            if (!vt[v]) {
                cnt++;
                BFS(v);
            }
        }
        if(cnt > connect) System.out.print(u + " ");
    }

    public void Processing() {
        khoitao();
        for (int u = 1; u <= n; ++u){
            if(!vt[u]){
                connect ++;
                BFS(u);
            }
        }
        for (int u = 1; u <= n; ++u)
            Vertex(u);
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            DSA09018 test = new DSA09018();
            test.Processing();
        }
    }
}
