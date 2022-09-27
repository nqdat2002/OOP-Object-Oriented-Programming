package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSA09019 {
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

    public boolean BFS(int u) {
        Arrays.fill(vt, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vt[u] = true;
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
                else if(parent[v] != os){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCircle(int n){
        for(int u = 1; u <= n; ++u){
            if(!vt[u] && BFS(u)){
                return true;
            }
        }
        return false;
    }

    public void Processing() {
        khoitao();
        if(isCircle(n))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            DSA09019 test = new DSA09019();
            test.Processing();
        }
    }
}
