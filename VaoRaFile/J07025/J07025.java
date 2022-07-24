package OOPs.VaoRaFile.J07025;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J07025{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<NhanVien> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(NhanVien.nextNhanVien(sc, i));
        }
        Collections.sort(list);
        for (NhanVien nv : list) {
            System.out.println(nv);
        }
        sc.close();
    }
}
class NhanVien implements Comparable<NhanVien>{
    private String code;
    private String name, sex, date, address;

    public NhanVien(){
        this. code = this.name = this.sex = this.date = this.address = "";
    }

    public void setCode(int cnt){
        String s = "KH" + cnt;
        while(s.length() < 5) s = s.substring(0, 2) + "0" + s.substring(2);
        this.code = s;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSet(String sex){
        this.sex = sex;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public NhanVien(String name, String sex, String date, String address, int cnt){
        this.setCode(cnt);
        this.name = name;
        this.trueName();
        this.sex = sex;
        this.date = date;
        trueDate();
        this.address = address;
    }

    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public String getSex(){
        return sex;
    }
    public String getDate(){
        return date;
    }
    public String getAddress(){
        return address;
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
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') res += s.charAt(i);
        }
        res = "";
        for (String ss : st){
           res += (Std(ss) + " ");
        }
        this.name = res;
    }

    public void trueDate(){
        if(this.date.charAt(1) == '/') this.date = "0" + this.date;
        if(this.date.charAt(4) == '/') this.date = this.date.substring(0, 3) + "0" + this.date.substring(3);
    }

    public static NhanVien nextNhanVien(Scanner sc, int cnt){
        return new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), cnt);
    }

    @Override
    public String toString(){
        return code + " " + name + sex + " " + address + " " + date;
    }

    @Override
    public int compareTo(NhanVien o) {
        if(o.getYear() != this.getYear()){
            return (int) (this.getYear() - o.getYear());
        }
        if(o.getMonth() != this.getMonth()){
            return (int) (this.getMonth() - o.getMonth());
        }
        return (int)(this.getDay() - o.getDay());
    }

}