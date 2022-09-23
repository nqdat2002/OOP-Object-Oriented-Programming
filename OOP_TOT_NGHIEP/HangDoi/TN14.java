package OOP_TOT_NGHIEP.HangDoi;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TN14 {
    public static long[] a;
    public static int n;
    public static double mod = 1e9 + 7;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            a = new long[n + 1];
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            input(sc, priorityQueue);
            noiDay(priorityQueue);
        }
        sc.close();
    }

    public static void noiDay(PriorityQueue<Long> priorityQueue) {
        long result = 0L;
        long a, b;
        while (priorityQueue.size() > 1) {
            a = priorityQueue.poll();
            b = priorityQueue.poll();
            long temp = a + b;
            temp %= mod;
            priorityQueue.offer(temp);
            result += temp;
            result %= mod;
        }
        System.out.println(result);
    }

    public static void input(Scanner sc, PriorityQueue<Long> priorityQueue) {
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            priorityQueue.offer(a[i]);
        }
    }
}
