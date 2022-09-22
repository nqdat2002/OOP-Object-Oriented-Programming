package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class TN01034 {
    final static int MOD = 1000 * 1000 * 1000 + 7;

    public static long[][] Matrix_Multiply(long[][] a, long[][] b, int n) {
        long[][] ans = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += (a[i][k] % MOD) * (b[k][j] % MOD) % MOD;
                    ans[i][j] %= MOD;
                }
            }
        }
        return ans;
    }

    public static long[][] Matrix_Power(long[][] base, long k, int n) {
        if(k == 1)
            return base;
        long [][] tmp = Matrix_Power(base, k / 2, n);
        if(k % 2 == 1){
            return Matrix_Multiply(base, Matrix_Multiply(tmp, tmp, n), n);
        }
        return Matrix_Multiply(tmp, tmp, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[][] a = new long[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    a[i][j] = sc.nextLong();
                }
            }
            long[][] b = Matrix_Power(a, k, n);
            long res = 0;
            for (int i = 0; i < n; i++) {
                res += b[i][n - 1] % MOD;
                res %= MOD;
            }
            System.out.println(res);
        }
        sc.close();
    }

}
