package rateLimiter.config;

public class Config {
    private int maxRequest;
    private long windowInseconds;

   public Config(int maxRequest , int windowInseconds){
        this.maxRequest = maxRequest;
        this.windowInseconds = windowInseconds;
    }

    public int getmaxRequest(){
        return maxRequest;
    }

    public long getwindowtime(){
        return windowInseconds;
    }
}
