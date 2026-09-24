package theatreService;

import java.util.HashMap;
import java.util.Map;

import screenservice.Screen;

public class Theatre {
    private Map<String, Screen> screens;
    private String name;
    private String theatreId;

    public Theatre(String name, String theatreId) {
        this.name = name;
        this.theatreId = theatreId;
        screens = new HashMap<>();
    }

    public String getname() {
        return name;
    }

    public String getId() {
        return theatreId;
    }

    public void addScreens(Screen screen) {
        screens.put(screen.getScreenId(), screen);
    }

    public Screen getScreen(String screenId) {
        return screens.get(screenId);
    }
}
