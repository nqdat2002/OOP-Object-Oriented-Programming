package OOPs.VaoRaFile.J07055;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07055 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<MarkStudent> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(MarkStudent.nextMarkStudent(sc, i));
        Collections.sort(list);
        for (MarkStudent st : list) {
            System.out.println(st);
        }
        sc.close();
    }
}
class MarkStudent implements Comparable<MarkStudent>{
    private String name, code, type;
    private double p1, p2, p3, p;

    public MarkStudent(){
        this.name = this.code = this.type = "";
        this.p1 = this.p2 = this.p3 = this.p = 0;
    }

    public String setCode(int cnt){
        String s = "SV" + cnt;
        while(s.length() < 4) s = s.substring(0, 2) + "0" + s.substring(2);
        return s;
    }

    public String setType(double point){
        if(point >= 8) return "GIOI";
        else if(point >= 6.5) return "KHA";
        else if(point >= 5) return "TRUNG BINH";
        return "KEM";
    }
    public double getPoint(){
        return p;
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

    public MarkStudent(int cnt, String name, double p1, double p2, double p3){
        this.code = setCode(cnt);
        this.name = name;
        this.trueName();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p = (double) (this.p1 * 0.25 + this.p2 * 0.35 + this.p3 * 0.40);
        this.type = setType(p);
    }

    public static MarkStudent nextMarkStudent(Scanner sc, int cnt){
        return new MarkStudent(cnt, sc.nextLine(), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine()));
    }

    @Override
    public String toString(){
        return code + " " + name + String.format("%.2f", (double)p) + " " + type;
    }

    @Override
    public int compareTo(MarkStudent o) {
        return (int) ((int)(100 * (o.getPoint() - this.getPoint())));
    }
    
}
