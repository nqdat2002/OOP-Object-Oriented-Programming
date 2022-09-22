package OOP_TOT_NGHIEP.HuongDoiTuong.TN02013;

import java.util.Scanner;

public class TN02013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            PhanSo A = new PhanSo(sc.nextLine());
            PhanSo B = new PhanSo(sc.nextLine());
            PhanSo tongAB = A.cong(B);
            PhanSo tichAB = A.nhan(B);
            PhanSo C = tongAB.nhan(tongAB);
            System.out.print(C);
            System.out.print(" ");
            System.out.println(tichAB.nhan(C));
        }
        sc.close();
    }
}

class PhanSo {
    private long x;
    private long y;

    public PhanSo() {
        this.x = 1;
        this.y = 1;
    }

    public PhanSo(String s){
        String [] array = s.split(" ");
        this.x = Integer.valueOf(array[0]);
        this.y = Integer.valueOf(array[1]);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public PhanSo cong(PhanSo a) {
        PhanSo res = new PhanSo();
        long mc = lcm(a.y, this.y);
        res.x = mc / a.y * a.x + mc / this.y * this.x;
        res.y = mc;
        res.Rutgon();
        return res;
    }

    public PhanSo nhan(PhanSo a) {
        PhanSo res = new PhanSo();
        res.x = this.x * a.x;
        res.y =  this.y * a.y;
        res.Rutgon();
        return res;
    }

    public void Binhphuong() {
        this.x = this.x * this.x;
        this.y = this.y * this.y;
    }

    public void Rutgon() {
        long tmp = gcd(this.x, this.y);
        this.x /= tmp;
        this.y /= tmp;
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return (long) a * b / gcd(a, b);
    }

    @Override
    public String toString(){
        return x + "/" + y;
    }
}