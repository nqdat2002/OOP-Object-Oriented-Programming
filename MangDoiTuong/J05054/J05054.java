package OOPs.MangDoiTuong.J05054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J05054 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int n = Integer.valueOf(x);
        x.isEmpty();
        List<Student> list = new ArrayList<>();
        List<Student> tmp = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            Student a = Student.nextStudent(sc, i);
            list.add(a);
            tmp.add(a);
        }
        Collections.sort(tmp, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2){
                return (int)( (int) 10 * (o2.getPoint() - o1.getPoint()));
            }
        });
        double pointmax = tmp.get(0).getPoint();
        int cnt = 1, q = 1;
        for (Student std : tmp) {
            if(std.getPoint() == pointmax){
                std.setRank(cnt);
                q++;
                continue;
            }
            else if(std.getPoint() < pointmax){
                std.setRank(q);
                pointmax = std.getPoint();
                cnt = q;
                q++;
                continue;
            }
        }
        for (Student st : tmp) {
            for (Student student : list) {
                if(st.getPoint() == student.getPoint()){
                    student.setRank(Integer.valueOf(st.getRank()));
                }
            }
        }
        for (Student st : list) {
            System.out.println(st);
        }
        sc.close();
    }
}
class Student{
    private String name, code, type;
    private double point;
    private String rank;

    public Student(){
        this.name = this.code = this.type = "";
        this.point = 0;
        this.rank = "";
    }

    public Student(String name, double point, int cnt){
        this.name = name;
        this.point = point;
        if(point >= 9) this.type = "Gioi";
        else if(point >= 7) this.type = "Kha";
        else if(point >= 5) this.type = "Trung Binh";
        else this.type = "Yeu";
        this.code = "HS" + cnt;
        while(this.code.length() < 4) this.code = this.code.substring(0, 2) + "0" + this.code.substring(2);
    }

    public static Student nextStudent(Scanner sc, int cnt){
        return new Student(sc.nextLine(), Double.valueOf(sc.nextLine()), cnt);
    }
    public void setRank(int cnt){
        rank = "" + cnt;
    }

    public double getPoint(){
        return point;
    }

    public String getRank(){
        return rank;
    }

    @Override
    public String toString(){
        return code + " " + name + " " + String.format("%.1f", (double)point) + " " + type + " " + rank;
    }

}
