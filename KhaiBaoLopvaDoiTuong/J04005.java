package OOPs.KhaiBaoLopvaDoiTuong;

import java.util.Scanner;

public class J04005 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String name = ip.nextLine(), date = ip.nextLine();
        double p1 = ip.nextDouble(), p2 = ip.nextDouble(), p3 = ip.nextDouble();
        ThiSinh a = new ThiSinh(name, date, p1, p2, p3);
        a.Show();
        ip.close();
    }
}
class ThiSinh{
    private String name, date;
    private double p1, p2, p3;

    public ThiSinh(){
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
    public void Show(){
        String s = this.date;
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        this.date = s;

        System.out.print(this.name + " " + this.date + " ");
        System.out.format("%.1f", (double) (this.p1 + this.p2 + this.p3));
        System.out.println();
    }
}