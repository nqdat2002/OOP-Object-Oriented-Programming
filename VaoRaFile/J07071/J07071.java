package OOPs.VaoRaFile.J07071;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J07071 {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<PerSon> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) 
            list.add(PerSon.nextPerSon(sc));
        Collections.sort(list);
        String m = sc.nextLine();
        int q = Integer.valueOf(m);
        m.isEmpty();
        while(q-- > 0){
            String s = sc.nextLine();
            if(s.contains("*")){
                for (PerSon perSon : list) {
                    String tmp = perSon.getShortname();
                    if(tmp.length() == s.length() && findName(tmp, s)){
                        System.out.println(perSon);
                    }
                }
            }else{
                for (PerSon perSon : list) {
                    String tmp = perSon.getShortname();
                    if(tmp.compareTo(s) == 0){
                        System.out.println(perSon);
                    }
                }
            }
        }
        sc.close();
    }

    public static boolean findName(String name, String shortname){
        int l2 = shortname.length(), index = 0;
        for(int i = 0; i < l2; ++i){
            if(name.charAt(i) != shortname.charAt(i)){
                index = i;
                break;
            }
        }
        for(int i = index + 1; i < l2; ++i){
            if(name.charAt(i) != shortname.charAt(i)){
                return false;
            }
        }
        return true;
    }
   
}

class PerSon implements Comparable<PerSon>{
    private String name, fistname, lastname;
    private String shortname;
    public PerSon(){
        this.name = this.fistname = this.lastname = "";
        this.shortname = "";
    }

    public PerSon(String name){
        this.name = name;
        String [] a = name.split(" ");
        this.fistname = a[0];
        this.lastname = a[a.length - 1];
        this.shortname = "";
        for(int i = 0; i < a.length - 1; ++i){
            this.shortname += ("" + a[i].charAt(0) + ".");
        }
        this.shortname += ("" + a[a.length - 1].charAt(0));
    }

    public static PerSon nextPerSon(Scanner sc){
        return new PerSon(sc.nextLine());
    }

    public String getFirstname(){
        return fistname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getShortname(){
        return shortname;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(PerSon o) {
        if(this.getLastname().compareTo(o.getLastname()) != 0){
            return this.getLastname().compareTo(o.getLastname());
        }
        return this.getFirstname().compareTo(o.getFirstname());
    }
}
