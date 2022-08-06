package OOPs.MangDoiTuong.J05006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05006{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<NhanVien> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(NhanVien.nextNhanVien(sc, i));
        }
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