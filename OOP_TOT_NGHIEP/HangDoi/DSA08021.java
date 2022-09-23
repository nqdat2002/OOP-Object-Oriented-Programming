package OOP_TOT_NGHIEP.HangDoi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSA08021 {
    static class Pair<T1, T2> {
        public T1 first;
        public T2 second;

        public Pair() {
            this.first = null;
            this.second = null;
        }

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return first;
        }

        public void setFirst(T1 first) {
            this.first = first;
        }

        public T2 getSecond() {
            return second;
        }

        public void setSecond(T2 second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }

    static int[][] a = new int[1001][1001];
    static int[][] vs = new int[1001][1001];
    static int n, m;

    public static void BFS() {
        for(int i = 0; i < 1001; ++i){
            Arrays.fill(vs[i], -1);
        }
        Queue<Pair<Integer, Integer> > q = new LinkedList<>();
        q.add(new Pair<>(1, 1));
        vs[1][1] = 0;
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.peek();
            q.poll();
            int i = p.getFirst(), j = p.getSecond();
            if(vs[i + a[i][j]][j] == -1){
                q.add(new Pair<>(i + a[i][j], j));
                vs[i + a[i][j]][j] = vs[i][j] + 1;
            }
            if(vs[i][j + a[i][j]] == -1){
                q.add(new Pair<>(i, a[i][j] + j));
                vs[i][j + a[i][j]] = vs[i][j] + 1;
            }
            if(vs[n][m] != -1) break;
        }
        System.out.println(vs[n][m]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i = 1; i <= n; i ++)
                for(int j = 1; j <= m; j ++) a[i][j] = sc.nextInt();
            BFS();
        }
        sc.close();
    }
}
