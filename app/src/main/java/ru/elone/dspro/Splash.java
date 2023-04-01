package ru.elone.dspro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.elone.dspro.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.splash);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(Splash.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }, 2*1000);
}}