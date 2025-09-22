class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] dirs = {-1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                for (int x : dirs) {
                    for (int y : dirs) {
                        if (x == 0 && y == 0) continue;
                        int ni = i + x, nj = j + y;
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && (board[ni][nj] == 1 || board[ni][nj] == -1)) {
                            liveNeighbors++;
                        }
                    }
                }
                // Mark transitions: 1->0 as -1, 0->1 as 2
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) board[i][j] = -1;
                if (board[i][j] == 0 && liveNeighbors == 3) board[i][j] = 2;
            }
        }
        // Final pass: update to new state
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
    }
}