package proxy;
import java.util.HashMap;
import java.util.Map;

public class VideoProxy implements VideoService {

    private RealVideoService realService = new RealVideoService();

    // cache
    private Map<String, String> cache = new HashMap<>();

    @Override
    public void playVideo(String videoId, boolean premiumUser) {

        System.out.println("\nRequest received for : " + videoId);

        // Premium Check
        if(videoId.equals("premium-video") && !premiumUser){
            System.out.println("Access Denied! Buy Premium.");
            return;
        }

        // Cache Check
        if(cache.containsKey(videoId)){
            System.out.println("Playing from cache...");
            System.out.println(cache.get(videoId));
            return;
        }

        // Not cached
        realService.playVideo(videoId, premiumUser);

        // Save in cache
        cache.put(videoId, "Playing video : " + videoId);
    }
}