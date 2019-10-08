class Shape {
    protected String name;
    protected double perimeter;
    protected double area;

    //constructors
    public Shape() {

    }

    //methods

    public void draw() {
        System.out.println("Drawing Shape\n");
    }

    public void getArea() {

    }

    public void getPerimeter() {

    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle\n");
    }

    @Override
    public void getArea() {
        this.area = Math.PI * radius * radius;
        System.out.printf("Circle area is : %.2f\n", this.area);
    }

    @Override
    public void getPerimeter() {
        this.perimeter = 2 * Math.PI * radius;
        System.out.printf("Circle perimeter is : %.2f\n", this.perimeter);
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle\n");
    }

    @Override
    public void getArea() {
        this.area = this.width * this.height;
        System.out.println("Rectangle area is : " + this.area + "\n");
    }

    @Override
    public void getPerimeter() {
        this.perimeter = 2 * (this.width + this.height);
        System.out.println("Rectangle perimeter is : " + this.perimeter + "\n");
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square\n");
    }

    @Override
    public void getArea() {
        this.area = this.side * this.side;
        System.out.println("Square area is : " + this.area + "\n");
    }

    @Override
    public void getPerimeter() {
        this.perimeter = 4 * this.side;
        System.out.println("Square perimeter is : " + this.perimeter + "\n");
    }
}

public class ShapeTester {
    //Main operation class for testing

    public static void main(String args[]) {

        Shape s = new Shape();
        Rectangle r = new Rectangle(2.0,3.0);
        Circle c = new Circle(4.0);
        Square sq = new Square(4.0);

        r.getArea();
        r.getPerimeter();

        c.getArea();
        c.getPerimeter();

        sq.getArea();
        sq.getPerimeter();

        r.draw();
        c.draw();
        s.draw();
        sq.draw();
    }

}
