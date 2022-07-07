package OOPs.KhaiBaoLopvaDoiTuong;

import java.util.Arrays;
import java.util.Scanner;

public class J05063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
        sc.close();
    }
}

class DaThuc{
    private int [] bac = new int[10005];
    private int [] hs = new int[10005];
    private int bacmax = 0;

    public DaThuc(){
        Arrays.fill(this.bac, 0);
        Arrays.fill(this.hs, 0);
        this.bacmax = 0;
    }

    public void setValue(int index, int val1, int val2){
        this.bac[index] = val2;
        this.hs[index] = val1;
    }

    public DaThuc(String s){
        Arrays.fill(this.bac, 0);
        Arrays.fill(this.hs, 0);
        String arr[] = s.split(" ");
        for(int i = 0; i < arr.length; ++i){
            if(arr[i].compareTo("+") != 0){
                String value1 = "";
                for(int j = 0; j < arr[i].length(); ++j){
                    char c = arr[i].charAt(j);
                    if(c >= '0' && c <= '9') value1 += c;
                    if(c == '*') break;
                }
                String value2 = "";
                for(int j = arr[i].length() - 1; j >= 0; --j){
                    char c = arr[i].charAt(j);
                    if(c >= '0' && c <= '9') value2 = c + value2;
                    if(c == '^') break;
                }
                if(i == 0) this.bacmax = Integer.valueOf(value2);
                this.setValue(Integer.valueOf(value2), Integer.valueOf(value1), Integer.valueOf(value2));
            }
        }
    }

    public DaThuc cong(DaThuc x){
        this.bacmax = Math.max(this.bacmax, x.bacmax);
        for(int i = this.bacmax; i >= 0; i--){
            this.bac[i] = Math.max(this.bac[i], x.bac[i]);
            this.hs[i] += x.hs[i];
        }
        return this;
    }

    @Override
    public String toString(){
        String res = "";
        for(int i = this.bacmax; i > 0; --i){
            if(this.hs[i] != 0){
                res += (this.hs[i] + "*x^" + this.bac[i] + " + ");
            }
        }
        res += (this.hs[0] + "*x^" + this.bac[0]);
        return res;
    }
}
