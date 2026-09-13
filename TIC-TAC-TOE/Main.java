import user.User;
import moves.Move;
import game.Game;

public class Main {
    public static void main(String args[]) {
        // System.out.println("hello");
        // User u1 = new User(1, "Shubham");
        // User u2 = new User(2, "Rohit");
        // Game g = new Game(u1, u2, 3);
        // g.getPlayers();
        // // write a test case for the game
        // Move m1 = new Move(0, 0, u1, 1);
        // g.playgame(m1);
        // Move m2 = new Move(0, 1, u2, 2);
        // g.playgame(m2);
        // Move m3 = new Move(1, 1, u1, 1);
        // g.playgame(m3);
        // Move m4 = new Move(0, 2, u2, 2);
        // g.playgame(m4);
        // Move m5 = new Move(2, 2, u1, 1);
        // g.playgame(m5);
        // System.out.println("Winner is: " + g.getWinner());
        // Move m6 = new Move(1, 0, u2, 2);
        // g.playgame(m6);
        // Move m7 = new Move(2, 0, u1, 1);
        // g.playgame(m7);
        // Move m8 = new Move(2, 1, u2, 3);
        // g.playgame(m8);

        User rohit = new User(2, "Rohit");
        User rahul = new User(3, "Rahul");

        Game game2 = new Game(rohit, rahul, 3);

        // Rohit uses marker 1, Rahul uses marker 2
        Move r1 = new Move(0, 0, rohit, 1);
        game2.playgame(r1);
        System.out.println("Winner is: " + game2.getWinner());

        Move r2 = new Move(1, 0, rahul, 2);
        game2.playgame(r2);
        System.out.println("Winner is: " + game2.getWinner());

        Move r3 = new Move(2, 2, rohit, 1);
        game2.playgame(r3);
        System.out.println("Winner is: " + game2.getWinner());

        Move r4 = new Move(1, 1, rahul, 2);
        game2.playgame(r4);

        // Undo Rahul's last move
        game2.undo();

        // Play Rahul's move again
        Move r4Again = new Move(1, 1, rahul, 2);
        game2.playgame(r4Again);

        Move r5 = new Move(0, 2, rohit, 1);
        game2.playgame(r5);

        Move r6 = new Move(1, 2, rahul, 2);
        game2.playgame(r6);

        System.out.println("Winner is: " + game2.getWinner());
    }
}