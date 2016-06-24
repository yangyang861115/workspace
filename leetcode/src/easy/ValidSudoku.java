package easy;

import java.util.*;

/*
 * 36
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        if (n != m)
            return false;

        Set<Character> set, set2;

        for (int i = 0; i < n; i++) {
            set = new HashSet<Character>();
            set2 = new HashSet<Character>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !set2.add(board[j][i]))
                    return false;
            }
        }

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                set = new HashSet<Character>();
                for (int a = i; a < i + 3; a++) {
                    for (int b = j; b < j + 3; b++)
                        if (board[a][b] != '.' && !set.add(board[a][b]))
                            return false;
                }
            }
        }

        return true;
    }
}
