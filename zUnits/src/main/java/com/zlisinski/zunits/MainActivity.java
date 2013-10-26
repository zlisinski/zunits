package com.zlisinski.zunits;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button distanceButton;
    Button massButton;
    Button pressureButton;
    Button speedButton;
    Button temperatureButton;
    Button volumeButton;
    TextView debugText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distanceButton = (Button)findViewById(R.id.btnDistance);
        massButton = (Button)findViewById(R.id.btnMass);
        pressureButton = (Button)findViewById(R.id.btnPressure);
        speedButton = (Button)findViewById(R.id.btnSpeed);
        temperatureButton = (Button)findViewById(R.id.btnTemperature);
        volumeButton = (Button)findViewById(R.id.btnVolume);
        debugText = (TextView)findViewById(R.id.debugText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void distanceClick(View v) {
        debugText.setText("Distance");
        Intent i = new Intent(MainActivity.this, DistanceActivity.class);
        startActivity(i);
    }

    public void massClick(View v) {
        debugText.setText("Mass");
        Intent i = new Intent(MainActivity.this, MassActivity.class);
        startActivity(i);
    }

    public void pressureClick(View v) {
        debugText.setText("Pressure");
    }

    public void speedClick(View v) {
        debugText.setText("Speed");
    }

    public void temperatureClick(View v) {
        debugText.setText("Temperature");
    }

    public void volumeClick(View v) {
        debugText.setText("Volume");
        Intent i = new Intent(MainActivity.this, VolumeActivity.class);
        startActivity(i);
    }
}
