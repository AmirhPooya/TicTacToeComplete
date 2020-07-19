package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class Ui {
    private int dim;
    private Scanner scanner;

    Ui(int dim) {
        scanner = new Scanner(System.in);
        this.dim = dim;
    }

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

    void draw() {
        System.out.println("Draw!");
    }

    int[] getPlayerInput(boolean wrong_before) {
        if(wrong_before)
            System.out.println("Invalid input! try again");
        System.out.println("Enter row:");
        int row = scanner.nextInt();
        System.out.println("Enter col:");
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    public void turn(int current_player) {
        System.out.println("It's " + current_player + " turn!");
    }
}
