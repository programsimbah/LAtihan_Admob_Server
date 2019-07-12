package com.example.myadmobserverlatihan;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonJ extends AsyncTask<Void,Void,Void> {
    //Fetch Json from server or hosting link
    String data="";
    String lines = "";

    //cukup klik command + enter atau ctrl + enter
    String JsoneJadi ="";
    Listener listenerJson;

    //saya tambah listener biar nanti mudah dipake
    public JsonJ(Listener listenerJson){
        this.listenerJson = listenerJson;
    }

    @Override protected Void doInBackground(Void... voids) {
        BufferedReader bufferedReader = null;
        try {

            //masukan alamat hosting kalian

            URL url = new URL("https://latihanantuziasite.000webhostapp.com/Admob.json");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            while (line != lines) {
                data = line + "\n";
                lines = line;
            }

            JsoneJadi = new JSONObject(data).toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //fungsi akan dipanggil jika proses load iklan sudah berhasil
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        try {
            listenerJson.Success(new JSONObject(JsoneJadi));
        } catch (JSONException e) {
            //fungi jika gagal
            e.printStackTrace();
        }
    }

}