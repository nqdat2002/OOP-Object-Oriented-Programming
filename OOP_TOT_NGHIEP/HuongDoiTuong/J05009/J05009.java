package OOP_TOT_NGHIEP.HuongDoiTuong.J05009;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<ThiSinh> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(ThiSinh.nextThiSinh(sc, i));
        Collections.sort(list, new Comparator<ThiSinh>(){
            @Override
            public int compare(ThiSinh o1, ThiSinh o2){
                if(o1.getPoint() != o2.getPoint()){
                    return (int) ((int)10 * (o1.getPoint() - o2.getPoint()));
                }
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        ThiSinh x = list.get(n - 1);
        for(ThiSinh s: list){
            if(s.getPoint() == x.getPoint()){
                s.Show();
            }
        }
        sc.close();
    }
}
class ThiSinh{
    private String code;
    private String name, date;
    private double p1, p2, p3;

    public ThiSinh(){
        this.code = "";
        this.name = this.date = "";
        this.p1 = this.p2 = this.p3 = 0;
    }

    public ThiSinh(String name, String date, double p1, double p2, double p3){
        this.name = name;
        this.date = date;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public void setCode(int cnt){
        String s = "" + cnt;
        this.code = s;
    }

    public double getPoint(){
        return this.p1 + this.p2 + this.p3;
    }
    public String getCode(){
        return code;
    }

    public static String trueDate(String s){
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        return s;
    }

    public static ThiSinh nextThiSinh(Scanner sc, int cnt){
        ThiSinh a = new ThiSinh();
        a.setCode(cnt);
        a.name = sc.nextLine();
        a.date = sc.nextLine();
        a.p1 = Double.valueOf(sc.nextLine());
        a.p2 = Double.valueOf(sc.nextLine());
        a.p3 = Double.valueOf(sc.nextLine());
        return a;
    }

    public void Show(){
        System.out.print(this.code + " " + this.name + " " + this.date + " ");
        System.out.format("%.1f", (double) (this.p1 + this.p2 + this.p3));
        System.out.println();
    }
}