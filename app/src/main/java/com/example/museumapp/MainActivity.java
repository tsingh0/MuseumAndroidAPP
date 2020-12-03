package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * MainActivity class is the class responsible for creating the homepage of the app.
 * When a museum image is clicked on the homepage this class sends it to the next activity.
 * MainActivity also sets the option that is chosen on the homepage and passes it to the
 * second activity.
 *
 * @author Kacper Murdzek, Taranvir Singh
 */
public class MainActivity extends AppCompatActivity {

    /**
     * onCreate method sets the homepage to the first view xml.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * sendNextActivity_1 method is activated when the first museum is selected and
     * sets the option to 1 and passes it to the next activity.
     *
     * @param view
     */
    public void sendNextActivity_1(View view) {
        Intent intent = new Intent(this, MuseumOne.class);
        MuseumOne.setOption(1);
        startActivity(intent);
    }

    /**
     * sendNextActivity_2 method is activated when the second museum is selected and
     * sets the option to 2 and passes it to the next activity.
     *
     * @param view
     */
    public void sendNextActivity_2(View view) {
        Intent intent = new Intent(this, MuseumOne.class);
        MuseumOne.setOption(2);
        startActivity(intent);
    }

    /**
     * sendNextActivity_3 method is activated when the third museum is selected and
     * sets the option to 3 and passes it to the next activity.
     *
     * @param view
     */
    public void sendNextActivity_3(View view) {
        Intent intent = new Intent(this, MuseumOne.class);
        MuseumOne.setOption(3);
        startActivity(intent);
    }

    /**
     * sendNextActivity_4 method is activated when the fourth museum is selected and
     * sets the option to 4 and passes it to the next activity.
     *
     * @param view
     */
    public void sendNextActivity_4(View view) {
        Intent intent = new Intent(this, MuseumOne.class);
        MuseumOne.setOption(4);
        startActivity(intent);
    }
}