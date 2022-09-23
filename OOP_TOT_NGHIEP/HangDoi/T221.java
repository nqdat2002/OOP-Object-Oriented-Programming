package OOP_TOT_NGHIEP.HangDoi;

import java.util.Scanner;

public class T221 {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            n = sc.nextInt();
            soNhiPhan();
        }
        sc.close();
    }
    
    public static void soNhiPhan(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(nhiPhan(i));
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }
    
    public static String nhiPhan(int so){
        StringBuilder sb1 = new StringBuilder();
        while(so != 0){
           sb1.append(so%2);
           so = so/2;
        }
        return sb1.reverse().toString();
    }
}
