package OOPs.MangDoiTuong.J05038;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<TinhCong> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(TinhCong.nextTinhCong(sc, i));
        }
        long sum = 0;
        for (TinhCong tc : list) {
            tc.Show();
            sum += tc.getThu();
        }
        System.out.println("Tong chi phi tien luong: " + sum);

        sc.close();
    }
}

class TinhCong{
    private String code;
    private String name, cv;
    private long luongcb, thuong, phucap, thu;
    private int hs;

    public TinhCong(){
        this.name = this.cv = this.code = "";
        this.luongcb = this.thu = this.thuong = this.phucap = 0;
        this.hs = 0;
    }
    
    public void setCode(int cnt){
        String s = "NV" + cnt;
        while(s.length() < 4) s = s.substring(0, 2) + "0" + s.substring(2);
        this.code = s;
    }

    public long getLCB(){
        return luongcb;
    }
    public long getPhucap(){
        return phucap;
    }
    public long getThuong(){
        return thuong;
    }
    public long getThu(){
        return thu;
    }
    public int getHs(){
        return hs;
    }

    public TinhCong(String name, long luongcb, int hs, String cv){
        this.name = name;
        this.luongcb = luongcb;
        this.cv = cv;
        this.hs = hs;
        this.thuong = this.phucap = this.thu = 0;
    }

    public static TinhCong nextTinhCong(Scanner sc, int cnt){
        TinhCong a = new TinhCong(sc.nextLine(), Long.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine()), sc.nextLine());
        a.setCode(cnt);
        String s = a.cv;
        if(a.hs >= 25) a.thuong = (long) (0.2 * a.hs * a.luongcb);
        else if(a.hs >= 22) a.thuong = (long) (0.1 * a.hs * a.luongcb);
        else a.thuong = 0 * a.hs * a.luongcb;

        if(s.charAt(0) == 'G' && s.charAt(1) == 'D') a.phucap = 250000;
        if(s.charAt(0) == 'P' && s.charAt(1) == 'G' && s.charAt(2) == 'D') a.phucap = 200000;
        if(s.charAt(0) == 'T' && s.charAt(1) == 'P') a.phucap = 180000;
        if(s.charAt(0) == 'N' && s.charAt(1) == 'V') a.phucap = 150000;
        a.thu = a.getLCB() * a.getHs() + a.getPhucap() + a.getThuong();
        return a;
    }

    public void Show(){
        System.out.println(this.code + " " + this.name + " " + (this.luongcb * this.hs) + " " + this.thuong + " " + this.phucap + " " + this.thu);
    }
}