import java.util.ArrayList;

public class Main {


    static double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }

    //Practice: Make a static method in Main that takes an array of LibraryItem objects and returns them all to the library.
    public static void returnAll(LibraryItem[] items) {

            for(int i = 0; i < items.length; i++) {
                items[i].returnItem();
            }
    }

    //Make a static method in Main that takes an array of LibraryItem objects and outputs an ArrayList of LibraryItem objects with all of the available items from the input array.
    public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
        ArrayList<LibraryItem> itemsAvailable = new ArrayList<>();
        
            for(int i = 0; i < items.length; i++) { 
            
                if(items[i].available() == true) {
                    itemsAvailable.add(items[i]);
                } 
                
            }     
        return itemsAvailable;
    }


    static Shape[] scaleAll(Shape[] shapes, double k) {
        Shape[] scaled = new Shape[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            scaled[i] = shapes[i].scale(k);
        }
        return scaled;
    }

    static <T> String arrayToString(T[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        return str + arr[arr.length - 1] + "]";
    }
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
        
       
        System.out.println("distance: " + Point.distance(a, b));
        
        

        
        
        
        //arraylists
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        System.out.println(arr);
        arr.set(0, "Goodbye");
        System.out.println(arr);

        ArrayList<Boolean> conditions = new ArrayList<>();
        conditions.add(true);
        conditions.add(arr.get(0) == "Hello");
        conditions.add(conditions.get(0) || conditions.get(1));
        System.out.println(conditions);

        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            intArr.add(0);
        }
        System.out.println(intArr.size());
        System.out.println(intArr.get(32));


        //Polymorphism - grid
        
        Grid<Integer> grid = new Grid<>(5, 0);
        grid.set(1, 1, 1);
        grid.set(2, 2, 7);
        System.out.println("Grid: \n" + grid);

        //Shape interface
        Shape[] shapes = {
            new Circle(new Point(1.8, -20), 2), 
            new Square(new Point(100, 2.1), 5.4),
            new Circle(new Point(0, 0), 1),
            new Circle(new Point(4, 9.123), 98.32),
            new Square(new Point(-321, 0), 0.02),
            new RightTriangle(new Point(0, 0), 2, 2)};
            System.out.println("Shapes Area: " + sumArea(shapes));
        
        



        //practice: rotation

        //pratice: center of mass
        System.out.println("center of mass: " + Point.centerOfMass(points));    

        //Practice: Create a non-static method in Grid called diagonal that returns an ArrayList with the primary diagonal of the grid 
        //(from top left to bottom right). Here's the header:
        System.out.println("Diagonal: " + grid.diagonal());
        

        //Practice: In the Circle class, create a static method that generates a Circle from 
        //three points that are on the edge of the circle (if you don't remember and can't figure out how to do this, look it up).
        Point point1 = new Point(-2, 2);
        Point point2 = new Point(-2, -6);
        Point point3 = new Point(5, 1);
        Circle newCircle = Circle.fromPoints(point1, point2, point3);
        System.out.println("newCircle Perimeter: " + newCircle.perimeter());

        
        //Practice: Create a RightTriangle class that implements Shape. The sides of the triangle are necessarily parallel to the x and y axes, but the right angle can be in any corner (top right, bottom left, etc). 
        //You can store a corner and two side lengths (or any other combination of fields that describe a right triangle).
        //In addition to all the methods in Shape, RightTriangle should have a static method called similar that takes two RightTriangle objects and returns whether or not they are similar.
        Point corner = new Point(0, 0);
        RightTriangle test1 = new RightTriangle(corner, 1, 1);
        RightTriangle test2 = new RightTriangle(corner, 2, 2);
        System.out.println("Similarity: " + RightTriangle.similar(test1, test2));
        
        Book testBook = new Book("test", "1", "a", 1);
        Book testBook2 = new Book("testtwo", "2", "b", 1);
        Book testBook3 = new Book("testthree", "3", "c", 1);
        LibraryItem[] testItems = {testBook, testBook2, testBook3};
        System.out.println(availableItems(testItems));
        testBook.checkOut();
        testBook2.checkOut();
        testBook3.checkOut();
        System.out.println(availableItems(testItems));
        returnAll(testItems);
        System.out.println(availableItems(testItems));
        returnAll(testItems);
        
        }
}