package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TN02012 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Department> list = new ArrayList<>();
        for(int i = 1; i <= n; ++i) list.add(Department.nextDepartment(sc));
        x = sc.nextLine();
        int m = Integer.valueOf(x);
        x.isEmpty();
        List<Employee> emp = new ArrayList<>();
        for(int i = 1; i <= m; ++i) emp.add(Employee.nextEmployee(sc, list));
        for (Employee employee : emp) {
            System.out.println(employee);
        }
    }
}

class Employee{
    private String name, code, depart;
    private long basic_Salary, total;
    private int factor, day_Work;
    private List<Department> list = new ArrayList<>();

    public Employee(String code, String name, long basic_Salary, int day_Work, List<Department> list){
        this.code = code;
        this.name = name;
        this.basic_Salary = basic_Salary;
        this.day_Work = day_Work;
        this.list = list;

        int year = Integer.valueOf(code.substring(1, 3));
        if(this.code.charAt(0) == 'A'){
            if(year <= 3) this.factor = 10;
            else if(year <= 8) this.factor = 12;
            else if(year <= 16) this.factor = 14;
            else this.factor = 20;
        }
        if(this.code.charAt(0) == 'B'){
            if(year <= 3) this.factor = 10;
            else if(year <= 8) this.factor = 11;
            else if(year <= 16) this.factor = 13;
            else this.factor = 16;
        }
        if(this.code.charAt(0) == 'C'){
            if(year <= 3) this.factor = 9;
            else if(year <= 8) this.factor = 10;
            else if(year <= 16) this.factor = 12;
            else this.factor = 14;
        }
        if(this.code.charAt(0) == 'D'){
            if(year <= 3) this.factor = 8;
            else if(year <= 8) this.factor = 9;
            else if(year <= 16) this.factor = 11;
            else this.factor = 13;
        }
        String s = code.substring(3);
        for (Department dp : this.list) {
            if(s.compareTo(dp.getCode()) == 0)
                this.depart = dp.getName().substring(1);
        }
        this.total = (long)(this.factor * this.day_Work * this.basic_Salary) * 1000;
    }

    public static Employee nextEmployee(Scanner sc, List<Department> list){
        return new Employee(sc.nextLine(), sc.nextLine(), Long.valueOf(sc.nextLine()), Integer.valueOf(sc.nextLine()), list);
    }

    @Override 
    public String toString(){
        return code + " " + name + " " + depart + " " + total;
    }
}

class Department{
    private String name, code;

    public Department(){
        this.name = this.code = "";
    }

    public Department(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static Department nextDepartment(Scanner sc){
        Department a = new Department();
        a.code = sc.next();
        String x = sc.nextLine();
        a.name = x;
        x.isEmpty();
        return a;
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
}
