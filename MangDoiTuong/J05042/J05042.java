package OOPs.MangDoiTuong.J05042;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// not Accept
public class J05042 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<Rank> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(Rank.nextRank(sc));
        }
        Collections.sort(list);
        for (Rank ts : list) {
            System.out.print(ts);
        }
        sc.close();
    }
}

class Rank implements Comparable<Rank>{
    private String name;
    private long accept, total;
    
    public Rank(){
        this.name = "";
        this.accept = this.total = 0;
    }

    public Rank(String name, long accept, long total){
        this.name = name;
        this.accept = accept;
        this.total = total;
    }

    public long getAccept(){
        return accept;
    }
    public long getTotal(){
        return total;
    }
    public String getName(){
        return name;
    }

    public static Rank nextRank(Scanner sc){
        Rank a = new Rank();
        a.name = sc.nextLine();
        a.accept = sc.nextLong();
        a.total = sc.nextLong();
        String x = sc.nextLine();
        x.isEmpty();
        return a;
    }

    @Override
    public int compareTo(Rank o) {
        if(this.getAccept() != o.getAccept())
            return (int)(o.getAccept() - this.getAccept());
        if(this.getTotal() != o.getTotal())
            return (int)(this.getTotal() - o.getTotal());
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString(){
        return name + " " + accept + " " + total + "\n";
    }
}
