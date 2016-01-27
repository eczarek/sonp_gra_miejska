package myapp.mycom.com.gra_miejska.json;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Adrian on 2015-11-16.
 */
public class Game {
    public static boolean isReady = false;
    public static int id;
    public static String title;
    public static String description;
    public static int level;
    public static int userId;
    public static int expectedTime;
    public static int actualStatus;
    public static List<Hint> hints= new ArrayList<>();

    public static void downloadGame(int gameId){
        id = gameId;
        actualStatus = 1;
        try {
            new AsyncTask<Integer, Void, String >(){

                @Override
                protected String doInBackground(Integer... params) {
                    return WebConnect.getWebPage("http://citygame.azurewebsites.net/games/download/"+ params[0].toString());
                }

                @Override
                protected void onPostExecute(String s){
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        title = jsonObject.optString("Title");
                        description = jsonObject.optString("Description");
                        level = jsonObject.optInt("Level");
                        userId = jsonObject.optInt("UserId");
                        expectedTime = jsonObject.optInt("ExpectedTime");
                        JSONArray list= jsonObject.optJSONArray("Hints");
                        for(int i = 0; i < list.length(); i++){
                            hints.add(new Hint(list.getJSONObject(i)));
                        }
                        isReady = true;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }.execute(gameId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static List<Hint> getGame(){
        return hints;
    }
    public static boolean getReady(){
        return isReady;
    }
}
