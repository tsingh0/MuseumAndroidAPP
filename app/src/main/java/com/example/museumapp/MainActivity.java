package com.example.museumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * MainActivity class is the class responsible for creating the homepage of the app.
 * When a museum image is clicked on the homepage this class sends it to the next activity.
 * MainActivity also sets the option that is chosen on the homepage and passes it to the
 * second activity.
 *
 * @author Kacper Murdzek, Taranvir Singh
 */
public class MainActivity extends AppCompatActivity {

    ArrayList<String> museumList;
    ArrayAdapter<String> arrayAdapter;
    /**
     * onCreate method sets the homepage to the first view xml.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview = (ListView)findViewById(R.id.listview);
        museumList = new ArrayList<String>();
        museumList.add("American Museum of Natural History");
        museumList.add("Metropolitan Museum of Art");
        museumList.add("The Museum of Modern Art");
        museumList.add("Museum of Illusions");
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, museumList);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * onItemClick method is initiated when an item in the list view is clicked.
             * The method takes the position of the element clicked and passes the position to the
             * second activity for the view to be set.
             *
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(MainActivity.this, MuseumOne.class);
                MuseumOne.setOption(position);
                startActivity(intent);
            }
        });

    }
}