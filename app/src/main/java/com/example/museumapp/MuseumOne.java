package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MuseumOne extends AppCompatActivity {
    private static int option;
    private static double adultTicketPrice;
    private static double studentTicketPrice;
    private static double seniorTicketPrice;
    private TextView AMNH;

    private Spinner spinner_child;
    private Spinner spinner_adult;
    private Spinner spinner_senior;
    private TextView ticketPrice;
    private TextView tax;
    private TextView total;

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
    public void calculate(View view){
        switch(option){
            case 1:
                spinner_child = findViewById(R.id.spinner_child);
                String numberOfChildren = spinner_child.getSelectedItem().toString();
                spinner_adult = findViewById(R.id.spinner_adult);
                String numberOfAdults = spinner_adult.getSelectedItem().toString();
                spinner_senior = findViewById(R.id.spinner_senior);
                String numberOfSeniors = spinner_senior.getSelectedItem().toString();
                int children = Integer.parseInt(numberOfChildren);
                int adults = Integer.parseInt(numberOfAdults);
                int seniors = Integer.parseInt(numberOfSeniors);
                double totalOfTickets = children * Prices.childPriceHistory +adults * Prices.adultPriceHistory+ seniors * Prices.seniorPriceHistory;
                double taxCost = totalOfTickets * 0.08875;
                double totalCost = totalOfTickets + taxCost;

                ticketPrice = (TextView)findViewById(R.id.ticketPrice);
                tax = (TextView)findViewById(R.id.tax);
                total = (TextView)findViewById(R.id.total);

                ticketPrice.setText("$ "+totalOfTickets+ "");
                tax.setText("$ "+taxCost+"");
                total.setText("$ " +totalCost+"");

                break;
            case 2:


                break;
            case 3:

                break;
            case 4:

                break;
            default:
                break;
        }
    }



}
