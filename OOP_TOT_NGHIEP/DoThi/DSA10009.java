package OOP_TOT_NGHIEP.DoThi;

import java.util.Scanner;

public class DSA10009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int [][] c = new int[105][105];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) c[i][j] = 0;
                else c[i][j] = 100000000;
            }
        }
        for(int i = 1; i <= m; i++){
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            c[u][v] = c[v][u] = w;
        }
        for(int k = 1; k <= n; k++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    if(c[i][j] > c[i][k] + c[k][j]) c[i][j] = c[i][k] + c[k][j];
        int q = sc.nextInt();
        while(q-- > 0){
            int u = sc.nextInt(), v = sc.nextInt();
            System.out.println(c[u][v]);
        }
        sc.close();
    }
}
