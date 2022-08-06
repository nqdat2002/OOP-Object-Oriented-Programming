package OOPs.VaoRaFile.J07019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J07019 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA1.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<clothes> clothe = new ArrayList<>();
        for(int i = 1; i <= n; ++i) clothe.add(clothes.nextClothes(sc));

        sc = new Scanner(new File("DATA2.in"));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Bill> bill = new ArrayList<>();
        for(int i = 1; i <= m; ++i) bill.add(Bill.nextBill(sc, i, clothe));
        for (Bill b : bill) {
            System.out.println(b);
        }
        sc.close();

    }
}

class Bill{
    private String codeBill, name;
    private int count, total, discount;
    private List<clothes> clot;
    public Bill(){
        this.codeBill = "";
        this.count = this.discount = this.total = 0;
    }
    public Bill(String codeBill, int count, int cnt, List<clothes> clot) {
        this.codeBill = codeBill + "-0" + (cnt < 10 ? ("0" + cnt) : cnt);
        this.count = count; 
        this.clot = clot;
        for (clothes cloth : clot) {
            if(cloth.getCode().compareTo(codeBill.substring(0, 2)) == 0){
                this.name = cloth.getName();
                if(codeBill.charAt(2) == '1') this.total = count * cloth.getCodeType1();
                else this.total = count * cloth.getCodeType2();
            }
        }
        if(count >= 150) this.discount = (int) (this.total * 0.5);
        else if(count >= 100) this.discount = (int)(this.total * 0.3);
        else if(count >= 50) this.discount = (int)(this.total * 0.15);
        else this.discount = 0;
    }
    public String getCodeBill(){
        return codeBill;
    }
    public int getCount(){
        return count;
    }
    public int getTotal(){
        return total;
    }
    public int getDiscount(){
        return discount;
    }
    public List<clothes> getClothes(){
        return clot;
    }

    public static Bill nextBill(Scanner sc, int cnt, List<clothes> clot){
        return new Bill(sc.next(), Integer.valueOf(sc.next()), cnt, clot);
    }

    @Override
    public String toString(){
        return codeBill + " " + name + " " + discount + " " + (total - discount);
    }
}

class clothes{
    private String code, name;
    private int cost_type1, cost_type2;

    public clothes(){
        this.code = this.name = "";
        this.cost_type1 = cost_type2 = 0;
    }

    public clothes(String code, String name, int cost_type1, int cost_type2){
        this.code = code;
        this.name = name;
        this.cost_type1 = cost_type1;
        this.cost_type2 = cost_type2;
    }
    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public int getCodeType1(){
        return cost_type1;
    }
    public int getCodeType2(){
        return cost_type2;
    }

    public static clothes nextClothes(Scanner sc){
        return new clothes(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine()));
    }
}