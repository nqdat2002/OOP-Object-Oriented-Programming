package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;

public class J04013 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String address = ip.nextLine(), name = ip.nextLine();
        String p1 = ip.nextLine(), p2 = ip.nextLine(), p3 = ip.nextLine();
        DiemThi a = new DiemThi(address, name, Double.valueOf(p1), Double.valueOf(p2), Double.valueOf(p3));
        a.Show();
        ip.close();
    }
}
class DiemThi{
    private String address, name;
    private double p1, p2, p3;

    public DiemThi(){
        this.address = this.name = "";
        this.p1 = this.p2 = this.p3 = 0;
    }

    public DiemThi(String address, String name, double p1, double p2, double p3){
        this.address = address;
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public void Show(){
        String s = this.address;
        double p = this.p1 * 2 + this.p2 + this.p3;
        double x = 0;
        if(s.charAt(2) == '1') x = 0.5;
        if(s.charAt(2) == '2') x = 1.0;
        if(s.charAt(2) == '3') x = 2.5;
        System.out.print(this.address + " " + this.name + " ");
        if(x == 1.0)
            System.out.format("%.0f ",(double)(x));
        else 
            System.out.format("%.1f ", (double)(x));
        if(p == (int) p)
            System.out.format("%.0f ",(double)(p));
        else 
            System.out.format("%.1f ", (double)(p));
        if(p + x >= 24) System.out.print("TRUNG TUYEN");
        else System.out.print("TRUOT");
        System.out.println();
    }
}