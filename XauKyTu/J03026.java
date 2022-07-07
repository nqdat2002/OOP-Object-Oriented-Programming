package OOPs.XauKyTu;

import java.util.Scanner;

// xau khac nhau dai nhat
public class J03026 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String s = ip.nextLine();
            String m = ip.nextLine();
            if(s.compareTo(m) == 0){
                System.out.print(-1);
            }else{
                System.out.println(mmax(s.length(), m.length()));;
            }
        }
        ip.close();
    }
    public static int mmax(int x, int y){
        if(x > y) return x;
        return y;
    }
}