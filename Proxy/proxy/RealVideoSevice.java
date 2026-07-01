package proxy;

class RealVideoService implements VideoService {

    @Override
    public void playVideo(String videoId, boolean premiumUser) {
        System.out.println("Fetching video from server...");
        System.out.println("Playing video : " + videoId);
    }
}