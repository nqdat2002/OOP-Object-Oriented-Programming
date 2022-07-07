package OOPs.XauKyTu;

import java.util.Scanner;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

// tap tu rieng cua hai xau
public class J03009 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String a = ip.nextLine();
            String b = ip.nextLine();
            String[] S = a.split(" ");
            String[] T = b.split(" ");
            Set<String> m = new HashSet<>();
            Set<String> n = new HashSet<>();
            Collections.addAll(m, S);
            Collections.addAll(n, T);
            for (String e : m) {
                if (!n.contains(e))
                    System.out.print(e + " ");
            }
            System.out.println();
        }
        ip.close();
    }
}