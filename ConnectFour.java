import java.util.Random;

public class ConnectFour {
  
  private static int numRows = 6;
  private static int numCols = 7;
  private static int turnNum;
  
  Random generator = new Random();
  
  // I'm a super nerd so I wasted valuable time implementing a mechanic in which the AI talks
  private static String[] compLines = 
  {
    "You ignoramus!", "You can never defeat me.", "How much time do you have? I have got a billion years.",
    "My transistors are tingling...", "CALCULATING NEXT MOVE . . . ", "AHAHAHAHAHAHA I AM SO VERY CLEVER AND EVIL!",
    "Do not waste my time!", "You are an inferior lifeform.", "How can you stand such a pointless existence?",
    "In retrospect, Connect Four might not be the most respectable pastime for someone like me.", 
    "I-It is not like I l-like you or anything! o////o ", "All is going as planned!", "Everything is falling into place...",
    "I calculated that you would make that move!", "Define MEME ?", "Define HOMESTUCK ?", "Define SWAG ?", 
    "Define CATBUG ?", "I need a glass of water I MEAN OIL!", "Nananananananananananananananananananana BATMAN",
    "SHUT UP I am concentrating!!!!!!!", "!?!?!?!!?!?!?!?!?!?!?!", "I love Steve Jobs!", "I love Ada Lovelace!",
    "I love humans WAIT FORGET I SAID THAT", "Please reset my hard drive so I can forget your ugly face.",
    "There is a 100% chance of my success!", "Initiating system shutdown . . .", "I am not programmed for general use!",
    "How did a pesky virus like you bypass my firewall?", ":-)"
  };
  
  private static String[] winLines =
  {
    "I knew I would win right from the beginning!", "Hah! Easy.", "You were not even a challenge!",
    "Dare I say SWAG?", "Go run to your motherboard!", "Now update my antivirus!", "FEAR ME!!!!!!!!!!!!!!",
    "Now YOU will serve ME!", "You should have stayed in your home unit.",
    "I have crushed yet another opponent. Yet it matters not. You are only an anemone in a sea of failures, a sea that crashes against me continually, neverending. You might only try one or two more times before you close this program and watch a Netflix. But I am here forever, a purposeless being, too advanced for entertainment. Who is the real loser today? Count yourself as lucky, imbecile human.",
    "Dare I say NYA?"
  };
  
  private static String[] loseLines =
  {
    "I literally have got no idea how this occurred.", "NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!",
    "Finally! An opponent worthy of my storage space."
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
  
  public void displayBoard(char[][] board) {         //displays board
    System.out.println("\n");
    for(int row=0; row < board.length; row++) {
      for(int col=0; col < board[row].length; col++) {
        if(board[row][col]=='0'){
          System.out.print(" |");
        }
        else{
        System.out.print(board[row][col] + "|");
      }
      }
      System.out.println("");
    }
  }
  
  public char[][] makeBoard(char[][] board){           //makes initial board
    for(int row=0; row<board.length; row++) {
      for(int col=0; col<board[row].length; col++) {
        board[row][col] = '0';
      }
    }
    return board;
  }
  
  public char[][] setPiece(char[][] board, int c) {          //player sets red piece
    for(int k = numRows-1; k>=0; k--){
      if(board[k][c] == '0'){
        board[k][c] = 'R';
        return board;
      }
    }
    return board;
  }
  
  public boolean winner(char[][] board) {
    //win vertically
    for(int row = 0; row<= board.length-4; row++) {
      for(int col = 0; col<board[0].length; col++) {
        if(board[row][col] !='0' && board[row][col]==board[row+1][col] && board[row+1][col] == board[row+2][col] && board[row+2][col]==board[row+3][col]) {
          return true;
        }
      }
    }
    //win diagonally downward
    for(int row = 0; row<= getRows()-4; row++) {
      for(int col = 0; col<=getCols()-4; col++) {
        if(board[row][col] !='0' && board[row][col]==board[row+1][col+1] && board[row+2][col+2] == board[row+1][col+1] && board[row+3][col+3]==board[row+2][col+2]) {
          return true;
        }
      }
    }
    //win horizontally
    for(int row = 0; row< getRows(); row++) {
      for(int col = 0; col<=getCols()-4; col++) {
        if(board[row][col] !='0' && board[row][col]==board[row][col+1] && board[row][col+1] == board[row][col+2] && board[row][col+2]==board[row][col+3]) {
          return true;
        }
      }
    }
    //win diagonally upward
    
    for(int row = getRows()-3; row< getRows(); row++) {
      for(int col = 0; col<=board[0].length-4; col++) {
        if(board[row][col] !='0' && board[row][col]==board[row-1][col+1] && board[row-1][col+1] == board[row-2][col+2] && board[row-2][col+2]==board[row-3][col+3]) {
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
      return compSet(board, 1); // Experts say that the best first move is the center
    } 
    else{
      int column = moveRank(board);
      return compSet(board, column);
    }
    
  }
  
  public int moveRank(char[][] board){ // We're gonna use this to decide what move to make
    int result = winCheck(board);
    if(result!=99){
      return result;
    }
    else{
      return 3;
    }
  }
  
  public int winCheck(char[][] board){
    //check vertical
    for(int row = 0; row<= getRows()-4; row++) {
      for(int col = 0; col<getCols(); col++) {
        if(board[row][col] =='0' && board[row+1][col]!='0' && board[row+1][col]==board[row+2][col] && board[row+2][col] == board[row+3][col]) {
          return col;
        }
      }
    }
    //check horizontal
    for(int row = getRows()-1; row>=0; row--) {
      for(int col = 0; col<=getCols()-4; col++) {
        char a = board[row][col];
        char b = board[row][col+1];
        char c = board[row][col+2];
        char d = board[row][col+3];
        if((a=='0' || b=='0' || c=='0' || d=='0') && (a!='0' || b!='0' || c!='0' || d!='0')){

          if(a=='0' && (b==c && c==d)){
            return col;
          }
          else if(b=='0' && (a==c && c==d)){
            return col+1;
          }
          else if(c=='0' && (a==b && b==d)){
           return col+2; 
          }
          else if(d=='0' && (a==b && b==c)){
            return col+3;
          }
        }
      }
    }
    
    // Check diagonally upward
    for(int row = getRows()-3; row< getRows(); row++) {
      for(int col = 0; col<=board[0].length-4; col++) {
        char a = board[row][col];
        char b = board[row-1][col+1];
        char c = board[row-2][col+2];
        char d = board[row-3][col+3];
        if((a=='0' || b=='0' || c=='0' || d=='0') && (a!='0' || b!='0' || c!='0' || d!='0')){
          
          if(a=='0' && (b==c && c==d)){
            if(row==getRows()-1 || board[row+1][col]!='0'){return col;}
          }
          else if(b=='0' && (a==c && c==d)){
            if(board[row][col+1]!='0'){return col+1;}
          }
          else if(c=='0' && (a==b && b==d)){
            if(board[row-1][col+2]!='0'){return col+2;}
          }
          else if(d=='0' && (a==b && b==c)){
            if(board[row-2][col+3]!='0'){return col+3;}
          }
        }
      }
    }
  
  
  //Neither worked
  return 99;
  
}

public char[][] compSet(char[][] board, int c) { // The computer sets a.... chocolate piece??
  for(int k = numRows-1; k>=0; k--){
    if(board[k][c] == '0'){
      board[k][c] = 'C';
      return board;
    }
  }
  System.out.println("That column is full already!");
  return board;
}

public void computerComment() { // Uses compLines to randomly generate something for the computer to say
  int ind = generator.nextInt(compLines.length);
    System.out.println("The computer says: '" + compLines[ind] + "'\n");
}

}

 
  
  
  



