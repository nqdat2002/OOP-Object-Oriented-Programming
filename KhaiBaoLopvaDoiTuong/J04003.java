package OOPs.KhaiBaoLopvaDoiTuong;

import java.util.Scanner;

public class J04003 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        long x = ip.nextLong();
        long y = ip.nextLong();
        PhanSo a = new PhanSo(x, y);
        a.Rutgon();
        System.out.print(a.getX() + "/" + a.getY());
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