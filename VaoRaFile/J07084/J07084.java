package OOPs.VaoRaFile.J07084;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07084 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("ONLINE.in"));
        ///Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<TimeUse> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(TimeUse.nextTimeUse(sc));
        Collections.sort(list);
        for (TimeUse t: list) {
            System.out.println(t);
        }
        sc.close();
    }
    
}
class TimeUse implements Comparable<TimeUse>{
    private String name, date_start, date_end;
    private long count;

    public TimeUse(){
        this.name = this.date_end = this.date_start;
        this.count = 0;
    }

    public TimeUse(String name, String date_start, String date_end) {
        this.name = name;
        this.date_end = date_end;
        this.date_start = date_start;
        this.setCount();
    }

    public void setCount(){
        DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        long getDiff = 0;
        try {
            String startDate = getDateStart();
            String endDate = getDateEnd();
            Date date1 = (Date) simpleDateFormat.parse(startDate);
            Date date2 = (Date) simpleDateFormat.parse(endDate);
            getDiff = (long) (date2.getTime() - date1.getTime());
            getDiff /= (long)(60 * 1000);
            this.count =  (long)(getDiff);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getName(){
        return name;
    }
    public String getDateStart(){
        return date_start;
    }
    public String getDateEnd(){
        return date_end;
    }
    public long getCount(){
        return count;
    }

    public static TimeUse nextTimeUse(Scanner sc){
        return new TimeUse(sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public String toString(){
        return name + " " +  count;
    }

    @Override
    public int compareTo(TimeUse o) {
        if(this.getCount() != o.getCount()){
            return (int)(o.getCount() - this.getCount());
        }
        return this.getName().compareTo(o.getName());
    }
}