package OOPs.VaoRaFile.J07057;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07057 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("THISINH.in"));
       // Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<MarkStudent> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(MarkStudent.nextMarkStudent(sc, i));
        Collections.sort(list);
        for (MarkStudent mark : list) {
            System.out.println(mark);
        }
    }
}

class MarkStudent implements Comparable<MarkStudent>{
    private String name, type, code, ethnic, address;
    private double p, plus;

    public MarkStudent(){
        this.name = this.type = this.code = this.ethnic = this.address = "";
        this.p = this.plus = 0;
    }
    public MarkStudent(String name, double p, String ethnic, String address, int cnt){
        this.code = "TS" + (cnt >= 10 ? cnt : ("0" + cnt));
        this.name = name;
        this.trueName();
        this.p = p;
        this.ethnic = ethnic;
        this.address = address;
        this.plus = 0;
        if(this.address.compareTo("1") == 0) this.plus += (double)1.5;
        else if(this.address.compareTo("2") == 0) this.plus += (double)1.0;

        if(this.ethnic.compareTo("Kinh") != 0) this.plus += (double)1.5;

        if((double)(this.p + this.plus) >= 20.5) this.type = "Do";
        else this.type = "Truot";
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
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')res += s.charAt(i);
        }
        res = "";
        for (String ss : st){
           res += (Std(ss) + " ");
        }
        this.name = res;
    }

    public static MarkStudent nextMarkStudent(Scanner sc, int cnt){
        return new MarkStudent(sc.nextLine(), Double.valueOf(sc.nextLine()), sc.nextLine(), sc.nextLine(), cnt);
    }

    public double getPoint(){
        return (p + plus);
    }

    public String getCode(){
        return code;
    }

    @Override
    public String toString(){
        return code + " " + name + String.format("%.1f", (double)(p + plus)) + " " + type;
    }

    @Override
    public int compareTo(MarkStudent o) {
        if(o.getPoint() != this.getPoint()){
            return (int)( (int) 10 * (o.getPoint() - this.getPoint()));
        }
        return this.getCode().compareTo(o.getCode());
    }
}
