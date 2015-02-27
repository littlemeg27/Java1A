//Created Brenna Pavlinchak 2/25/2015

package com.example.ravenmargret.java1project4;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends ActionBarActivity
{
    final String TAG = "API TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //My API KEY m7yan8vjttevv849nkhyr3wp
        //or
        //tvvcmnd7pfnt68u3achn5k86
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button searchButton = (Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView enterMovie = (TextView)findViewById(R.id.enterMovie);
                String movie = enterMovie.getText().toString();
                try
                {
                    ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//Check network class

                    NetworkInfo info = manager.getActiveNetworkInfo();
                    if(info !=null && info.isConnected())
                    {
                        MyTask myTask = new MyTask();
                        myTask.execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=m7yan8vjttevv849nkhyr3wp&q="+ enterMovie +"&page_limit=10");
                    }
                }
                catch(Exception e)
                {
                    Log.e(TAG, "Invalid query for movie: " + movie);
                }
            }
        });

    }

    private void updateDisplay(Movie movie)
    {
        ((TextView))//Updating the display with the new 
    }
    private class MyTask extends AsyncTask<String, Void, JSONObject>
    {
        final String TAG = "API DEMO AsyncTask";

        ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("Loading...");
            dialog.setTitle("Network Call");
            dialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... params)
        {
            String results = ""; //All this and below should be to collect string responses
                                //According to what Donlan says in the video hope this code is right
            try
            {
                URL url = new URL(params[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();
                results = IOUtils.toString(is);
                is.close();
            }
            catch(MalformedURLException e)
            {
                e.printStackTrace();
                results = "N/A";
                //Log.e(TAG, "Could not create URL Connection to " + url.toString());
            }
            catch(IOException e)
            {
                e.printStackTrace();
                results = "N/A";
            }

            Log.i(TAG, "Received Data " + results);

            JSONObject apiObject;

            try
            {
                apiObject = new JSONObject(results);
            }
            catch(JSONException e)
            {
                Log.e(TAG, "Cannot convert API Response to JSON");
                apiObject = null;
            }

            try
            {
                apiObject = (apiObject != null) ? apiObject.getJSONObject("movies"):null;
                Log.i(TAG, "API JSON data received " + apiObject.toString());
            }
            catch(Exception e)
            {
                Log.e(TAG, "Could not parse data record from response " + apiObject.toString());
                apiObject = null;
            }

            return apiObject;





        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(JSONObject apiObject)
        {
            Movie endResult = new Movie(apiObject);

            updateDisplay(endResult);




            super.onPostExecute(apiObject);



        }

    }

}
