package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendNextActivity_1(View view){
        Intent intent = new Intent(this , MuseumOne.class);
        MuseumOne.setOption(1);
        startActivity(intent);
    }
    public void sendNextActivity_2(View view){
        Intent intent = new Intent(this, MuseumOne.class);
        MuseumOne.setOption(2);
        startActivity(intent);
    }
    public void sendNextActivity_3(View view){
        Intent intent = new Intent(this, MuseumOne.class);
        MuseumOne.setOption(3);
        startActivity(intent);
    }
    public void sendNextActivity_4(View view){
        Intent intent = new Intent(this, MuseumOne.class);
        MuseumOne.setOption(4);
        startActivity(intent);
    }
}