package OOPs.MangDoiTuong.J05023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// liet ke sv theo khoa

public class J05023 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(Student.nextStudent(sc));
        }
        x = sc.nextLine();
        int q = Integer.valueOf(x);
        x.isEmpty();
        while(q-- > 0){
            String cls = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN KHOA " + cls + ":");
            for (Student s : list) {
                if(s.getKhoa().compareTo(cls.substring(2)) == 0){
                    s.Show();
                }
            }
        }
        sc.close();
    }
}
class Student{
    private String code, name, classes, email;

    public Student(){
        this.code = this.name = this.classes = this.email = "";
    }
    public Student(String code, String name, String classes, String date, double gpa){
        this.code = code;
        this.name = name;
        this.classes = classes;
        this.email = date;
    }

    public String getClasses(){
        return classes;
    }
    public String getCode(){
        return code;
    }
    public String getKhoa(){
        String s = this.classes;
        return s.substring(1, 3);
    }

    public static Student nextStudent(Scanner sc){
        Student a = new Student();
        a.code = sc.nextLine();
        a.name = sc.nextLine();
        a.classes = sc.nextLine();
        a.email = sc.nextLine();
        return a;
    }

    public void Show(){
        System.out.println(this.code + " " + this.name + " " + this.classes + " " + this.email);
    }
}
