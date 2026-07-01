package proxy;

public class Main {

    public static void main(String[] args) {

        VideoService service = new VideoProxy();

        service.playVideo("movie1", false);

        service.playVideo("movie1", false);

        service.playVideo("premium-video", false);

        service.playVideo("premium-video", true);
    }
}