package OOPs.MangDoiTuong.J05071;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class J05071 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        List<City> city = new ArrayList<>();
        for(int i = 1; i <= n; ++i) city.add(City.nextCity(sc));

        int m = sc.nextInt();
        List<Bill> bill = new ArrayList<>();
        for(int i = 1; i <= m; ++i) bill.add(Bill.nextBill(sc));

        for (Bill b : bill) {
            if(b.getPhone().charAt(0) == '0' && b.getPhone().contains("-")){
                for (City c : city) {
                    if(b.getPhone().substring(1, 3).compareTo(c.getId()) == 0){
                        b.setTotal(c.getCost());
                        System.out.println(b.getPhone() + " " + c.getName() + " " + b.getMinute() + " " + b.getTotal());
                        break;
                    }
                }
            }else{
                b.setTotal(800);
                System.out.println(b.getPhone() + " Noi mang " + b.getMinute() + " " + b.getTotal());
            }
        }
        sc.close();
    }
}

class Bill{
    private String phone, time_start, time_end;
    private int minute;
    private long total;

    public Bill(){
        this.phone = this.time_end = this.time_start = "";
        this.total = this.minute = 0;
    }

    public Bill(String phone, String time_start, String time_end){
        this.phone = phone;
        this.time_end = time_end;
        this.time_start = time_start;
        setMinute();
        this.total = 0;
        if(phone.charAt(0) != '0'){
            if(this.minute % 3 == 1) this.minute += 2;
            if(this.minute % 3 == 2) this.minute += 1;
            this.minute /= 3;
        }
    }

    public void setMinute(){
        DateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        long getDiff = 0;
        try {
            String startDate = getTimeStart();
            String endDate = getTimeEnd();
            Date date1 = (Date) simpleDateFormat.parse(startDate);
            Date date2 = (Date) simpleDateFormat.parse(endDate);
            getDiff = (long) (date2.getTime() - date1.getTime());
            getDiff /= (long)(60 * 1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.minute = (int)getDiff;
    }

    public void setTotal(long cost){
        this.total = cost * this.minute;
    }

    public String getPhone(){
        return phone;
    }
    public String getTimeStart(){
        return time_start;
    }
    public String getTimeEnd(){
        return time_end;
    }
    public int getMinute(){
        return minute;
    }
    public long getTotal(){
        return total;
    }
    
    public static Bill nextBill(Scanner sc){
        return new Bill(sc.next(), sc.next(), sc.next());
    }
}

class City{
    private String id, name;
    private long cost;

    public City(){
        this.id = this.name = "";
        this.cost = 0;
    }

    public City(String id, String name, long cost){
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public static City nextCity(Scanner sc){
        return new City(sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine()));
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public long getCost(){
        return cost;
    }
}   