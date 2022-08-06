package OOPs.MangDoiTuong.J05064;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class J05064 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Teacher> list = new ArrayList<>();
        Map<String, Integer > mp = new HashMap<>();
        for(int i = 1; i <= n; ++i){
            Teacher a = Teacher.nextTeacher(sc);
            if(!mp.containsKey(a.getCode())){
                mp.put(a.getCode(), 1);
                list.add(a);
                continue;
            }
            else if(a.getCode().compareTo("HP") == 0 && mp.get(a.getCode()) == 1){
                mp.remove("HP");
                mp.put("HP", 2);
                list.add(a);
                continue;
            }
            else if(a.getCode().compareTo("GV") == 0) list.add(a);
        }
        for (Teacher tch : list) {
            System.out.println(tch);
        }
        sc.close();
    }
}
class Teacher{
    private String code, name;
    private long salary, count, total, allowance;

    public Teacher(){
        this.code = this.name = "";
        this.salary = this.count = this.total = this.allowance = 0;
    }
    public Teacher(String code, String name, long salary){
        this.code = code;
        this.name = name;
        this.salary = salary;
        String s = this.code.substring(0, 2);
        if(s.compareTo("HT") == 0) this.allowance = 2000000;
        else if(s.compareTo("HP") == 0) this.allowance = 900000;
        else this.allowance = 500000;
        this.count = Long.valueOf(code.substring(2));
        this.total = (long) (this.count * this.salary + this.allowance);
    }

    public static Teacher nextTeacher(Scanner sc){
        return new Teacher(sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine()));
    }

    public String getCode(){
        return code.substring(0, 2);
    }

    @Override
    public String toString(){
        return code + " " + name + " " + count + " " + allowance + " " + total;
    }
}
