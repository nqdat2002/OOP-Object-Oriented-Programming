package OOPs.MangDoiTuong.J05080;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05080 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Subject> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Subject.nextSubject(sc));
        Collections.sort(list);
        x = sc.nextLine();
        int q = Integer.valueOf(x);
        x.isEmpty();
        while(q-- > 0){
            String teach = sc.nextLine();
            for(Subject sb: list){
                if(sb.getTeacher().compareTo(teach) == 0){
                    System.out.println("Danh sach cho giang vien " + teach + ":");
                    break;
                }
            }
            for (Subject sb : list) {
                if(sb.getTeacher().compareTo(teach) == 0){
                    System.out.println(sb);
                }
            }
        }
        sc.close();
    }
}
class Subject implements Comparable<Subject>{
    private String name, code, teacher, group;

    public Subject(){
        this.name = this.code = this.teacher = this.group = "";
    }

    public Subject(String code, String name, String group, String teacher){
        this.code = code;
        this.name = name;
        this.group = group;
        this.teacher = teacher;
    }

    public static Subject nextSubject(Scanner sc){
        return new Subject(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public String getGroup(){
        return group;
    }
    public String getTeacher(){
        return teacher;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + group;
    }

    @Override
    public int compareTo(Subject o) {
        if(this.getCode().compareTo(o.getCode()) != 0){
            return this.getCode().compareTo(o.getCode());
        }
        return this.getGroup().compareTo(o.getGroup());
    }
}