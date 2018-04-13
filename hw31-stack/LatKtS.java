/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/

public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
    int numChars = s.length();
    Latkes yum = new Latkes( numChars );

    for( int i = 0; i < numChars; i++ ) {
      yum.push( s.substring(i,i+1) );
    }

    String retStr = "";
    for( int i = 0; i < numChars; i++ ) {
      retStr += yum.pop();
    }

    return retStr;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
    Latkes stack = new Latkes(s.length());

    for (int i = 0 ; i < s.length(); i ++) {
      String tmp = s.substring(i, i+1);
      if ( tmp.equals("(") || tmp.equals("{")
           || tmp.equals("[") )
        stack.push(tmp);
      else if (stack.isEmpty()) return false;
      else if (  tmp.equals(")") && !stack.pop().equals("(")
                 || tmp.equals("}") && !stack.pop().equals("{")
                 || tmp.equals("]") && !stack.pop().equals("[") )
        return false;
    }
    return stack.isEmpty();
  }//end allMatched()

  /*  ALTERNATE VERSION
    public static boolean allMatched( String s )
    {
  int maxSize = s.length();
  Latkes parenStack = new Latkes(maxSize);

  //process input string, one char at a time
  for( int i = 0; i < s.length(); i++ ) {
      String curr = s.substring( i, i+1 );

      // if an opener, push onto stack
      if ( curr.equals("(") ||
     curr.equals("{") ||
     curr.equals("[") ) {
    parenStack.push( curr );
      }
      // if a closer, pop from stack, chk for match
      else if ( curr.equals(")") ) {
    if ( parenStack.isEmpty() ||
         !parenStack.pop().equals("(") )
        return false;
      }
      else if ( curr.equals("}") ) {
    if ( parenStack.isEmpty() ||
         !parenStack.pop().equals("{") )
        return false;
      }
      else if ( curr.equals("]") ) {
    if ( parenStack.isEmpty() ||
         !parenStack.pop().equals("[") )
        return false;
      }
  }

  if ( parenStack.isEmpty() )
      return true;
  else {
      return false;
  }
    }//end allMatched()
   */


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
