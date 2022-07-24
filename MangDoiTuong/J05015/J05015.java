package OOPs.MangDoiTuong.J05015;

import java.util.ArrayList;
import java.util.Collections;
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
    }
}

class Racing implements Comparable<Racing>{
    private final int s = 120 * 60;
    private String name, code, addresss, time_start;
    private int speed;

    public Racing(){
        this.name = this.code = this.addresss = this.time_start = "";
        this.speed = 0;
    }

    public Racing(String name, String address, String time_start){
        this.name = name;
        this.addresss = address;
        this.time_start = time_start;
        this.code = "";

        String [] a = address.split(" ");
        for(int i = 0; i < a.length; ++i){
            this.code += ("" + a[i].charAt(0));
        }
        String [] b = name.split(" ");
        for(int i = 0; i < b.length; ++i){
            this.code += ("" + b[i].charAt(0));
        }

        int minute = (this.time_start.charAt(0) - 48 - 6) * 60 + Integer.valueOf(this.time_start.substring(2, 4));
        this.speed = (int) (Math.round((double)(s / minute)));
    }

    public static Racing nextRacing(Scanner sc){
        return new Racing(sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    public int getSpeed(){
        return speed;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + addresss + " " + speed + " Km/h";
    }

    @Override
    public int compareTo(Racing o) {
        return (int) (o.getSpeed() - this.getSpeed());
    }
}
