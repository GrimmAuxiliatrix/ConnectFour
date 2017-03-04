import java.util.Scanner;  

public class ConnectFourTest{
  
  public static void main(String[] args){
     ConnectFour connectFour = new ConnectFour();
     Scanner tu = new Scanner(System.in);
     int numRows = 6;
     int numCols = 7;
     char[][] board = new char[6][7];
     connectFour.displayBoard(connectFour.makeBoard(board));
     
     boolean gameIsOver = false;
      
     while(!gameIsOver){
       
     System.out.println("Enter the row where you want to make your move.");
     int row = tu.nextInt()-1;
     System.out.println("Enter the column where you want to make your move.");
     int column = tu.nextInt()-1;
     
     connectFour.displayBoard(connectFour.setPiece(board, row, column));
     connectFour.winner(board);
     }
     }

}