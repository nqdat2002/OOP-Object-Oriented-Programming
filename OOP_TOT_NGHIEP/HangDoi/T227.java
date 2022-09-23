package OOP_TOT_NGHIEP.HangDoi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class T227 {
    final static int limit = 9999;
    public static int [] prime = new int[limit + 1];

    public static void Eratosthenes(){
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for(int i = 2; i * i <= limit; ++i){
            if(prime[i] == 1){
                for (int j = i * i; j <= limit; j += i){
                    prime[j] = 0;
                }
            }
        }
    }

    public static void BFS(String s, String t){
        Queue<String> q = new LinkedList<>();
        q.add(s);
        int [] vs = new int[limit];
        Arrays.fill(vs, -1);
        vs[Integer.valueOf(s)] = 0;
        while(!q.isEmpty()){
            String c = q.peek(); q.poll();
            for (int index = 0; index < 4; ++index){
                String a = c;
                int id = 1, init = 0;
                if(index == 0 || index == 3) init = 1;
                if(index == 3) id = 2;
                for(int i = init; i <= 9; i += id){
                    if(a.charAt(index) - 48 != i){
                        a = a.substring(0, index) + (char)(i + 48) + a.substring(index + 1); 
                        if(prime[Integer.valueOf(a)] == 1){
                            String b = a;
                            if(vs[Integer.valueOf(b)] == -1){
                                vs[Integer.valueOf(b)] = vs[Integer.valueOf(c)] + 1;
                                q.add(b);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(vs[Integer.valueOf(t)]);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        Eratosthenes();
        while(t-- > 0){
            BFS(sc.next(), sc.next());
        }
        sc.close();
    }
}
