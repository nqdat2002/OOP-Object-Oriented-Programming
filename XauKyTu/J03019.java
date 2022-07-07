package OOPs.XauKyTu;

import java.util.Scanner;

// xau con lon nhat
public class J03019 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String s = ip.next();
        int i = 0;
        for(char c = 'z';c >= 'a'; c--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == c){
                    System.out.printf(String.valueOf(s.charAt(j)));
                    i = j;
                }
            }
        }
        ip.close();
    }
} 