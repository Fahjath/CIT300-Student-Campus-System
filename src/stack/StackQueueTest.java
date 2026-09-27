package stack;

import queue.Queue;

public class StackQueueTest {

    public static void main(String[] args) {

        // =========================
        // STACK TEST - LIFO
        // =========================

        Stack stack = new Stack(5);

        stack.push("Student A");
        stack.push("Student B");
        stack.push("Student C");

        System.out.println("===== STACK TEST =====");

        System.out.println("Top item: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack empty: " + stack.isEmpty());


        // =========================
        // QUEUE TEST - FIFO
        // =========================

        Queue queue = new Queue(5);

        queue.enqueue("Student A");
        queue.enqueue("Student B");
        queue.enqueue("Student C");

        System.out.println();
        System.out.println("===== QUEUE TEST =====");

        System.out.println("Front item: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue empty: " + queue.isEmpty());
    }
}