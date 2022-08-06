package OOPs.VaoRaFile.J07037;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J07037 {
    public static void main(String [] args) throws FileNotFoundException{
        File file = new File("DN.in");
        Scanner sc = new Scanner(file);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<DoanhNghiepTT> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(DoanhNghiepTT.nextDoanhNghiepTT(sc));
        }
        Collections.sort(list, new Comparator<DoanhNghiepTT>() {
            @Override
            public int compare(DoanhNghiepTT o1, DoanhNghiepTT o2){
                return (o1.getCode().compareTo(o2.getCode()));
            }
        });
        for (DoanhNghiepTT dn : list) {
            dn.Show();
        }
        sc.close();
    }
}
class DoanhNghiepTT{
    private String code, name;
    private int count;

    public DoanhNghiepTT(){
        this.code = this.name = "";
        this.count = 0;
    }
    public DoanhNghiepTT(String code, String name, int count){
        this.code = code;
        this.name = name;
        this.count = count;
    }

    public int getCount(){
        return count;
    }
    public String getCode(){
        return code;
    }

    public static DoanhNghiepTT nextDoanhNghiepTT(Scanner sc){
        DoanhNghiepTT a = new DoanhNghiepTT();
        a.code = sc.nextLine();
        a.name = sc.nextLine();
        a.count = Integer.valueOf(sc.nextLine());
        return a;
    }

    public void Show(){
        System.out.println(this.code + " " + this.name + " " + this.count);
    }
}