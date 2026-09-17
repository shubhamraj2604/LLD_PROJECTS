package rateLimiter.ratelimter;
import rateLimiter.config.Config;
public class TokenBucket implements RateLimiter {
    Config config;
    /** The number of tokens in the bucket */
    private int tokens;
    private int lastrefillTime;
    private long windowTime;
    private int maxTokens;
    private long refillRate;
    public TokenBucket(Config config){
        this.config = config;
        this.tokens = config.getmaxRequest();
        this.windowTime = config.getwindowtime();
        this.maxTokens = config.getmaxRequest();
        // 1 token every X seconds
        refillRate = windowTime / maxTokens;
        lastrefillTime = (int)(System.currentTimeMillis() / 1000);
    }

    public boolean allowRequest() {
        long currTime = (System.currentTimeMillis() / 1000);
        long elapsedTime = currTime - lastrefillTime;
        long tokensToAdd = elapsedTime / refillRate;
        if(tokensToAdd > 0){
            tokens = Math.min(maxTokens , tokens + (int)tokensToAdd);
            lastrefillTime = (int)currTime;
        }
        if(tokens > 0){
            tokens--;
            System.out.println("TokenBucket: Request allowed. Tokens left: " + tokens);
            return true;
        }
        System.out.println("TokenBucket: Request denied. No tokens available.");
        return false;
    }
}
