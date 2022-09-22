package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSA09005 {
    private int n, m, start;
    private boolean[] vt = new boolean[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public void khoitao() {
        Arrays.fill(vt, false);
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
            System.out.print(v + " ");
            for (int os: ds.get(v)){
                if(!vt[os]){
                    q.add(os);
                    vt[os] = true;
                }
            }
        }
    }

    public void Processing() {
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        khoitao();
        BFS(start);
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            DSA09004 test = new DSA09004();
            test.Processing();
        }
    }
}
