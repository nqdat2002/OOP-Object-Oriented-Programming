package OOPs.MangDoiTuong.J05066;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J05066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Staff> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) {
            Staff a = Staff.nextStaff(sc);
            if(a.getType().compareTo("GD") == 0 && Integer.valueOf(a.getNum()) > 1){
                a.setType("NV");
                list.add(a);
                continue;
            }
            else if(a.getType().compareTo("TP") == 0 && Integer.valueOf(a.getNum()) > 3){
                a.setType("NV");
                list.add(a);
                continue;
            }
            else if(a.getType().compareTo("PP") == 0 && Integer.valueOf(a.getNum()) > 3){
                a.setType("NV");
                list.add(a);
                continue;
            }
            list.add(a);
            
        }
        Collections.sort(list);
        x = sc.nextLine();
        int q = Integer.valueOf(x);
        x.isEmpty();
        while(q-- > 0){
            String names = sc.nextLine();
            names = names.toLowerCase();
            for (Staff staff : list) {
                String nm = staff.getName();
                nm = nm.toLowerCase();
                if(nm.contains(names)){
                    System.out.println(staff);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

class Staff implements Comparable<Staff>{
    private String name, code, type, num, cnt_salary;
    public Staff(){
        this.name = this.code = this.type = this.num = this.cnt_salary;
    }

    public Staff(String line){
        String [] array = line.split(" ");

        this.code = array[0];
        this.name = "";
        for(int i = 1; i < array.length - 1; ++i) this.name += (array[i] + " ");
        this.name += array[array.length - 1];
        this.type = code.substring(0, 2);
        this.num = code.substring(4);
        this.cnt_salary = code.substring(2, 4);
    }

    public void setType(String s){
        this.code = s + this.code.substring(2);
        this.type = s;
    }

    public static Staff nextStaff(Scanner sc){
        return new Staff(sc.nextLine());

    }

    public String getType(){
        return type;
    }
    public String getNum(){
        return num;
    }
    public String getCnt_salary(){
        return cnt_salary;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + " " + type + " " + num + " " + cnt_salary;
    }

    @Override
    public int compareTo(Staff o) {
        if(o.getCnt_salary().compareTo(this.getCnt_salary()) != 0){
            return o.getCnt_salary().compareTo(this.getCnt_salary());
        }
        return this.getNum().compareTo(o.getNum());
    }
}