import rateLimiter.RateLimiterService;
import rateLimiter.config.Config;
import user.User;
import userTier.UseTier;

public class Main {
    public static void main(String[] args) {
    RateLimiterService rateLimiterService = new RateLimiterService();
    rateLimiterService.addConfig(new Config(3, 60), "TokenBucket", UseTier.FREE);
    Config premiumConfig = new Config(20, 60);
    rateLimiterService.addConfig(premiumConfig , "FixedWindow" , UseTier.PREMIUM);
    User user = new User("Shubham", UseTier.FREE);
    rateLimiterService.addUser(user);
    // for(int requestNumber = 1; requestNumber <= 4; requestNumber++) {
    //   boolean allowed = rateLimiterService.allowRequest(user);
    //   System.out.println(
    //     "Request " + requestNumber + " allowed: " + allowed);
    // }  
    User user2 = new User("Suyash", UseTier.PREMIUM);
    rateLimiterService.addUser(user2);
    for(int i=0;i<=25;i++){
        boolean allowed = rateLimiterService.allowRequest(user2);
        System.out.println(
        "Request " + i + " allowed: " + allowed);
    }
}
}
