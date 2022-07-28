package OOPs.Basic;

import java.util.Scanner;
import java.util.Vector;

public class J01023 {
    public static Scanner sc = new Scanner(System.in);
    private int n, m;
    private String s;
    private Vector<Integer> v;
    private boolean ok;

    public void init(){
        s = sc.nextLine();
        v = new Vector<>();
        n = s.length();
        m = 0;
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) == '?' && i != 3){
                ++m;
            }
        }
        ok = false;
    }

    public void Try(int i, Vector<Integer> a, int cnt){
        if(ok)
            return;
        for(int j = 0; j <= 9; ++j){
            a.add(j);
            if(i == cnt){
                int index = 0;
                String res = s;
                for(int k = 0; k < n; ++k){
                    if(k != 3 && res.charAt(k) == '?'){
                        res = res.substring(0, k) + ("" + a.get(index)) + res.substring(k + 1, res.length());
                        index ++;
                    }
                }
                int x = 10 * (res.charAt(0) - 48) + res.charAt(1) - 48;
                int y = 10 * (res.charAt(5) - 48) + res.charAt(6) - 48;
                int z = 10 * (res.charAt(10) - 48) + res.charAt(11) - 48;
                if(x >= 10 && y >= 10 && z >= 10){
                    if(res.charAt(3) == '+'){
                        if(x + y == z){
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                    }
                    if(res.charAt(3) == '-'){
                        if(x - y == z){
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                    }
                    if(res.charAt(3) == '*'){
                        if(x * y == z){
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                    }
                    if(res.charAt(3) == '/'){
                        if(z * y == x){
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                    }
                    if(res.charAt(3) == '?'){
                        if(x + y == z){
                            res = res.substring(0, 3) + "+" + res.substring(4);
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                        if(x - y == z){
                            res = res.substring(0, 3) + "-" + res.substring(4);
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                        if(x * y == z){
                            res = res.substring(0, 3) + "*" + res.substring(4);
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                        if(y * z == x){
                            res = res.substring(0, 3) + "/" + res.substring(4);
                            System.out.println(res);
                            ok = true;
                            return;
                        }
                    }
                }
            }
            else Try(i + 1, a, cnt);
            a.remove(a.size() - 1);
        }
    }
    public void Solve(){
        init();
        Try(0, v, m);
        if(!ok) System.out.println("WRONG PROBLEM!");
    }

    public static void main(String [] args){
        String x = sc.nextLine();
        int t = Integer.valueOf(x);
        x.isEmpty();
        while(t-- > 0){
            J01023 A = new J01023();
            A.Solve();
        }
    }
}
