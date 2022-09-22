package OOP_TOT_NGHIEP.HuongDoiTuong.J05018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05018 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<PointStudent> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(PointStudent.nextPointStudent(sc, i));
        }
        Collections.sort(list, new Comparator<PointStudent> (){
            @Override
            public int compare(PointStudent o1, PointStudent o2){
                if((int) 10 * (o1.getAverave() - o2.getAverave()) != 0)
                    return (int) (10 * (o2.getAverave() - o1.getAverave()));
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        for (PointStudent st : list) {
            st.Show();
        }
        sc.close();
    }
}

class PointStudent{
    private final int mx = 10;
    private String name, code, type;
    private double [] Point = new double [mx];
    private double average;

    public PointStudent(){
        this.name = this.code = this.type =  "";
        Arrays.fill(this.Point, 0.0);
        this.average = 0.0;
    }

    public PointStudent(String name, double [] Point){
        this.name = name;
        this.Point = Point.clone();
    }

    public void setCode(int cnt){
        String s = "HS" + cnt;
        while(s.length() < 4) s = s.substring(0, 2) + "0" + s.substring(2);
        this.code = s;
    }

    public void setType(){
        double p = this.average;
        if(p >= 9.0) this.type = "XUAT SAC";
        else if (p >= 8.0) this.type = "GIOI";
        else if (p >= 7.0) this.type = "KHA";
        else if (p >= 5.0) this.type = "TB";
        else this.type = "YEU";
    }

    public double getAverave(){
        double p = 0;
        for(int i = 0; i < this.mx; ++i){
            p += this.Point[i];
        }
        p += (this.Point[1] + this.Point[0]);
        return p;
    }
    public String getCode(){
        return code;
    }

    public static PointStudent nextPointStudent(Scanner sc, int cnt){
        PointStudent a = new PointStudent();
        a.name = sc.nextLine();
        a.setCode(cnt);
        for(int i = 0; i < a.mx; ++i){
            a.Point[i] = sc.nextDouble();
            a.average += a.Point[i];
        }
        a.average += (a.Point[0] + a.Point[1]);
        a.average /= 12;
        a.average = (double) Math.round((double) (a.average) * 10) / 10;
        String x = sc.nextLine(); x.isEmpty();
        a.setType();
        return a;
    }

    public void Show(){
        System.out.print(this.code + " " + this.name + " " + this.average + " ");
        //System.out.format("%.1f ",(double) this.average);
        System.out.println(this.type);
    }
}