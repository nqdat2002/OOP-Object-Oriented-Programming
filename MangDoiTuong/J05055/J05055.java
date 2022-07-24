package OOPs.MangDoiTuong.J05055;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05055 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Athlete> list = new ArrayList<>();
        List<Athlete> tmp = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            Athlete a = Athlete.nexAthlete(sc, i);
            list.add(a);
            tmp.add(a);
        }
        Collections.sort(tmp, new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2){
                return o1.getTotalTime().compareTo(o2.getTotalTime());
            }
        });
        String s = tmp.get(0).getTotalTime();
        int cnt = 1, q = 1;
        for (Athlete std : tmp) {
            if(std.getTotalTime().compareTo(s) == 0){
                std.setRank(cnt);
                q++;
                continue;
            }
            else if(std.getTotalTime().compareTo(s) > 0){
                std.setRank(q);
                s = std.getTotalTime();
                cnt = q;
                q++;
                continue;
            }
        }
        for (Athlete st : tmp) {
            for (Athlete a : list) {
                if(st.getTotalTime() == a.getTotalTime()){
                    a.setRank(Integer.valueOf(st.getRank()));
                }
            }
        }
        for (Athlete st : list) {
            System.out.println(st);
        }
        sc.close();
    }
}

class Athlete{
    private final int year = 2021;
    private String name, code, date, startTime, endTime;
    private String Pri_time, Real_time, Total_time;
    private String rank;

    public Athlete(){
        this.name = this.code = this.startTime = this.endTime = "";
        this.Pri_time = this.Real_time = this.Total_time = "";
        this.rank = "";
    }
    public Athlete(String name, String date, String startTime, String endTime, int cnt){
        this.setCode(cnt);
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.setPri_Time();
        this.Real_time = SubtractTime(this.startTime, this.endTime);
        this.Total_time = SubtractTime(this.Pri_time, this.Real_time);
    }

    public void setCode(int cnt){
        code = "VDV" + cnt;
        while(code.length() < 5) code = code.substring(0, 3) + "0" + code.substring(3);
    }

    public void setRank(int cnt){
        rank = "" + cnt;
    }

    public void setPri_Time(){
        String s = this.date;
        int age = this.year - Integer.valueOf(s.substring(6));
        if(age >= 32) Pri_time = "00:00:03";
        else if(age >= 25) Pri_time = "00:00:02";
        else if(age >= 18) Pri_time = "00:00:01";
        else Pri_time = "00:00:00";
    }

    public static String SubtractTime(String a, String b){
        int h1 = Integer.valueOf(a.substring(0, 2)), h2 = Integer.valueOf(b.substring(0, 2));
        int m1 = Integer.valueOf(a.substring(3, 5)), m2 = Integer.valueOf(b.substring(3, 5));
        int s1 = Integer.valueOf(a.substring(6)), s2 = Integer.valueOf(b.substring(6));
        long total1 = h1 * 3600 + m1 * 60 + s1, total2 = h2 * 3600 + m2 * 60 + s2;
        long dev = total2 - total1;
        int h3 = 0, m3 = 0, s3 = 0;
        while(dev >= 3600){
            h3 += dev / 3600;
            dev %= 3600;
        }
        while(dev >= 60){
            m3 += dev / 60;
            dev %= 60;
        }
        s3 = (int) dev;
        String s = "" + h3 + ":" + m3 + ":" + s3;
        if(s.charAt(1) == ':') s = "0" + s;
        if(s.charAt(4) == ':') s = s.substring(0, 3) + "0" + s.substring(3);
        if(s.length() < 8) s = s.substring(0, 6) + "0" + s.substring(6);
        return s;
    }

    public static Athlete nexAthlete(Scanner sc, int cnt){
        return new Athlete(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), cnt);
    }

    public String getTotalTime(){
        return Total_time;
    }
    public String getRank(){
        return rank;
    }

    @Override 
    public String toString(){
        return code + " " + name + " " + Real_time + " " + Pri_time + " " + Total_time + " " + rank;
    }
}
