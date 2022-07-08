package OOPs.Collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class J08025 {
    public static Scanner sc = new Scanner(System.in);
    final static int [] dl = {1, 5, 2, 4, 6, 3};
    final static int [] dr = {4, 1, 3, 5, 2, 6};

    public String Drt(String s, int a[], int n){
        String res = "";
        for(int i = 0; i < n; ++i) res += s.charAt(a[i] - 1);
        return res;
    }

    public void BFS(String s, String t){
        Map<String, Integer> mp = new HashMap<String, Integer>();
        mp.put(s, 1);
        Queue<String> q = new LinkedList<>();
        q.add(s);
        while(q.size() > 0){
            String c = q.peek(); q.poll();
            if(c.compareTo(t) == 0 && mp.containsKey(c)){
                System.out.println(mp.get(c) - 1);
                return;
            }

            String a = Drt(c, dl, 6);
            if(!mp.containsKey(a)){
                q.add(a);
                mp.put(a, mp.get(c) + 1);
            }

            String b = Drt(c, dr, 6);
            if(!mp.containsKey(b)){
                q.add(b);
                mp.put(b, mp.get(c) + 1);
            }
        }
    }

    public String NotBlank(String s){
        String res = "";
        String [] array = s.split(" ");
        for(int i = 0; i < array.length; ++i) res += array[i];
        return res;
    }

    public static void main(String [] args){
        String x = sc.nextLine();
        int t = Integer.valueOf(x);
        x.isEmpty();
        while(t-- > 0){
            J08025 test = new J08025();
            test.BFS(test.NotBlank((sc.nextLine())), test.NotBlank(sc.nextLine()));
        }
        sc.close();
    }

}
