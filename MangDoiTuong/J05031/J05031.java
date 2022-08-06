package OOPs.MangDoiTuong.J05031;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05031 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<MarkStudent> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(MarkStudent.nextMarkStudent(sc));
        }
        Collections.sort(list, new Comparator<MarkStudent>(){
            @Override
            public int compare(MarkStudent o1, MarkStudent o2){
                return o1.getName().compareTo(o2.getName());
            }
        });
        int index = 1;
        for (MarkStudent student : list) {
            System.out.print(index + " ");
            student.Show();
            index ++;
        }
        sc.close();
    }
}
class MarkStudent{
    private String code, name, classes;
    private double p1, p2, p3;

    public MarkStudent(){
        this.code = this.name = this.classes = "";
        this.p1 = this.p2 = this.p3 = 0;
    }
    public MarkStudent(String code, String name, String classes, double p1, double p2, double p3){
        this.code = code;
        this.name = name;
        this.classes = classes;
        this.p1 = p1;
        this.p3 = p3;
        this.p2 = p2;
    }

    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }

    public static MarkStudent nextMarkStudent(Scanner sc){
        MarkStudent a = new MarkStudent();
        a.code = sc.nextLine();
        a.name = sc.nextLine();
        a.classes = sc.nextLine();
        a.p1 = Double.valueOf(sc.nextLine());
        a.p2 = Double.valueOf(sc.nextLine());
        a.p3 = Double.valueOf(sc.nextLine());
        return a;
    }

    public void Show(){
        System.out.print(this.code + " " + this.name + " " + this.classes + " ");
        System.out.format("%.1f %.1f %.1f\n", (double)this.p1, (double)this.p2, (double)this.p3);
    }
}