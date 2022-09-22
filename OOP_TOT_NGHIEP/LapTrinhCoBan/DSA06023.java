package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class DSA06023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[1000];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int tmp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.print("Buoc " + (i + 1) + ": ");
            for (int k = 0; k < n; k++)
                System.out.print(a[k] + " ");
            System.out.println();
        }
        sc.close();
    }
}
