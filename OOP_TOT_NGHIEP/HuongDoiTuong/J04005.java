package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class J04005 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ThiSinh a = ThiSinh.nextThiSinh(sc);
        System.out.println(a);
        sc.close();
    }
}
class ThiSinh{
    private String name;
    private Date date;
    private double p1, p2, p3;

    public ThiSinh(){
        this.name = "";
        this.date = new Date();
        this.p1 = this.p2 = this.p3 = 0;
    }

    public ThiSinh(String name, String date, double p1, double p2, double p3) throws ParseException{
        this.name = name;
        this.date = (new SimpleDateFormat("dd/MM/yyyy").parse(date));
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public static ThiSinh nextThiSinh(Scanner sc) throws ParseException{
        return new ThiSinh(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
    }
    
    @Override
    public String toString(){
        return name + " " + new SimpleDateFormat("dd/MM/yyyy").format(date) + " " + String.format("%.1f", (double)(p1 + p2 + p3));
    }
}