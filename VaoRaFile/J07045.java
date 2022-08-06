//
package OOPs.VaoRaFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}

class LoaiPhong implements Comparable<LoaiPhong>{
    private String type, name;
    private int day;
    private double cost;

    public LoaiPhong(){
        this.type = this.name = "";
        this.day = 0;
        this.cost = 0;
    }

    public Vector<String> trueLine(String a){
        String arr[] = a.split(" ");
        Vector<String> st = new Vector<>();
        for(int i = 0; i < arr.length; ++i) st.add(arr[i]);
        return st;
    }

    public LoaiPhong(String s){
        Vector<String> v = trueLine(s);
        this.type = v.get(0);
        this.name = v.get(1);
        this.day = Integer.valueOf(v.get(2));
        this.cost = Double.valueOf(v.get(3));
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return this.name.compareTo(o.getName());
    }
    
    @Override
    public String toString(){
        return this.type + " " + this.name + " " + this.day + " " + this.cost;
    }
}