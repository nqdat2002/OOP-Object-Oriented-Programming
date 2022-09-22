package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;

public class J04006 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String name = ip.nextLine(), classes = ip.nextLine(), date = ip.nextLine();
        double p = ip.nextDouble();
        SinhVien a = new SinhVien();
        // Sinhvien a = new SinhVien(name, classes, date, p);
        a.setName(name);
        a.setClasses(classes);
        a.setDate(date);
        a.setPoint(p);
        a.Show();
        ip.close();
    }
}
class SinhVien{
    private String name, classes, date;
    private double p;

    public SinhVien(){
        this.name = this.date = this.classes = "";
        this.p = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setPoint(double p){
        this.p = p;
    }
    // ham khoi tao co tham so
    // public SinhVien(String name, String classes, String date, double p){
    //     this.name = name;
    //     this.classes = classes;
    //     this.date = date;
    //     this.p = p;
    // }
    public void Show(){
        String s = this.date;
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        this.date = s;

        System.out.print("B20DCCN001 ");
        System.out.print(this.name + " " + this.classes + " " + this.date + " ");
        System.out.format("%.2f", (double) (p));
        System.out.println();
    }
}