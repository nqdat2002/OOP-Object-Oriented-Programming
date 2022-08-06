package OOPs.MangDoiTuong.J05046;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class J04046 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Product> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) {
            list.add(Product.nextProduct(sc, i));
        }
        Map<String, Integer> mp = new HashMap<>();
        for (Product pr : list) {
            if(!mp.containsKey(pr.getCode())){
                mp.put(pr.getCode(), 1);
                pr.setCode(1);
            }else{
                int bef = mp.get(pr.getCode()); 
                mp.remove(pr.getCode());
                mp.put(pr.getCode(), bef + 1);
                pr.setCode(bef + 1);
            }
        }

        for (Product pr : list) {
            System.out.println(pr);
        }
        sc.close();
    }
}
class Product{
    private String name, code;
    private long count, cost, discount, total;

    public Product(){
        this.name = this.code = "";
        this.count = this.cost = this.discount = this.total = 0;
    }
    public Product(String name, long count, long cost){
        this.name = name;
        this.count = count;
        this.cost = cost;
    }

    public static Product nextProduct(Scanner sc, int cnt){
        Product a = new Product(sc.nextLine(), Long.valueOf(sc.nextLine()), Long.valueOf(sc.nextLine()));
        if(a.count > 10) a.discount = (long) (a.count * a.cost * 0.05);
        else if(a.count >= 8) a.discount = (long) (a.count * a.cost * 0.02);
        else if(a.count >= 5) a.discount = (long) (a.count * a.cost * 0.01);
        else a.discount = 0;
        a.total = (long) (a.count * a.cost) - a.discount;
        a.setCode(cnt);
        return a;
    }

    public String getCharacterOfCode(){
        String [] a = name.split(" ");
        String res = "" + a[0].charAt(0) + a[1].charAt(0);
        res = res.toUpperCase();
        return res;
    }
    public void setCode(int cnt){
        this.code =  getCharacterOfCode() + "0" + cnt;
    }

    public String getCode(){
        return code.substring(0, 2);
    }

    @Override 
    public String toString(){
        return code + " " + name + " " + discount + " " + total;
    }
}
