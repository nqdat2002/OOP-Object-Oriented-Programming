package OOPs.KhaiBaoLopvaDoiTuong;

import java.util.Scanner;

public class J04007 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String name = ip.nextLine(), sex = ip.nextLine(), date = ip.nextLine(), address = ip.nextLine(), phone = ip.nextLine(), st_date = ip.nextLine();
        NhanVien a = new NhanVien(name, sex, date, address, phone, st_date);
        a.Show();
        ip.close();
    }
}
class NhanVien{
    private String name, sex, date, address, phone, st_date;

    public NhanVien(){
        this.name = this.sex = this.date = this.address = this.phone = this.st_date = "";
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

    public void Show(){
        String s = this.date;
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        this.date = s;

        s = this.st_date;
        if(s.charAt(1) == '/') s = "0" + s;
        if(s.charAt(4) == '/') s = s.substring(0, 3) + "0" + s.substring(3, s.length());
        this.st_date = s;

        System.out.print("00001 ");
        System.out.print(this.name + " " + this.sex + " " + this.date + " " + this.address + " " + this.phone + " " + this.st_date);
        System.out.println();
    }
}