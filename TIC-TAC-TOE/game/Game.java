package game;

import board.Board;
import moves.Move;
import user.User;
import board.State;
public class Game {
    private Board board;
    private User user1;
    private User user2;
    
    public Game(User user1, User user2, int n) {
        this.user1 = user1;
        this.user2 = user2;
        this.board = new Board(n);
    }

    public void playgame(Move move){
        if(board.getStatus() == State.FINISHED || board.getStatus() == State.DRAW){
            System.out.println("Game is already finished");
            return;
        }
        if(!move.getUserName().equals(user1.getname()) && !move.getUserName().equals(user2.getname())){
            System.out.println("Invalid User");
            return;
        }
        if (move.getUserName().equals(user1.getname()) && move.getMove() != 1) {
            System.out.println("Invalid move for user1");
            return;
        }

        if (move.getUserName().equals(user2.getname()) && move.getMove() != 2) {
            System.out.println("Invalid move for user2");
            return;
         }
        board.addMove(move);
    }

    public void getPlayers(){
        System.out.println(user1.getname() + "  v/s  " + user2.getname());
        return;
    }
    
    public String getWinner(){
        if(board.getStatus() == State.FINISHED){
            int winner = board.getWinner();
            if(winner == 1){
                return user1.getname();
            }
            else if(winner == 2){
                return user2.getname();
            }
        }
        else if(board.getStatus() == State.DRAW){
            return "DRAW";
        }
        return "Game is still ongoing";
    }
    
    public void undo() {
        board.undo();
    }
}
