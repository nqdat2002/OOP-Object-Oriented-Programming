package OOPs.XauKyTu;

import java.util.Scanner;
import java.util.Vector;

// loai bo 100
public class Pair1 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        String x = ip.nextLine();
        x.isEmpty();
        while (t-- > 0) {
            String a = ip.nextLine();
            int cnt = 0, res = 0;
            Vector<Pair<Character, Integer> > vv = new Vector<>();
            for (int i = 0; i < a.length(); ++i) {
                char c = a.charAt(i);
                Pair<Character, Integer> px = new Pair<>();
                px.setFirst(c);
                px.setSecond(i);
                vv.add(px);
                while(vv.size() >= 3 && vv.get(vv.size() - 1).getFirst() == '0' && vv.get(vv.size() - 2).getFirst() == '0' && vv.get(vv.size() - 3).getFirst() == '1'){
                    vv.remove(vv.size() - 1);
                    vv.remove(vv.size() - 1);
                    vv.remove(vv.size() - 1);
                }
                cnt = vv.get(vv.size() - 1).getSecond();
                res = mmax(res, i - cnt);
            }
            System.out.println(res);
        }
        ip.close();
    }
    public static int mmax(int x, int y){
        if(x > y)
            return x;
        return y;
    }
}
class Pair<T1, T2> {
    /**
     * The first element of this pair.
     */
    protected T1 first = null;

    /**
     * The second element of this pair.
     */
    protected T2 second = null;

    /**
     * Creates a new {@code Pair} with a pair of {@code null} values.
     */
    public Pair() {
    }

    /**
     * Creates a new {@code Pair} with the specified {@code first} and
     * {@code second} values.
     * 
     * @param first
     *            the value of the first element of the pair.
     * @param second
     *            the value of the second element of the pair.
     */
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first element of this pair.
     * 
     * @return the first element of this pair.
     */
    public T1 getFirst() {
        return first;
    }

    /**
     * Sets the first element of this pair.
     * 
     * @param first
     *            the new first element of this pair.
     */
    public void setFirst(T1 first) {
        this.first = first;
    }

    /**
     * Gets the second element of this pair.
     * 
     * @return the second element of this pair.
     */
    public T2 getSecond() {
        return second;
    }

    /**
     * Sets the second element of this pair.
     * 
     * @param second
     *            the new second element of this pair.
     */
    public void setSecond(T2 second) {
        this.second = second;
    }
}
