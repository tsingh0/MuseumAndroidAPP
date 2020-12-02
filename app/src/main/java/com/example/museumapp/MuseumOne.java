package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MuseumOne extends AppCompatActivity {
    private static int option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch(option){
            case 1:
                setContentView(R.layout.activity_museum_one);
                break;
            case 2:
                setContentView(R.layout.activity_museum_two);
                break;
            case 3:
                setContentView(R.layout.activity_museum_three);
                break;
            case 4:
                setContentView(R.layout.activity_museum_four);
                break;
            default:
                break;
        }

        }
    public static void setOption(int option){
        MuseumOne.option = option;
    }
}