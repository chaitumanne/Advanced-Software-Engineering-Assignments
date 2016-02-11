package edu.umkc.cm7cd.WeatherStatus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import okhttp3.Call;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherStatus extends AppCompatActivity {

    private static EditText cityName;
    private static Button checkStatus;
    TextView currentLoc;
    TextView temp;
    TextView minTemp;
    TextView maxTemp;
    TextView wind;
    TextView humid;
    TextView countryName;
    TextView currentDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void checkWeatherStatus(View view) {

        currentLoc = (TextView) findViewById(R.id.textView_currentLocation);
        temp = (TextView) findViewById(R.id.textView_temperature);
        minTemp = (TextView) findViewById(R.id.textView_minTemperature);
        maxTemp = (TextView) findViewById(R.id.textView_maxTemperature);
        wind = (TextView) findViewById(R.id.textView_windSpeed);
        humid = (TextView) findViewById(R.id.textView_humidity);
        countryName = (TextView) findViewById(R.id.textView_country);
        cityName = (EditText)findViewById(R.id.editText_cityName);
        checkStatus = (Button) findViewById(R.id.button_checkButton);
        currentDateTime = (TextView) findViewById(R.id.textView_time);

        String urlApi = "http://api.openweathermap.org/data/2.5/weather?q="+cityName.getText().toString()+"&units=imperial&appid=290971ef2739f21e6678008b8dddea10";
        final String response1 = "";
        OkHttpClient okHttpClient = new OkHttpClient();
        try {

            Request request = new Request.Builder()
                    .url(urlApi)
                    .build();

            okHttpClient.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println(e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final JSONObject jsonResult;
                    final String result = response.body().string();

                    try {
                        jsonResult = new JSONObject(result);
                        JSONObject mainOjbect = jsonResult.getJSONObject("main");
                        JSONObject systemOjbect = jsonResult.getJSONObject("sys");
                        JSONObject windObject = jsonResult.getJSONObject("wind");
                        final String currentLocation = jsonResult.getString("name");
                        final Double temperature= mainOjbect.getDouble("temp");
                        final Double minTemperature= mainOjbect.getDouble("temp_min");
                        final Double maxTemperature= mainOjbect.getDouble("temp_max");
                        final Double windSpeed=windObject.getDouble("speed");
                        final Double humidity=mainOjbect.getDouble("humidity");
                        final String time="";
                        final String country=systemOjbect.getString("country");
                        Log.d("okHttp", jsonResult.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //hideKeyboard(outputTextView);
                              //  outputTextView.setText(convertedText);
                                currentLoc.setText("City Name: " + currentLocation);

                                countryName.setText("Country Name: "+ country);
                                temp.setText("Current Temperature: "+ temperature);
                                minTemp.setText("Min Temperature: "+ minTemperature);
                                maxTemp.setText("Max Temperature: "+ maxTemperature);
                                wind.setText("Wind Speed: "+ windSpeed);
                                humid.setText("Humidity: "+ humidity);
                                String currentTimeDate = DateFormat.getDateTimeInstance().format(new Date());
                                currentDateTime.setText("Time: "+ currentTimeDate.toString());
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });


        } catch (Exception ex) {
         //   outputTextView.setText(ex.getMessage());

        }

    }

}


