package OOPs.MangDoiTuong.J05058;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<DiemThi> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(DiemThi.nextDiemThi(sc));
        }
        Collections.sort(list, new Comparator<DiemThi>(){
            @Override
            public int compare(DiemThi o1, DiemThi o2){
                if((int) 10 * (o1.getP() - o2.getP() ) != 0)
                    return (int) ((int) 10 * (o2.getP() - o1.getP()));
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        for (DiemThi ts : list) {
            ts.Show();
        }
        sc.close();
    }
}
class DiemThi{
    private String address, name;
    private double p1, p2, p3, p, u;

    public DiemThi(){
        this.address = this.name = "";
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

    public double getP(){
        return p;
    }

    public static DiemThi nextDiemThi(Scanner sc){
        DiemThi a = new DiemThi();
        a.address = sc.nextLine();
        a.name = sc.nextLine();
        a.p1 = Double.valueOf(sc.nextLine());
        a.p2 = Double.valueOf(sc.nextLine());
        a.p3 = Double.valueOf(sc.nextLine());
        if(a.address.charAt(2) == '1') a.u = 0.5;
        if(a.address.charAt(2) == '2') a.u = 1.0;
        if(a.address.charAt(2) == '3') a.u = 2.5;
        a.p = a.p1 * 2 + a.p2 + a.p3 + a.u;
        return a;
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
        if(this.p >= 24) 
            System.out.print("TRUNG TUYEN");
        else 
            System.out.print("TRUOT");
        System.out.println();
    }
}