package OOPs.VaoRaFile.J07052;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07052 {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("THISINH.in"));
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<DiemThi> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(DiemThi.nextDiemThi(sc));
        }
        double nmax = -100.0;
        Collections.sort(list);
        for (DiemThi ts : list) {
            nmax = Math.max(ts.getPoint(), nmax);
        }
        tm = sc.nextLine();
        int q = Integer.valueOf(tm);
        tm.isEmpty();
        for (DiemThi ts : list) {
            if(ts.getPoint() == nmax){
                ts.SetType(nmax);
                q--;
                continue;
            }
            else if(ts.getPoint() < nmax && q > 0){
                nmax = ts.getPoint();
                ts.SetType(nmax);
                q--;
                continue;
            }
            ts.SetType(nmax);
        }
        System.out.format("%.1f\n", nmax);
        for (DiemThi ts : list) {
            System.out.println(ts);
        }
        sc.close();
    }
}
class DiemThi implements Comparable<DiemThi> {
    private String address, name, type;
    private double p1, p2, p3, p, u;

    public DiemThi(){
        this.address = this.name = this.type = "";
        this.p1 = this.p2 = this.p3 = this.p = this.u;
    }

    public DiemThi(String address, String name, double p1, double p2, double p3){
        this.address = address;
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public String getCode(){
        return address;
    }

    public double getPoint(){
        return p;
    }

    public static DiemThi nextDiemThi(Scanner sc){
        DiemThi a = new DiemThi();
        a.address = sc.nextLine();
        a.name = sc.nextLine();
        a.trueName();
        a.p1 = Double.valueOf(sc.nextLine());
        a.p2 = Double.valueOf(sc.nextLine());
        a.p3 = Double.valueOf(sc.nextLine());
        if(a.address.charAt(2) == '1') a.u = 0.5;
        if(a.address.charAt(2) == '2') a.u = 1.0;
        if(a.address.charAt(2) == '3') a.u = 2.5;
        a.p = a.p1 * 2 + a.p2 + a.p3 + a.u;
        return a;
    }

    public void SetType(double max){
        if(p >= max) type = "TRUNG TUYEN";
        else type = "TRUOT";
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
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') res += s.charAt(i);
        }
        res = "";
        for (String ss : st){
           res += (Std(ss) + " ");
        }
        this.name = res;
    }

    public void Show(){
        System.out.print(this.address + " " + this.name + " ");
        double x = this.u;
        if(x == 1.0)
            System.out.format("%.0f ",(double)(x));
        else 
            System.out.format("%.1f ", (double)(x));
        if(this.p == (int) p)
            System.out.format("%.0f ",(double)(this.p));
        else 
            System.out.format("%.1f ", (double)(this.p));
        System.out.print(type);
        System.out.println();
    }

    public String toString(){
        String res = address + " " + name;
        String s1 = (u == 1.0) ? String.format("%.0f ", u) : String.format("%.1f ", u);
        String s2 = (p == (int)p) ? String.format("%.0f ", p) : String.format("%.1f ", p);
        return res + s1 + s2 + type;
    }

    @Override
    public int compareTo(DiemThi o) {
        if(this.getPoint() != o.getPoint()){
            return (int)((int) 100 * (o.getPoint() - this.getPoint()));
        }
        return this.getCode().compareTo(o.getCode());
    }
}