package OOPs.KhaiBaoLopvaDoiTuong.J04004;

import java.util.Scanner;

public class J04004 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        long x = ip.nextLong();
        long y = ip.nextLong();
        PhanSo a = new PhanSo(x, y);
        x = ip.nextLong();
        y = ip.nextLong();
        PhanSo b = new PhanSo(x, y);
        PhanSo res = new PhanSo();
        res = res.CongPS(a, b);
        res.Rutgon();
        System.out.print(res.getX() + "/" + res.getY());
        ip.close();
    }
}
class PhanSo{
    private long x;
    private long y;

    public PhanSo(){
        this.x = 1;
        this.y = 1;
    }
    public PhanSo(long x, long y){
        this.x = x;
        this.y = y;
    }
    public long getX(){
        return x;
    }
    public long getY(){
        return y;
    }

    public void In(){
        System.out.print(this.x + "/" + this.y);
    }

    public PhanSo CongPS(PhanSo a, PhanSo b){
        PhanSo res = new PhanSo(1, 1);
        long mc = lcm(a.y, b.y);
        a.x = mc / a.y * a.x;
        b.x = mc / b.y * b.x;
        res.x = a.x + b.x;
        res.y = mc;
        res.Rutgon();
        return res;
    }

    public void Binhphuong(){
        this.x = this.x * this.x;
        this.y = this.y * this.y;
    }

    public void Rutgon(){
        long tmp = gcd(this.x, this.y);
        this.x /= tmp;
        this.y /= tmp;
    }

    public static long gcd(long a, long b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static long lcm(long a, long b){
        return (long) a * b / gcd(a, b);
    }
}