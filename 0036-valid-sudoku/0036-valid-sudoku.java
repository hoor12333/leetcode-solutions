import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) return false;
                    rows.add(board[i][j]);
                }
                // Check column
                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i])) return false;
                    cols.add(board[j][i]);
                }
                // Check 3x3 box
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                char c = board[RowIndex + j / 3][ColIndex + j % 3];
                if (c != '.') {
                    if (box.contains(c)) return false;
                    box.add(c);
                }
            }
        }
        return true;
    }
}