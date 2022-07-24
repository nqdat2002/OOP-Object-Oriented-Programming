package OOPs.VaoRaFile.J07010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07010{
    public static void main(String [] args) throws FileNotFoundException{
        File f = new File("SV.in");
        Scanner sc = new Scanner(f);
        List<Student> list = new ArrayList<>();
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        for(int i = 1; i <= n; ++i){
            list.add(Student.nextStudent(sc, i));
        }
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
    
    public void setCode(int cnt){
        String s = "B20DCCN" + cnt;
        while(s.length() < 10) s = s.substring(0, 7) + "0" + s.substring(7);
        this.code = s;
    }

    public static Student nextStudent(Scanner sc, int cnt){
        Student a = new Student();
        a.setCode(cnt);
        a.name = sc.nextLine();
        a.classes = sc.nextLine();
        String s = sc.nextLine();
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        a.date = s;
        a.gpa = Double.valueOf(sc.nextLine());
        
        return a;
    }

    public void Show(){
        System.out.print(this.code + " " + this.name + " " + this.classes + " " + this.date + " ");
        System.out.format("%.2f\n", (double)this.gpa);
    }
}