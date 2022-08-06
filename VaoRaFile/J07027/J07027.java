package OOPs.VaoRaFile.J07027;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07027 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        String x = sc.nextLine();
        x.isEmpty();
        List<Student> stu = new ArrayList<>();
        for(int i = 1; i <= n; ++i) stu.add(Student.nextStudent(sc));
        Collections.sort(stu);

        sc = new Scanner(new File("BAITAP.in"));
        int m = sc.nextInt();
        x = sc.nextLine();
        x.isEmpty();
        List<Project> pro = new ArrayList<>();
        for(int i = 1; i <= m; ++i) pro.add(Project.nextProject(sc, i, stu));

        sc = new Scanner(new File("NHOM.in"));
        int q = n;
        for(int i = 1; i <= q; ++i){
            String code = sc.next();
            String type = sc.next();
            for (Student student : stu) {
                if(student.getCode().compareTo(code) == 0) student.setType(type);
            }
        }

        for (Student student : stu) {
            for (Project project : pro) {
                if(student.getType().compareTo(project.getNum()) == 0){
                    System.out.println(student + " " + project.getName());
                    break;
                }
            }
        }
        sc.close();
    }
}
class Project{
    private String name, num;
    private List<Student> student;
    
    public Project(){
        this.name = this.num = "";
    }

    public Project(String name, int cnt, List<Student> student){
        this.name = name;
        this.num = "" + cnt;
        this.student = student;
    }

    public static Project nextProject(Scanner sc, int cnt, List<Student> student){
        return new Project(sc.nextLine(), cnt, student);
    }

    public String getName(){
        return name;
    }
    public String getNum(){
        return num;
    }
    public List<Student> getList(){
        return student;
    }

}

class Student implements Comparable<Student>{
    private String name, code, phone, type;

    public Student(){
        this.name = this.code = this.phone = this.type = "";
    }

    public Student(String code, String name, String phone){
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.type = "";
    }
    
    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public String getPhone(){
        return phone;
    }
    public String getType(){
        return type;
    }

    public void setType(String s){
        this.type = s;
    }

    public static Student nextStudent(Scanner sc){
        return new Student(sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public String toString(){
        return code + " " + name + " " + phone + " " + type;
    }

    @Override
    public int compareTo(Student o) {
        return this.getCode().compareTo(o.getCode());
    }
}
