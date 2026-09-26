package stack;

public class Stack {

    private Object[] items;
    private int top;

    public Stack(int capacity) {
        items = new Object[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == items.length - 1;
    }

    public void push(Object item) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return;
        }

        items[++top] = item;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        return items[top--];
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return items[top];
    }

    public int size() {
        return top + 1;
    }
}