package OOP_TOT_NGHIEP.HuongDoiTuong;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

// CHUA AC

public class TN02014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0){
            Triangle a = new Triangle(sc.nextLine());
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
        sc.close();
    }
}
class Triangle extends Point{ 
    private Point p1; 
    private Point p2;
    private Point p3;

    private double a;
    private double b;
    private double c;

    public Triangle(){
        this.p1 = new Point(0, 0);
        this.p2 = new Point(0, 0);
        this.p3 = new Point(0, 0);
        this.a = Point.distance(p1, p2);
        this.b = Point.distance(p2, p3);
        this.c = Point.distance(p1, p3);
    }

    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.a = Point.distance(p1, p2);
        this.b = Point.distance(p2, p3);
        this.c = Point.distance(p1, p3);
    }

    public Triangle(String s){
        StringTokenizer stk = new StringTokenizer(s);
        Vector<String> v = new Vector<>();
        while(stk.hasMoreTokens()){
            v.add(stk.nextToken());
        }
        this.p1 = new Point(Double.valueOf(v.get(0)), Double.valueOf(v.get(1)));
        this.p2 = new Point(Double.valueOf(v.get(2)), Double.valueOf(v.get(3)));
        this.p3 = new Point(Double.valueOf(v.get(4)), Double.valueOf(v.get(5)));
        this.a = Point.distance(p1, p2);
        this.b = Point.distance(p2, p3);
        this.c = Point.distance(p1, p3);
    }

    public boolean valid(){
        return (a + b > c && a + c > b && b + c > a);
    }
    
    public String getPerimeter(){
        return String.format("%.3f", (double)(a + b + c));
    }
    
    public String getArea(){
        double p = (a + b + c) / 2;
        return String.format("%.2f", (double)Math.sqrt(p * (p - a) * (p - b) * (p - c)));     
    }
    
    public String getCircumcircle(){
        double p = (a + b + c) / 2;
        double S = (p * (p - a) * (p - b) * (p - c));
        return String.format("%.3f", (double) Math.PI * (a * a * b * b * c * c / (16 * S)));
    }
    
    public static Triangle nextTriangle(Scanner sc){
        return new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
    }
    
    @Override
    public String toString(){
        return p1.toString() + " " + p2.toString() + " " + p3.toString();
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

