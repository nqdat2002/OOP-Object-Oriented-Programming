package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DSA09008 {
    private int n, m;
    private boolean[] vt = new boolean[1005];
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
            int u = sc.nextInt();
            int v = sc.nextInt();
            ds.get(u).add(v);
            ds.get(v).add(u);
        }
    }

    public void DFS(int u) {
        vt[u] = true;
        for (int os : ds.get(u)) {
            if (!vt[os])
                DFS(os);
        }
    }

    public void Processing() {
        khoitao();
        int cnt = 0;
        for (int u = 1; u <= n; ++u) {
            if (!vt[u]) {
                cnt++;
                DFS(u);
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            new DSA09008().Processing();
        }
    }
}
