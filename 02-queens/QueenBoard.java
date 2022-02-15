import java.util.*;
import java.io.*;

public class QueenBoard {
    private int[][] board;


    public QueenBoard(int row, int col) {
        this.board = new int[row][col];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }


    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q'
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:
     *_ _ Q _
     *Q _ _ _
     *_ _ _ Q
     *_ Q _ _
     *excludes the characters up to the comment(*)
     */
    public String toString() {
        String temp = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    temp += "_ ";
                }
                if (board[i][j] == -1) {
                    temp += "Q ";
                }
                if (board[i][j] >= 1) {
                    temp += "X ";
                }
            }
            temp += "\n";
        }
        return temp;
    }

    /**
     *@return true when the queen added correctly, false Otherwise
     *@precondition r and c are valid indices of the board array
     *@postcondition the board is only changed when the function returns true
     * in which case the queen is added and all it's threatened positions are incremented
     */
    private boolean addQueen(int r, int c) {

        if (board[r][c] == 0) {
            board[r][c] = -1;

            for (int i = r + 1; i < board.length; i++) {
                board[i][c] += 1;
            }

            for (int a = 1;
                (a < board.length - r) && (a < board[0].length - c); a++) {
                board[r + a][c + a] += 1;
            }

            for(int b = 1; (c - b > -1)  && (r + b < board.length); b++){
              board[r + b][c - b] += 1;
            }
            return true;
        }
        return false;
    }

    /**Remove the queen that was added to r,c
     *@precondition r and c are valid indices of the board array and there is a queen at position r,c
     *@postcondition the board is modified to remove that queen and all it's
     *threatened positions are decremented
     */
    private void removeQueen(int r, int c) {
          board[r][c] = 0;
          for (int i = r + 1; i < board.length; i++) {
              board[i][c] -= 1;
          }
          for (int a = 1;
              (a < board.length - r) && (a < board[0].length - c); a++) {
              board[r + a][c + a] -= 1;
          }
      }



    /**Find the first solution configuration possible for this size board. Start by placing
     *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
     *  move the previous queen to the next valid space. This means everyone will generate the same
     *  first solution.
     *@postcondition: the board remains in a solved state.
     *@return false when the board is not solveable and leaves the board filled with zeros;
     *        returns true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
     */
    public boolean solve() {
        return true;
    }

    /**Find all possible solutions to this size board.
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
     */
    public int countSolutions() {
        return 1;
    }


    public static void main(String[] args) {

        QueenBoard t5 = new QueenBoard(20, 20);
        t5.addQueen(3, 9);
        t5.addQueen(3, 19);
        t5.addQueen(10, 0);
        t5.addQueen(19, 19);


        System.out.println(t5);




    }
}
