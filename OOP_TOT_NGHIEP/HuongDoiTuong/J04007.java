package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class J04007 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        NhanVien a = NhanVien.nextNhanVien(sc);
        System.out.println(a);
        sc.close();
    }
}

class NhanVien {
    private String name, sex, address, phone, code;
    private Date date, st_date;

    public NhanVien() {
        this.name = this.sex = this.address = this.phone = "";
        this.code = "";
        this.date = new Date();
        this.st_date = new Date();
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

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public Date getDate(){
        return date;
    }

    public Date getSt_Date(){
        return st_date;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSet(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDate(String date){

    }

    public void setSTDate(){
        
    }

    public NhanVien(String name, String sex, String date, String address, String phone, String st_date) throws ParseException {
        this.code = "00001";
        this.name = name;
        this.sex = sex;
        this.date = (new SimpleDateFormat("dd/MM/yyyy").parse(date));
        this.address = address;
        this.phone = phone;
        this.st_date = (new SimpleDateFormat("dd/MM/yyyy").parse(st_date));
    }

    public static NhanVien nextNhanVien(Scanner sc) throws ParseException {
        return new NhanVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public String toString() {
        return code + " " + name + " " + sex + " " + new SimpleDateFormat("dd/MM/yyyy").format(date) + " " + address + " " +
        phone + " " + new SimpleDateFormat("dd/MM/yyyy").format(st_date);
    }
}