package OOP_TOT_NGHIEP.NganXep;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DSA07020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println(chuanHoa(s));
        }
        sc.close();
    }

    public static String chuanHoa(String s) {
        StringBuilder kq = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            for (int i = t.length() - 1; i >= 0; i--) {
                kq.append(t.charAt(i));
            }
            kq.append(" ");
        }
        kq.deleteCharAt(kq.length() - 1);
        return kq.toString();
    }
}
