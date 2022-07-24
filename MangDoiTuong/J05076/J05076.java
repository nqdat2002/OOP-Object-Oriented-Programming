package OOPs.MangDoiTuong.J05076;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05076 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Product> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Product.nextProduct(sc));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        while(m -- > 0){
            String s = sc.next();
            long i = Long.valueOf(sc.next()), ci = Long.valueOf(sc.next()), e = Long.valueOf(sc.next());
            for (Product pro : list) {
                if(s.compareTo(pro.getCode()) == 0){
                    pro.setImport_Export(s, i, ci, e);
                    System.out.println(pro);
                }
            }
        }
    }

}
class Product{
    private String name, type, code;
    private long count_import, cost_import, count_export, total_import, total_export;

    public Product(){
        this.code = this.type = this.name = "";
        this.count_import = this.count_export = this.cost_import = 0;
        this.total_export = this.total_import = 0;
    }
    public Product(String code, String name, String type){
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public void setImport_Export(String s, long cnt_i, long cost_i, long cnt_e){
        this.count_import = cnt_i;
        this.count_export = cnt_e;
        this.cost_import = cost_i;
        this.total_import = (long) (this.count_import * this.cost_import);
        if(this.type.compareTo("A") == 0) this.total_export = (long) (this.count_export * this.cost_import + (this.count_export * this.cost_import) * 0.08);
        if(this.type.compareTo("B") == 0) this.total_export = (long) (this.count_export * this.cost_import + (this.count_export * this.cost_import) * 0.05);
        if(this.type.compareTo("C") == 0) this.total_export = (long) (this.count_export * this.cost_import + (this.count_export * this.cost_import) * 0.02);
    }

    public static Product nextProduct(Scanner sc){
        return new Product(sc.nextLine(), sc.nextLine(), sc.nextLine());
    }

    public String getType(){
        return type;
    }
    public String getCode(){
        return code;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + total_import + " " + total_export;
    }
}