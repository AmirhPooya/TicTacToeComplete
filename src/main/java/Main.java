package main.java;

public class Main {
    public static void main(String[] args) {
        WinCondition w = new WinCondition() {
            private boolean check_row(Board board, int[][] toBeChecked, int dim) {
                int player = board.getPlayer(toBeChecked[0]);
                if(player == 0)
                    return false;
                for(int i = 1; i < dim; i++) {
                    int player2 = board.getPlayer(toBeChecked[i]);
                    if(player != player2)
                        return false;
                }
                return true;
            }
            @Override
            public boolean checkWon(Board board, int dim) {
                int[][] toBeChecked = new int[dim][2];
                for(int i = 0; i < dim; i++) {
                    for(int j = 0; j < dim; j++) {
                        toBeChecked[i][0] = i;
                        toBeChecked[i][1] = j;
                    }
                    if(check_row(board, toBeChecked, dim))
                        return true;
                }

                for(int i = 0; i < dim; i++) {
                    for(int j = 0; j < dim; j++) {
                        toBeChecked[i][0] = j;
                        toBeChecked[i][1] = i;
                    }
                    if(check_row(board, toBeChecked, dim))
                        return true;
                }

                for(int i = 0; i < dim; i++) {
                    toBeChecked[i][0] = i;
                    toBeChecked[i][1] = i;
                    if(check_row(board, toBeChecked, dim))
                        return true;
                }

                for(int i = 0; i < dim; i++) {
                    toBeChecked[i][0] = i;
                    toBeChecked[i][1] = dim - i - 1;
                    if(check_row(board, toBeChecked, dim))
                        return true;
                }
                return false;
            }
        };
        Board board = new Board(3, w);
    }
}
