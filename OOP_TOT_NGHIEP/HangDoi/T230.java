package OOP_TOT_NGHIEP.HangDoi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class T230 {
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

    static char[][] a = new char[101][101];
    static int[][] vs = new int[101][101];
    static int n;

    public static boolean check(int x, int y, int n, int m) {
        return !(x >= n || y >= m || x < 0 || y < 0 || a[x][y] == 'X');
    }

    public static void BFS(Pair<Integer, Integer> b) {
        for(int i = 0; i < 101; ++i){
            Arrays.fill(vs[i], -1);
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(b);
        vs[b.getFirst()][b.getSecond()] = 0;
        while (!q.isEmpty()) {
            Pair<Integer, Integer> t = q.peek();
            q.poll();
            int x = t.getFirst(), y = t.getSecond();
            for (int j = y + 1; j < n; ++j) {
                if (check(x, j, n, n) && vs[x][j] == -1) {
                    vs[x][j] = vs[x][y] + 1;
                    q.add(new Pair<>(x, j));
                } else
                    break;
            }
            for (int j = y - 1; j >= 0; --j) {
                if (check(x, j, n, n) && vs[x][j] == -1) {
                    vs[x][j] = vs[x][y] + 1;
                    q.add(new Pair<>(x, j));
                } else
                    break;
            }
            for (int j = x + 1; j < n; ++j) {
                if (check(j, y, n, n) && vs[j][y] == -1) {
                    vs[j][y] = vs[x][y] + 1;
                    q.add(new Pair<>(j, y));
                } else
                    break;
            }
            for (int j = x - 1; j >= 0; --j) {
                if (check(j, y, n, n) && vs[j][y] == -1) {
                    vs[j][y] = vs[x][y] + 1;
                    q.add(new Pair<>(j, y));
                } else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while (t-- > 0) {
            n = Integer.valueOf(sc.nextLine());
            Vector<String> v = new Vector<>();
            for (int i = 0; i < n; ++i)
                v.add(sc.nextLine());
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    a[i][j] = v.get(i).charAt(j);
                }
            }
            int x = sc.nextInt(), y = sc.nextInt(), p = sc.nextInt(), q = sc.nextInt();
            sc.nextLine();
            BFS(new Pair<Integer, Integer>(x, y));
            System.out.println(vs[p][q]);
        }
        sc.close();
    }
}
