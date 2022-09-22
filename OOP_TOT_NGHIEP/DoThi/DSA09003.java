package OOP_TOT_NGHIEP.DoThi;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DSA09003 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(), m = sc.nextInt();
            ArrayList<PriorityQueue<Integer> > list = new ArrayList<>();
            for (int i = 0; i <= n; ++i){
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                list.add(pq);
            }
            while(m -- > 0){
                int x = sc.nextInt(), y = sc.nextInt();
                list.get(x).add(y);
            }
            for (int i = 1; i <= n; ++i){
                System.out.print(i + ": ");
                while(list.get(i).size() > 0){
                    System.out.print(list.get(i).peek() + " ");
                    list.get(i).poll();
                }   
                System.out.println();
            }
        }
        sc.close();
    }
}
