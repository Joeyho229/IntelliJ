package Exercise4;

public class Point {
    private double x;
    private double y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        double d = Math.sqrt((x-p.getX())*(x-p.getX())+(y-p.getY())*(y-p.getY()));
        return d;
    }

    static public double distance(Point p1, Point p2){
        double d = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2)+Math.pow(p1.getY() - p2.getY(), 2));
        return d;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
