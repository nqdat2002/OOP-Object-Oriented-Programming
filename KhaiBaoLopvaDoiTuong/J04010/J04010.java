package OOPs.KhaiBaoLopvaDoiTuong.J04010;

import java.util.Scanner;

public class J04010 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        while(t-- > 0){
            double x = ip.nextDouble(), y = ip.nextDouble();
            Point p1 = new Point(x, y);
            x = ip.nextDouble(); y = ip.nextDouble();
            Point p2 = new Point(x, y);
            x = ip.nextDouble(); y = ip.nextDouble();
            Point p3 = new Point(x, y);

            double a = Point.distance(p1, p2);
            Double b = Point.distance(p1, p3);
            double c = Point.distance(p2, p3);
            if(a + b > c && a + c > b && b + c > a){
                double p = (a + b + c) / 2;
                double S = (p * (p - a) * (p - b) * (p - c));
                System.out.format("%.3f\n", (double) Math.PI * (a * a * b * b * c * c / (16 * S)));
            }else {
                System.out.println("INVALID");
            }
        }
        ip.close();
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