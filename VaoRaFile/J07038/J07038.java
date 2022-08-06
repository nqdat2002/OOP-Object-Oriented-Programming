package OOPs.VaoRaFile.J07038;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07038 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        //Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Student> Stulist = new ArrayList<>();
        for(int i = 1; i <= n; ++i) Stulist.add(Student.nextStudent(sc));
        //Collections.sort(Stulist);

        sc = new Scanner(new File("DN.in"));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Enterprise> enterList = new ArrayList<>();
        for(int i = 1; i <= m; ++i) enterList.add(Enterprise.nextEnterprise(sc));
        
        sc = new Scanner(new File("THUCTAP.in"));
        x = sc.nextLine();
        int p = Integer.valueOf(x);
        x.isEmpty();
        List<InternShip> internShip = new ArrayList<>();
        for(int i = 1; i <= p; ++i) internShip.add(InternShip.nextInternShip(sc));
        Collections.sort(internShip);

        x = sc.nextLine();
        x.isEmpty();
        x = sc.nextLine();
        int q = Integer.valueOf(x);
        x.isEmpty();

        while(q-- > 0){
            String codecpn = sc.nextLine();
            int counta = 0;
            for (Enterprise enter : enterList) {
                if(enter.getCode().compareTo(codecpn) == 0){
                    System.out.println("DANH SACH THUC TAP TAI " + enter.getName() + ":");
                    counta = enter.getCount();
                    break;
                }
            }
            int cnt = 0;
            for (InternShip intern : internShip) {
                for (Student stu : Stulist) {
                    if(intern.getCodeEnterprise().compareTo(codecpn) == 0 && stu.getCode().compareTo(intern.getCodeStu()) == 0 && cnt < counta){
                        System.out.println(stu);
                        cnt++;
                    }
                }
            }
        }
        sc.close();
    }
}

class InternShip implements Comparable<InternShip>{
    private String codeStu, codeEnterprise;

    public InternShip(){
        this.codeStu = this.codeEnterprise = "";
    }
    public InternShip(String codeStu, String NameEnterprise){
        this.codeStu = codeStu;
        this.codeEnterprise = NameEnterprise;
    }

    public static InternShip nextInternShip(Scanner sc){
        return new InternShip(sc.next(), sc.next());
    }

    public String getCodeEnterprise(){
        return codeEnterprise;
    }
    public String getCodeStu(){
        return codeStu;
    }

    @Override
    public int compareTo(InternShip o) {
        return this.getCodeStu().compareTo(o.getCodeStu());
    }

}

class Enterprise {
    private String name, code;
    private int count;

    public Enterprise(){
        this.name = this.code = "";
        this.count = 0;
    }
    public Enterprise(String code, String name, int count){
        this.code = code;
        this.name = name;
        this.count = count;
    }
    
    public static Enterprise nextEnterprise(Scanner sc){
        return new Enterprise(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()));
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