package myapp.mycom.com.gra_miejska.json;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by Adrian on 2015-11-12.
 */
public class GameInfo {
    public static int id;
    public static String title;
    public static String description;
    public static int level;
    public static int userId;
    public static int expectedTime;

    public static void downloadGameInfo(int gameId){
        id = gameId;
        try {
            new AsyncTask<Integer, Void, String >(){

                @Override
                protected String doInBackground(Integer... params) {
                    return WebConnect.getWebPage("http://citygame.azurewebsites.net/games/getdetails/"+ params[0].toString());
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

    public static String getTitle() {
        return title;
    }
    public static String getDescription() {
        return description;
    }

    public static int getLevel() {
        return level;
    }

    public static int getExpectedTime() {
        return expectedTime;
    }
}
