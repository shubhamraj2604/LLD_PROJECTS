package board;

import java.util.*;
import moves.Move;

public class Board {
    private Deque<Move> moves = new ArrayDeque<Move>();
    // addLast()
    // removeLast()
    private final int grid[][];
    int winner = -1;
    private State status = State.PLAYING;

    // 0 or 1 -> 0 = user1 , 1 - user 2 , -1 not played yet
    public Board(int n) {
        grid = new int[n][n];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, -1));
    }

    // private void checkstatus(){
    // // for(int i=0;i<grid.length;i++){
    // // for(int j=0;j<grid.length;j++){
    // // System.out.print(grid[i][j] + " ");
    // // }
    // // System.out.println();
    // // }

    public State getStatus() {
        return status;
    }

    // this checks if we have found our winner or not.
    // if a user has filled a row or column or diagonal with his moves then he is
    // the winner.
    private boolean checkState(int curr, int i, int j) {
        int n = grid.length;
        // Check row
        boolean row = true;
        for (int col = 0; col < n; col++) {
            if (grid[i][col] != curr) {
                row = false;
                break;
            }
        }

        if (row) {
            return true;
        }

        // Check column
        boolean col = true;
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            if (grid[rowIndex][j] != curr) {
                col = false;
                break;
            }
        }

        if (col) {
            return true;
        }

        // Check main diagonal (\)
        if (i == j) {
            boolean diagonal = true;
            for (int index = 0; index < n; index++) {
                if (grid[index][index] != curr) {
                    diagonal = false;
                    break;
                }
            }
            if (diagonal) {
                return true;
            }
        }

        // Check anti-diagonal (/)
        if (i + j == n - 1) {
            boolean diagonal = true;

            for (int index = 0; index < n; index++) {
                if (grid[index][n - 1 - index] != curr) {
                    diagonal = false;
                    break;
                }
            }

            if (diagonal) {
                return true;
            }
        }

        return false;
    }

    public boolean checkDraw() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == -1) {
                    return false;
                }
            }
        }
        status = State.DRAW;
        return true;
    }

    public int getWinner() {
        return winner;
    }

    public void addMove(Move move) {
        if (getStatus() == State.FINISHED || getStatus() == State.DRAW) {
            System.out.println("Game ended in" + getStatus());
            return;
        }
        Move lastMove = moves.peekLast();
        if (lastMove != null) {
            if (lastMove.getUserName().equals(move.getUserName())) {
                System.out.println("Same User");
                return;
            }

            if (lastMove.getMove() == move.getMove()) {
                System.out.print("Same move as last move");
                return;
            }
        }
        int currentMove = move.getMove();
        int i = move.getI();
        int j = move.getJ();
        if (grid[i][j] != -1) {
            System.out.println("Position is already occupied");
            return;
        }

        grid[i][j] = currentMove;
        moves.addLast(move);
        if (checkState(currentMove, i, j)) {
            winner = currentMove;
            status = State.FINISHED;
            return;
        }
        if (checkDraw()) {
            return;
        }
    }

    public void undo() {
        if (status == State.FINISHED || status == State.DRAW) {
            System.out.println("Game has already ended. No more moves can be undone.");
            return;
        }
        Move lastMove = moves.peekLast();
        if (lastMove == null) {
            System.out.println("No moves to undo. The game hasn't started yet.");
        } else {
            int i = lastMove.getI();
            int j = lastMove.getJ();
            grid[i][j] = -1;
            moves.pollLast();
            System.out.println("Last move undone successfully.");
        }
    }
}
