package OOPs.MangDoiTuong.J05067;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class J05067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Petronleum> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Petronleum.nextPetronleum(sc));
        for (Petronleum petro : list) {
            System.out.println(petro);
        }
        sc.close();
    }
}

class Petronleum{
    private String name, code;
    private long count, cost, total, tax;
    private Map<String, String> findName = new HashMap<>();
    private Map<String, Long> findCost = new HashMap<>();
    private Map<String, Double> findTax = new HashMap<>();

    public void setInfor(){
        this.findName.put("BP", "British Petro");
        this.findName.put("ES", "Esso");
        this.findName.put("SH", "Shell");
        this.findName.put("CA", "Castrol");
        this.findName.put("MO", "Mobil");
        this.findName.put("TN", "Trong Nuoc");

        this.findCost.put("X", (long) 128000);
        this.findCost.put("D", (long) 11200);
        this.findCost.put("N", (long) 9700);

        this.findTax.put("X", (double)0.03);
        this.findTax.put("D", (double)0.035);
        this.findTax.put("N", (double)0.02);
    }

    public Petronleum(){
        this.name = this.code = "";
        this.count = this.cost = this.total = this.tax = 0;
        this.setInfor();
    }
    
    public Petronleum(String code, long count){
        this.code = code;
        this.count = count;
        this.setInfor();
        String s = code.substring(3);
        String s2 = code.substring(0, 1);
        this.name = this.findName.get(s);
        this.cost = this.findCost.get(s2);
        if(s.compareTo("TN") == 0) this.tax = 0;
        else this.tax = (long) (this.findTax.get(s2) * (this.cost * this.count));
        this.total = (long)(this.cost * this.count + this.tax);
    }

    public static Petronleum nextPetronleum(Scanner sc){
        return new Petronleum(sc.next(), Long.valueOf(sc.next()));
    }

    @Override
    public String toString(){
        return code + " " + name + " " + cost + " " + tax + " " + total;
    }
}
