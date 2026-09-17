package rateLimiter;

import java.util.*;
import user.User;
import userTier.UseTier;
import rateLimiter.ratelimter.*;
import rateLimiter.config.*;

public class RateLimiterService {

    private Map<UseTier, RateLimiter> rateLimiters = new HashMap<>();
    private Map<User, RateLimiter> userRateLimiter = new HashMap<>();
    RateLimiterFactory factory;

    public RateLimiterService() {
        factory = new RateLimiterFactory();
        // Config freeConfig = new Config(5, 60);
        // Config premiumConfig = new Config(20, 60);
        // rateLimiters.put(
        //         UseTier.FREE, factory.createRateLimiter(
        //                 "TokenBucket",
        //                 freeConfig));

        // rateLimiters.put(
        //         UseTier.PREMIUM,
        //         factory.createRateLimiter(
        //                 "FixedWindow",
        //                 premiumConfig));
    }

    public void addConfig(Config config, String type, UseTier useTier) {
        RateLimiter rateLimiter = factory.createRateLimiter(type, config);
        rateLimiters.put(useTier, rateLimiter);
        for (Map.Entry<User, RateLimiter> entry : userRateLimiter.entrySet()) {
            if (entry.getKey().getTier() == useTier) {
                entry.setValue(rateLimiter);
            }
        }
    }

    public void addUser(User user) {
        UseTier tier = user.getTier();
        RateLimiter rateLimiter = rateLimiters.get(tier);
        userRateLimiter.put(user, rateLimiter);
    }

    public boolean allowRequest(User user) {
        RateLimiter rateLimiter = userRateLimiter.get(user);
        if (rateLimiter == null) {
            throw new IllegalArgumentException(
                    "No rate limiter assigned for user: " + user.getname());
        }
        return rateLimiter.allowRequest();
    }
}