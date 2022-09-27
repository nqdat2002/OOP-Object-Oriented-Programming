package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class TN06003 {
    private int n, m, vertex;
    private boolean[] vt = new boolean[1005];
    private int[] parent = new int[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public Stack<Integer> res = new Stack<>();
    public Set<Integer> list = new TreeSet<>();

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, 0);
        while (!res.isEmpty())
            res.remove(0);
        list.clear();
        n = sc.nextInt();
        m = sc.nextInt();
        vertex = sc.nextInt();
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
        list.add(u);
        for (int v : ds.get(u)) {
            if (!vt[v]) {
                parent[v] = u;
                DFS(v);
            }
        }
    }

    public void Processing() {
        khoitao();
        boolean ok = false;
        for (int u = 1; u <= n; ++u){
            if(!vt[u]){
                DFS(u);
                if(!list.contains(vertex)){
                    ok = true;
                    for (int x: list) {
                        System.out.println(x);
                    }
                }
                list.clear();
            }
        }
        if(!ok) System.out.println(0);
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            new TN06003().Processing();
        }
    }
}
