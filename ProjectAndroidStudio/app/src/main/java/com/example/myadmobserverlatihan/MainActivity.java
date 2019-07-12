package com.example.myadmobserverlatihan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonJ(new Listener() {
            @Override
            public void Success(JSONObject jsonObject) {
                Log.d("TEST", "Success: "+jsonObject.toString());
                String appId="";
                String bannerUnit="";
                String intersUnit="";
                try {
                    appId = jsonObject.getString("unitAd");
                    bannerUnit = jsonObject.getString("banner");
                    intersUnit = jsonObject.getString("inter");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("TEST", "AppID: "+appId);
                Log.d("TEST", "BannerID: "+bannerUnit);
                Log.d("TEST", "IntersUnit: "+intersUnit);

                //Oke done ya hehhe
                //See yaa

            }
        }).execute();
    }
}
