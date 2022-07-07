package OOPs.XauKyTu;

import java.util.Scanner;
// dao tu
public class J03032 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String b = ip.nextLine();
        b.isEmpty();
        while (t-- > 0) {
            String s = ip.nextLine();
            String[] arr = s.split(" ");
            int n = arr.length;
            for (int i = 0; i < n; ++i) {
                for (int j = arr[i].length() - 1; j >= 0; --j) {
                    System.out.print(arr[i].charAt(j));
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        ip.close();
    }
}