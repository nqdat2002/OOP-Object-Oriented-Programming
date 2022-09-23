package OOP_TOT_NGHIEP.HangDoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T223 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Queue<Long> q = new LinkedList<>();
            long n = sc.nextLong();
            q.add((long)1);
            while(q.size() > 0){
                long tmp = q.peek();
                q.poll();
                if (tmp % n == 0){
                    System.out.println(tmp);
                    break;
                }
                q.add((long)(10 * tmp));
                q.add((long)(10 * tmp + 1));
            }
        }
        sc.close();
    }
}
