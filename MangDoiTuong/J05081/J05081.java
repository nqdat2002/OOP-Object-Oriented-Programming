package OOPs.MangDoiTuong.J05081;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05081{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<MatHang> A = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            A.add(MatHang.nextMatHang(sc, i));
        }
        Collections.sort(A, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang o1, MatHang o2){
                if(o1.getLn() != o2.getLn())
                    return (int) (o2.getLn() - o1.getLn());
                return o1.getMa().compareTo(o2.getMa());
            }
        });

        for (MatHang matHang : A) {
            matHang.Show();
        }
        sc.close();
    }
}
class MatHang{
    private String ma, ten, dv;
    private long gb, gm, ln;

    public MatHang(){
        this.ma = this.ten = this.dv = "";
        this.gb = this.gm = this.ln = 0;
    }

    public MatHang(String ten, String dv, long gm, long gb){
        this.ten = ten;
        this.dv = dv;
        this.gb = gb;
        this.gm = gm;
    }

    public String getMa(){
        return ma;
    }

    public long getLn(){
        return ln;
    }

    public void setMa(int cnt){
        String s = "MH" + cnt;
        while(s.length() < 5) s = s.substring(0, 2) + 0 + s.substring(2);
        this.ma = s;
    }

    public static MatHang nextMatHang(Scanner sc, int cnt){
        MatHang a = new MatHang();
        a.ten = sc.nextLine();
        a.dv = sc.nextLine();
        a.gm = Long.valueOf(sc.nextLine());
        a.gb = Long.valueOf(sc.nextLine());
        a.ln = a.gb - a.gm;
        a.setMa(cnt);
        return a;
    }
    public void Show(){
        System.out.printf(this.ma + " " + this.ten + " " + this.dv + " ");
        System.out.println(this.gm + " " + this.gb + " " + this.ln);
    }
}