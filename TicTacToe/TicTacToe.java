/**
 * written by Adam Einstein
 */
import java.util.Scanner;

public class TicTacToe {  
  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args)
  {
    final int SIZE = 3; // Constant
    char[][] board = new char[SIZE][SIZE]; // establishes the game board and size specified by constant
    resetBoard(board); // initializes board with blank cells
    System.out.println(" Welcome to Tic Tac Toe Journey ! How many games can you win in a row? "); 
    showBoard(board);  // displays blank board after welcome dialogue                      
    System.out.print(" Which symbol do you want to play, \"x\" or \"o\"? ");// Decides which symbol the user wants to play as(X/O)
    char userSymbol = sc.next().toLowerCase().charAt(0);
    char compSymbol = (userSymbol == 'x') ? 'o' : 'x'; 
    System.out.println();
    System.out.print(" Do you want to go first (y/n)? "); // Ask if the user wants to go first
    char ans = sc.next().toLowerCase().charAt(0); //character input
    int turn; //  user= 0, computer =1
    int remainCount = SIZE * SIZE; // empty cell count
    
    // FIRST MOVE.
    if (ans == 'y') 
    {
      turn = 0;
      userPlay(board, userSymbol); // user puts their first move
    }
    else 
    {
      turn = 1;
      compPlay(board, compSymbol); // computer puts its first move
    }
    showBoard(board);
    remainCount--;      // Show the board, and lower the count of remaining cells
    // Play the game until either one wins
    boolean done = false;
    int winner = -1;   // 0 = user, 1 = computer, -1 = draw
    
    while (!done && remainCount > 0) 
    {
      done = isGameWon(board, turn, userSymbol, compSymbol); //Set winner if won has been made
      if (done)
        winner = turn; // the one who made the last move won the game
      else             // No winner yet, find the next turn and play
      {
        turn = (turn + 1 ) % 2;
        if (turn == 0)
          userPlay(board, userSymbol);
        else
          compPlay(board, compSymbol);
        showBoard(board);
        remainCount--;        // Show the board after one move, and lower the remaining count.
      }
    }
    if (winner == 0)     // Declare the winner
      System.out.println(" You Win! ");
    else if (winner == 1)
      System.out.println(" You lost... ");
    else
      System.out.println(" It's a draw... ");
  }
  public static void resetBoard(char[][] brd)
  {
    for (int i = 0; i < brd.length; i++)
      for (int j = 0; j < brd[0].length; j++)
      brd[i][j] = ' ';
  }
  public static void showBoard(char[][] brd)
  {
    int numRow = brd.length;
    int numCol = brd[0].length;
    System.out.println();
    // First write the column header
    System.out.print("    ");
    for (int i = 0; i < numCol; i++)
      System.out.print(i + "   ");
    System.out.print('\n');
    System.out.println(); 
    
    // To write the table
    for (int i = 0; i < numRow; i++) 
    {
      System.out.print(i + " ");
      for (int j = 0; j < numCol; j++) 
      {
        if (j != 0)
          System.out.print("|");
        System.out.print(" " + brd[i][j] + " ");
      }
      System.out.println();
      if (i != (numRow - 1)) 
      {
        System.out.print("   ");
        for (int j = 0; j < numCol; j++) 
        {
          if (j != 0)
            System.out.print("__"); //creates grid for table
          System.out.print("___");
        }
        System.out.println();
      }
    }
    System.out.println();
  }
  
  public static void userPlay(char[][] brd, char abcd)
  {
    System.out.print(" Enter coordinates, first entering your X coordinate alone, and the follow with your Y coordinate ");
    int rowIndex = sc.nextInt();
    int colIndex = sc.nextInt();
    while (brd[rowIndex][colIndex] != ' ') 
    {
      System.out.print(" The cell is already taken. Enter coordinates: ");
      rowIndex = sc.nextInt();
      colIndex = sc.nextInt();
    }
    
    brd[rowIndex][colIndex] = abcd;
  }
  
  public static void compPlay(char[][] brd, char abcd)
  {
    // Find the first empty cell and put a tic there.
    for (int i = 0; i < brd.length; i++) {
      for (int j = 0; j < brd[0].length; j++) {
        if (brd[i][j] == ' ') { // empty cell
          brd[i][j] = abcd;
          return;
        }
      }
    }
  } 
  public static boolean isGameWon(char[][] brd, int turn, char abce, char abcd)
  {
    char symbol;
    if (turn == 0)
      symbol = abce;
    else
      symbol = abcd;
    int i, j;
    boolean win = false;
    // Check win by a row
    for (i = 0; i < brd.length && !win; i++) 
    {
      for (j = 0; j < brd[0].length; j++) 
      {
        if (brd[i][j] != symbol)
          break;
      }
      if (j == brd[0].length)
        win = true;
    }
    // Check win by a column
    for (j = 0; j < brd[0].length && !win; j++) 
    {
      for (i = 0; i < brd.length; i++) 
      {
        if (brd[i][j] != symbol)
          break;
      }
      if (i == brd.length)
        win = true;
    }
    // Check win by a diagonal type 1
    if (!win) 
    {
      for (i = 0; i < brd.length; i++) 
      {
        if (brd[i][i] != symbol)
          break;
      }
      if (i == brd.length)
        win = true;
    }
    // Check win by a diagonal type 2
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][brd.length - 1 - i] != symbol)
          break;
      }
      if (i == brd.length)
        win = true;
    }
    // return win
    return win;
  }
}