package OOPs.MangDoiTuong.J05025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05025 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<GiangVien> list = new ArrayList<GiangVien>();
        for(int i = 1; i <= n; ++i){
            list.add(GiangVien.nextGiangVien(sc, i));
        }
        Collections.sort(list, new Comparator<GiangVien>(){
            @Override
            public int compare(GiangVien o1, GiangVien o2){
                if(o1.getLastName().compareTo(o2.getLastName()) != 0){
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                return o1.getCode().compareTo(o2.getCode());
            }
        });

        for(GiangVien s: list){
            s.Show();
        }
        sc.close();        
    }
}
class GiangVien{
    private String code, name, subject;

    public GiangVien(){
        this.code = this.name = this.subject = "";
    }
    public GiangVien(String code, String name, String subject){
        this.code = code;
        this.name = name;
        this.subject = subject;
    }

    public void setCode(int cnt){
        String s = "GV" + cnt;
        if(s.length() < 4) s = s.substring(0, 2) + "0" + s.substring(2);
        this.code = s;
    }

    public String getCode(){
        return code;
    }

    public String getLastName(){
        String s = this.name;
        int index = s.lastIndexOf(" ");
        return s.substring(index + 1);
    }

    public static GiangVien nextGiangVien(Scanner sc, int cnt){
        GiangVien a = new GiangVien();
        a.setCode(cnt);
        a.name = sc.nextLine();
        String s = sc.nextLine();
        String res = "";
        res += s.charAt(0);
        for(int i = 1; i < s.length() - 1; ++i){
            if((s.charAt(i) == ' ' && s.charAt(i + 1) != ' '))
                res += s.charAt(i + 1);
        }
        a.subject = res.toUpperCase();
        return a;
    }

    public void Show(){
        System.out.println(this.code + " " + this.name + " " + this.subject);
    }
}
