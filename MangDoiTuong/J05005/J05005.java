package OOPs.MangDoiTuong.J05005;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J05005 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(Student.nextStudent(sc, i));
        }
        Collections.sort(list, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                return (int) ((int) 100 * (o2.getGpa() - o1.getGpa()));
            }
        });
        for (Student student : list) {
            student.Show();
        }
        sc.close();
    }
}
class Student{
    private String code, name, classes, date;
    double gpa;

    public Student(){
        this.code = this.name = this.classes = this.date = "";
        this.gpa = 0;
    }
    public Student(String name, String classes, String date, double gpa){
        this.name = name;
        this.classes = classes;
        this.date = date;
        this.gpa = gpa;
    }

    public double getGpa(){
        return gpa;
    }

    public void trueDate(){
        String s = this.date;
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        this.date = s;
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
    public void setCode(int cnt){
        String s = "B20DCCN" + cnt;
        while(s.length() < 10) s = s.substring(0, 7) + "0" + s.substring(7);
        this.code = s;
    }

    public static Student nextStudent(Scanner sc, int cnt){
        Student a = new Student();
        a.setCode(cnt);
        a.name = sc.nextLine();
        a.trueName();
        a.classes = sc.nextLine();
        a.date = sc.nextLine();
        a.trueDate();
        a.gpa = Double.valueOf(sc.nextLine());
        return a;
    }

    public void Show(){
        System.out.print(this.code + " " + this.name + "" + this.classes + " " + this.date + " ");
        System.out.format("%.2f\n", (double)this.gpa);
    }
}
