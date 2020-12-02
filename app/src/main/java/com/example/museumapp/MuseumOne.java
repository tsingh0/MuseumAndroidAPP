package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

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


    public void goWebsite(View view){

        switch(option){
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amnh.org/")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.metmuseum.org/")));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.moma.org/")));
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://newyork.museumofillusions.us/")));
                break;
            default:
                break;
        }

    }



}
