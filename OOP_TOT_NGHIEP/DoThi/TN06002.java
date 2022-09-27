package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TN06002 {
    private int n, m;
    private boolean[] vt = new boolean[20005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public void khoitao() {
        Arrays.fill(vt, false);
        n = sc.nextInt();
        m = sc.nextInt();
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
        System.out.println(cnt);
    }

    public void Processing() {
        khoitao();
        for (int u = 1; u <= n; ++u)
            Vertex(u);
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            TN06002 test = new TN06002();
            test.Processing();
        }
    }
}
