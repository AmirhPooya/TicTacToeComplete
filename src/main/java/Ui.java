package main.java;

import java.util.Arrays;

public class Ui {
    private int dim;

    private String multiplyString(int n, char c) {
        char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }

    private String multiplyString(int n) {
        return multiplyString(n, '_');
    }

    void print_board(int[][] board) {
        String line = multiplyString(2 * dim + 1);
        for(int i = 0; i < dim; i++) {
            System.out.println(line);
            StringBuilder row = new StringBuilder("|");
            for (int j = 0; j < dim; j++)
                row.append(board[i][j]).append('|');
            System.out.println(row);
        }
        System.out.println(line);
    }

    void won_player(int player) {
        System.out.println("player " + player + " won!");
    }

    Ui(int dim) {
        this.dim = dim;
    }
}
