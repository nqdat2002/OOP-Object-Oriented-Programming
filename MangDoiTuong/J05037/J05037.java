package OOPs.MangDoiTuong.J05037;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05037 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<TinhGia> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(TinhGia.nextTinhGia(sc, i));
        Collections.sort(list);
        for (TinhGia tg : list) {
            System.out.println(tg);
        }
        sc.close();
    }
}
class TinhGia implements Comparable<TinhGia>{
    private String ma, ten, dvi;
    private long phivc, giaban, thanhtien;
    private long soluong, gianhap;

    public TinhGia(){
        this.ma = this.ten = this.dvi = "";
        this.phivc = this.giaban = this.thanhtien = this.soluong = this.gianhap = 0;
    }
    public TinhGia(int cnt, String ten, String dvi, long gianhap, long soluong){
        this.ma = setMa(cnt);
        this.ten = ten;
        this.dvi = dvi;
        this.soluong = soluong;
        this.gianhap= gianhap;
        this.phivc = (long) (Math.round((this.soluong * this.gianhap) * 0.05));
        this.thanhtien = this.phivc + (long)(this.soluong * this.gianhap);
        this.giaban = (long) ((Math.ceil((this.thanhtien + (long)this.thanhtien * 0.02) / this.soluong) + 99) / 100 ) * 100;
    }
    public long getGiaban(){
        return giaban;
    }

    public String setMa(int cnt){
        String s = "MH" + cnt;
        while(s.length() < 4) s = s.substring(0, 2) + "0" + s.substring(2);
        return s;
    }

    public static TinhGia nextTinhGia(Scanner sc, int cnt){
        return new TinhGia(cnt, sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine()), Long.valueOf(sc.nextLine()));
    }

    @Override
    public String toString(){
        return ma + " " + ten + " " + dvi + " " + phivc + " " + thanhtien + " " + giaban; 
    }
    @Override
    public int compareTo(TinhGia o) {
        return (int)(o.getGiaban() - this.getGiaban());
    }

}
