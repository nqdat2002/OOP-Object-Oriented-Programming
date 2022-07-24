package OOPs.VaoRaFile.J07076;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class J07076 {
    public static void main(String [] args) throws FileNotFoundException{
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int id = sc.nextInt();
            int [][] a = new int[n][m];
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j) a[i][j] = sc.nextInt();
            }
            Vector<Integer> tmp = new Vector<>();
            for(int i = 0; i < n; ++i) tmp.add(a[i][id - 1]);
            Collections.sort(tmp);
            for(int i = 0; i < n; ++i) a[i][id - 1] = tmp.get(i);
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
