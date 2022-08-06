package OOPs.VaoRaFile.J07059;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07059 {
    public static void main(String [] args) throws FileNotFoundException{
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("CATHI.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Shift> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Shift.nextShift(sc, i));
        Collections.sort(list);
        for (Shift sf : list) {
            System.out.println(sf);
        }
        sc.close();
    }
}

class Shift implements Comparable<Shift>{
    private String code, date, room, time;
    
    public Shift(){
        this.code = this.date = this.room = this.time = "";
    }
    public String setCode(int cnt){
        String x = "C" + cnt;
        while(x.length() < 4) x = x.substring(0, 1) + "0" + x.substring(1);
        return x;
    }
    public Shift(int cnt, String date, String time, String room){
        this.code = setCode(cnt);
        this.date = date;
        this.time = time;
        this.room = room;
    }

    public static Shift nextShift(Scanner sc, int cnt){
        return new Shift(cnt, sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    public int getYear(){
        String s = this.date;
        return 1000 * (s.charAt(6) - 48) + 100 * (s.charAt(7) - 48) + 10 * (s.charAt(8) - 48) + s.charAt(9) - 48;
    }
    public int getMonth(){
        String s = this.date;
        return 10 * (s.charAt(3) - 48) + s.charAt(4) - 48;
    }
    public int getDay(){
        String s = this.date;
        return 10 * (s.charAt(0) - 48) + s.charAt(1) - 48;
    }
    public int getHour(){
        String s = this.time;
        return 10 * (s.charAt(0) - 48) + s.charAt(1) - 48;
    }
    public int getMinute(){
        String s = this.time;
        return 10 * (s.charAt(3) - 48) + s.charAt(4) - 48;
    }
    public String getCode(){
        return code;
    }

    @Override
    public String toString(){
        return code + " " + date + " " + time + " " + room;
    }

    @Override
    public int compareTo(Shift o) {
        if(this.getYear() != o.getYear()){
            return (int) (this.getYear() - o.getYear());
        }
        if(this.getMonth() != o.getMonth()){
            return (int) (this.getMonth() - o.getMonth());
        }
        if(this.getDay() != o.getDay()){
            return (int) (this.getDay() - o.getDay());
        }
        if(this.getHour() != o.getHour()){
            return (int) (this.getHour() - o.getHour());
        }
        if(this.getMinute() != o.getMinute()){
            return (int) (this.getMinute() - o.getMinute());
        }
        return this.getCode().compareTo(o.getCode());
    }

}