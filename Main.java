public class Main {
    public static void main(String[] args) {
        
        Point point = new Point(4, 3);
        Point a = new Point(1, 1);
        Point b = new Point(1, 6);
        Point[] points = {a, b};
        
        Point xTranslation = point.translateX(3); // should be (7, 3)
        Point yTranslation = point.translateY(-7); // should be (4, -4)
        Point xyTranslation = point.translateX(-4).translateY(-3); // should be (0, 0)
        
        System.out.println("x transl: " + xTranslation);
        System.out.println("y transl: " + yTranslation);
        System.out.println("xy transl: " + xyTranslation);
        
       
        System.out.println(point.distance(a, b));
        
        //pratice :D - center of mass
        System.out.println(point.centerOfMass(points));
        
        
        
    }

}