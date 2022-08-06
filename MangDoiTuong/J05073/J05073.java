package OOPs.MangDoiTuong.J05073;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Product> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Product.nextProduct(sc));
        for (Product pro : list) {
            System.out.println(pro);
        }
        sc.close();
    }
}
class Product{
    private String code;
    private long cost, count;
    private double total, tax, transport;

    public Product(){
        this.code = "";
        this.cost = this.count = 0;
        this.total = this.tax = this.transport = 0;
    }

    public Product(String code, long cost, long count){
        this.code = code;
        this.cost = cost;
        this.count = count;
        if(code.charAt(0) == 'T') {
            this.tax = 0.29 * cost * count;
            this.transport = 0.04 * cost * count;
        }
        else if(code.charAt(0) == 'C'){
            this.tax = 0.10 * cost * count;
            this.transport = 0.03 * cost * count;
        }
        else if(code.charAt(0) == 'D') {
            this.tax = 0.08 * cost * count;
            this.transport = 0.025 * cost * count;
        }
        else if(code.charAt(0) == 'M') {
            this.tax = 0.02 * cost * count;
            this.transport = 0.005 * cost * count;
        }

        if(code.charAt(3) == 'C') this.tax = 0.95 * this.tax;
        this.total = this.cost * this.count + this.tax + this.transport;
        this.total = 1.2 * this.total;
    }

    public static Product nextProduct(Scanner sc){
        return new Product(sc.next(), Long.valueOf(sc.next()), Long.valueOf(sc.next()));
    }

    public String getCode(){
        return code;
    }
    public double getTotal(){
        return total;
    }

    @Override
    public String toString(){
        return code + " " + String.format("%.2f", (double) this.total / this.count);
    }
}