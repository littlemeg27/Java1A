//Created by Brenna Pavlinchak on 2/15/15


package com.example.ravenmargret.java1project3;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.R.layout.simple_list_item_1;


public class MainActivity extends ActionBarActivity
{
    Context mContext;
    TextView breed;
    TextView type;
    TextView hairType;
    TextView color;
    TextView temperament;
    TextView age;
    ListView listView;
    Spinner theSpinner;
    ArrayList dogs;
    int dogsIndex;
    ArrayAdapter<String> spinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        listView = (ListView)findViewById(R.id.listView);
        breed = (TextView)findViewById(R.id.breed);
        type = (TextView)findViewById(R.id.type);
        hairType = (TextView)findViewById(R.id.hairType);
        color = (TextView)findViewById(R.id.color);
        temperament = (TextView)findViewById(R.id.temperament);
        age = (TextView)findViewById(R.id.age);

        dogs.add(new Dogs("Golden Retriever", "Sporting", "Medium Coat", "Red & Gold", "Reliable, Friendly, Kind", "11 Years"));
        dogs.add(new Dogs("Standard Poodle", "Non-Sporting", "Wavy Coat", "Various", "Eager to please", "12 Years"));
        dogs.add(new Dogs("Greyhound", "Hound","Smooth Coat","Various","Even Tempered, Athletic, Gentle","15 Years"));
        dogs.add(new Dogs("Great Dane", "Sporting", "Smooth Coat", "Various", "Devoted, Reserved, Gentle", "8 Years"));
        dogs.add(new Dogs("Alaskan Malamute", "Working", "Medium Coat", "Black, Grey & White", "Playful, Devoted, Loyal", "13 to 16 years"));
        dogs.add(new Dogs("Giant Schnauzer", "Working", "Medium Coat", "Black", "Strong Willed, Loyal, Kind", "10 Years"));
        dogs.add(new Dogs("Airedale Terrier", "Terrier", "Wavy Coat", "Brown and Black", "Outgoing, Alert, Friendly", "11.5 Years"));



        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            theSpinner = (Spinner) findViewById(R.id.spinner);
            spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

            theSpinner.setAdapter(spinnerAdapter);

        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            final Adapter theAdapter = new Adapter(mContext, dogs);
            listView.setAdapter(theAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, simple_list_item_1, dogs);

                    listView.setAdapter(arrayAdapter);
                }
            });
        }

    }//End of onCreate



}
