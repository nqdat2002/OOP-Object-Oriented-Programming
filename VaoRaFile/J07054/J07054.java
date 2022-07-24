package OOPs.VaoRaFile.J07054;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07054 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        //Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<AverageMark> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(AverageMark.nextAverageMark(sc, i));
        Collections.sort(list, new Comparator<AverageMark>(){
            @Override
            public int compare(AverageMark o1, AverageMark o2) {
                if((int)100 * (o2.getPoint() - o1.getPoint()) != 0)
                    return (int) ((int)100 * (o2.getPoint() - o1.getPoint()));
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        double pointmax = list.get(0).getPoint();
        int cnt = 1, q = 1;
        for (AverageMark std : list) {
            if(std.getPoint() == pointmax){
                std.setRank(cnt);
                q++;
                continue;
            }
            else if((int) 100 * std.getPoint() < (int) 100 * pointmax){
                std.setRank(q);
                pointmax = std.getPoint();
                cnt = q;
                q++;
                continue;
            }
        }
        for (AverageMark avg : list) {
            System.out.println(avg);
        }
        sc.close();
    }
}

class AverageMark{
    private String name, code, rank;
    private double p1, p2, p3, p;

    public AverageMark(){
        this.name = this.code = this.rank = "";
        this.p1 = this.p2 = this.p3 = this.p;
    }
    public AverageMark(String name, double p1, double p2, double p3, int cnt){
        this.code = "SV" + (cnt >= 10 ? cnt : ("0" + cnt));
        this.name = name; this.trueName();
        this.p1 = p1; 
        this.p2 = p2; 
        this.p3 = p3;
        this.p = this.p1 * 3 + this.p2 * 3 + this.p3 * 2;
        this.p /= 8;
        this.p = (double)Math.round((double) (p) * 100) / 100;
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
        this.name = res;
    }

    public static AverageMark nextAverageMark(Scanner sc, int cnt){
        return new AverageMark(sc.nextLine(), Double.valueOf(sc.nextLine()), 
                                Double.valueOf(sc.nextLine()), Double.valueOf(sc.nextLine()), cnt);
    }

    public void setRank(int cnt){
        this.rank = "" + cnt;
    }

    public String getRank(){
        return rank;
    }
    
    public double getPoint(){
        return p;
    }
    public String getCode(){
        return code;
    }

    @Override
    public String toString(){
        return code + " " + name + String.format("%.2f", (double)p) + " " + rank;
    }
}
