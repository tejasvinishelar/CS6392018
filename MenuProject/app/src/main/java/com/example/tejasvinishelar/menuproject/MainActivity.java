package com.example.tejasvinishelar.menuproject;

import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button openNewActivity,sendsms,makecall,openweb,openmap,sharelove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openNewActivity=findViewById(R.id.newactivityid);
        sendsms= findViewById(R.id.smsid);
        makecall=findViewById(R.id.phoneid);
        openweb=findViewById(R.id.webid);
        openmap=findViewById(R.id.mapid);
        sharelove=findViewById(R.id.shareid);

        openNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent=new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent =new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+ Uri.encode("4752189757")));
                intent.putExtra("sms_body","Tejasvini Shelar");
                startActivity(intent);
            }
        });

        makecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:4752189757"));
                startActivity(intent);
            }
        });

        openweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent =new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

        openmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = String.format("geo:20.3271 ,74.2473");
                Uri geo= Uri.parse(geoUri);
                Intent intent =new Intent(Intent.ACTION_VIEW,geo);
                startActivity(intent);
            }
        });

        sharelove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent =new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share the love"));
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest/.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "You Clicked on Settings", Toast.LENGTH_LONG).show();
        }

        if (id == R.id.action_help) {
            final Intent intent=new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
