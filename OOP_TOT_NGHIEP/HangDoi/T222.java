package OOP_TOT_NGHIEP.HangDoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T222 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Queue<Long> q = new LinkedList<>();
            long n = sc.nextLong();
            q.add((long)1);
            int cnt = 0;
            while(q.size() > 0){
                long tmp = q.peek();
                q.poll();
                if (tmp <= n){
                    cnt ++;
                    q.add((long)(10 * tmp));
                    q.add((long)(10 * tmp + 1));
                }
                else break;
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
