package OOPs.XauKyTu;

import java.util.Scanner;

public class J03028 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int t = Integer.valueOf(x);
        x.isEmpty();
        while(t-- > 0){
            String s = sc.nextLine();
            int l = s.length(), sum1 = 0, sum2 = 0;
            Character [] s1 = new Character[20005], s2 = new Character[20005];
            int j = 0, k = 0;
            for(int i = 0; i < l / 2; ++i){
                s1[j] = s.charAt(i);
                j++;
                sum1 += s.charAt(i) - 65;
            }

            for(int i = l / 2; i < l; ++i){
                s2[k] = s.charAt(i);
                k++;
                sum2 += s.charAt(i) - 65;
            }

            for(int i = 0; i < j; i++){
                s1[i] = (char) (((s1[i] - 65 + sum1) % 26) + 65);
            }
            for(int i = 0; i < k; i++){
                s2[i] = (char) (((s2[i] - 65 + sum2) % 26 ) + 65);
            }
            for(int i = 0; i < j; i++){
                s1[i] = (char) (((s1[i] - 65 + s2[i] - 65) % 26) + 65);
            }
            for(int i = 0; i < j; i++) System.out.print(s1[i]);
            System.out.println();
        }
        sc.close();
    }
}
