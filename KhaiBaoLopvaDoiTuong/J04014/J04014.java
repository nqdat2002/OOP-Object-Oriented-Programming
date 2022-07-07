package OOPs.KhaiBaoLopvaDoiTuong.J04014;

import java.util.Scanner;

public class J04014 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        while(t-- > 0){
            long x = ip.nextLong(), y = ip.nextLong();
            PhanSo a = new PhanSo(x, y);
            long m = ip.nextLong(), n = ip.nextLong();
            PhanSo b = new PhanSo(m, n);
            PhanSo res = new PhanSo();
            res.CongPS(a, b);
            res.Binhphuong();
            res.Rutgon();
            System.out.print(res.getX() + "/" + res.getY() + " ");
            res.NhanPS(a);
            res.NhanPS(b);
            res.Rutgon();
            System.out.print(res.getX() + "/" + res.getY() + "\n");
            
        }
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
        System.out.print(this.x + "/" + this.y + "\n");
    }

    public void CongPS(PhanSo a, PhanSo b){
        long mc = lcm(a.y, b.y);
        this.x = mc / a.y * a.x + mc / b.y * b.x;
        this.y = mc;
    }
    public void NhanPS(PhanSo a){
        this.x = this.x * a.x;
        this.y = this.y * a.y;
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