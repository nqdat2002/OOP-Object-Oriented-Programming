package OOPs.QuanHeGiuaCacLop.J06003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J06003 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String x = sc.nextLine();
        x.isEmpty();
        List<Student> stu = new ArrayList<>();
        for(int i = 1; i <= n; ++i) stu.add(Student.nextStudent(sc));

        List<Project> pro = new ArrayList<>();
        for(int i = 1; i <= m; ++i) pro.add(Project.nextProject(sc, i, stu));
        
        x = sc.nextLine();
        int q = Integer.valueOf(x);
        x.isEmpty();
        while(q-- > 0){
            String type = sc.nextLine();
            System.out.println("DANH SACH NHOM " + type + ":");
            for (Project project : pro) {
                project.ShowStudent(type);
                break;
            }
            for (Project project : pro) {
                if(project.getNum().compareTo(type) == 0){
                    System.out.println("Bai tap dang ky: " + project.getName());
                    break;
                }
            }
        }
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

    public void ShowStudent(String type){
        for (Student stu : student) {
            if(stu.getType().compareTo(type) == 0){
                System.out.println(stu);
            }
        }
    }

    @Override
    public String toString(){
        return name + " " + num;
    }
}

class Student{
    private String name, code, phone, type;

    public Student(){
        this.name = this.code = this.phone = this.type = "";
    }

    public Student(String code, String name, String phone, String type){
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.type = type;
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

    public static Student nextStudent(Scanner sc){
        return new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public String toString(){
        return code + " " + name + " " + phone;
    }
}
