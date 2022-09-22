package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TN02018 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Subject> subject = new ArrayList<>();
        for(int i = 1; i <= n; ++i) subject.add(Subject.nextSubject(sc));

        int m = sc.nextInt();
        List<Teacher> teacher = new ArrayList<>();
        for(int i = 1; i <= m; ++i) teacher.add(Teacher.nextTeacher(sc));

        int q = sc.nextInt();
        List<Timer> timer = new ArrayList<>();
        for(int i = 1; i <= q; ++i) timer.add(Timer.nextTimer(sc));

        String x = sc.next();
        double time = 0;
        for (Teacher teach : teacher) {
            if(teach.getCodeTeacher().compareTo(x) == 0){
                System.out.println("Giang vien: " + teach.getNameTeacher());
                break;
            }
        }
        for (Timer tim : timer) {
            if(tim.getCodeTeacher().compareTo(x) == 0){
                for (Subject sub : subject) {
                    if(tim.getCodeSubject().compareTo(sub.getCode()) == 0){
                        System.out.println(sub.getName() + " " + tim.getTotal());
                        break;
                    }
                }
            }
        }
        for (Timer tim : timer) {
            if(tim.getCodeTeacher().compareTo(x) == 0){
                time += tim.getTotal();
            }
        }
        System.out.print("Tong: ");
        System.out.format("%.2f", (double)time);
        sc.close();
    }
}

class Timer{
    private String codeSubject, codeTeacher;
    private double total_time;

    public Timer(){
        this.codeSubject = this.codeTeacher = "";
        this.total_time = 0;
    }

    public Timer(String codeTeacher, String codeSubject, double total_time){
        this.codeTeacher = codeTeacher;
        this.codeSubject = codeSubject;
        this.total_time = total_time;
    }

    public String getCodeTeacher(){
        return codeTeacher;
    }
    public String getCodeSubject(){
        return codeSubject;
    }
    public double getTotal(){
        return total_time;
    }

    public static Timer nextTimer(Scanner sc){
        return new Timer(sc.next(), sc.next(), Double.valueOf(sc.next()));
    }

}   

class Teacher{
    private String codeTeacher, nameTeacher;

    public Teacher(){
        this.codeTeacher = this.nameTeacher = "";
    }

    public Teacher(String codeTeacher, String nameTeacher){
        this.codeTeacher = codeTeacher;
        this.nameTeacher = nameTeacher.substring(1);
    }

    public static Subject nextSubject(Scanner sc){
        return new Subject(sc.next(), sc.nextLine());
    }

    public String getNameTeacher(){
        return nameTeacher;
    }
    public String getCodeTeacher(){
        return codeTeacher;
    }

    public static Teacher nextTeacher(Scanner sc){
        return new Teacher(sc.next(), sc.nextLine());
    }
}

class Subject{
    private String name, code;

    public Subject(){
        this.name = this.code = "";
    }

    public Subject(String code, String name){
        this.code = code;
        this.name = name.substring(1);
    }

    public static Subject nextSubject(Scanner sc){
        return new Subject(sc.next(), sc.nextLine());
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
}
