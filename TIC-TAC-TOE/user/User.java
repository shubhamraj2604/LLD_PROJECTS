package user;

public class User {
    private int user_id;
    private String name;

    public User(int user_id , String name){
        this.user_id = user_id;
        this.name = name;
    }

    public String getname(){
        return name;
    }

    public int getId(){
        return user_id;
    }
}
