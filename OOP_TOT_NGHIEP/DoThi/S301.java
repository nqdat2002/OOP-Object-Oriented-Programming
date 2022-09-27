package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class S301 {
    private int n, m, start, end;
    private boolean[] vt = new boolean[1005];
    private int[] parent = new int[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, 0);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            ds.add(tmp);
        }
        for (int i = 1; i <= m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            ds.get(u).add(v);
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
            // System.out.print(v + " ");
            for (int os : ds.get(v)) {
                if (!vt[os]) {
                    q.add(os);
                    vt[os] = true;
                    parent[os] = v;
                }
            }
        }
    }

    public void Path(int s, int t) {
        if (parent[t] == 0) {
            System.out.println(-1);
            return;
        }
        Stack<Integer> st = new Stack<>();
        st.add(t);
        int k = t;
        while (parent[k] != s) {
            st.add(parent[k]);
            k = parent[k];
        }
        st.add(s);
        while (!st.isEmpty()) {
            System.out.print(st.peek());
            st.pop();
            if (!st.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public void Processing() {
        khoitao();
        BFS(start);
        Path(start, end);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            S301 test = new S301();
            test.Processing();
        }
    }
}
