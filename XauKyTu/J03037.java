package OOPs.XauKyTu;

import java.util.Scanner;

// vong tron
public class J03037 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String s = ip.nextLine();
        int [] vs = new int [200];
        int [] d = new int [200];
        for (int i = 0; i < s.length(); i++){ 
            vs[s.charAt(i)] = i;
        }
        for (int i = 0; i < s.length(); i++){ 
            if(i != vs[s.charAt(i)])
                d[s.charAt(i)] = i;
        }
        int cnt = 0;
        for(char i = 'A'; i <= 'Z'; i++){
            for(char j = 'A'; j <= 'Z'; j++){
                if(d[j] > d[i] && d[j] < vs[i] && vs[j] > vs[i]) 
                    ++cnt;
                else if(d[j] < d[i] && d[i] < vs[j] && vs[j] < vs[i]) 
                    ++cnt;
            }
        }
        System.out.println(cnt / 2);
        ip.close();
    }
} 