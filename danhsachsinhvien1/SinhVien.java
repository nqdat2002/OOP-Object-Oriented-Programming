package OOPs.danhsachsinhvien1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SinhVien implements Serializable{
    private String ma, ten, lop;
    private Date ngaysinh;
    private float gpa;

    public SinhVien(int id, String ten, String lop, String ngaysinh){
        this.ma = "B20DCCN" + id;
        while(this.ma.length() < 10) this.ma = this.ma.substring(0, 7) + "0" + this.ma.substring(7);
        DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = (Date) simpleDateFormat.parse(ngaysinh);
            this.ngaysinh = date;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.ten = ten;
        this.lop = lop;
    }
    
    public String toString(){
        return ma + " " + ten + " " + lop + " " + ngaysinh + " " + String.format("%.2f", (double)gpa);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ArrayList<SinhVien> array = new ArrayList<>();
        FileInputStream sc = new FileInputStream("SV.in");
        try{
            ObjectInputStream readStream = new ObjectInputStream(sc);
            //array = (ArrayList<SinhVien>) readStream.readObject();
            array = new ArrayList<>();
            readStream.readObject();
            readStream.close();
        }catch(ClassNotFoundException e){
            
        }
        sc.close();
        for (SinhVien sinhVien : array) {
            System.out.println(sinhVien);
        }
    }
}