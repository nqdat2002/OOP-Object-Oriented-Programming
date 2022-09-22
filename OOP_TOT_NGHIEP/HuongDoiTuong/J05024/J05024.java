package OOP_TOT_NGHIEP.HuongDoiTuong.J05024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// liet ke sv theo nganh

public class J05024 {
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
        Map<String, String> mp = new HashMap<String, String>();
        mp.put("KE TOAN", "DCKT");
        mp.put("CONG NGHE THONG TIN", "DCCN");
        mp.put("DIEN TU", "DCDT");
        mp.put("AN TOAN THONG TIN", "DCAT");
        mp.put("VIEN THONG", "DCVT");
        while(q-- > 0){
            String cls = sc.nextLine();
            cls = cls.toUpperCase();
            System.out.println("DANH SACH SINH VIEN NGANH " + cls + ":");
            String p = "";
            if(mp.containsKey(cls)) p = mp.get(cls);
            for (Student s : list) {
                if(s.getNganh().compareTo(p) == 0){
                    if(p == "DCCN" || p == "DCAT"){
                        if(s.getClasses().charAt(0) != 'E')
                            s.Show();
                    }
                    else s.Show();
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
    public Student(String code, String name, String classes, String date){
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
    public String getNganh(){
        String s = this.code;
        return s.substring(3, 7);
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