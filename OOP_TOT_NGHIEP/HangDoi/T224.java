package OOP_TOT_NGHIEP.HangDoi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T224 {
    public static long n;
    public static Queue<Long> queue;
    public static HashMap<Integer, Integer> key = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        int t = sc.nextInt();
        while(t-- >0){
            queue = new LinkedList<>();
            n = sc.nextLong();
            queue.offer(9L);
            so0Va9();
        }
        sc.close();
    }

    public static void so0Va9(){
        long so=9;
        int i = 0;
        while(so%n != 0){
            so = queue.peek()*10 + key.get(i);
            queue.offer(so);
            i++;
            if(i > 1){
                queue.poll();
                i=0;
            }
        }
        System.out.println(so);
    }

    public static void init(){
        key.put(0,0);
        key.put(1,9);
    }
}
