package OOP_TOT_NGHIEP.DoThi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DSA10011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= m; ++j) {
                    a[i][j] = sc.nextInt();
                    dis[i][j] = oo;
                }
            }
            Dijkstra();
            System.out.println(dis[n][m]);

        }
        sc.close();
    }

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

    final static int oo = 1000 * 1000 * 1000 + 7;
    final static int[] dx = {1, -1, 0, 0};
    final static int[] dy = {0, 0, 1, -1};
    static int[][] a = new int[505][505];
    static int[][] dis = new int[505][505];
    static int n, m;
    static PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> q = new PriorityQueue<>(Comparator.comparing(Pair::getSecond));

    public static boolean check(int x, int y, int n, int m) {
        return (x <= n && y <= m && x >= 1 && y >= 1);
    }

    public static void Dijkstra() {
        dis[1][1] = a[1][1];
        while (!q.isEmpty()) {
            q.poll();
        }
        q.add(new Pair<>(new Pair<>(1, 1), dis[1][1]));
        while (!q.isEmpty()) {
            int x = q.peek().getFirst().getFirst(),
                    y = q.peek().getFirst().getSecond(),
                    w = q.peek().getSecond();
            q.poll();
            for (int i = 0; i < 4; ++i) {
                int u = x + dx[i], v = y + dy[i];
                if (check(u, v, n, m)) {
                    if (dis[u][v] > a[u][v] + w) {
                        dis[u][v] = a[u][v] + w;
                        q.add(new Pair<>(new Pair<>(u, v), dis[u][v]));
                    }
                }
            }
        }
    }
}
