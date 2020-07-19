package main.java;

public class Board {
    private int board[][];
    private int dim;
    WinCondition winCondition;
    boolean setBoard(int i, int j, int player) {
        if(i >= dim || j >= dim || i < 0 || j < 0 || board[i][j] != 0)
            return false;
        board[i][j] = player;
        return true;
    }

    int[][] getBoard() {
        return board.clone();
    }

    int getPlayer(int i, int j) {
        return board[i][j];
    }

    int getPlayer(int[] i) {
        int x = i[0];
        int y = i[1];
        return board[x][y];
    }

    Board(int n, WinCondition w) {
        dim = n;
        board = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = 0;
        winCondition = w;
    }

    boolean checkWon() {
        return winCondition.checkWon(this, dim);
    }

}
