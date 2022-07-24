package OOPs.MangDoiTuong.J05027;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05027 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<GiangVien> list = new ArrayList<GiangVien>();
        for(int i = 1; i <= n; ++i){
            list.add(GiangVien.nextGiangVien(sc, i));
        }
        x = sc.nextLine();
        int q = Integer.valueOf(x);
        x.isEmpty();
        while(q-- > 0){
            String sub = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + sub + ":");
            for(GiangVien s: list){
                if(SimilarTo(s.getName(), sub)){
                    s.Show();
                }
            }
        }
        sc.close();        
    }
    public static boolean SimilarTo(String a, String b){
        a = a.toLowerCase();
        b = b.toLowerCase();
        if(a.contains(b))
            return true;
        return false;
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
    public String getName(){
        return name;
    }
    public String getSubject(){
        return subject;
    }

    public static String trueSubject(String s){
        String res = "";
        res += s.charAt(0);
        for(int i = 1; i < s.length() - 1; ++i){
            if((s.charAt(i) == ' ' && s.charAt(i + 1) != ' '))
                res += s.charAt(i + 1);
        }
        return res.toUpperCase();
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
        a.subject = GiangVien.trueSubject(sc.nextLine());
        return a;
    }

    public void Show(){
        System.out.println(this.code + " " + this.name + " " + this.subject);
    }
}
