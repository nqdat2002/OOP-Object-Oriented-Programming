package OOPs.MangDoiTuong.J05044;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05044 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<NhanVien> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(NhanVien.nextNhanVien(sc, i));
        x = sc.nextLine();
        for (NhanVien nv : list) {
            if(x.compareTo(nv.getCvu()) == 0){
                System.out.println(nv);
            } 
        }
        sc.close();
    }
}

class NhanVien{
    private String ma, ten, cvu;
    private int lcb, hs, phucap, luongchinh, tamung, conlai;

    public NhanVien(){
        this.ten = this.ma = this.cvu = "";
        this.lcb = this.hs = this.phucap = this.luongchinh = this.tamung = this.conlai = 0;
    }

    public NhanVien(String ten, String cvu, int lcb, int hs){
        this.ten = ten;
        this.cvu = cvu;
        this.lcb = lcb;
        this.hs = hs;
    }

    public static String setMa(int cnt){
        String s = "NV" + cnt;
        while(s.length() < 4) s = s.substring(0, 2) + "0" + s.substring(2);
        return s;
    }

    public static NhanVien nextNhanVien(Scanner sc, int cnt){
        NhanVien a = new NhanVien(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine()));
        a.ma = setMa(cnt);

        String s = a.cvu;
        a.phucap = 100;
        if(s.compareTo("GD") == 0) a.phucap = 500;
        if(s.compareTo("PGD") == 0) a.phucap = 400;
        if(s.compareTo("TP") == 0) a.phucap = 300;
        if(s.compareTo("KT") == 0) a.phucap = 250;
    
        a.luongchinh = (int) (a.lcb * a.hs);
        
        int u = a.luongchinh, v = a.phucap, t = 0;
        if(u + v < 37500) {
            t = (int)Math.round((double)((u + v) * 2 / 3) / 1000) * 1000;   
        }
        else t = 25000;
        a.tamung = t;
        a.conlai = (int) (u + v - a.tamung);
        return a;
    }
    public String getCvu(){
        return cvu;
    }

    @Override
    public String toString(){
        return ma + " " + ten + " " + phucap + " " + luongchinh + " " + tamung + " " + conlai;
    }
}