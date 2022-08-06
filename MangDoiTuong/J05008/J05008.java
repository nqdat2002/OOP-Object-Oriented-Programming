package OOPs.MangDoiTuong.J05008;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            List<Point> list = new ArrayList<>();
            int n = sc.nextInt();
            for(int i = 0; i < n; ++i){
                list.add(Point.nextPoint(sc));
            }
            double res = 0;
            for(int i = 1; i < n - 1; ++i){
                res += Point.getArea(list.get(0), list.get(i), list.get(i + 1));
            }
            System.out.format("%.3f\n", (double)res);
        }
        sc.close();
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

    public static Point nextPoint(Scanner sc){
        return new Point(sc.nextDouble(), sc.nextDouble());
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

    public static double getArea(Point p1, Point p2, Point p3){
        double a = Point.distance(p1, p2);
        double b = Point.distance(p1, p3);
        double c = Point.distance(p2, p3);
        double p = (a + b + c) / 2;
        return (double)Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public String toString() {
        return "(+" + this.x + "," + this.y + ")";
    }
}