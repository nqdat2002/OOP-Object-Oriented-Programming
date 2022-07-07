package OOPs.XauKyTu;

import java.util.Scanner;

// rut gon xau ky tu
public class J03027 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String s = ip.nextLine();
        while(true) {
            int j = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    j++;
                    s = s.substring(0, i) + s.substring(i + 2, s.length());
                }
            }
            if(j == 0)break;
        }
        if(s.length()==0) System.out.println("Empty String");
        else System.out.println(s);
        ip.close();
    }
}