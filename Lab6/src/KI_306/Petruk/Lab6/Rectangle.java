package KI_306.Petruk.Lab6;

/**
 * A class representing a rectangle with a width and height.
 */
public class Rectangle implements Comparable<Rectangle> {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public int compareTo(Rectangle other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + ", area=" + getArea() + "}";
    }
}
