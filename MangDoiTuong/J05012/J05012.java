package OOPs.MangDoiTuong.J05012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05012 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Product> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) 
            list.add(Product.nextProduct(sc));
        Collections.sort(list);
        for (Product pro: list) {
            System.out.println(pro);
        }
        sc.close();
    }
}
class Product implements Comparable<Product>{
    private String name, code;
    private long cost, total, tax;
    private int count;

    public Product(){
        this.name = this.code = "";
        this.count = 0;
        this.cost = this.total = this.tax = 0;
    }

    public Product(String code, String name, int count, long cost, long tax){
        this.code = code;
        this.name = name;
        this.count = (int)count;
        this.cost = (long)cost;
        this.tax = (long)tax;
        this.total = (long)((long)(this.count * this.cost) - this.tax);
    }
    public static Product nextProduct(Scanner sc){
        return new Product(sc.nextLine(), sc.nextLine(), Integer.valueOf(sc.nextLine()), 
        Long.valueOf(sc.nextLine()), Long.valueOf(sc.nextLine()));
    }

    public Long getTotal(){
        return (long)total;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + (int)count + " " + (long)cost + " " + (long)tax + " " + (long)total;
    }

    @Override
    public int compareTo(Product o) {
        if(o.getTotal() > this.getTotal())
            return 1;
        return -1;
    }
}