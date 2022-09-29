package danhsachsinhvien1;

import java.text.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("SV.in"));
        ArrayList<SinhVien> ds = (ArrayList<SinhVien>) sc.readObject();
        for(SinhVien tmp : ds){
            System.out.println(tmp);
        }
        sc.close();
    }
}
