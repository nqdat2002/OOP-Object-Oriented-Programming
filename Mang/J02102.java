package OOPs.Mang;

import java.util.Arrays;
import java.util.Scanner;

public class J02102 {
    public static void main(String [] args){
        Scanner ip = new Scanner(System.in);
        int t = 1;
        while(t-->0){
            int n = ip.nextInt();
            int [] a = new int[n * n];
            for(int i = 0; i < n * n; ++i) a[i] = ip.nextInt();
            int [][] b = new int[n + 1][n + 1];
            int id = n, k = 0;
            Arrays.sort(a);
            for (int i = 1 ; i <= n / 2 + 1 ; i ++) {
                for (int j = i ; j <= id ; j++)
                    b[i][j] = a[k++];
                    
                for (int j = i + 1 ; j <= id; j ++)
                    b[j][id] = a[k++];
                    
                for (int j = id - 1 ; j >= i ; j --)
                    b[id][j] = a[k++];
                    
                for (int j = id - 1 ; j > i ; j --)
                    b[j][i] = a[k++];
                id--;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    System.out.print(b[i][j] + " ");
                System.out.println();
            }
        }
        ip.close();
    }
}