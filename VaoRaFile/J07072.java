package OOPs.VaoRaFile;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class J07072{
    public static void main(String [] args) throws FileNotFoundException{
        File f = new File("DANHSACH.in");
        Scanner sc = new Scanner(f);
        List<Person> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(Person.nextPerson(sc));
        }
        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                if((o1.getTen().compareTo(o2.getTen())) != 0){
                    return o1.getTen().compareTo(o2.getTen());
                }
                if((o1.getHo().compareTo(o2.getHo())) != 0){
                    return o1.getHo().compareTo(o2.getHo());
                }
                return o1.getDem().compareTo(o2.getDem());
            }
        });
        for (Person person : list) {
            person.Show();
        }
        sc.close();
    }
}

class Person{
    private String name;
    private String ho, dem, ten;
    private Vector<String> listname = new Vector<>();

    public Person(){
        this.name = this.ho = this.dem = this.ten = "";
        this.listname.clear();
    }

    public Person(String name){
        this.name = name;
    }

    public String getTen(){
        return ten;
    }
    public String getHo(){
        return ho;
    }
    public String getDem(){
        return dem;
    }

    public Vector<String> trueName(String a){
        a.toLowerCase();
        a = a.trim();
        Vector<String> st = new Vector<>();
        String res = "";
        a = a + " ";
        a = a.toLowerCase();
        for(int i=0 ; i< a.length() ; i++){
            if(a.charAt(i) == ' ' && res.length() > 0){
                res = res.toLowerCase();
                st.add(Std(res));
                res = "";
            }
            else if(a.charAt(i) >= 'a' && a.charAt(i) <= 'z') res += a.charAt(i);
        }
        return st;
    }
    public static String Std(String s){
        String res = "";
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(i == 0){
                res += Character.toUpperCase(c);
            }
            else res += c;
        }
        return res;
    }

    public static Person nextPerson(Scanner sc){
        Person a = new Person();
        a.name = sc.nextLine();
        a.listname = a.trueName(a.name);
        a.name = "";
        int l = a.listname.size();
        a.ho = a.listname.get(0);
        a.ten = a.listname.get(l - 1);
        for(int i = 1; i < l - 1; ++i) a.dem += (a.listname.get(i) + " ");
        for(int i = 0; i < l; ++i) a.name += (a.listname.get(i) + " ");
        return a;
    }

    public void Show(){
        System.out.println(this.name);
    }
}