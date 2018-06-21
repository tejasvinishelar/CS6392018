package com.example.tejasvinishelar.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // Set your Image URL into a string
    String URL = "https://raw.githubusercontent.com/tejasvinishelar/CS6392018/master/Chandvad.jpg";

    ImageView image;
    Button button;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);
        new DownloadImage().execute(URL);

    }

    // DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, Drawable> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Drawable doInBackground(String... stringUrl) {
            String imageURL = stringUrl[0];
            Drawable drawable=null;
            try{
                URL url =new URL(imageURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                if(connection.getResponseCode() != 200){
                    throw new Exception("Failed to connect");

                }

                InputStream is = connection.getInputStream();
                drawable = Drawable.createFromStream(is, "src name");
                return drawable;

            }catch (Exception e){
                Log.e("Image","Failed to load Images",e);

            }

            return drawable;
        }

        @Override
        protected void onPostExecute(Drawable result) {
            image.setImageDrawable(result);
        }
    }
}
