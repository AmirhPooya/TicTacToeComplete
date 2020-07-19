package main.java;

public class Game {
    private static Board board;
    private Ui ui;
    private int dim = 3;

    Game () {
        initUi();
        initBoard();
        start();
    }

    void start() {
        int current_player = 1;
        do{
            int i, j;
            do {
                int[] a = ui.getPlayerInput();
                i = a[0];
                j = a[1];
            } while(!board.setBoard(i, j, current_player));
            current_player = 3 - current_player;

        } while(!board.checkWon());
        ui.won_player(current_player);
    }

    void initUi() {
        ui = new Ui(dim);
    }

    void initBoard() {
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
                    toBeChecked[i][0] = i;
                    toBeChecked[i][1] = i;
                }
                if(check_row(board, toBeChecked, dim))
                    return true;

                for(int i = 0; i < dim; i++) {
                    toBeChecked[i][0] = i;
                    toBeChecked[i][1] = dim - i - 1;
                }
                if(check_row(board, toBeChecked, dim))
                    return true;

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

                return false;
            }
        };
        Board board = new Board(dim, w);
    }
}
