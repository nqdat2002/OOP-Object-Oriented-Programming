package OOPs.MangDoiTuong.J05016;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05016 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
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
    private long count, cost, sum_cost;

    public Customer(){
        this.CustomerCode = this.RoomCode = this.name = this.date_end = this.date_start;
        this.count = this.cost = this.sum_cost = 0;
    }

    public Customer(int cnt, String name, String Roomcode, String date_start, String date_end, long cost) {
        this.CustomerCode = setCustomerCode(cnt);
        this.name = name;
        trueName();
        this.RoomCode = Roomcode;
        this.date_end = trueDate(date_end);
        this.date_start = trueDate(date_start);
        this.cost = cost;
        this.setCount();
        if(this.getRoom().compareTo("1") == 0) this.sum_cost = (long)25 * getCount() + getCost();
        if(this.getRoom().compareTo("2") == 0) this.sum_cost = (long)34 * getCount() + getCost();
        if(this.getRoom().compareTo("3") == 0) this.sum_cost = (long)50 * getCount() + getCost();
        if(this.getRoom().compareTo("4") == 0) this.sum_cost = (long)80 * getCount() + getCost();
        
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
            getDiff /= (long)(24 * 60 * 60 * 1000);
            this.count =  (long)(getDiff + 1);
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
    public String getRoom(){
        return RoomCode.substring(0, 1);
    }
    public long getCount(){
        return count;
    }
    public long getCost(){
        return cost;
    }
    public long getSum_cost(){
        return sum_cost;
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

    public static Customer nextCustomer(Scanner sc, int cnt){
        return new Customer(cnt, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine()));
    }

    @Override
    public String toString(){
        return CustomerCode + " " + name + " " + RoomCode + " " +  count + " " + sum_cost;
    }

    @Override
    public int compareTo(Customer o) {
        return (int) (o.getSum_cost() - this.getSum_cost());
    }
}