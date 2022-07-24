package OOPs.MangDoiTuong.J05035;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05035 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int n = Integer.valueOf(tm);
        tm.isEmpty();
        List<ThucTap> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            list.add(ThucTap.nextThucTap(sc, i));
        }
        Collections.sort(list, new Comparator<ThucTap>(){
            @Override
            public int compare(ThucTap o1, ThucTap o2){
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        tm = sc.nextLine();
        int q = Integer.valueOf(tm);
        tm.isEmpty();
        while(q-- > 0){
            String company = sc.nextLine();
            for (ThucTap st : list) {
                if(st.getComp().compareTo(company) == 0){
                    st.Show();
                }
            }
        }
        sc.close();
    }
}
class ThucTap{
    private int order = 0;
    private String code, name, classes, email, comp;

    public ThucTap(){
        this.order = 0;
        this.code = this.name = this.classes = "";
        this.email = this.comp = "";
    }
    public ThucTap(int order, String code, String name, String classes, String email, String comp){
        this.order = order;
        this.code = code;
        this.name = name;
        this.classes = classes;
        this.email = email;
        this.comp = comp;
    }

    public String getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public String getComp(){
        return comp;
    }

    public static ThucTap nextThucTap(Scanner sc, int cnt){
        ThucTap a = new ThucTap();
        a.order = cnt;
        a.code = sc.nextLine();
        a.name = sc.nextLine();
        a.classes = sc.nextLine();
        a.email = sc.nextLine();
        a.comp = sc.nextLine();
        return a;
    }

    public void Show(){
        System.out.println(this.order + " " + this.code + " " + this.name + " " + this.classes + " " + this.email + " " + this.comp);
    }
}