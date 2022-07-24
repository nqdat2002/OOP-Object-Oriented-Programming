package OOPs.MangDoiTuong.J05014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05014 {
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
    private String name, code, type, subject, status;
    private double p1, p2, p, u;

    public Select(){
        this.name = this.code = this.type = this.subject = this.status = "";
        this.p1 = this.p2 = this.p = this.u = 0;
    }
    public Select(String name, String type, double p1, double p2, int cnt){
        this.code = "GV" + (cnt > 9 ? cnt : ("0" + cnt));
        this.name = name;
        this.type = type;
        if(this.type.charAt(0) == 'A') this.subject = "TOAN";
        if(this.type.charAt(0) == 'B') this.subject = "LY";
        if(this.type.charAt(0) == 'C') this.subject = "HOA";

        if(type.charAt(1) == '1') this.u = 2.0;
        if(type.charAt(1) == '2') this.u = 1.5;
        if(type.charAt(1) == '3') this.u = 1.0;
        if(type.charAt(1) == '4') this.u = 0.0;
        this.p1 = p1;
        this.p2 = p2;
        this.p = (double) (this.p1 * 2 + this.p2) + this.u;
        if(this.p >= 18) this.status = "TRUNG TUYEN";
        else this.status = "LOAI";

    }
    public static Select nextSelect(Scanner sc, int cnt){
        return new Select(sc.nextLine(), sc.nextLine(), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine()), cnt);
    }
    public double getPoint(){
        return p;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + subject + " " + String.format("%.1f", (double)p) + " " + status;
    }
    @Override
    public int compareTo(Select o) {
        return (int)((int) 10 * (o.getPoint() - this.getPoint()));
    }
}