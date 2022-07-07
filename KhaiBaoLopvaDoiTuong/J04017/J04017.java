package OOPs.KhaiBaoLopvaDoiTuong.J04017;

import java.util.Scanner;
public class J04017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
             int n = sc.nextInt(), m = sc.nextInt();
             Matrix a = new Matrix(n,m);
             a.nextMatrix(sc);
             Matrix b = a.trans();
             System.out.println(a.mul(b));
        }
        sc.close();
    }
}

class Matrix{
    private int n, m;
    private int [][] a;

    public Matrix(int n, int m){
        this.n = n;
        this.m = m;
        this.a = new int[n][m];
    }

    public void nextMatrix(Scanner sc){
        for(int i = 0; i < this.n; i++){
            for(int j = 0; j < this.m; j++){
                this.a[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix trans(){
        Matrix res = new Matrix(this.m, this.n);
        for(int i = 0; i < this.m; ++i){
            for(int j = 0; j < this.n; ++j){
                res.a[i][j] = this.a[j][i];
            }
        }
        return res;
    }

    public Matrix mul(Matrix x){
        Matrix res = new Matrix(this.n, x.m);
        for(int i = 0; i < this.n; ++i){
            for(int j = 0; j < x.m; ++j){
                for(int k = 0; k < this.m; ++k){
                    res.a[i][j] += (this.a[i][k] * x.a[k][j]);
                }
            }
        }
        return res;
    }

    @Override
    public String toString(){
        String res = "";
        for(int i = 0; i < this.n; ++i){
            for(int j = 0; j < this.m; ++j){
                res += (this.a[i][j] + " ");
            }
            res += "\n";
        }
        return res;
    }
}
