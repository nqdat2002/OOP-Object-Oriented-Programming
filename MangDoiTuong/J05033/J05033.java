package OOPs.MangDoiTuong.J05033;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05033 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<Time> A = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            A.add(Time.nextTime(sc));
        }
        Collections.sort(A, new Comparator<Time>(){
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.getHour() != o2.getHour()){
                    return (int)(o1.getHour() - o2.getHour());
                }
                if(o1.getMinute() != o2.getMinute()){
                    return (int)(o1.getMinute() - o2.getMinute());
                }
                return (int) (o1.getSecond() - o2.getSecond());
            }
        });
        for(Time x: A) x.Show();
        
        sc.close();
    }
}

class Time{
    private int hour, minute, second;

    public Time(){
        this.hour = this.minute = this.second = 0;
    }
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
    public static Time nextTime(Scanner sc){
        Time a = new Time();
        a.hour = sc.nextInt();
        a.minute = sc.nextInt();
        a.second = sc.nextInt();
        return a;
    }

    public void Show(){
        System.out.println(this.hour + " " + this.minute + " " + this.second);
    }
}
