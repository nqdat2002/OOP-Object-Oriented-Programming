package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;

public class J04015 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String code = ip.nextLine(), name = ip.nextLine();
        long lcb = ip.nextLong();
        ThuThapGV a = new ThuThapGV(code, name, lcb);
        a.Show();
        ip.close();
    }
}
class ThuThapGV{
    private String code, name;
    private long luongcb;
    private int hs;

    public ThuThapGV(String code, String name, long luongcb){
        this.code = code;
        this.name = name;
        this.luongcb = luongcb;
        this.hs = 0;
    }

    public void Show(){
        String s = this.code;
        this.hs = (s.charAt(2) - 48) * 10 + s.charAt(3) - 48;
        int x = 0;
        if(s.charAt(0) == 'H' && s.charAt(1) == 'T') x = 2000000;
        if(s.charAt(0) == 'H' && s.charAt(1) == 'P') x = 900000;
        if(s.charAt(0) == 'G' && s.charAt(1) == 'V') x = 500000;
        System.out.print(this.code + " " + this.name + " " + this.hs + " " + x + " " + (this.luongcb * this.hs + x));
        System.out.println();
    }
}