package main.java;

public class Game {
    private static Board board;
    private int dim = 3;

    Game () {
        initUi();
        initBoard();
        start();
    }

    void start() {
        //TODO
    }

    void initUi() {
        //TODO
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
                //TODO
                return false;
            }
        };
        Board board = new Board(dim, w);
    }
}
