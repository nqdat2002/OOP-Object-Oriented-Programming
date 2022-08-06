package OOPs.VaoRaFile.J07046;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07046 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("KHACH.in"));
       //Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Customer> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Customer.nextCustomer(sc, i));
        Collections.sort(list);
        for (Customer nv : list) {
            System.out.println(nv);
        }
        sc.close();
    }
    
}
class Customer implements Comparable<Customer>{
    private String CustomerCode, RoomCode, name, date_start, date_end;
    private long count;

    public Customer(){
        this.CustomerCode = this.RoomCode = this.name = this.date_end = this.date_start;
        this.count = 0;
    }

    public Customer(int cnt, String name, String Roomcode, String date_start, String date_end) {
        this.CustomerCode = setCustomerCode(cnt);
        this.name = name;
        this.RoomCode = Roomcode;
        this.date_end = date_end;
        this.date_start = date_start;
        this.setCount();;
    }

    public String setCustomerCode(int cnt){
        String x = "KH" + cnt;
        while(x.length() < 4) x = x.substring(0, 2) + "0" + x.substring(2);
        return x;
    }

    public void setCount(){
        DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        long getDiff = 0;
        try {
            String startDate = getDateStart();
            String endDate = getDateEnd();
            Date date1 = (Date) simpleDateFormat.parse(startDate);
            Date date2 = (Date) simpleDateFormat.parse(endDate);
            getDiff = (long) (date2.getTime() - date1.getTime());
            this.count =  (long)(getDiff / (24 * 60 * 60 * 1000));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getDateStart(){
        return date_start;
    }
    public String getDateEnd(){
        return date_end;
    }

    public long getCount(){
        return count;
    }

    public static Customer nextCustomer(Scanner sc, int cnt){
        return new Customer(cnt, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public String toString(){
        return CustomerCode + " " + name + " " + RoomCode + " " + count;
    }

    @Override
    public int compareTo(Customer o) {
        return (int) (o.getCount() - this.getCount());
    }
}
