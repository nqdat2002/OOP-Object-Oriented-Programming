package OOP_TOT_NGHIEP.HuongDoiTuong.J05011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05011 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<TimeGame> A = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            A.add(TimeGame.nextTimeGame(sc));
        }
        Collections.sort(A, new Comparator<TimeGame>(){
            @Override
            public int compare(TimeGame o1, TimeGame o2) {
                if(o1.getHour() != o2.getHour())
                    return (int) (o2.getHour() - o1.getHour());
                return (int) (o2.getMinute() - o1.getMinute());
            }
        });
        for(TimeGame x: A) x.Show();
        sc.close();
    }
}

class TimeGame{
    private String code, name;
    private String st, en;
    private int h, m;

    public TimeGame(){
        this.code = this.name = this.st = this.en = "";
        this.h = this.m = 0;
    }
    public TimeGame(String name, String code, String st, String en){
        this.name = name;
        this.code = code;
        this.st = st;
        this.en = en;
    }

    public int getHour(){
        return h;
    }

    public int getMinute(){
        return m;
    }

    public static TimeGame nextTimeGame(Scanner sc){
        TimeGame a = new TimeGame();
        a.code = sc.nextLine();
        a.name = sc.nextLine();
        a.st = sc.nextLine();
        a.en = sc.nextLine();
        a.h = (Integer.valueOf(a.en.substring(0, 2)) - Integer.valueOf(a.st.substring(0, 2)));
        a.m = (Integer.valueOf(a.en.substring(3)) - Integer.valueOf(a.st.substring(3)));
        return a;
    }

    public void Show(){
        int hour = 0, minute = 0;
        minute = 60 * this.h + this.m;
        while(minute >= 60){
            hour = minute / 60;
            minute -= hour * 60;
        }
        System.out.println(this.code + " " + this.name + " " + hour + " gio " + minute + " phut");
    }
}