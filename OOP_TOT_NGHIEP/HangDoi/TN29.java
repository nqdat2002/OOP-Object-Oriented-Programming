package OOP_TOT_NGHIEP.HangDoi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TN29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String s = sc.next();
            System.out.println(Solve(k, s));
        }
        sc.close();
    }

    public static long Solve(int k, String s) {
        int l = s.length();
        int[] cnt = new int[300];
        Arrays.fill(cnt, 0);
        for (int i = 0; i < l; ++i) {
            cnt[s.charAt(i)]++;
        }

        PriorityQueue<Long> q = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });

        for (Character c = 'A'; c <= 'Z'; ++c) {
            if (cnt[c] > 0)
                q.add((long)cnt[c]);
        }
        long res = 0;
        while (k-- > 0) {
            long x = q.peek();
            q.poll();
            x--;
            q.add(x);
        }
        while (q.size() > 0) {
            Long t = q.peek();
            q.poll();
            res += (long)(t * t);
        }
        return res;
    }
}
