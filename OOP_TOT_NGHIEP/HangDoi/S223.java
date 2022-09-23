package OOP_TOT_NGHIEP.HangDoi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class S223 {
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

    public static void BFS(int n) {
        Set<Integer> st = new HashSet<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(n, 0));
        st.add(n);
        while (q.size() > 0) {
            Pair<Integer, Integer> a = q.peek();
            q.poll();
            if (a.getFirst() == 1) {
                System.out.println(a.getSecond());
                return;
            }
            if (a.getFirst() == 2) {
                System.out.println(a.second + 1);
                return;
            }
            for (int i = (int) Math.sqrt(a.getFirst()); i >= 2; --i) {
                if (a.getFirst() % i == 0 && !st.contains(a.getFirst() / i)) {
                    q.add(new Pair<>(a.getFirst() / i, a.getSecond() + 1));
                    st.add(a.getFirst() / i);
                }
            }

            if (!st.contains(a.getFirst() - 1)) {
                q.add(new Pair<>(a.getFirst() - 1, a.getSecond() + 1));
                st.add(a.getFirst() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            BFS(n);
        }
        sc.close();
    }
}