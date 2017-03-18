import java.util.Scanner;  

public class ConnectFourTest{
  
  public static void main(String[] args){
     ConnectFour connect = new ConnectFour(1); // I changed it to connect because connectFour was too long
     Scanner tu = new Scanner(System.in);
     char[][] board = new char[connect.getRows()][connect.getCols()];
     board = connect.makeBoard(board);
     
     boolean gameIsOver = false;
     
     while(!gameIsOver){
       
       // The computer's turn
       board = connect.computerTurn(board);
       connect.displayBoard(board);
       connect.computerComment();
       
       // The player's turn
       System.out.println("Enter the column where you want to make your move.");
       int column = tu.nextInt()-1;
       board = connect.setPiece(board, column);    
       
       // Housekeeping
       connect.displayBoard(board);
       if(connect.winner(board)){
         gameIsOver = true;
       }       
       connect.nextTurn();
     }
  }  
  
}
