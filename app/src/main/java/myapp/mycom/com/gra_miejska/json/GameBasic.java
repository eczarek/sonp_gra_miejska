package myapp.mycom.com.gra_miejska.json;

import org.json.JSONObject;

/**
 * class-a ktora reprezentuje podstawowe elementy gry potrzebne do listy
 */
public class GameBasic {
    public int id;
    public String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public GameBasic(JSONObject jsonObject){
        id = jsonObject.optInt("Id");
        title = jsonObject.optString("Title");

    }

}
