package OOP_TOT_NGHIEP.HangDoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(Cnt_Change(s, e));
        }
        sc.close();
    }

    public static int Cnt_Change(int s, int t) {
        int[] a = new int[10000];
        for (int i = 0; i < 10000; i++)
            a[i] = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        a[s] = 0;
        while (!q.isEmpty()) {
            int i = q.peek();
            q.poll();
            if (a[t] != Integer.MAX_VALUE)
                break;
            if (i - 1 > 0 && a[i - 1] == Integer.MAX_VALUE) {
                a[i - 1] = Math.min(a[i - 1], a[i] + 1);
                q.add(i - 1);
            }
            if (i * 2 < 10000 && a[i * 2] == Integer.MAX_VALUE) {
                a[i * 2] = Math.min(a[i * 2], a[i] + 1);
                q.add(i * 2);
            }
        }
        return a[t];
    }
}
