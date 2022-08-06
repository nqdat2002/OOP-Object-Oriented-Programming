package OOPs.MangDoiTuong.J05015;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class J05015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Racing> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Racing.nextRacing(sc));
        Collections.sort(list);
        for (Racing racing : list) {
            System.out.println(racing);
        }
        sc.close();
    }
}

class Racing implements Comparable<Racing>{
    private String name, code, addresss, time_end;
    private int speed, minute;

    public Racing(){
        this.name = this.code = this.addresss = this.time_end = "";
        this.speed = this.minute = 0;
    }

    public Racing(String name, String address, String time_end){
        this.name = name;
        this.addresss = address;
        this.time_end = time_end;
        this.code = "";

        String ss = address + " " + name;
        for(int i = 0; i < ss.length(); ++i)
            if(ss.charAt(i) >= 'A' && ss.charAt(i) <= 'Z')
                this.code += ("" + ss.charAt(i));

        DateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        long getDiff = 0;
        try {
            String startDate = "6:00";
            String endDate = getTimeEnd();
            Date date1 = (Date) simpleDateFormat.parse(startDate);
            Date date2 = (Date) simpleDateFormat.parse(endDate);
            getDiff = (long) (date2.getTime() - date1.getTime());
            getDiff /= (long)(60 * 1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.minute = (int)getDiff;
        String st = String.format("%.0f", (double) 120 * 60 / minute);
        this.speed = Integer.valueOf(st);
    }

    public static Racing nextRacing(Scanner sc){
        return new Racing(sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    public int getSpeed(){
        return speed;
    }
    public String getTimeEnd(){
        return time_end;
    }
    public int getMinute(){
        return minute;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + addresss + " " + speed + " Km/h";
    }

    @Override
    public int compareTo(Racing o) {
        if(o.getMinute() < this.getMinute()){
            return 1;
        }
        return -1;
    }
}
