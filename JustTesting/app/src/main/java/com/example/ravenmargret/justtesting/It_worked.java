//Created Brenna Pavlinchak 2/9/2015

package com.example.ravenmargret.justtesting;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class It_worked extends ActionBarActivity
{

    private Button addButton;
    protected Button indexButton;
    private EditText addWordText;
    private EditText indexText;
    private TextView wordTextBox;
    private TextView averageTextBox;
    Context mContext;

    int letter;
    int word;
    int count;
    int average;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_worked);
        mContext = this;


        final ArrayList arrayList = new ArrayList<String>();
        addButton = (Button) findViewById(R.id.addButton);
        addWordText = (EditText) findViewById(R.id.addWordText);
        indexButton = (Button) findViewById(R.id.indexButton);
        indexText = (EditText) findViewById(R.id.indexText);
        wordTextBox = (TextView) findViewById(R.id.wordTextBox);
        averageTextBox = (TextView) findViewById(R.id.averageTextBox);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)//Start of first Button
            {

                String addItem = addWordText.getText().toString();
                if (!arrayList.contains(addItem))
                {
                    arrayList.add(addItem); //Add item to the array list
                    addWordText.setText(""); //Reset the word text box

                    letter = addItem.length(); //Find out the length word

                    count = count + letter; //Find out the total count of the letters
                }

                word = arrayList.size(); //Find the word count
                wordTextBox.setText(String.valueOf("Number Of Words: " + word)); //Put the text into the text view

                average = count / word; //Find the average of the letters
                averageTextBox.setText(String.valueOf("Average Letter's: " + average)); //Put the text into the text view

            }

        }); //End of Button


        indexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)//Start of second Button
            {

                index = Integer.parseInt(String.valueOf(indexText.getText()));

                if (index < arrayList.size()) //If the size of the array is the size of the index put in
                {
                    indexText.setText(""); //Reset the number text box
                    String addItem = indexText.getText().toString();

                    if (!arrayList.contains(addItem)) //Check to see if there are items inside of the arraylist
                    {
                        String arrayWord = "";

                        arrayWord = (String) arrayList.get(index); //Get the word from the index

                        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext); //Alert set for the index
                        dialog.setTitle("Picked an Index");
                        dialog.setMessage("Index picked: " + arrayWord);
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }

                        });
                        dialog.show();
                    }

                }//End of if
                else //If a number is not picked then show this alert
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                    dialog.setTitle("Picked an Index");
                    dialog.setMessage("The index you picked was invalid");
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                        }

                    });
                    dialog.show();
                }//End of else
            } //End of onClick

        }); //End of second Button

    } //End of onCreate

}

