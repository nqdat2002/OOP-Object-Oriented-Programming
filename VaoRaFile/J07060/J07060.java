package OOPs.VaoRaFile.J07060;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07060 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONTHI.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Subject> subject = new ArrayList<>();
        for(int i = 1; i <= n; ++i) subject.add(Subject.nextSubject(sc));

        sc = new Scanner(new File("CATHI.in"));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Shift> shift = new ArrayList<>();
        for(int i = 1; i <= m; ++i) shift.add(Shift.nextShift(sc, i));
        Collections.sort(shift);

        sc = new Scanner(new File("LICHTHI.in"));
        x = sc.nextLine();
        int p = Integer.valueOf(x);
        x.isEmpty();
        List<Schedule> schedules = new ArrayList<>();
        for(int i = 1; i <= p; ++i) schedules.add(Schedule.nextSchedule(sc, subject, shift));

        for (Shift sh : shift) {
            for (Schedule schedule : schedules) {
                if(sh.getCode().compareTo(schedule.getShift_code()) == 0){
                    System.out.print(sh + " ");
                    for (Subject sub : subject) {
                        if(schedule.getSubject_code().compareTo(sub.getCode()) == 0){
                            System.out.print(sub + " ");
                            System.out.println(schedule);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        sc.close();
    }
}

class Schedule{
    private String Shift_code, Subject_code, Group_code;
    private int Count_student;
    private List<Subject> subject;
    private List<Shift> shift;

    public Schedule(){
        this.Shift_code = this.Subject_code = this.Group_code;
        this.Count_student = 0;
        this.subject = new ArrayList<>();
        this.shift = new ArrayList<>();
    }

    public Schedule(String Shift_code, String Subject_code, String Group_code, int Count_Student, List<Subject> subject, List<Shift> shift){
        this.Shift_code = Shift_code;
        this.Subject_code = Subject_code;
        this.Group_code = Group_code;
        this.Count_student = Count_Student;
        this.subject = subject;
        this.shift = shift;
    }
    public String getShift_code(){
        return Shift_code;
    }
    public String getSubject_code(){
        return Subject_code;
    }
    public String getGroup_code(){
        return Group_code;
    }
    public int getCount_Student(){
        return Count_student;
    }
    public List<Subject> getListSubject(){
        return subject;
    }
    public List<Shift> getListShift(){
        return shift;
    }

    public static Schedule nextSchedule(Scanner sc, List<Subject> subject, List<Shift> shift){
        return new Schedule(sc.next(), sc.next(), sc.next(), Integer.valueOf(sc.next()), subject, shift);
    }

    @Override
    public String toString(){
        return Group_code + " " + Count_student;
    }
}

class Shift implements Comparable<Shift>{
    private String date, time, id, code;

    public Shift(){
        this.code = this.date = this.time = this.id = "";
    }

    public Shift(String date, String time, String id, int cnt){
        this.date = date;
        this.time = time;
        this.id = id;
        this.code = "C" + cnt;
        while(this.code.length() < 4) this.code = this.code.substring(0, 1) + "0" + this.code.substring(1);
    }

    public String getCode(){
        return code;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getId(){
        return id;
    }

    public static Shift nextShift(Scanner sc, int cnt){
        return new Shift(sc.nextLine(), sc.nextLine(), sc.nextLine(), cnt);
    }

    @Override
    public int compareTo(Shift o) {
        if(this.getDate().compareTo(o.getDate()) != 0){
            return this.getDate().compareTo(o.getDate());
        }
        return this.getTime().compareTo(o.getTime());
    }

    @Override
    public String toString(){
        return date + " " + time + " " + id;
    }
}

class Subject{
    private String name, code, type;

    public Subject(){
        this.name = this.code = this.type = "";
    }

    public Subject(String code, String name, String type){
        this.name = name;
        this.code = code;
        this.type = type;
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public String getType(){
        return type;
    }

    public static Subject nextSubject(Scanner sc){
        return new Subject(sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public String toString(){
        return name;
    }
}