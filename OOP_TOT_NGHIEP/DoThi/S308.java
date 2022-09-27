package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class S308 {
    private int n, m;
    private boolean[] vt = new boolean[10005];
    private int[] parent = new int[10005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public Vector<Integer> res = new Vector<>();

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, 0);
        while (!res.isEmpty())
            res.remove(0);
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
        for (int v : ds.get(u)){
            if(!vt[v])
                DFS(v);
        }
    }

    public void Processing() {
        khoitao();
        DFS(1);
        boolean ok = false;
        for (int u = 1; u <= n; ++u){
            if(!vt[u]){
                ok = true;
                System.out.println("NO");
                break;
            }
        }
        if(!ok) System.out.println("YES");
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            S308 test = new S308();
            test.Processing();
        }
    }
}
