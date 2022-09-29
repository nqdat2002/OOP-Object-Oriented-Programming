package OOPs.VaoRaFile.J07042;

import java.io.Serializable;

public class Pair implements Serializable, Comparable<Pair> {
    private int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(Pair o) {
        return this.getFirst() - o.getFirst();
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// ObjectInputStream obj=new ObjectInputStream(new FileInputStream("DATA.in"));
// ArrayList<Pair> a=(ArrayList<Pair>)obj.readObject();
// Collections.sort(a);
// Set<String> set=new HashSet<>();
// for(Pair x:a){
// String s=String.valueOf(x.getFirst())+"-"+String.valueOf(x.getSecond());
// if(x.getFirst()<x.getSecond()&&!set.contains(s)){
// set.add(s);
// System.out.println(x);
// }
// }

// ObjectInputStream obj=new ObjectInputStream(new FileInputStream("DATA.in"));
// ArrayList<Pair> a=(ArrayList<Pair>)obj.readObject();
// Collections.sort(a);
// Set<String> set=new HashSet<>();
// for(Pair x:a){
// String s=String.valueOf(x.getFirst())+"-"+String.valueOf(x.getSecond());
// BigInteger first=new BigInteger(String.valueOf(x.getFirst()));
// BigInteger second=new BigInteger(String.valueOf(x.getSecond()));
// if(x.getFirst()<x.getSecond()&&first.gcd(second).toString().equals("1")&&!set.contains(s)){
// set.add(s);
// System.out.println(x);
// }
// }