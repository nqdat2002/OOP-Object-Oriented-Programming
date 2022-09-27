package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class S302 {
    private int n, m;
    private boolean[] vt = new boolean[1005];
    private int[] parent = new int[1005];
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
        Stack<Integer> st = new Stack<>();
        Arrays.fill(vt, false);
        if (u == 1) {
            st.add(2);
            vt[2] = true;
        } else {
            st.add(1);
            vt[1] = true;
        }
        vt[u] = true;
        int cnt = 1;
        while (!st.isEmpty()) {
            int x = st.peek(); st.pop();
            for (int v : ds.get(x)) {
                if (!vt[v]) {
                    cnt++;
                    vt[v] = true;
                    st.add(x);
                    st.add(v);
                    break;
                }
            }
        }
        if (cnt < n - 1) 
            res.add(u);
    }

    public void Processing() {
        khoitao();
        for (int u = 1; u <= n; ++u)
            DFS(u);
        Collections.sort(res);
        System.out.println(res.size());
        for (int x : res)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            S302 test = new S302();
            test.Processing();
        }
    }
}
