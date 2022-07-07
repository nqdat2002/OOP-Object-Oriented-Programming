package OOPs.KhaiBaoLopvaDoiTuong;

import java.util.Scanner;

public class J04002 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int t = 1;
        while(t-- > 0){
            double x = ip.nextDouble();
            double y = ip.nextDouble();
            String s = ip.nextLine();
            if(x <= 0 || y <= 0){
                System.out.println("INVALID");
            }
            else{
                // co dau cach o dau tien
                char c = s.charAt(1);
                s = s.toLowerCase();
                c = Character.toUpperCase(c);
                s = c + s.substring(2, s.length());
                Rectange r = new Rectange(x, y, s);
                System.out.format("%.0f ", r.findPerimeter());
                System.out.format("%.0f ", r.findArea());
                System.out.print(r.getColor());
            }
        }
        ip.close();
    }
}
class Rectange{
    private double width;
    private double height;
    private String color;

    public Rectange(){
        this.width = 1;
        this.height = 1;
    }
    public Rectange (double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public double findArea(){
        return this.height * this.width;
    }

    public double findPerimeter(){
        return (this.height + this.width) * 2;
    }
}