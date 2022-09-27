package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TN05003 {
    private int n, m, start;
    private boolean[] vt = new boolean[1005];
    private int[] parent = new int[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public Stack<Integer> res = new Stack<>();

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, 0);
        while (!res.isEmpty())
            res.remove(0);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            ds.add(tmp);
        }
        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            ds.get(u).add(v);
            ds.get(v).add(u);
        }
    }

    public void DFS(int u) {
        vt[u] = true;
        for (int v : ds.get(u)) {
            if (!vt[v]) {
                parent[v] = u;
                DFS(v);
            }
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
                    parent[os] = v;
                    vt[os] = true;
                }
            }
        }
    }

    public void Path(int s, int t) {
        Arrays.fill(vt, false);
        BFS(s);
        if (!vt[t]) {
            System.out.println("No path");
            return;
        }
        while (t != s) {
            res.add(t);
            t = parent[t];
        }
        res.add(s);
        while (!res.isEmpty()) {
            System.out.print(res.peek() + " ");
            res.pop();
        }
        System.out.println();
    }

    public void Processing() {
        khoitao();
        for (int u = 1; u <= n; ++u) {
            if (u != start) {
                Path(start, u);
            }
        }
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            new TN05003().Processing();
        }
    }
}
