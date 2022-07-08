package OOPs.Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J08029 {
    public static Scanner sc = new Scanner(System.in);
    final static int [] dx = {0, 2, 2, 1, 1, -2, -2, -1, -1};
    final static int [] dy = {0, 1, -1, 2, -2, 1, -1, 2, -2};
    boolean [][] vs = new boolean[10][10];

    public void BFS(String s1, String s2){ 
        for(int i = 0; i < 10; ++i) for(int j = 0; j < 10; ++j) vs[i][j] = false;
        Pair<Integer, Integer> p1 = new Pair<>(setInteger(s1, 0, 96), setInteger(s1, 1, 48));
        Pair<Integer, Integer> p2 = new Pair<>(setInteger(s2, 0, 96), setInteger(s2, 1, 48));
        
        vs[p1.getFirst()][p1.getFirst()] = true;
  
        Queue<Pair<Pair<Integer, Integer>, Integer> > q = new LinkedList<>();
        q.add(new Pair<>(new Pair<>(p1.getFirst(), p1.getSecond()), 0));
        while(q.size() > 0){
            int x = q.peek().first.first, y = q.peek().first.second, w = q.peek().second;
            q.poll();
            if(x == p2.first && y == p2.second){
                System.out.println(w);
                return;
            }
            for(int i = 1; i <= 8; ++i){
                int xx = dx[i] + x, yy = dy[i] + y;
                if(xx >= 1 && xx <= 8 && yy >= 1 && yy <= 8 && !vs[xx][yy]){
                    vs[xx][yy] = true;
                    q.add(new Pair<>(new Pair<>(xx, yy), w + 1));
                }
            }
        }
    }

    public int setInteger(String s, int index, int j){
        return (int)s.charAt(index) - j;
    }

    public static void main(String [] args){
        String x = sc.nextLine();
        int t = Integer.valueOf(x);
        x.isEmpty();
        while(t-- > 0){
            J08029 test = new J08029();
            test.BFS(sc.next(), sc.next());
        }
        sc.close();
    }
}

class Pair<T1, T2> {
    public T1 first;
    public T2 second;

    public Pair() {
        this.first = null;
        this.second = null;
    }
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first; 
    }
    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }
    public void setSecond(T2 second) {
        this.second = second;
    }
}
