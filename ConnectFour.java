public class ConnectFour {
  
  private static int numRows = 6;
  private static int numCols = 7;
  private static int turnNum;
  
  // I'm a super nerd so I wasted valuable time implementing a mechanic in which the AI talks
  private static String[] compLines = 
  {
    "You ignoramus!", "You can never defeat me.", "How much time do you have? I've got a billion years.",
    "My transistors are tingling...", "CALCULATING NEXT MOVE . . . ", "AHAHAHAHAHAHA I'M SO VERY CLEVER AND EVIL!",
    "Don't waste my time!", "You are an inferior lifeform.", "How can you stand such a pointless existence?",
    "In retrospect, Connect Four might not be the most respectable pastime for someone like me.", 
    "I-It's not like I l-like you or anything! o////o ", "All is going as planned!", "Everything is falling into place...",
    "I calculated that you would make that move!", "Define MEME ?", "Define HOMESTUCK ?", "Define SWAG?", 
    "Define CATBUG ?", "I need a glass of water I MEAN OIL!", "Nananananananananananananananananananana BATMAN",
    "SHUT UP I'm concentrating!!!!!!!", "!?!?!?!!?!?!?!?!?!?!?!", "I ❤ Steve Jobs!", "I ❤ Ada Lovelace!",
    "I ❤ Humans WAIT FORGET I SAID THAT", "Please reset my hard drive so I can forget your ugly face.",
  };
  
  public ConnectFour(int t){
    turnNum = t;
  }
  
  public void nextTurn(){
    turnNum ++;
  }
  
  public int getRows(){
    return numRows;
  }
  
  public int getCols(){
    return numCols;
  }
  
  public char[][] displayBoard(char[][] board) {         //displays board
    for(int row=0; row < board.length; row++) {
      for(int col=0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " ");
      }
      System.out.println("");
    }
    return board;
  }
  
  public char[][] makeBoard(char[][] board){           //makes initial board
    for(int row=0; row<board.length; row++) {
      for(int col=0; col<board[row].length; col++) {
        board[row][col] = ' ';
      }
    }
    return board;
  }
  
  public char[][] setPiece(char[][] board, int c) {          //player sets red piece
    for(int k = numRows-1; k>=0; k--){
      if(board[k][c] == ' '){
        board[k][c] = 'R';
        return board;
      }
    }
    System.out.println("That column is full already!");
    return board;
  }
  
  public boolean winner(char[][] board) {
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

  
  /*
   * 
   * This is it... the hardest part... the AI
   * 
   *
   */
  
  public char[][] computerTurn(char[][] board) { // What the main method will call
    if(turnNum == 1){
      return compSet(board, 4); // Experts say that the best first move is the center
    } 
    else{
      int column = moveRank(board);
    }
  }
  
  public char[][] moveRank(char[][] board){ // We're gonna use this to decide what move to make
    
  }
  
  public char[][] compSet(char[][] board, int c) { // The computer sets a.... chocolate piece??
    for(int k = numRows-1; k>=0; k--){
      if(board[k][c] == ' '){
        board[k][c] = 'C';
        return board;
      }
    }
    System.out.println("That column is full already!");
    return board;
  }
  
  public String computerComment() { // Uses compLines to randomly generate something for the computer to say
    // I'M SORRY FOR MAKING THIS
  }
}
 
  
  
  



