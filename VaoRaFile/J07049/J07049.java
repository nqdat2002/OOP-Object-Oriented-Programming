package OOPs.VaoRaFile.J07049;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class J07049 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Product> hsP = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            hsP.put(id, new Product(id, sc.nextLine(), Long.parseLong(sc.nextLine()),Integer.parseInt(sc.nextLine())));
        }
        ArrayList<List> arrL = new ArrayList<>();
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String id = String.format("KH%02d", i + 1);
            Customer cus = new Customer(id, sc.nextLine(), sc.nextLine(), sc.nextLine(),Integer.parseInt(sc.nextLine()), sc.nextLine());
            Product pro = hsP.get(cus.getMaSP());
            arrL.add(new List(cus, pro));
        }
        Collections.sort(arrL);
        for(List l : arrL){
            System.out.println(l);
        }
        sc.close();
    }
}
class List implements Comparable<List> {
    private Customer customer;
    private Product product;

    public List(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
    }

    private Date tinhNgayHetHan(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.customer.getNgaymua());
        calendar.add(Calendar.MONTH, this.product.getTgianBaoHanh());
        return calendar.getTime();
    }

    public int compareTo(List o){
        if(this.tinhNgayHetHan().equals(o.tinhNgayHetHan())){
            return this.customer.getMa().compareTo(o.customer.getMa());
        }
        return this.tinhNgayHetHan().compareTo(o.tinhNgayHetHan());
    }

    public String toString(){
        return customer + " " +  this.customer.getSoLuong() * this.product.getGiaBan() + " " + new SimpleDateFormat("dd/MM/yyyy").format(tinhNgayHetHan());
    }

}

class Customer {
    private String ma;
    private String hoVaTen;
    private String diaChi;
    private String maSP;
    private Integer soLuong;
    private Date ngaymua;
    private String day;

    public Customer(String ma, String hoVaTen, String diaChi, String maSP, Integer soLuong, String ngaymua) throws ParseException {
        this.ma = ma;
        this.hoVaTen = hoVaTen;
        this.diaChi = diaChi;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.day = ngaymua.substring(0,2);
        this.ngaymua = new SimpleDateFormat("dd/MM/yyyy").parse(ngaymua);
    }

    public String getDay() {
        return day;
    }

    public String getMa() {
        return ma;
    }

    public String getMaSP() {
        return maSP;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public String toString(){
        return ma + " " + hoVaTen + " " + diaChi + " " + maSP;
    }
}

class Product {
    private String ma;
    private String ten;
    private Long giaBan;
    private Integer tgianBaoHanh;

    public Product(String ma, String ten, Long giaBan, Integer tgianBaoHanh) {
        this.ma = ma;
        this.ten = ten;
        this.giaBan = giaBan;
        this.tgianBaoHanh = tgianBaoHanh;
    }

    public Long getGiaBan() {
        return giaBan;
    }
    public String getMa(){
        return ma;
    }
    public String getTen(){
        return ten;
    }

    public Integer getTgianBaoHanh() {
        return tgianBaoHanh;
    }
}