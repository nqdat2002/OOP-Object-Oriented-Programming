package OOPs.MangDoiTuong.J05032;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05032 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<Age> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Age.nextAge(sc));
        Collections.sort(list, new Comparator<Age>(){
            @Override
            public int compare(Age o1, Age o2){
                if(o1.getYear() != o2.getYear()){
                    return (int) (o1.getYear() - o2.getYear());
                }
                if(o1.getMonth() != o2.getMonth()){
                    return (int) (o1.getMonth() - o2.getMonth());
                }
                return (int)(o1.getDay() - o2.getDay());
            }
        });
        list.get(n - 1).Show();
        list.get(0).Show();
        sc.close();
    }
}

class Age{
    private String name, date;

    public Age(){
        this.name = this.date;
    }

    public Age(String name, String date){
        this.name = name;
        this.date = date;
    }

    public static Age nextAge(Scanner sc){
        Age a = new Age(sc.next(), sc.next());
        return a;
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

    public void Show(){
        System.out.println(this.name);
    }
}