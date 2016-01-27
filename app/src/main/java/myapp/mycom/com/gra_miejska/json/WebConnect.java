package myapp.mycom.com.gra_miejska.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Adrian on 2015-11-11.
 */
public class WebConnect {
    /**
     * metoda getWebPage pobiera i zwraca strone jako string
     * @param webUrl adres do strony
     * @return strone jako strin
     */
    public static String getWebPage(String webUrl){

        try{
            URL url = new URL(webUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder strBuilder = new StringBuilder();
            String temp;
            while ((temp = reader.readLine()) != null) {
                strBuilder.append(temp);
            }
            return strBuilder.toString();
        }catch (Exception e){

        }
        return null;
    }
}
