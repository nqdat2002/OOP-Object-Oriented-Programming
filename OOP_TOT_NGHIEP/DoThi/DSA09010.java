package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSA09010 {
    private int n, m;
    private boolean[] vt = new boolean[1005];
    private int [] parent = new int[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public int connect;

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, 0);
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

    public boolean BFS(int u) {
        Arrays.fill(vt, false);
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vt[u] = true;
        while (q.size() > 0) {
            int v = q.peek();
            cnt ++;
            q.poll();
            vt[v] = true;
            for (int os : ds.get(v)) {
                if (!vt[os]) {
                    q.add(os);
                    vt[os] = true;
                }
            }
        }
        return cnt == n;
    }

    public void Processing() {
        khoitao();
        boolean ok = false;
        for (int u = 1; u <= n; ++u){
            if(!BFS(u)){
                ok = true;
                break;
            }
        }
        if(ok) System.out.println("NO");
        else System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            DSA09010 test = new DSA09010();
            test.Processing();
        }
    }
}
