package bruh;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class api {
    double temp;
    double tempMin;
    String main;
    int humidity;
    int seaLevel;
    String country;
    String name;
    String description;
    double speed;
    int deg;

    final String API_KEY = "fa880a1c402477a50968b6bb6084e1b8";
    String CITY = "Hyderabad";
    String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    void get(String city){
        this.CITY=city;
    }
    void nigg(){
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + CITY + "&appid=" + API_KEY + "&units=metric";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try (Response response = client.newCall(request).execute()) {
            parse(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void parse(String response){
        JSONObject json = new JSONObject(response);

        temp = json.getJSONObject("main").getDouble("temp");
        tempMin = json.getJSONObject("main").getDouble("temp_min");
        humidity = json.getJSONObject("main").getInt("humidity");
        seaLevel = json.getJSONObject("main").optInt("sea_level", -1);
        country = json.getJSONObject("sys").getString("country");
        name = json.getString("name");
    
        JSONObject weatherObj = json.getJSONArray("weather").getJSONObject(0);
        main = weatherObj.getString("main");
        description = weatherObj.getString("description");

        JSONObject wind = json.getJSONObject("wind");
        speed = wind.getDouble("speed");
        deg = wind.getInt("deg");

    }
}