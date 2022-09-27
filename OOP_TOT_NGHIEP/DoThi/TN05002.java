package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TN05002 {
    private int n, m, start;
    private boolean[] vt = new boolean[1005];
    private int[] parent = new int[1005];
    private ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    private Queue<Integer> q = new LinkedList<>();

    public void khoitao() {
        Arrays.fill(vt, false);
        Arrays.fill(parent, 0);
        while(!q.isEmpty()) q.poll();
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
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

    public void BFS(int u) {
        Queue<Integer> qq = new LinkedList<>();
        qq.add(u);
        while (qq.size() > 0) {
            int v = qq.peek(); qq.poll();
            vt[v] = true;
            q.add(v);
            for (int os : ds.get(v)) {
                if (!vt[os]) {
                    qq.add(os);
                    vt[os] = true;
                }
            }
        }
    }

    public void Processing() {
        khoitao();
        System.out.print("BFS(" + start + ") = ");
        BFS(start);
        while(!q.isEmpty()){
            System.out.print(q.peek());
            q.poll();
            if(!q.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            TN05002 test = new TN05002();
            test.Processing();
        }
    }
}
