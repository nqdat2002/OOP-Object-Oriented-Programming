package OOPs.MangDoiTuong.J05068;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class J05068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Petronleum> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) 
            list.add(Petronleum.nextPetronleum(sc));
        Collections.sort(list);
        for (Petronleum petro : list) {
            System.out.println(petro);
        }
        sc.close();
    }
}

class Petronleum implements Comparable<Petronleum>{
    private String name, code;
    private long count, cost, total, tax;
    private Map<String, String> findName = new HashMap<>();
    private Map<String, Long> findCost = new HashMap<>();
    private Map<String, Double> findTax = new HashMap<>();

    public void setInfor(){
        this.findName.clear();
        this.findName.put("BP", "British Petro");
        this.findName.put("ES", "Esso");
        this.findName.put("SH", "Shell");
        this.findName.put("CA", "Castrol");
        this.findName.put("MO", "Mobil");
        this.findName.put("TN", "Trong Nuoc");

        this.findCost.clear();
        this.findCost.put("X", (long) 128000);
        this.findCost.put("D", (long) 11200);
        this.findCost.put("N", (long) 9700);

        this.findTax.clear();
        this.findTax.put("X", (double)0.03);
        this.findTax.put("D", (double)0.035);
        this.findTax.put("N", (double)0.02);
    }

    public Petronleum(){
        this.name = this.code = "";
        this.count = this.cost = this.total = this.tax = 0;
    }
    
    public Petronleum(String array){
        this.code = array.substring(0, 5);
        this.count = Long.valueOf(array.substring(6));
        this.setInfor();

        String s = this.code.substring(3);
        String s2 = "" + this.code.charAt(0);

        this.name = (String)this.findName.get(s);
        this.cost = (long)this.findCost.get(s2);

        if(s.compareTo("TN") == 0) 
            this.tax = 0;
        else 
            this.tax = (long) ((this.cost * this.count) * this.findTax.get(s2));

        this.total = (long) ((long)(this.cost * this.count) + this.tax);
    }

    public static Petronleum nextPetronleum(Scanner sc){
        return new Petronleum(sc.nextLine());
    }

    public long getTotal(){
        return this.total;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + cost + " " + tax + " " + total;
    }

    @Override
    public int compareTo(Petronleum o) {
        if(o.getTotal() > this.getTotal())
            return 1;
        return -1;
    }
}
