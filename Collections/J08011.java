package OOPs.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J08011 {
    public static boolean isRev(int x){
        int m = 0, n = 0;
        while(x > 0){
            int i = x % 10;
            int j = (x / 10) % 10;
            if(i >= j) m++;
            else return false;
            n++;
            x /= 10;
        }
        return m == n;
    }

    public static void main(String [] args){
        int [] a = new int [100005], b = new int [100005], c = new int[100005];
        Scanner sc = new Scanner(System.in);
        int id = 0, cnt = 0, j = 0;
        Map<Integer, Integer > mp = new HashMap<>();
        while (sc.hasNext()){
            a[id] = sc.nextInt();
            if(!mp.containsKey(a[id]) || mp.isEmpty()){
                mp.put(a[id], id);
            }
            id++;
        }
        for (int i = 0; i < id; i++) {
            cnt = 0;
            if (isRev(a[i])) {
                for (int k = 0; k < i; k++)
                    if (a[i] == a[k])
                        cnt++;
        
                if (cnt >= 1)
                    continue;
                else{
                    b[j] = a[i];
                    j++;
                }
            }
        }
        for (int i = 0; i < j; i++) {
            c[i] = 0;
            for (int k = 0; k < id; k++)
                if (b[i] == a[k])
                    c[i]++;
        }
        for (int i = 0; i < j - 1; i++) {
            for (int k = i + 1; k < j; k++) {
                if (c[i] < c[k]) {
                    int z = b[i]; b[i] = b[k]; b[k] = z;
                    int y = c[i]; c[i] = c[k]; c[k] = y;
                }
            }
        }
        for (int i = 0; i < j - 1; i++) {
            for (int k = i + 1; k < j; k++) {
                if(c[i] == c[k] && mp.get(b[i]) > mp.get(b[k])){
                    int z = b[i]; b[i] = b[k]; b[k] = z;
                    int y = c[i]; c[i] = c[k]; c[k] = y;
                }
            }
        }
        for(int i = 0; i < j; i++)
		    System.out.println(b[i] + " " + c[i]);
        sc.close();
    }
}
