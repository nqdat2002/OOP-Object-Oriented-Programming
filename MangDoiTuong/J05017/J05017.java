package OOPs.MangDoiTuong.J05017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Water> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Water.nextWater(sc, i));
        Collections.sort(list);
        for (Water racing : list) {
            System.out.println(racing);
        }
    }
}
class Water implements Comparable<Water>{
    private String name, code;
    private long old_num, new_num, total;

    public Water(){
        this.name = this.code = "";
        this.old_num = this.new_num = this.total = 0;
    }

    public Water(String name, long old_num, long new_num, int cnt){
        this.name = name;
        this.old_num = old_num;
        this.new_num = new_num;
        this.code = "KH" + (cnt > 9 ? cnt : ("0" + cnt));

        int count = (int) (this.new_num - this.old_num);
        if(count <= 50) this.total = (long) (Math.round((double)(count * 100 * 1.02)));
        else if(count <= 100){
            int c = count - 50;
            this.total = (long) (Math.round((double)((c * 150 + 50 * 100) * 1.03)));
        }
        else{
            int c = count - 100;
            this.total = (long)(Math.round((double)((c * 200 + 50 * 150 + 50 * 100) * 1.05)));
        }
    }

    public static Water nextWater(Scanner sc, int cnt){
        return new Water(sc.nextLine(), Long.valueOf(sc.nextLine()), Long.valueOf(sc.nextLine()), cnt);
    }

    public long getTotal(){
        return total;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + total;
    }

    @Override
    public int compareTo(Water o) {
        if(o.getTotal() > this.getTotal()){
            return 1;
        }
        return -1;
    }
}