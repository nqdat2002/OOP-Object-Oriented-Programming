package OOPs.MangDoiTuong.J05060;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05060 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<PhuHo> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(PhuHo.nextPhuHo(sc, i));
        }
        for (PhuHo ph : list) {
            System.out.println(ph);
        }
        sc.close();
    }
}
class PhuHo{
    private final int year = 2021;
    private String name, date, type, code;
    private double p1, p2, p, bonus;
    private int age;

    public PhuHo(){
        this.name = this.date = this.type = this.code = "";
        this.p1 = this.p2 = this.p = this.bonus = 0;
        this.age = 0;
    }

    public PhuHo(String name, String date, double p1, double p2, int cnt){
        this.name = name;
        this.date = date;
        this.p1 = p1;
        this.p2 = p2;
        this.age = this.year - Integer.valueOf(this.date.substring(6));
        this.code = "PH" + ((cnt >= 10) ? cnt : ("0" + cnt));
        if(p1 >= 8 && p2 >= 8) this.bonus = 1;
        else if(p1 >= 7.5 && p2 >= 7.5) this.bonus = 0.5;
        else this.bonus = 0;

        this.p = (int)(Math.round((this.p1 + this.p2) / 2 + bonus));
        if(this.p > 10) this.p = 10;

        if(this.p < 5) this.type = "Truot";
        else if(this.p == 5 || this.p == 6) this.type = "Trung binh";
        else if(this.p == 7) this.type = "Kha";
        else if(this.p == 8) this.type = "Gioi";
        else if(this.p == 9 || this.p == 10) this.type = "Xuat sac";
    }

    public static PhuHo nextPhuHo(Scanner sc, int cnt){
        return new PhuHo(sc.nextLine(), sc.nextLine(), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine()), cnt);
    }

    @Override
    public String toString(){
        return code + " " + name + " " + age + " " + String.format("%.0f", (double)p) + " " + type;
    }
}