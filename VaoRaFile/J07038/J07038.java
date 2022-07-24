package OOPs.VaoRaFile.J07038;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Student> Stulist = new ArrayList<>();
        for(int i = 1; i <= n; ++i) Stulist.add(Student.nextStudent(sc));
        Collections.sort(Stulist);
        for (Student stu : Stulist) {
            System.out.println(stu);
        }

        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Enterprise> enterList = new ArrayList<>();
        for(int i = 1; i <= m; ++i) enterList.add(Enterprise.nextEnterprise(sc, Stulist));
        for (Enterprise enter : enterList) {
            System.out.println(enter);
        }

        x = sc.nextLine();
        int p = Integer.valueOf(x);
        x.isEmpty();
        List<InternShip> internShip = new ArrayList<>();
        for(int i = 1; i <= p; ++i) internShip.add(InternShip.nextInternShip(sc));
        
        x = sc.nextLine();
        int q = Integer.valueOf(x);
        x.isEmpty();

        while(q-- > 0){
            String namecpn = sc.nextLine();
            System.out.println("DANH SACH THUC TAP TAI " + namecpn + ":");
        }
    }
}

class InternShip{
    private String codeStu, nameEnterprise;
    private Enterprise enterprise;

    public InternShip(){
        this.codeStu = this.nameEnterprise = "";
    }
    public InternShip(String codeStu, String NameEnterprise){
        this.codeStu = codeStu;
        this.nameEnterprise = NameEnterprise;
    }

    public static InternShip nextInternShip(Scanner sc){
        return new InternShip(sc.next(), sc.next());
    }

    public String getCodeEnterprise(){
        return enterprise.getCode();
    }
    public int getCountEnterprise(){
        return enterprise.getCount();
    }

    public String getNameEnterprise(){
        return nameEnterprise;
    }
    public String getCodeStu(){
        return codeStu;
    }

}

class Enterprise {
    private String name, code;
    private int count;
    private List<Student> stu = new ArrayList<>();

    public Enterprise(){
        this.name = this.code = "";
        this.count = 0;
    }
    public Enterprise(String code, String name, int count, List<Student> stu){
        this.code = code;
        this.name = name;
        this.count = count;
        this.stu = stu;
    }
    
    public static Enterprise nextEnterprise(Scanner sc, List<Student> stu){
        return new Enterprise(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), stu);
    }

    public void setStu(List<Student> stu){
        this.stu = stu;
    }
    public List<Student> getList(){
        return stu;
    }
    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public int getCount(){
        return count;
    }
    
    @Override
    public String toString(){
        return code + " " + name + " " + count;
    }
}

class Student implements Comparable<Student>{
    private String name, code, classes, email;

    public Student(){
        this.name = this.code = this.classes = this.email = "";
    }
    public Student(String code, String name, String classes, String email){
        this.code = code;
        this.name = name;
        this.trueName();
        this.classes = classes;
        this.email = email;
    }
    public static Student nextStudent(Scanner sc){
        return new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
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
        for (int i = 0; i < st.size() - 1; ++i){
           res += (Std(st.get(i)) + " ");
        }
        res += Std(st.get(st.size() - 1));
        this.name = res;
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + classes;
    }

    @Override
    public int compareTo(Student o) {
        return this.getCode().compareTo(o.getCode());
    }
}