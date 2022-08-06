package OOPs.MangDoiTuong.J05053;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05053 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Clothes> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Clothes.nextClothes(sc));
        Collections.sort(list);
        for (Clothes clo : list) {
            System.out.println(clo);
        }
    }
}

class Clothes implements Comparable<Clothes>{
    private String code, name;
    private long cost, discount, total;
    private int cnt;
    private String Num;

    public Clothes(){
        this.code = this.name = this.Num = "";
        this.cost = this.discount = this.total = 0;
        this.cnt = 0;
    }

    public Clothes(String name, String code, long cost, int cnt){
        this.name = name;
        this.code = code;
        this.cost = cost;
        this.cnt = cnt;
        this.Num = this.getNum();
        if(code.charAt(4) == '1') this.discount = (long) (this.cnt * this.cost * 0.5);
        else this.discount = (long)(this.cnt * this.cost * 0.3);
        this.total = (long) ((long) (this.cnt * this.cost) - this.discount);
    }

    public String getNum(){
        return code.substring(1, 4);
    }

    public static Clothes nextClothes(Scanner sc){
        return new Clothes(sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine()));
    }

    @Override
    public String toString(){
        return name + " " + code + " " + Num + " " + discount + " " + total;
    }

    @Override
    public int compareTo(Clothes o) {
        return this.getNum().compareTo(o.getNum());
    }
}