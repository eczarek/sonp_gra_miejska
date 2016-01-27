package myapp.mycom.com.gra_miejska.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 2015-11-16.
 */
public class Hint {
    public String description;
    public int status;
    public Point point;
    public List<String> answers = new ArrayList<String>();

    public String getDescription() {
        return description;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public Point getPoint() {
        return point;
    }

    public Hint(JSONObject jsonObject) throws JSONException {
        description = jsonObject.optString("Description");
        status = jsonObject.optInt("Status");
        point = new Point(jsonObject.getJSONObject("Point"));
        JSONArray list= jsonObject.optJSONArray("Answers");
        for(int i = 0; i < list.length(); i++){
            answers.add(list.getJSONObject(i).getString("Content"));
        }
    }
}
