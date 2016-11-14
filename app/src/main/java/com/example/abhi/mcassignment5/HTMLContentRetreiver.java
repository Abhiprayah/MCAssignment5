package com.example.abhi.mcassignment5;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Abhi on 11-11-2016.
 */

public class HTMLContentRetreiver extends AsyncTask<String, String, String> {

    private Context context;
    public HTMLContentRetreiver(Context context){
        super();
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = "https://www.iiitd.ac.in/about";
        StringBuilder content = new StringBuilder();
        try {
            URL url1 = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String temp = "";
            while((temp = bufferedReader.readLine()) != null) {
                content.append(temp);
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
        }catch (MalformedURLException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return content.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ((MainActivity)context).result = s;
        ((MainActivity)context).setResult();
    }
}
