package com.example.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * トップ画面を制御するActivityクラス.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 画面を表示する.
     * note:デフォルトで実装されている
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            new AsyncHttpRequest(this).execute(new URL("https://api.openweathermap.org/data/2.5/weather?lat=34.8899&lon=135.2254&units=metric&appid=6fed7f8a8b65d9b677317a8833be2d0c"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}