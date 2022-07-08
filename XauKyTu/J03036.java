package OOPs.XauKyTu;

import java.util.ArrayList;
import java.util.Scanner;

public class J03036 {
    public static String Rotate(String s){
        char c = s.charAt(0);
        s = s.substring(1, s.length());
        return s + c;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int t = Integer.valueOf(x);
        x.isEmpty();
        ArrayList<String> array = new ArrayList<>();        
        for(int i = 0; i < t; ++i){
            array.add(sc.nextLine());
        }
        String tmp = "";
        int res = 100000, check = 1;
        for(int i = 0; i < array.get(0).length(); ++i){
            int sum = i;
            for(int j = 1; j < t; ++j){
                int cnt = 0;
                if(array.get(0).compareTo(array.get(j)) != 0){
                    tmp = array.get(j);
                    while(array.get(0).compareTo(tmp) != 0){
                        cnt++;
                        tmp = Rotate(tmp);
                        if(cnt > array.get(0).length() - 1){
                            check = 0;
                            break;
                        }
                    }
                }
                if(check == 0) break;
                sum += cnt;
            }
            if (check == 0) break;
            if (sum < res) res = sum;
            String tm = Rotate(array.get(0));
            array.set(0, tm);
        }   
        if(check != 0) System.out.println(res);
        else System.out.println(-1);
        sc.close();
    }
}
