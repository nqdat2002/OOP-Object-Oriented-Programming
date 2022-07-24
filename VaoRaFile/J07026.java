package OOPs.VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07026 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("POLYGON.in"));
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            Point p[] = new Point[n];
            for(int i = 0; i < n; i++){
                p[i] = new Point(in.nextInt(),in.nextInt());
            }
            Polygon poly = new Polygon(p);
            System.out.println(poly.getArea());
        }
        in.close();
    }
}

class Polygon{
    private Point [] p = new Point[1004];

    public Polygon(Point [] array){
        this.p = array.clone();
    }
    public String getArea(){
        double res = 0;
        for(int i = 1; i < this.p.length - 1; ++i){
            res += Point.getAreaOfTriagle(p[0], p[i], p[i + 1]);
        }
        return String.format("%.3f",(double) res);
    }

    @Override
    public String toString(){
        return getArea();
    }
}

class Point{
    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    public static Point nextPoint(Scanner sc){
        return new Point(sc.nextInt(), sc.nextInt());
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public double distance(int x, int y){
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    public static double getAreaOfTriagle(Point p1, Point p2, Point p3){
        double a = Point.distance(p1, p2);
        double b = Point.distance(p1, p3);
        double c = Point.distance(p2, p3);
        double p = (a + b + c) / 2;
        return (double)Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "(+" + this.x + "," + this.y + ")";
    }
}