/* Kenny Li
APCS2 Pd1
HW#36 - Now Let's Consider You Lots at Fake Terry's
2018-04-18 W */

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue() 
	{
  _front = null;
  _end = null;
  _size = 0;
	}//end default constructor


  public void enqueue( T enQVal ) 
  {
  LLNode<T> temp = new LLNode<T>(enQVal, null);
  if (isEmpty()) {
    _front = temp;
    _end = temp;
  } else {
    _end.setNext(temp);
    _end = _end.getNext();
    _end.setNext(_front);
  }
  _size += 1;
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue() 
  {
  if (isEmpty()) {
    return null;
  } else {
    sample();
    T retVal = _front.getValue();
    _front = _front.getNext();
    _end.setNext(_front);
    _size -= 1;
    return retVal;
  }
  }//end dequeue()


  public T peekFront() 
  {
  return _front.getValue();
  }


  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * Make the queue circular
   * Randomize a number from 0 to size - 1
   * Shift the front and end that many spaces
   ******************************************/
  public void sample () 
  {
  int shift = (int)(_size * Math.random());
  while (shift > 0) {
    _front = _front.getNext();
    _end = _end.getNext();
    shift -= 1;;
  }
  }//end sample()


  public boolean isEmpty() 
  {
  return _size == 0;
  } //O(1)


    // print each node, separated by spaces
  public String toString() 
  {
  String retStr = _front.getValue() + " ";
  LLNode<T> temp = _front.getNext();
  while (temp != _front) {
    retStr += temp + " ";
    temp = temp.getNext();
  }
  return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {
    

      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing..."); 
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");

      System.out.println("\nnow testing toString()..."); 
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow dequeuing..."); 
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      System.out.println("\nnow dequeuing from empty queue..."); 
      System.out.println( PirateQueue.dequeue() );
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
