package OOPs.MangDoiTuong.J05062;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String x = sc.nextLine();
        x.isEmpty();
        List<Salary> list = new ArrayList<>();
        List<Salary> stu = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            Salary a = Salary.nextSalary(sc);
            list.add(a);
            stu.add(a);
        }
        Collections.sort(list, new Comparator<Salary>() {
            @Override
            public int compare(Salary o1, Salary o2){
                return (int)(100 * (o2.getGpa() - o1.getGpa()));
            }
        });
        int cnt = 0;
        for (Salary salary : list) {
            if(salary.getGpa() * 100 >= 36 && salary.getAttendence() >= 90 && cnt < m){
                salary.setType("XUATSAC");
                cnt++;
                continue;
            }
            else if(salary.getGpa() * 100 >= 32 && salary.getAttendence() >= 80 && cnt < m){
                salary.setType("GIOI");
                cnt++;
                continue;
            }
            else if(salary.getGpa() * 100 >= 25 && salary.getAttendence() >= 70 && cnt < m){
                salary.setType("KHA");
                cnt++;
                continue;
            }
            salary.setType("KHONG");
        }
        System.out.println(cnt);
        for (Salary salary : list) {
            System.out.println(salary);
        }
    }
}

class Salary{
    private String name, type;
    private double gpa;
    private int attendence;

    public Salary(){
        this.name = this.type ="";
        this.gpa = 0;
        this.attendence = 0;
    }

    public Salary(String name, double gpa, int attendence){
        this.name = name;
        this.gpa = gpa;
        this.attendence = attendence;
    }

    public void setType(String s){
        this.type = s;
    }
    public double getGpa(){
        return gpa;
    }
    public int getAttendence(){
        return attendence;
    }
    public String getType(){
        return type;
    }

    public static Salary nextSalary(Scanner sc){
        Salary a = new Salary(sc.nextLine(), Double.valueOf(sc.next()), Integer.valueOf(sc.next()));
        String x = sc.nextLine();
        x.isEmpty();
        return a;
    }

    @Override
    public String toString(){
        return name + ": " + type; 
    }
}
