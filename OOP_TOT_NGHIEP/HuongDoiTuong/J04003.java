package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;

public class J04003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo a = PhanSo.nextPhanSo(sc);
        a.Rutgon();
        System.out.println(a); 
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

    public PhanSo(long x, long y) {
        this.x = x;
        this.y = y;
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

    public static PhanSo nextPhanSo(Scanner sc) {
        return new PhanSo(sc.nextLong(), sc.nextLong());
    }

    @Override
    public String toString() {
        return x + "/" + y;
    }
}