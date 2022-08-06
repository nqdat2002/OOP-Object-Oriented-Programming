package OOPs.VaoRaFile.J07020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07020 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("KH.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Customer> cus = new ArrayList<>();
        for(int i = 1; i <= n; ++i) cus.add(Customer.nextCustomer(sc, i));

        sc = new Scanner(new File("MH.in"));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Items> ite = new ArrayList<>();
        for(int i = 1; i <= m; ++i) ite.add(Items.nextItems(sc, i));

        sc = new Scanner(new File("HD.in"));
        x = sc.nextLine();
        int p = Integer.valueOf(x);
        x.isEmpty();
        List<Bill> bill = new ArrayList<>();
        for(int i = 1; i <= p; ++i) bill.add(Bill.nextBill(sc, i, cus, ite));
        for (Bill b : bill) {
            System.out.println(b);
        }
    }
}

class Bill{
    private String codeCustomer, codeItems, codeBill, line;
    private int count, total;
    private List<Customer> cus;
    private List<Items> ite;

    public Bill(){
        this.codeBill = this.codeCustomer = this.codeItems = this.line = "";
        this.count = this.total = 0;
        this.cus = new ArrayList<>();
        this.ite = new ArrayList<>();
    }

    public Bill(String codeCustomer, String codeItems, int count, int cnt, List<Customer> cus, List<Items> ite){
        this.codeCustomer = codeCustomer;
        this.codeItems = codeItems;
        this.count = count;
        this.cus = cus;
        this.ite = ite;
        String s = "HD" + cnt;
        while(s.length() < 5) s = s.substring(0, 2) + "0" + s.substring(2);
        this.codeBill = s;
        this.line = "";
        this.setLine(codeCustomer, codeItems, count);
    }

    public void setLine(String codeCustomer, String codeItems, int count){
        this.line += (this.codeBill + " ");
        for (Customer customer : cus) {
            if(customer.getCode().compareTo(codeCustomer) == 0){
                this.line += (customer.toString() + " ");
                break;
            }
        }
        for (Items item : ite) {
            if(item.getCode().compareTo(codeItems) == 0){
                this.line += (item.toString() + " ");
                this.total = item.getCostExport() * count;
            }
        }
        this.line += (count + " " + this.total);

    }
    public String getCodeBill(){
        return codeBill;
    }
    public String getCodeCustomer(){
        return codeCustomer;
    }
    public String getCodeItems(){
        return codeItems;
    }
    public int getCount(){
        return count;
    }
    public int getTotal(){
        return total;
    }
    public List<Customer> getCustomer(){
        return cus;
    }
    public List<Items> getItems(){
        return ite;
    }

    public static Bill nextBill(Scanner sc, int cnt, List<Customer> cus, List<Items> ite){
        return new Bill(sc.next(), sc.next(), Integer.valueOf(sc.next()), cnt, cus, ite);
    }

    @Override
    public String toString(){
        return line;
    }
}

class Items{
    private String code, name, type;
    private int cost_import, cost_export;

    public Items(){
        this.code = this.name = this.type = "";
        this.cost_export = this.cost_import = 0;
    }

    public Items(String name, String type, int cost_import, int cost_export, int cnt){
        this.name = name;
        this.type = type;
        this.cost_import = cost_import;
        this.cost_export = cost_export;
        String s = "MH" + cnt;
        while(s.length() < 5) s = s.substring(0, 2) + "0" + s.substring(2);
        this.code = s;
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public String getType(){
        return type;
    }
    public int getCostImport(){
        return cost_import;
    }
    public int getCostExport(){
        return cost_export;
    }

    public static Items nextItems(Scanner sc, int cnt){
        return new Items(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine()), cnt);
    }

    @Override
    public String toString(){
        return name + " " + type + " " + cost_import + " " + cost_export;
    }
}

class Customer{
    private String name, code, address, sex, date;

    public Customer(){
        this.name = this.code = this.address = this.sex = this.date = "";
    }

    public Customer(String name, String sex, String date, String address, int cnt){
        this.name = name;
        this.sex = sex;
        this.date = date;
        this.address = address;
        this.code = "KH0" + (cnt < 10 ? ("0" + cnt) : cnt);
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public String getSex(){
        return sex;
    }
    public String getdate(){
        return date;
    }
    public String getAddress(){
        return address;
    }

    public static Customer nextCustomer(Scanner sc, int cnt){
        return new Customer(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), cnt);
    }

    @Override
    public String toString(){
        return name + " " + address;
    }
}
