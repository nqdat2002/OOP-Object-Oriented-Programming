package OOPs.MangDoiTuong.J05074;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05074 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) 
            list.add(Student.nextStudent(sc));
        while(n-- > 0){
            String code = sc.next();
            String day = sc.next();
            for (Student st : list) {
                if(st.getCode().compareTo(code) == 0){
                    st.setPoint(day);
                }
            }
        }
        for (Student st: list) {
            System.out.println(st);
        }
    }
}

class Student{
    private String name, code, classes;
    private int point;

    public Student(){
        this.name = this.code = this.classes = "";
        this.point = 0;
    }

    public Student(String code, String name, String classes){
        this.name = name;
        this.code = code;
        this.classes = classes;
        this.point = 0;
    }

    public static Student nextStudent(Scanner sc){
        return new Student(sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    public String getCode(){
        return code;
    }

    public void setPoint(String s){
        int v = 0, m = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == 'v') v++;
            if(s.charAt(i) == 'm') m++;
        }
        this.point = 10 - 2 * v - m;
        if(this.point <= 0) this.point = 0;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + classes + " " + point +  (point == 0 ? (" KDDK") : "");
    }
}