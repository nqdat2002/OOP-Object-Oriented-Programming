package OOPs.KhaiBaoLopvaDoiTuong.J04019;

import java.text.DecimalFormat;
import java.util.Scanner;

public class J04019{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
        sc.close();
    }
}
class Triangle{
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(){
        this.p1 = new Point(0, 0);
        this.p2 = new Point(0, 0);
        this.p3 = new Point(0, 0);
    }

    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public boolean valid(){
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p1, p3);
        return (a + b > c && a + c > b && b + c > a);
    }
    public String getPerimeter(){
        double a = Point.distance(p1, p2);
        double b = Point.distance(p2, p3);
        double c = Point.distance(p1, p3);
        DecimalFormat df = new DecimalFormat("#.###");
        double res = a + b + c;
        return df.format(res);
    }
}

class Point{
    private double x;
    private double y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public static Point nextPoint(Scanner ip){
        Point p = new Point(0, 0);
        p.x = ip.nextDouble();
        p.y = ip.nextDouble();
        return p;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public double distance(double x, double y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    public String toString() {
        return "(+" + this.x + "," + this.y + ")";
    }
}