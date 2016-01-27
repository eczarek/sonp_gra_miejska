package myapp.mycom.com.gra_miejska.json;

import org.json.JSONObject;

/**
 * Created by Adrian on 2015-11-16.
 */
public class Point {
    public double lat;
    public double lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public Point(JSONObject jsonObject){
        lat = jsonObject.optDouble("Lat");
        lng = jsonObject.optDouble("Lng");
    }
}
