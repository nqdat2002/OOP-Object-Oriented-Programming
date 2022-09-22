package OOP_TOT_NGHIEP.LapTrinhCoBan;

import java.util.Scanner;

public class DSA06026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        SapXep(a, n);
        sc.close();
    }

    private static void SapXep(int[] a, int n) {
        for (int i = 1; i <= n - 1; i++) {
            boolean check = false;
            for (int j = 1; j <= n - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    check = true;
                }
            }
            if (check == false) {
                break;
            } else {
                System.out.print("Buoc " + i + ": ");
                for (int j = 1; j <= n; j++) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
            }
        }

    }   
}
