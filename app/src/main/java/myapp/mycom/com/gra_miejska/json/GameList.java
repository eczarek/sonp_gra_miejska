package myapp.mycom.com.gra_miejska.json;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 */
public class GameList {
    public static String webPage = null;
    public static boolean isReady = false;
    public static List<GameBasic> gameList = new ArrayList<>();
    // metoda pobiera liste gier i przypisuje ja do listy(gameList)
    public static void updateGameList(){
        try {
            new AsyncTask < String, Void, String >(){

                @Override
                protected String doInBackground(String... params) {
                    return WebConnect.getWebPage("http://citygame.azurewebsites.net/games/getlist");
                }

                @Override
                protected void onPostExecute(String s){


                    try {
                        JSONArray list= new JSONArray(s);
                        for(int i = 0; i < list.length(); i++){
                            gameList.add(new GameBasic(list.getJSONObject(i)));
                        }
                        isReady = true;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


            }
            }.execute("cos").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static List<GameBasic> getGameList(){
        return gameList;
    }
}
