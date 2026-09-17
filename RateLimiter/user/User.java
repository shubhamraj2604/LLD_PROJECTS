package user;

import userTier.UseTier;

public class User {
    private String name;
    private UseTier useTier;
    
    public User(String name , UseTier useTier){
        this.name = name;
        this.useTier = useTier;
    }
   public UseTier getTier(){
    return useTier;
   }

   public String getname(){
    return name;
   }
}
