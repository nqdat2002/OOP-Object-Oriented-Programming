package OOP_TOT_NGHIEP.HuongDoiTuong.J05007;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class J05007{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<NhanVien> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(NhanVien.nextNhanVien(sc, i));
        }
        Collections.sort(list, new Comparator<NhanVien>(){
            @Override
            public int compare(NhanVien o1, NhanVien o2){
                if(o1.getYear() != o2.getYear())
                    return (int) (o1.getYear() - o2.getYear());
                
                if(o1.getMonth() != o2.getMonth())
                    return (int) (o1.getMonth() - o2.getMonth());
                
                return (int)(o1.getDay() - o2.getDay());
            }
        });
        for (NhanVien nv : list) {
            nv.Show();
        }
        sc.close();
    }
}
class NhanVien{
    private String code;
    private String name, sex, date, address, phone, st_date;

    public NhanVien(){
        this. code = this.name = this.sex = this.date = this.address = this.phone = this.st_date = "";
    }

    public void setCode(int cnt){
        String s = "000" + cnt;
        while(s.length() < 5) s = s.substring(0, 3) + "0" + s.substring(3);
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
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setSt_date(String st_date){
        this.st_date = st_date;
    }

    public NhanVien(String name, String sex, String date, String address, String phone, String st_date){
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.st_date = st_date;
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
    public String getPhone(){
        return phone;
    }
    public String getSt_Date(){
        return st_date;
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

    public static NhanVien nextNhanVien(Scanner sc, int cnt){
        NhanVien a = new NhanVien();
        a.setCode(cnt);
        a.name = sc.nextLine();
        a.sex = sc.nextLine();
        a.date = trueDate(sc.nextLine());
        a.address = sc.nextLine();
        a.phone = sc.nextLine();
        a.st_date = sc.nextLine();
        return a;
    }

    public void Show(){
        System.out.print(this.code + " ");
        System.out.print(this.name + " " + this.sex + " " + this.date + " " + this.address + " " + this.phone + " " + this.st_date);
        System.out.println();
    }
}