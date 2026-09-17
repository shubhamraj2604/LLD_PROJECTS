package rateLimiter.ratelimter;
import rateLimiter.config.*;;
public class RateLimiterFactory {
    public RateLimiter createRateLimiter(String type , Config config){
        if(type.equals("TokenBucket")){
               return new TokenBucket(config);
        }else if(type.equals("FixedWindow")){
               return new FixedWindow(config);
        }
        throw new IllegalArgumentException("Unknown rate limiter type: " + type);
    }
}
