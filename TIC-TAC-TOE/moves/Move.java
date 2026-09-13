package moves;
import user.User;
public class Move {
    private User user;
    private int i ;
    private int j;
    private int move ;
    public Move(int i , int j , User user , int move){
         this.user = user;
         this.i = i;
         this.j = j;
         this.move = move;
    }

    public int getI(){
         return i;
    }

    public int getJ(){
        return j;
    }

    public String getUserName(){
        return user.getname();
    }

    public int getMove(){
        return move;
    }
}
