package OOPs.VaoRaFile.J07081;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07081 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Student> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Student.nextStudent(sc));
        Collections.sort(list);
        for (Student st : list) {
            System.out.println(st);
        }
        sc.close();
    }
}
class Student implements Comparable<Student>{
    private String name, code, email, phone;
    private Vector<String> allName = new Vector<>();

    public Student(){
        this.name = this.code = this.phone = this.email = "";
        this.allName.isEmpty();
    }
    public Student(String code, String name, String phone, String email){
        this.name = name;
        this.code = code;
        this.phone = phone;
        this.email = email;
        String [] array = name.split(" ");
        for(int i = 0; i < array.length; ++i) this.allName.add(array[i]);
    }

    public String getLastName(){
        return allName.get(allName.size() - 1);
    }
    public String getFirstName(){
        return allName.get(0);
    }
    public String getMidName(){
        String res = "";
        for(int i = 1; i < allName.size() - 1; ++i) res += (allName.get(i) + " ");
        return res;
    }
    public String getCode(){
        return code;
    }

    public static Student nextStudent(Scanner sc){
        return new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public int compareTo(Student o) {
        if(this.getLastName().compareTo(o.getLastName()) != 0){
            return this.getLastName().compareTo(o.getLastName());
        }
        if(this.getFirstName().compareTo(o.getFirstName()) != 0){
            return this.getFirstName().compareTo(o.getFirstName());
        }
        if(this.getMidName().compareTo(o.getMidName()) != 0){
            return this.getMidName().compareTo(o.getMidName());
        }
        return this.getCode().compareTo(o.getCode());
    }

    @Override
    public String toString(){
        return code + " " + name + " " + phone + " " + email;
    }
}
