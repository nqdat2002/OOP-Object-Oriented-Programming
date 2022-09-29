package test;

import java.io.Serializable;

public class Pair implements Serializable, Comparable<Pair>{
        private int first,second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
        public int getFirst(){
            return this.first;
        }
        public int getSecond(){
            return this.second;
        }
        @Override
        public int compareTo(Pair o){
            return this.first-o.getFirst();
        }
        @Override
        public String toString(){
            return "(" + this.first + ", " + this.second + ")";
        }
}
