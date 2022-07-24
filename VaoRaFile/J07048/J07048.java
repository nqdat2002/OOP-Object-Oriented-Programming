package OOPs.VaoRaFile.J07048;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07048 {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        // Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Product> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Product.nextProduct(sc));
        Collections.sort(list);
        for (Product nv : list) {
            System.out.println(nv);
        }
        sc.close();
    }
}

class Product implements Comparable<Product>{
    private String name, code;
    private int cost, timeUse;

    public Product(){
        this.name = this.code = "";
        this.cost = this.timeUse = 0;
    }

    public Product(String code, String name, int cost, int timeUse){
        this.code = code;
        this.name = name;
        this.cost = cost;
        this.timeUse = timeUse;
    }   
    public int getCost(){
        return cost;
    }
    public String getCode(){
        return code;
    }

    public static Product nextProduct(Scanner sc){
        return new Product(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine()));
    }

    @Override
    public String toString(){
        return code + " " + name + " " + cost + " " + timeUse;
    }

    @Override
    public int compareTo(Product o) {
        if(this.getCost() != o.getCost()){
            return (int)(o.getCost() - this.getCost());
        }
        return this.getCode().compareTo(o.getCode());
    }

}