package com.example.weather;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;


        public class MainActivity extends AppCompatActivity {

            // Project Created by Ferdousur Rahman Shajib
            // www.androstock.com

            TextView temperature, humidity_field, pressure_field;
            /* Please Put your API KEY here */
            //String OPEN_WEATHER_MAP_API = "6fed7f8a8b65d9b677317a8833be2d0c";
            /* Please Put your API KEY here */
            //http://api.openweathermap.org/data/2.5/weather?lat=34.8899&lon=135.2254


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                temperature = (TextView) findViewById(R.id.temperature);
                humidity_field = (TextView) findViewById(R.id.humidity_field);
                pressure_field = (TextView) findViewById(R.id.pressure_field);


            }



            class DownloadWeather extends AsyncTask < String, Void, String > {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();

                }
                protected String doInBackground(String...args) {
                    String xml = Function.excuteGet("http://api.openweathermap.org/data/2.5/weather?34.8899&lon=135.2254&units=metric&appid=6fed7f8a8b65d9b677317a8833be2d0c");
                    return xml;
                }
                @Override
                protected void onPostExecute(String xml) {

                    try {
                        JSONObject json = new JSONObject(xml);
                        if (json != null) {
                            //JSONObject details = json.getJSONArray("weather").getJSONObject(0);
                            JSONObject main = json.getJSONObject("main");

                            temperature.setText(String.format("%.2f", "三田の天気は"+main.getDouble("temp")) + "°");
                            humidity_field.setText("Humidity: " + main.getString("humidity") + "%");
                            pressure_field.setText("Pressure: " + main.getString("pressure") + " hPa");
                        }
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "Error, Check City", Toast.LENGTH_SHORT).show();
                    }


                }



            }



        }