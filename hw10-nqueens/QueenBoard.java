/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    	return solveH(0); //start at leftmost column
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
    for( int r = 0; r < _board.length; r++ ) {
      if ( _board[r][col] == 0 ) { 
        addQueen(r,col);
        if ( col==_board.length-1 ) { 
          return true;
        }
        else if ( solveH(col + 1) ) {
          return true;
        }
        else { 
          removeQueen(r,col);
        }
	    }
    }
    return false;  //no solns from here
  }//end solveH


  public void printSolution()
  {
    String ans = "";

    //attempt to solve
    if ( !solve() ) {
      ans = " *** NO SOLUTION *** " ;
    }
    else {
      /** Print board, a la toString...
          Except:
          all negs and 0's replaced with underscore
          all 1's replaced with 'Q'
      */
      for( int r = 0; r < _board.length; r++ ) {
        for( int c = 0; c < _board[0].length; c++ ) {
          if (_board[r][c] == 1) {
            ans += "Q\t";
          }
          else {
            ans += "_\t";
          }
        }
        ans += "\n";
      }
    }
    System.out.println(ans);
  }//end printSolution



  //================= YE OLDE SEPARATOR =================

  /***
   * Places a queen on the board.
   * precondition: row & column valid
   * postcondition: if row/col not avail, return false
   *  else place 1 at location, return true
   */
  private boolean addQueen( int row, int col )
  {
    //is this spot attackable?
    if( _board[row][col] != 0 ) {
	    return false;
    }

    //spot is safe, so mark it
    _board[row][col] = 1;
    
    int offset = 1;

    // mark all spots attackable by latest queen
    // by decrementing their value
    // (anything <0 is not safe from attack)
    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]--;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Removes a queen from the board
   *  and configures as if she were never there
   * precondition: 
   * postcondition: queen at input location is gone,
   *  all changes associated with her placement are undone
   *  board is configured as if she had never been placed.
   */
  private boolean removeQueen( int row, int col )
  {
    //is there no queen here?
    if ( _board[row][col] != 1 ) {
	    return false;
    }

    //...so there was a queen here. Remove her.
    _board[row][col] = 0;

    int offset = 1;

    //mark all spots this queen could have attacked as a
    //little bit safer. (they could still be attackable by other queens)
    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Overrides inherited method to allow SOP(this)
   * precondition: _board has non-null String at every location
   * postcondition: board unchanged, represented flushed to stdout
   */
  public String toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    /*
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    */

    for( int n=1; n<=10; n++ ) {
      System.out.println("\n " + n + " safe queens on an "
                         + n + "x" + n + " board: ");    
      QueenBoard qb = new QueenBoard(n);
      qb.printSolution();
    }
  }
  
}//end class
