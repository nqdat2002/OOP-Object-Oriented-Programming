package OOPs.VaoRaFile.J07047;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07047 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        //Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Room> room = new ArrayList<>();
        for(int i = 1; i <= m; ++i) room.add(Room.nextRoom(sc));

        String x = sc.nextLine();
        x.isEmpty();
        x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Customer> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Customer.nextCustomer(sc, i));
        for (Customer nv : list) {
            for(Room rm : room){
                if(nv.getRoomCode().compareTo(rm.getCode()) == 0){
                    nv.setCost(rm.getDayCost(), rm.getRate());
                    break;
                }
            }
        }
        Collections.sort(list);
        for(Customer cus: list){
            System.out.println(cus);
        }
        sc.close();
    }
    
}
class Customer implements Comparable<Customer>{
    private String CustomerCode, RoomCode, name, date_start, date_end;
    private long count, cost, sum_cost;
    private double rate, total, discount, surcharge;

    public Customer(){
        this.CustomerCode = this.RoomCode = this.name = this.date_end = this.date_start;
        this.count = this.cost = this.sum_cost = 0;
        this.rate = this.total = this.discount = this.surcharge = 0;
    }

    public Customer(int cnt, String name, String Roomcode, String date_start, String date_end) {
        this.CustomerCode = setCustomerCode(cnt);
        this.name = name;
        this.RoomCode = Roomcode;
        this.date_end = date_end;
        this.date_start = date_start;
        this.setCount();
        this.cost = 0;       
        this.rate = 0; 
        this.discount = 0;
        this.total = 0;
        this.surcharge = 0;
    }

    public void setCost(long RoomCost, double Roomrate){
        this.cost = RoomCost;
        this.rate = Roomrate;
        int c = (int) this.count;
        if(c == 0) c = 1;
        this.sum_cost = (long)(this.cost * c);
        this.surcharge = (double)(this.rate * this.sum_cost);
        this.total = sum_cost + this.surcharge;
        if(this.count >= 30) this.discount = (double)(this.total * 0.06);
        else if(this.count >= 20) this.discount = (double)(this.total * 0.04);
        else if(this.count >= 10) this.discount = (double)(this.total * 0.02);
        else this.discount = 0;
        this.total = (double)(this.total - this.discount);
        //this.total = Math.round(this.total * 100) / 100;
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
            this.count =  (long)(getDiff);
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
    public String getRoomCode(){
        return RoomCode.substring(2, 3);
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
    public double getTotal(){
        return total;
    }
    public double getRate(){
        return rate;
    }
    public double getDiscount(){
        return discount;
    }

    public static Customer nextCustomer(Scanner sc, int cnt){
        return new Customer(cnt, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    @Override
    public String toString(){
        return CustomerCode + " " + name + " " + RoomCode + " " +  count + " " + String.format("%.2f",(double)total);
    }

    @Override
    public int compareTo(Customer o) {
        if(o.getCount() > this.getCount()){
            return 1;
        }
        return -1;
    }
}

class Room{
    private String code, type;
    private long day_cost;
    private double rate;

    public Room(){
        this.code = this.type = "";
        this.day_cost = 0;
        this.rate = 0;
    }

    public Room(String code, String type, long day_cost, double rate){
        this.code = code;
        this.type = type;
        this.day_cost = day_cost;
        this.rate = rate;
    }
    
    public String getCode(){
        return code;
    }
    public String getType(){
        return type;
    }
    public long getDayCost(){
        return day_cost;
    }
    public double getRate(){
        return rate;
    }

    public static Room nextRoom(Scanner sc){
        return new Room(sc.next(), sc.next(), Long.valueOf(sc.next()), Double.valueOf(sc.next()));
    }
}