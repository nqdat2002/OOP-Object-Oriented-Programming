package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TN05006 {
    private int n, m;
    private boolean[] vt = new boolean[1005];
    private int[] parent = new int[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public int max_connect;

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, 0);
        max_connect = -10;
        n = sc.nextInt();
        m = sc.nextInt();
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

    public void DFS(int u, int cnt) {
        max_connect = Math.max(cnt, max_connect);
        vt[u] = true;
        for (int v : ds.get(u)) {
            if (!vt[v]) {
                DFS(v, cnt + 1);
            }
        }
    }

    public void Processing() {
        khoitao();
        for(int u = 0; u < n; ++u){
            Arrays.fill(vt, false);
            DFS(u, 0);
        }
        System.out.println(max_connect);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            new TN05006().Processing();
        }
    }
}
