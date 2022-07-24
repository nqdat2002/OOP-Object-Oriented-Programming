package OOPs.MangDoiTuong.J05013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05013 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Select> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Select.nextSelect(sc, i));
        Collections.sort(list);
        for (Select select : list) {
            System.out.println(select);
        }
    }
}
class Select implements Comparable<Select>{
    private String name, code, type;
    private double p1, p2, p;

    public Select(){
        this.name = this.code = this.type = "";
        this.p1 = this.p2 = this.p = 0;
    }
    public Select(String name, double p1, double p2, int cnt){
        this.code = "TS" + (cnt > 9 ? cnt : ("0" + cnt));
        this.name = name;
        if(p1 > 10) p1 = (double)p1 / 10;
        if(p2 > 10) p2 = (double)p2 / 10;
        this.p1 = p1;
        this.p2 = p2;
        this.p = (double) (this.p1 + this.p2) / 2;
        this.p = (double)Math.round((double) (p) * 100) / 100;
        if(this.p > 9.5) this.type = "XUAT SAC";
        else if(this.p >= 8) this.type = "DAT";
        else if(this.p > 5) this.type = "CAN NHAC";
        else this.type = "TRUOT";
    }
    public static Select nextSelect(Scanner sc, int cnt){
        return new Select(sc.nextLine(), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine()), cnt);
    }
    public double getPoint(){
        return p;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + String.format("%.2f", (double)p) + " " + type;
    }
    @Override
    public int compareTo(Select o) {
        return (int)((int) 100 * (o.getPoint() - this.getPoint()));
    }
}