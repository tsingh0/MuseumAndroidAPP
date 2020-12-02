package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MuseumOne extends AppCompatActivity {
    private static int option;
    private static double adultTicketPrice;
    private static double studentTicketPrice;
    private static double seniorTicketPrice;
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
        Toast.makeText(getApplicationContext(),"Maximum of 5 tickets for each!",Toast.LENGTH_SHORT).show();

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
