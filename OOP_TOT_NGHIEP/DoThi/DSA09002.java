package OOP_TOT_NGHIEP.DoThi;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class DSA09002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        Vector<Pair<Integer, Integer>> v = new Vector<>();
        for (int i = 1; i <= n; ++i) {
            StringTokenizer stk = new StringTokenizer(sc.nextLine());
            while (stk.hasMoreTokens()) {
                String s = stk.nextToken();
                if (Integer.valueOf(s) > i) {
                    v.add(new Pair<>(i, Integer.valueOf(s)));
                }
            }
        }
        for (Pair<Integer, Integer> pair : v) {
            System.out.println(pair);
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
}
