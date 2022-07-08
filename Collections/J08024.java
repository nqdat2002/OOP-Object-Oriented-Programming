package OOPs.Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class J08024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Queue<Long> q = new LinkedList<>();
        Vector<Long> v = new Vector<>();
        q.add((long) 9);
        v.add((long) 9);
        while (v.size() <= 10000) {
            long x = q.peek();
            q.poll();
            q.add((long) 10 * x);
            q.add((long) 10 * x + 9);
            v.add((long) 10 * x);
            v.add((long) 10 * x + 9);
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < v.size(); ++i) {
                if (v.get(i) % n == 0) {
                    System.out.println(v.get(i));
                    break;
                }
            }
        }
        sc.close();
    }
}
