package Exercise1;

public class Main {

    public static void main(String[] args){
        Triangle myTriangle = new Triangle(1, 2, 3);
        myTriangle.setColor("yellow");
        myTriangle.setFilled(true);

        System.out.println(myTriangle.toString());
        System.out.println(myTriangle.getArea());
        System.out.println(myTriangle.getPerimeter());
        //System.out.println(myTriangle);
    }
}
