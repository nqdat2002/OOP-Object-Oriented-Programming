package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TN05001 {
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
    public void DFS(int u) {
        vt[u] = true;
        q.add(u);
        for (int os : ds.get(u)) {
            if (vt[os] == false){
                DFS(os);
            }
        }
    }

    public void Processing() {
        khoitao();
        System.out.print("DFS(" + start + ") = ");
        DFS(start);
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
            TN05001 test = new TN05001();
            test.Processing();
        }
    }
}
