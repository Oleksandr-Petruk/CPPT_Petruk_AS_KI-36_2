package KI_306.Petruk.Lab6;

public class Driver {
    public static void main(String[] args) {
        // Example usage with Person
        Stack<Person> personStack = new Stack<>();
        personStack.push(new Person("Alice", 30));
        personStack.push(new Person("Bob", 25));
        personStack.push(new Person("Charlie", 35));
        personStack.push(new Person("Diana", 20));

        System.out.println("Minimum element in the person stack: " + personStack.findMin());
        System.out.println("Removed from stack: " + personStack.pop());
        System.out.println("Minimum element after removal: " + personStack.findMin());

        // Example usage with Rectangle
        Stack<Rectangle> rectangleStack = new Stack<>();
        rectangleStack.push(new Rectangle(4, 5));  // Area = 20
        rectangleStack.push(new Rectangle(3, 6));  // Area = 18
        rectangleStack.push(new Rectangle(2, 8));  // Area = 16
        rectangleStack.push(new Rectangle(1, 10)); // Area = 10

        System.out.println("Minimum element in the rectangle stack: " + rectangleStack.findMin());
        System.out.println("Removed from stack: " + rectangleStack.pop());
        System.out.println("Minimum element after removal: " + rectangleStack.findMin());
    }
}
