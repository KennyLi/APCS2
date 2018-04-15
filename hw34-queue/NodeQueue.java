public class NodeQueue<T> implements Queue<T> 
{
    LLNode<T> front;
    LLNode<T> back;
    int size = 0;

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            T retVal = front.getValue();
            front = front.getNext();
            return retVal;
        }
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( T x ) {
        if (size == 0) {
            front = new LLNode(x, null);
            back = front;
        } else {
            LLNode<T> temp = new LLNode(x, null);
            back.setNext(temp);
            back = back.getNext();
        }
        size += 1;
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
        return size == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public T peekFront() {
        return front.getValue();
    }

    public static void main (String[] args) {
        NodeQueue<Integer> cakes = new NodeQueue<Integer>();
        cakes.enqueue(2);
        cakes.enqueue(4);
        cakes.enqueue(8);
        cakes.enqueue(16);
        cakes.enqueue(32);
        System.out.println(cakes.peekFront());
        System.out.println("Peek expecting: 2");
        System.out.println(cakes.dequeue());
        System.out.println("Dequeue expecting: 2");
        System.out.println(cakes.dequeue());
        System.out.println("Dequeue expecting: 4");
        System.out.println(cakes.dequeue());
        System.out.println("Dequeue expecting: 8");
        System.out.println(cakes.dequeue());
        System.out.println("Dequeue expecting: 16");
        System.out.println(cakes.dequeue());
        System.out.println("Dequeue expecting: 32");
        System.out.println(cakes.dequeue());
        System.out.println("Dequeue expecting: NULL");                  
    }
}