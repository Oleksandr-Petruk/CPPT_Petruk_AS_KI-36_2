package KI_306.Petruk.Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * A parameterized class that implements a stack with basic operations.
 *
 * @param <T> The type of data stored in the stack. Must be comparable.
 */
public class Stack<T extends Comparable<T>> {
    private List<T> elements;

    /**
     * Constructor to create an empty stack.
     */
    public Stack() {
        this.elements = new ArrayList<>();
    }

    /**
     * Adds an element to the stack.
     *
     * @param element The element to add.
     */
    public void push(T element) {
        elements.add(element);
    }

    /**
     * Removes the last element from the stack.
     *
     * @return The removed element.
     * @throws IllegalStateException If the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    /**
     * Returns the minimum element in the stack.
     *
     * @return The minimum element.
     * @throws IllegalStateException If the stack is empty.
     */
    public T findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        T min = elements.get(0);
        for (T element : elements) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
