package rateLimiter.ratelimter;
import rateLimiter.config.Config;
public class FixedWindow implements RateLimiter {
      private int token;
      private int maxTokens;
      private long windowTime;
      private long lastTime;
      public FixedWindow(Config congig){
          lastTime = (int)(System.currentTimeMillis() / 1000);
          this.windowTime = congig.getwindowtime();
          this.maxTokens = congig.getmaxRequest();
          token = maxTokens;
      }
     
      public boolean allowRequest(){
          long currTime = (System.currentTimeMillis() / 1000);
          long timeDiff = currTime - lastTime;
          if(timeDiff >= windowTime){
             token = maxTokens;
             lastTime = currTime;
          }
          if(token > 0){
            token--;
            System.out.println("FixedWindow: Request allowed. Tokens left: " + token);
            return true;
          }
          System.out.println("FixedWindow: Request denied. No tokens available.");
          return false;
      }
}
