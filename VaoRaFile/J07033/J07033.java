package OOPs.VaoRaFile.J07033;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class J07033 {
    public static void main(String [] args) throws FileNotFoundException{
        File file = new File("SINHVIEN.in");
        Scanner sc = new Scanner(file);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(Student.nextStudent(sc));
        }
        Collections.sort(list, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                return o1.getCode().compareTo(o2.getCode());

            }
        });
        for (Student student : list) {
            student.Show();
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

    public static Student nextStudent(Scanner sc){
        Student a = new Student();
        a.code = sc.nextLine();
        a.name = sc.nextLine();
        a.trueName();
        a.classes = sc.nextLine();
        a.email = sc.nextLine();
        return a;
    }

    public void Show(){
        System.out.println(this.code + " " + this.name + " " + this.classes + " " + this.email);
    }
}