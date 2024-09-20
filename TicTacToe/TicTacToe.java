import java.util.Scanner;

/**
 * TicTacToe
 */
public class TicTacToe {
    

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        char player = 'X';
        boolean gameOver = false;

        for (int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col] =' '; // Corrected here
            }
        }

        Scanner sc = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.println("player " + player + "'s turn");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(board[row][col]==' '){
                board[row][col] = player;
                gameOver= haveWon(board , player);

                if(gameOver){
                    System.out.println("\n" + player + " IS WON....");
                   
                }else{
                    player = (player == 'X') ? 'O' : 'X';

                }
            }else{
                System.out.println("Invalid Location .");
            }

        }

        printBoard(board);
    }

    // check the who is win or not
    // check the who is win or not
private static boolean haveWon(char[][] board, char player) {
    // Check the row for same sign
    for(int row=0;row<board.length;row++){
        if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
            return true;
        }
    }

    // Check the column for same sign
    for(int col=0;col<board[0].length;col++){
        if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
            return true;
        }
    }

    // for diagonal 
    if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
        return true;
    }

    if(board[2][0]==player && board[1][1]==player && board[0][2]==player){
        return true;
    }
    return false;
}
    // Print the board
    // Print the board
    private static void printBoard(char[][] board) {
    System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println((board[i][0] == ' ' ? " " : board[i][0]) + " | " +
                               (board[i][1] == ' ' ? " " : board[i][1]) + " | " +
                               (board[i][2] == ' ' ? " " : board[i][2]));
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

}