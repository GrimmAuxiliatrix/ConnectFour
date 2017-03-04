public class ConnectFour {
  
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
   
   public static char[][] setPiece(char[][] board, int r, int c) {          //player sets red piece
     while(board[r+1][c] =='O') {
      r++;
     }
      board[r][c] = 'R';
     
    /* for(int i=0; i<6; i++) {
       if(board[r+1][c] !='O') {
        board[r][c] = 'R';
       }
     }    */
    return board;
   }
   
   public static boolean winner(char[][] board) {
     int counter = 1;
     for(int i=0; i<board.length; i++) {
       for(int j=0; j<board[i].length; j++) {
         if(board[i][j] == board[i+counter][j+counter]) {
          System.out.println("YOU'RE WINNER!");
          return true;
         }
       }
       counter++;
     }
  return false;
}
}
  
  
 