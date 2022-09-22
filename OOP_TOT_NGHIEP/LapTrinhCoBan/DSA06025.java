package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class DSA06025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sapxep(a, n);
        sc.close();
    }

    public static void sapxep(int[] a, int n) {
        System.out.println("Buoc 0: " + a[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = j + 1; k <= i; k++) {
                    if (a[j] > a[k]) {
                        int temp = a[j];
                        a[j] = a[k];
                        a[k] = temp;
                    }
                }
            }
            System.out.print("Buoc " + i + ": ");
            for (int j = 0; j <= i; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
}
