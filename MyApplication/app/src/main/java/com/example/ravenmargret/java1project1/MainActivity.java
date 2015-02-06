package com.example.ravenmargret.java1project1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
{

    private Button addButton;
    private EditText addWordText;
    protected Button indexButton;
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
        setContentView(R.layout.activity_main);
        mContext = this;


        final ArrayList arrayList = new ArrayList<String>();
        button = (Button)findViewById(R.id.button);
        textBox = (EditText)findViewById(R.id.editText);
        button2 = (Button)findViewById(R.id.button2);
        textBox2 = (EditText)findViewById(R.id.editText2);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String addItem = textBox.getText().toString();
                if (!arrayList.contains(addItem))
                {
                    arrayList.add(addItem); //Add item to the array list
                    Log.i("Title", addItem);
                    textBox.setText(""); //Reset the word text box

                    letter = addItem.length(); //Find out the length word

                    count = count + letter; //Find out the total count of the letters
                }

                word = arrayList.size(); //Find the word count
                textView.setText(String.valueOf("Count of Words: " + word)); //Put the text into the text view

                average = count / word; //Find the average of the letters
                textView2.setText(String.valueOf("Average Letter Count: " + average)); //Put the text into the text view

            }

        }); //End of Button


        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)//Start of second Button
            {
                index = Integer.parseInt(String.valueOf(textBox2.getText()));

                if (index < arrayList.size()) //If the size of the array is the size of the index put in
                {
                    textBox2.setText(""); //Reset the number text box
                    String addItem = textBox2.getText().toString();

                    if (!arrayList.contains(addItem)) //Check to see if there are items inside of the arraylist
                    {
                        String theWord = "";

                        theWord = (String) arrayList.get(index); //Get the word from the index


                        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext); //Alert set for the index
                        dialog.setTitle("You Picked an Index!");
                        dialog.setMessage("Index pick of the ArrayList: " + theWord);
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                            }

                        });
                        dialog.show();
                    }//End of



                }
                else //If a number is not picked an alert will pop up
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                    dialog.setTitle("You Picked an Index!");
                    dialog.setMessage("The index that was picked was invalid");
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                        }

                    });
                    dialog.show();
                }
            } //End of onClick

        }); //End of second Button




    }
