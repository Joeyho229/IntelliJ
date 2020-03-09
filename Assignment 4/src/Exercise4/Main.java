package Exercise4;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(10, 30.5);
        System.out.println(p1.distance(p2));
        System.out.println(Point.distance(p1, p2));
    }
}
