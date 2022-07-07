package OOPs.XauKyTu;

import java.util.Scanner;
// so la ma
public class J03023 {
    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while(t-- > 0){
            String s = ip.nextLine();
            int [] a = new int [100];
            for(int i = 0; i < s.length(); ++i){
                char c = s.charAt(i);
                if(c == 'I') 
                    a[i] = 1;
                else if(c== 'V')
                    a[i] = 5;
                else if(c == 'X')
                    a[i] = 10;
                else if(c == 'L')
                    a[i] = 50;
                else if(c == 'C')
                    a[i] = 100;
                else if(c == 'D')
                    a[i] = 500;
                else if(c == 'M')
                    a[i] = 1000;
            }
            int res = a[s.length() - 1];
            for(int i = s.length() - 1; i > 0; i--){
                if(a[i] > a[i - 1])
                    res = res - a[i - 1];
                else if(a[i] == a[i - 1] || a[i] < a[i - 1])
                    res = res + a[i - 1];
            }
            System.out.println(res);
        }
        ip.close();
    }
}