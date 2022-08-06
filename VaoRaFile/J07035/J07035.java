package OOPs.VaoRaFile.J07035;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07035 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        //Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Student> Stulist = new ArrayList<>();
        for (int i = 1; i <= n; ++i)
            Stulist.add(Student.nextStudent(sc));

        sc = new Scanner(new File("MONHOC.in"));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Subject> subject = new ArrayList<>();
        for (int i = 1; i <= m; ++i)
            subject.add(Subject.nextSubject(sc));

        sc = new Scanner(new File("BANGDIEM.in"));
        x = sc.nextLine();
        int p = Integer.valueOf(x);
        x.isEmpty();
        List<Transcript> transcripts = new ArrayList<>();
        for (int i = 1; i <= p; ++i)
            transcripts.add(Transcript.nextTranscript(sc));
        Collections.sort(transcripts);
           
        int q = Integer.valueOf(sc.next());
        while (q-- > 0) {
            String codesub = sc.next();
            for (Subject sub : subject){
                if(sub.getCode().compareTo(codesub) == 0){
                    System.out.println("BANG DIEM MON " + sub.getName() + ":");
                    break;
                }
            }
            for (Transcript transcript : transcripts) {
                for (Student stu : Stulist) {
                    if(transcript.getCodeStudent().compareTo(stu.getCode()) == 0 && transcript.getCodeSubject().compareTo(codesub) == 0){
                        System.out.println(stu + " " + transcript.getPoint());
                        break;
                    }
                }
            }
        }
    }
}

class Transcript implements Comparable<Transcript> {
    private String codeStudent, codeSubject;
    private String point;

    public Transcript() {
        this.codeStudent = this.codeSubject = "";
        this.point = "";
    }

    public Transcript(String codeStudent, String codeSubject, String point) {
        this.codeStudent = codeStudent;
        this.codeSubject = codeSubject;
        this.point = point;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public String getCodeSubject() {
        return codeSubject;
    }

    public String getPoint() {
        return point;
    }

    public static Transcript nextTranscript(Scanner sc) {
        return new Transcript(sc.next(), sc.next(), sc.next());
    }

    @Override
    public String toString() {
        return codeStudent + " " + codeSubject + " " + point;
    }

    @Override
    public int compareTo(Transcript o) {
        if (this.getPoint().compareTo(o.getPoint()) != 0) {
            return (int) (10 * (Double.valueOf(o.getPoint()) - Double.valueOf(this.getPoint())));
        }
        return this.getCodeStudent().compareTo(o.getCodeStudent());
    }

}

class Subject {
    private String name, code;
    private int count;

    public Subject() {
        this.name = this.code = "";
        this.count = 0;
    }

    public Subject(String code, String name, int count) {
        this.name = name;
        this.code = code;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getType() {
        return count;
    }

    public static Subject nextSubject(Scanner sc) {
        return new Subject(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()));
    }
}

class Student implements Comparable<Student> {
    private String name, code, classes, email;

    public Student() {
        this.name = this.code = this.classes = this.email = "";
    }

    public Student(String code, String name, String classes, String email) {
        this.code = code;
        this.name = name;
        this.trueName();
        this.classes = classes;
        this.email = email;
    }

    public static Student nextStudent(Scanner sc) {
        return new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    public String Std(String s) {
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (i == 0) {
                res += Character.toUpperCase(c);
            } else
                res += c;
        }
        return res;
    }

    public void trueName() {
        String s = this.name;
        s = s.trim();
        Vector<String> st = new Vector<>();
        String res = "";
        s = s + " ";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && res.length() > 0) {
                res = res.toLowerCase();
                st.add(res);
                res = "";
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                res += s.charAt(i);
        }
        res = "";
        for (int i = 0; i < st.size() - 1; ++i) {
            res += (Std(st.get(i)) + " ");
        }
        res += Std(st.get(st.size() - 1));
        this.name = res;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + classes;
    }

    @Override
    public int compareTo(Student o) {
        return this.getCode().compareTo(o.getCode());
    }
}
