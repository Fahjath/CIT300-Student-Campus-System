package queue;

public class Queue {

    private Object[] items;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        items = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public void enqueue(Object item) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        Object item = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size--;

        return item;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }

        return items[front];
    }

    public int size() {
        return size;
    }
}