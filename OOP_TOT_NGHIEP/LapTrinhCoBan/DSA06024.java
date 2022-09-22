package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class DSA06024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[1000];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int min;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
            System.out.print("Buoc " + (i + 1) + ": ");
            for (int h = 0; h < n; h++)
                System.out.print(a[h] + " ");
            System.out.println();
        }
        sc.close();
    }
}
