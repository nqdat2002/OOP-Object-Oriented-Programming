package OOPs.MangDoiTuong.J04018;

import java.util.Scanner;

public class J04018 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String tm = sc.nextLine();
        int t = Integer.valueOf(tm);
        tm.isEmpty();
        while(t-- > 0){
            SoPhuc a = SoPhuc.nextSoPhuc(sc);
            SoPhuc b = SoPhuc.nextSoPhuc(sc);
            SoPhuc c = SoPhuc.Cong(a, b);
            SoPhuc d = c;
            c = SoPhuc.Nhan(c, a);
            c.Show();
            System.out.print(", ");
            d = SoPhuc.Nhan(d, d);
            d.Show();
            System.out.println();
        }
        sc.close();
    }
}

class SoPhuc{
    private int thuc, ao;

    public SoPhuc(){
        this.thuc = this.ao = 0;
    }
    public SoPhuc(int thuc, int ao){
        this.thuc = thuc;
        this.ao = ao;
    }

    public static SoPhuc Cong(SoPhuc A, SoPhuc B){
        SoPhuc res = new SoPhuc();
        res.thuc = A.thuc + B.thuc;
        res.ao = A.ao + B.ao;
        return res;
    }

    public static SoPhuc Nhan(SoPhuc A, SoPhuc B){
        SoPhuc res = new SoPhuc();
        res.thuc = A.thuc * B.thuc - A.ao * B.ao;
        res.ao = A.thuc * B.ao + A.ao * B.thuc;
        return res;
    }

    public static SoPhuc nextSoPhuc(Scanner sc){
        SoPhuc a = new SoPhuc();
        a.thuc = sc.nextInt();
        a.ao = sc.nextInt();
        return a;
    }

    public void Show(){
        int x = this.thuc, y = this.ao;
        if(y == Math.abs(y)){
            System.out.print(x + " + " + y + "i");
        }
        else {
            y = Math.abs(y);
            System.out.print(x + " - " + y + "i");
        }
    }

}
