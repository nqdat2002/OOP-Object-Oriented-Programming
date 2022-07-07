package OOPs.XauKyTu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// Day con tang dan
public class J07008 {
    public static ArrayList<String> ar = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("DAYSO.in");
        Scanner ip = new Scanner(file);
        //Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int [] a = new int [n + 1];
        int [] b = new int [n + 1];
        for(int i = 1; i <= n; ++i) a[i] = ip.nextInt();
        a[0] = 0;
        for(int k = 2; k <= n; ++k){
            for(int i = 0; i <= n; ++i) b[i] = 0;
            Try(1, b, a, k, n);
        }
        Collections.sort(ar);
        for(int i = 0; i < ar.size(); ++i){
            System.out.println(ar.get(i));
        }
        ip.close();
    }

    public static void Try(int i, int b[], int a[], int k, int n){
        for(int j = b[i - 1] + 1; j <= n - k + i; ++j){
            b[i] = j;
            if(i == k){
                if(check(k, a, b)){
                    String s = "";
                    for(int x = 1; x <= k; ++x){
                        s += a[b[x]] + " ";
                    }
                    ar.add(s);
                }
            }
            else Try(i + 1, b, a, k, n);
        }
    }
    public static boolean check(int k, int a[], int b[]){
        for(int i = 1; i < k; i ++){
            if(a[b[i]] > a[b[i + 1]])
                return false;
        }
        return true;
    }
}