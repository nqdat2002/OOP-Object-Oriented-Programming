package OOPs.VaoRaFile.J07056;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07056 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        //Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Electronic> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) {list.add(Electronic.nextElectronic(sc, i)); x = sc.nextLine(); x.isEmpty();}
        Collections.sort(list);
        for (Electronic mark : list) {
            System.out.println(mark);
        }
    }
}
class Electronic implements Comparable<Electronic>{
    private String name, code, type;
    private long old_num, new_num, inLimit, outLimit, total, tax, limit, count;

    public Electronic(){
        this.name = this.code = this.type = "";
        this.old_num = this.new_num = this.count = this.inLimit = this.outLimit 
        = this.total = this.tax = this.count = 0;
    }

    public Electronic(String name, String type, long old_num, long new_num, int cnt){
        this.name = name; this.trueName();
        this.type = type;
        this.old_num = old_num;
        this.new_num = new_num;
        this.count = this.new_num - this.old_num;

        this.code = "KH" + (cnt > 9 ? cnt : ( "0" + cnt));
        if(this.type.compareTo("A") == 0) this.limit = 100;
        if(this.type.compareTo("B") == 0) this.limit = 500;
        if(this.type.compareTo("C") == 0) this.limit = 200;

        this.inLimit = (this.count < this.limit ? this.count * 450 : this.limit * 450);
        this.outLimit = (this.count > this.limit ?  (this.count - this.limit) * 1000 : 0);
        this.tax = (long) (0.05 * this.outLimit);
        this.total = this.inLimit + this.outLimit + this.tax;
    }

    public String Std(String s){
        String res = "";
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(i == 0){
                res += Character.toUpperCase(c);
            }
            else res += c;
        }
        return res;
    }

    public void trueName(){
        String s = this.name;
        s = s.trim();
        Vector<String> st = new Vector<>();
        String res = "";
        s = s + " ";
        s = s.toLowerCase();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' ' && res.length() > 0){
                res = res.toLowerCase();
                st.add(res);
                res = "";
            }
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')res += s.charAt(i);
        }
        res = "";
        for (String ss : st){
           res += (Std(ss) + " ");
        }
        res = res.substring(0, res.length() - 1);
        this.name = res;
    }

    public static Electronic nextElectronic(Scanner sc, int cnt){
        return new Electronic(sc.nextLine(), sc.next(), Long.valueOf(sc.next()) , Long.valueOf(sc.next()), cnt);
    }

    public Long getTotal(){
        return total;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + inLimit + " " + outLimit + " " + tax + " " + total;
    }

    @Override
    public int compareTo(Electronic o) {
        return (int)(o.getTotal() - this.getTotal());
    }
}
