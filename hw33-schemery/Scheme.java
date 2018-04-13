/* Kenny Li
APCS2 -- pd1
HW 33 - What a Racket
2018-04-13 F */

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split expression into array
 *   2. Create two stacks: one for operators and other or numbers
 *   3. Traverse the array backwards
 *	 	a. if element is an operator, add to operator stack
 *      b. if element is not an operator and not an open paren,
 *		   add to numbers stack
 *		c. if element is an open paren perform the unload method 
 *		   and then push the returned value.
 *         Unload method performs the operator at the top of the operators stack
 *	       on the numbers in the numbers stack until it reaches a closing paren.
 *		   When it reaches the clothing paren, pop it out and return the output.
 *   5. Profit!
 *
 * STACK OF CHOICE: ALStack by Mr.Brown
 * b/c I don't think it matters which one we use.
 * The stacks should operate the same b/t both implementations.
 ******************************************************/

public class Scheme
{
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
	  String[] array = expr.split("\\s+");
	  Stack<Integer> operators = new ALStack<Integer>();
	  Stack<String> numbers = new ALStack<String>();
	  for (int x = array.length - 1; x >= 0; x--) {
		  if (array[x].equals("+")) {
			  operators.push(1);
		  } else if (array[x].equals("-")) {
			  operators.push(2);
		  } else if (array[x].equals("*")) {
			  operators.push(3);
		  } else if (array[x].equals("(")) {
			  numbers.push(unload(operators.pop(), numbers));
		  } else {
			  numbers.push(array[x]);
		  }
	  }
	  return numbers.pop();
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers )
  {
	int output = Integer.parseInt(numbers.pop());
	while (!numbers.peek().equals(")")) {
		if (op == 1) {
			output += Integer.parseInt(numbers.pop());
		} else if (op == 2) {
			output -= Integer.parseInt(numbers.pop());
		} else {
			output *= Integer.parseInt(numbers.pop());
		}
	}
	numbers.pop();
	return "" + output;
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );	  
      //...-4
	  
      String zoo5 = "( + ( * 2 4 ) ( + 3 4 ) ( - 2 1 ) ( + 2 2 ) )";
      System.out.println(zoo5);
      System.out.println("zoo5 eval'd: " + evaluate(zoo5) );	  
      //...20
	  
      String zoo6 = "( * ( + 3 2 ) 2 3 )";
      System.out.println(zoo6);
      System.out.println("zoo6 eval'd: " + evaluate(zoo6) );	  
      //...30
	  
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v	  
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
