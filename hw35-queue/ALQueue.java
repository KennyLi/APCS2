/* Kenny Li
APCS2 Pd1
HW#35 - Nor Do Aussies
2018-04-17 T */

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {

    private ArrayList<T> queue = new ArrayList<T>();

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return queue.remove(0);
        }

    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( T x ) {
        queue.add(x);
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public T peekFront() {
        return queue.get(0);
    }

    public static void main(String[] args) {
        ALQueue<Integer> cake = new ALQueue<Integer>();
        cake.enqueue(1);
        cake.enqueue(2);
        cake.enqueue(3);
        cake.enqueue(4);
        cake.enqueue(5);
        System.out.println(cake.peekFront());
        System.out.println("Expected peek: 1");
        System.out.println(cake.dequeue());
        System.out.println("Expected dequeue: 1");
        System.out.println(cake.dequeue());
        System.out.println("Expected dequeue: 2");
        System.out.println(cake.dequeue());
        System.out.println("Expected dequeue: 3");
        System.out.println(cake.dequeue());
        System.out.println("Expected dequeue: 4");
        System.out.println(cake.dequeue());
        System.out.println("Expected dequeue: 5");
        System.out.println(cake.dequeue());
        System.out.println("Expected dequeue: null");


    }
}