package OOPs.KhaiBaoLopvaDoiTuong;

import java.util.Scanner;

public class J04012 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String name = ip.nextLine(), luongcb = ip.nextLine(), hs = ip.nextLine(),  cv = ip.nextLine();
        TinhCong a = new TinhCong(name, Long.valueOf(luongcb), Integer.valueOf(hs), cv);
        a.Show();
        ip.close();
    }
}
class TinhCong{
    private String name, cv;
    private long luongcb;
    private int hs;

    public TinhCong(String name, long luongcb, int hs, String cv){
        this.name = name;
        this.luongcb = luongcb;
        this.cv = cv;
        this.hs = hs;
    }

    public void Show(){
        String s = this.cv;
        long x = 0, y = 0;
        if(this.hs >= 25) y = (long) (0.2 * this.hs * this.luongcb);
        else if(this.hs >= 22) y = (long) (0.1 * this.hs * this.luongcb);
        else y = 0 * this.hs * this.luongcb;

        if(s.charAt(0) == 'G' && s.charAt(1) == 'D') x = 250000;
        if(s.charAt(0) == 'P' && s.charAt(1) == 'G' && s.charAt(2) == 'D') x = 200000;
        if(s.charAt(0) == 'T' && s.charAt(1) == 'P') x = 180000;
        if(s.charAt(0) == 'N' && s.charAt(1) == 'V') x = 150000;
        System.out.print("NV01" + " " + this.name + " " + (this.luongcb * this.hs) + " " + y + " " + x + " " + (this.luongcb * this.hs + x + y));
        System.out.println();
    }
}