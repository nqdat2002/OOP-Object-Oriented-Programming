package OOPs.VaoRaFile.J07053;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07053 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
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
        this.trueName();
        this.date = date;
        this.trueDate();
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
        this.p = Double.valueOf(String.format("%.0f", (double)p));
    }
    public String Std(String s){
        String res = "";
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(i == 0){
                res += Character.toUpperCase(c);
            }
            else res += c;
        }
        return res;
    }

    public void trueName(){
        String s = this.name;
        s = s.trim();
        Vector<String> st = new Vector<>();
        String res = "";
        s = s + " ";
        s = s.toLowerCase();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' ' && res.length() > 0){
                res = res.toLowerCase();
                st.add(res);
                res = "";
            }
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')res += s.charAt(i);
        }
        res = "";
        for (String ss : st){
           res += (Std(ss) + " ");
        }
        this.name = res;
    }

    public void trueDate(){
        String s = this.date;
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3);
        this.date = s;
    }

    public static PhuHo nextPhuHo(Scanner sc, int cnt){
        return new PhuHo(sc.nextLine(), sc.nextLine(), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine()), cnt);
    }

    @Override
    public String toString(){
        return code + " " + name + age + " " + String.format("%.0f", (double)p) + " " + type;
    }
}