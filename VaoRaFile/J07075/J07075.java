package OOPs.VaoRaFile.J07075;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class J07075 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("MONHOC.in"));
        //Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Subject> subject = new ArrayList<>();
        for(int i = 1; i <= n; ++i) subject.add(Subject.nextSubject(sc));

        sc = new Scanner(new File("LICHGD.in"));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Schedule> schedules = new ArrayList<>();
        for(int i = 1; i <= m; ++i) schedules.add(Schedule.nextSchedule(sc, i));
        Collections.sort(schedules);

        String teach = sc.nextLine();

        System.out.println("LICH GIANG DAY GIANG VIEN " + teach + ":");

        for (Schedule schedule : schedules) {
            for(Subject sub : subject){
                if(schedule.getNameTeacher().compareTo(teach) == 0 && sub.getCode().compareTo(schedule.getCodeSubject()) == 0){
                    System.out.print(schedule.getCodeGroup() + " ");
                    System.out.print(sub.getName() + " ");
                    System.out.println(schedule.getOrder() + " " + schedule.getPeriod() + " " + schedule.getRoom());
                    break;
                }
            }
        }

        sc.close();
    }
}

class Schedule implements Comparable<Schedule>{
    private String codeSubject, period, order, room, nameTeacher, codeGroup;

    public Schedule(){
        this.codeGroup = this.period = this.order = this.room = this.nameTeacher = this.codeSubject = "";
    }
    public Schedule(String codeSubject, String order, String period, String nameTeacher, String room, int cnt){
        this.codeSubject = codeSubject;
        this.order = order;
        this.period = period;
        this.nameTeacher = nameTeacher;
        this.room = room;
        this.codeGroup = "HP" + cnt;
        while(this.codeGroup.length() < 5) 
            this.codeGroup = this.codeGroup.substring(0, 2) + "0" + this.codeGroup.substring(2);
    }

    public String getCodeSubject(){
        return codeSubject;
    }
    public String getPeriod(){
        return period;
    }
    public String getOrder(){
        return order;
    }
    public String getRoom(){
        return room;
    }
    public String getNameTeacher(){
        return nameTeacher;
    }
    public String getCodeGroup(){
        return codeGroup;
    }

    public static Schedule nextSchedule(Scanner sc, int cnt){
        return new Schedule(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), cnt);
    }

    @Override
    public String toString(){
        return codeGroup + " " + order + " " + period + " " + nameTeacher + " " + room;
    }

    @Override
    public int compareTo(Schedule o) {
        if(this.getOrder().compareTo(o.getOrder()) != 0){
            return this.getOrder().compareTo(o.getOrder());
        }
        if(this.getPeriod().compareTo(o.getPeriod()) != 0){
            return this.getPeriod().compareTo(o.getPeriod());
        }
        return this.getNameTeacher().compareTo(o.getNameTeacher());
    }
}

class Subject{
    private String name, code;
    private int count;

    public Subject(){
        this.name = this.code = "";
        this.count = 0;
    }

    public Subject(String code, String name, int count){
        this.name = name;
        this.code = code;
        this.count = count;
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public int getType(){
        return count;
    }

    public static Subject nextSubject(Scanner sc){
        return new Subject(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()));
    }
}