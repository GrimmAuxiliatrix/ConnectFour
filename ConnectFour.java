public class ConnectFour {
  
  private static int numRows = 6;
  private static int numCols = 7;
  
  public int getRows(){
    return numRows;
  }
  
  public int getCols(){
    return numCols;
  }
  
  public static char[][] displayBoard(char[][] board) {         //displays board
    for(int row=0; row < board.length; row++) {
      for(int col=0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " ");
      }
      System.out.println("");
    }
    return board;
  }
  
  public static char[][] makeBoard(char[][] board){           //makes initial board
    for(int row=0; row<board.length; row++) {
      for(int col=0; col<board[row].length; col++) {
        board[row][col] = 'O';
      }
    }
    return board;
  }
  
  public static char[][] setPiece(char[][] board, int c) {          //player sets red piece
    for(int k = 0; k<numRows; k++){
      if(board[k][c] == '0'){
        board[k][c] = 'R';
      }
    }
    return board;
  }
   
   
   public static boolean winner(char[][] board) {
     //win vertically
     for(int row = 0; row<= board.length-4; row++) {
       for(int col = 0; col<board[0].length; col++) {
         if(board[row][col] !=0 && board[row][col]==board[row+1][col] && board[row+1][col] == board[row+2][col] && board[row+2][col]==board[row+3][col]) {
           return true;
         }
       }
     }
     //win diagonally downward
     for(int row = 0; row<= board.length-4; row++) {
       for(int col = 0; col<=board[0].length-4; col++) {
         if(board[row][col] !=0 && board[row][col]==board[row+1][col+1] && board[row+2][col+2] == board[row+1][col+1] && board[row+3][col+3]==board[row+2][col+2]) {
           return true;
         }
       }
     }
     //win horizontally
     for(int row = 0; row< board.length; row++) {
       for(int col = 0; col<=board[0].length-4; col++) {
         if(board[row][col] !=0 && board[row][col]==board[row][col+1] && board[row][col+1] == board[row][col+2] && board[row][col+2]==board[row][col+3]) {
           return true;
         }
       }
     }
     //win diagonally upward
     
     for(int row = 3; row< board.length; row++) {
       for(int col = 0; col<=board[0].length-4; col++) {
         if(board[row][col] !=0 && board[row][col]==board[row-1][col+1] && board[row-1][col+1] == board[row-2][col+2] && board[row-2][col+2]==board[row-3][col+3]) {
           return true;
         }
       }
     }
     return false;
   }
   }
  
  
 
