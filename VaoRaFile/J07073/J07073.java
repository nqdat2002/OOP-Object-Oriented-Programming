package OOPs.VaoRaFile.J07073;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07073 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Subject> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(Subject.nextSubject(sc));
        }
        Collections.sort(list);
        for (Subject sb : list) {
            if(sb.getMethod().contains("Truc tuyen") || sb.getMethod().contains(".ptit.edu.vn")){
                System.out.println(sb);
            }
        }
    }
}
class Subject implements Comparable<Subject>{
    private String name, code, type, method;
    private int cnt;

    public Subject(){
        this.name = this.code = this.type = this.method = "";
        this.cnt = 0;
    }
    public Subject(String code, String name, int cnt, String type, String method){
        this.code = code;
        this.name = name;
        this.cnt = cnt;
        this.type = type;
        this.method = method;
    }
    public String getCode(){
        return code;
    }

    public String getMethod(){
        return method;
    }

    public static Subject nextSubject(Scanner sc){
        return new Subject(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), sc.nextLine(),  sc.nextLine());
    }

    @Override
    public String toString(){
        return code + " " + name + " " + cnt + " " + type + " " + method;
    }

    @Override
    public int compareTo(Subject o) {
        return this.getCode().compareTo(o.getCode());
    }
}