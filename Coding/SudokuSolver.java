import java.io.*;
import java.util.*;

class sudukoSolver {

    static char[] getCandidates(char[][] board, int row, int col) {
        List<Character> candidates = new ArrayList<Character>();
        List<Character> allCandidates = new ArrayList<Character>(){{
            add('1');
            add('2');
            add('3');
            add('4');
            add('5');
            add('6');
            add('7');
            add('8');
            add('9');
        }};

        boolean collision = false;
        int rows = board.length;
        for (char ch : allCandidates) {
            collision = false;
            for (int i = 0; i < rows; i++) {
                if (board[row][i] == ch || board[i][row] == ch) {
                    collision = true;
                    break;
                }

            }
        
            if (!collision) {
                candidates.add(ch);
            }
        }
        
        char[] myArray = new char[candidates.size()];
        int i=0;
        
        for(Character ch: candidates){
            myArray[i]=ch;
            i++;
        }
        return myArray;
    }

    static boolean sudokuSolve(char[][] board) {
        // your code goes here
         int row=board.length; 
         int col=board[0].length;
      System.out.println(row);
      System.out.println(col);
        char[] candidates = null;
        int rows = board.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[i][j] == '.') {
                    candidates = getCandidates(board, i, j);
                }

                if (candidates == null) {
                    return true;
                }

                for (int k = 0; k < candidates.length; k++) {
                    board[i][j] = candidates[k];
                    if (sudokuSolve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }

            }
        }
        return false;

    }

    public static void main(String[] args) {
       char[][] multi = new char[][]{
            { '.', '.', '.', '7', '.', '.', '3', '.', '1' },
            { '3', '.', '.', '9', '.', '.', '.', '.', '.' },
            { '.', '4', '.', '3', '1', '.', '2', '.', '.' },
            { '.', '6', '.', '4', '.', '.', '5', '.', '.' },
            { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
            { '.', '.', '1', '.', '.', '8', '.', '4', '.' },
            { '.', '.', '6', '.', '2', '1', '.', '5', '.' },
            { '.', '.', '.', '.', '.', '9', '.', '.', '8' },
            { '8', '.', '5', '.', '.', '4', '.', '.', ',' },
          };
      System.out.println(sudokuSolve(multi));
    }
}
