package OOP_TOT_NGHIEP.HuongDoiTuong.J05082;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J05082 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<KhachHang> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(KhachHang.nextKhachHang(sc, i));
        }
        Collections.sort(list);
        for (KhachHang kh: list){
            System.out.println(kh);
        }
    }
}
class KhachHang implements Comparable<KhachHang>{
    private String code;
    private String name, sex, date, address;

    public KhachHang(){
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

    public KhachHang(String name, String sex, String date, String address){
        this.name = name;
        this.sex = sex;
        this.date = date;
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

    public static String trueDate(String s){
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        return s;
    }

    public static KhachHang nextKhachHang(Scanner sc, int cnt){
        KhachHang a = new KhachHang();
        a.setCode(cnt);
        a.name = sc.nextLine();
        a.trueName();
        a.sex = sc.nextLine();
        a.date = trueDate(sc.nextLine());
        a.address = sc.nextLine();
        return a;
    }

    public void Show(){
        System.out.print(this.code + " ");
        System.out.print(this.name + " " + this.sex + " " + this.address + " " + this.date);
        System.out.println();
    }

    @Override
    public String toString(){
        return code + " " + name + " " + sex + " " + address + " " + date;
    }

    @Override
    public int compareTo(KhachHang o) {
        if(this.getYear() != o.getYear()){
            return (int)(this.getYear() - o.getYear());
        }
        if(this.getMonth() != o.getMonth()){
            return (int)(this.getMonth() - o.getMonth());
        }
        return (int)(this.getDay() - o.getDay());
    }
}