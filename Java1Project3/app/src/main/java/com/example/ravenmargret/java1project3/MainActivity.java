//Created by Brenna Pavlinchak on 2/15/15


package com.example.ravenmargret.java1project3;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

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
    ArrayAdapter<String> spinnerAdapter;
    ArrayList <String> showing = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        listView = (ListView)findViewById(R.id.listView);
        breed = (TextView)findViewById(R.id.textView);
//        type = (TextView)findViewById(R.id.type);
//        hairType = (TextView)findViewById(R.id.hairType);
        color = (TextView)findViewById(R.id.theDesc);
//        temperament = (TextView)findViewById(R.id.temperament);
//        age = (TextView)findViewById(R.id.age);

        final ArrayList<Dogs> dogs = new ArrayList<Dogs>();
        if(dogs !=null)
        {
            dogs.add(new Dogs("Golden Retriever", "Sporting", "Medium Coat", "Red & Gold", "Reliable, Friendly, Kind", "11 Years"));
            dogs.add(new Dogs("Standard Poodle", "Non-Sporting", "Wavy Coat", "Various", "Eager to please", "12 Years"));
            dogs.add(new Dogs("Greyhound", "Hound", "Smooth Coat", "Various", "Even Tempered, Athletic, Gentle", "15 Years"));
            dogs.add(new Dogs("Great Dane", "Sporting", "Smooth Coat", "Various", "Devoted, Reserved, Gentle", "8 Years"));
            dogs.add(new Dogs("Alaskan Malamute", "Working", "Medium Coat", "Black, Grey & White", "Playful, Devoted, Loyal", "13 to 16 years"));
            dogs.add(new Dogs("Giant Schnauzer", "Working", "Medium Coat", "Black", "Strong Willed, Loyal, Kind", "10 Years"));
            dogs.add(new Dogs("Airedale Terrier", "Terrier", "Wavy Coat", "Brown and Black", "Outgoing, Alert, Friendly", "11.5 Years"));
        }

        ListView lv = (ListView)findViewById(R.id.listView);
        Adapter theAdaptor = new Adapter(MainActivity.this, dogs);
        lv.setAdapter(theAdaptor);

        LinearLayout portrait = (LinearLayout)findViewById(R.id.portraitView); //Setting for the hide or view
        RelativeLayout landscape = (RelativeLayout)findViewById(R.id.landscapeView);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            portrait.setVisibility(View.VISIBLE);
            landscape.setVisibility(View.GONE);
            theSpinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerArray, android.R.layout.simple_dropdown_item_1line);
            theSpinner.setAdapter(spinnerAdapter);
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            portrait.setVisibility(View.GONE);
            landscape.setVisibility(View.VISIBLE);
            //ArrayAdapter<String>   = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dogs);
            //listView.setAdapter(theAdapter);
        }

        theSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                breed.setText(dogs.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = dogs.get(position).toString();
                color.setText(selectedItem + "");
            }
        });


        // Relitive layout for the landscape
        // linear layout for portrate
        // Hide and show the layouts based on the oriantation of the device
        // GONE for removal and VISABLE for showing


    }//End of onCreate

}
