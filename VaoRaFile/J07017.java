package OOPs.VaoRaFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class J07017 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}

class Pair<T1, T2> {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public int getFirst() {
        return first;
    }
    public void setFirst(int first) {
        this.first = first;
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
    }

	public boolean isPrime(){
		return pr((int)this.first) && pr((int)this.second);
	}
	public boolean pr(int n){
		if(n < 2) return false;
		for(int i = 2; i <= Math.sqrt(n); ++i){
			if(n % i == 0)
				return false;
		}
		return true;
	}

    @Override
    public String toString(){
        return this.first + " " + this.second;
    }
}