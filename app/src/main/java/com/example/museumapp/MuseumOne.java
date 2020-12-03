package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.museumapp.R.drawable.*;

/**
 * MuseumOne class controls the activity_museum_one.xml, it gives the interface functionality,
 * to allow users to calculate the ticket price for four different museums abiding by the
 * New York State sales tax to calculate the grand total. Interface does not allow for more
 * than 5 of each type of ticket.
 *
 * @author Kacper Murdzek, Tarnavir Singh
 */
public class MuseumOne extends AppCompatActivity {
    private static int option;
    private static double adultTicketPrice;
    private static double studentTicketPrice;
    private static double seniorTicketPrice;

    private Spinner spinner_child;
    private Spinner spinner_adult;
    private Spinner spinner_senior;
    private TextView ticketPrice;
    private TextView tax;
    private TextView total;

    DecimalFormat df = new DecimalFormat("#,###,##0.00");
    DecimalFormat df2 = new DecimalFormat("0");

    /**
     * onCreate method sets the second activity and shows a different view for each museum.
     * onCreate method displays ticket price for every age group for each museum.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (option) {
            case 1:
                setContentView(R.layout.activity_museum_one);

                TextView historyName = findViewById(R.id.museumName);
                historyName.setText(R.string.american_museum_of_natural_history);

                ImageButton historyImage = findViewById(R.id.museumImage);
                historyImage.setImageResource(b9);

                TextView historyStudent = findViewById(R.id.studentPrice);
                historyStudent.setText(R.string.child_price_history);

                TextView historyAdult = findViewById(R.id.adultPrice);
                historyAdult.setText(R.string.adult_price_history);

                TextView historySenior = findViewById(R.id.seniorPrice);
                historySenior.setText(R.string.senior_price_history);

                break;
            case 2:
                setContentView(R.layout.activity_museum_one);

                TextView metName = findViewById(R.id.museumName);
                metName.setText(R.string.the_metropolitan_museum_of_art);

                ImageButton metImage = findViewById(R.id.museumImage);
                metImage.setImageResource(met);

                TextView metStudent = findViewById(R.id.studentPrice);
                metStudent.setText(R.string.child_price_met);

                TextView metAdult = findViewById(R.id.adultPrice);
                metAdult.setText(R.string.adult_price_met);

                TextView metSenior = findViewById(R.id.seniorPrice);
                metSenior.setText(R.string.senior_price_met);

                break;
            case 3:
                setContentView(R.layout.activity_museum_one);

                TextView momaName = findViewById(R.id.museumName);
                momaName.setText(R.string.the_museum_of_modern_art);

                ImageButton momaImage = findViewById(R.id.museumImage);
                momaImage.setImageResource(moderart);

                TextView momaStudent = findViewById(R.id.studentPrice);
                momaStudent.setText(R.string.child_price_moma);

                TextView momaAdult = findViewById(R.id.adultPrice);
                momaAdult.setText(R.string.adult_price_moma);

                TextView momaSenior = findViewById(R.id.seniorPrice);
                momaSenior.setText(R.string.senior_price_moma);

                break;
            case 4:
                setContentView(R.layout.activity_museum_one);

                TextView illusionName = findViewById(R.id.museumName);
                illusionName.setText(R.string.museum_of_illusions);

                ImageButton illusionImage = findViewById(R.id.museumImage);
                illusionImage.setImageResource(illusions);

                TextView illusionStudent = findViewById(R.id.studentPrice);
                illusionStudent.setText(R.string.child_price_illusions);

                TextView illusionAdult = findViewById(R.id.adultPrice);
                illusionAdult.setText(R.string.adult_price_illusions);

                TextView illusionSenior = findViewById(R.id.seniorPrice);
                illusionSenior.setText(R.string.senior_price_illusions);

                break;
            default:
                break;
        }
        Toast.makeText(getApplicationContext(), "Maximum of 5 tickets for each!", Toast.LENGTH_SHORT).show();

    }

    /**
     * setOption method sets the option instance variable.
     * Option instance variable allows MuseumOne class to know which museum was
     * selected on the start screen.
     *
     * @param option
     */
    public static void setOption(int option) {
        MuseumOne.option = option;
    }

    /**
     * goWebsite is ran when the museum image is clicked.
     * This method brings the user to the museum homepage when the museum image is clicked on the second activity screen.
     *
     * @param view
     */
    public void goWebsite(View view) {

        switch (option) {
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

    /**
     * calculate method sends the museum option to the set price method, so the price can be
     * set according to the museum selected.
     *
     * @param view
     */
    public void calculate(View view) {
        switch (option) {
            case 1:
                setPrice(1);
                break;
            case 2:
                setPrice(2);
                break;
            case 3:
                setPrice(3);
                break;
            case 4:
                setPrice(4);
                break;
            default:
                break;
        }
    }

    /**
     * setPrice method sets the TextView fields on the interface
     * to the respective cost of the tickets for each museum.
     * setPrice method also calculates the sales tax for the museum
     * and displays it.
     *
     * @param option
     */
    private void setPrice(int option) {
        spinner_child = findViewById(R.id.spinner_child);
        String numberOfChildren = spinner_child.getSelectedItem().toString();
        spinner_adult = findViewById(R.id.spinner_adult);
        String numberOfAdults = spinner_adult.getSelectedItem().toString();
        spinner_senior = findViewById(R.id.spinner_senior);
        String numberOfSeniors = spinner_senior.getSelectedItem().toString();
        int children = Integer.parseInt(numberOfChildren);
        int adults = Integer.parseInt(numberOfAdults);
        int seniors = Integer.parseInt(numberOfSeniors);
        double totalOfTickets = 0;
        switch (option) {
            case 1:
                totalOfTickets = children * Prices.childPriceHistory + adults * Prices.adultPriceHistory + seniors * Prices.seniorPriceHistory;
                break;
            case 2:
                totalOfTickets = children * Prices.childPriceMet + adults * Prices.adultPriceMet + seniors * Prices.seniorPriceMet;
                break;
            case 3:
                totalOfTickets = children * Prices.childPriceMoMa + adults * Prices.adultPriceMoMa + seniors * Prices.seniorPriceMoMa;
                break;
            case 4:
                totalOfTickets = children * Prices.childPriceIllusions + adults * Prices.adultPriceIllusions + seniors * Prices.seniorPriceIllusions;

        }
        double taxCost = totalOfTickets * 0.08875;
        double totalCost = totalOfTickets + taxCost;
        ticketPrice = (TextView) findViewById(R.id.ticketPrice);
        tax = (TextView) findViewById(R.id.tax);
        total = (TextView) findViewById(R.id.total);

        ticketPrice.setText("$ " + df2.format(totalOfTickets) + "");
        tax.setText("$ " + df.format(taxCost) + "");
        total.setText("$ " + df.format(totalCost) + "");
    }
}
