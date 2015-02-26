package com.example.ravenmargret.java1project4;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends ActionBarActivity
{
    Button searchMovie;
    EditText enterMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //My API KEY m7yan8vjttevv849nkhyr3wp
        //or
        //tvvcmnd7pfnt68u3achn5k86
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//Check network class

        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info !=null && info.isConnected())
        {
            MyTask myTask = new MyTask();
            myTask.execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=m7yan8vjttevv849nkhyr3wp&q="+  +"&page_limit=10");
            //+ variable for a search feature
            //If i move above line to another class now the heck do i make it work with a button variable?
        }

    }

    private class MyTask extends AsyncTask<String, Void, String>
    {

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
        protected String doInBackground(String... params)
        {
            String results = "";

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
            }
            catch(IOException e)
            {
                e.printStackTrace();
                results = "N/A";
            }

            return results;
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(String s)
        {
            super.onCancelled(s);
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);

            if(!s.equals("N/A"))
            {
                //Place code to handle JSON data

                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();

                JSONObject jsonObject;

                try //Check network class
                {
                    jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONObject("").getJSONArray("");

                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        //Loop though JSON Array to add to an arraylist.
                        //Add array to list view
                    }
                }
                catch(JSONException e)
                {
                    e.printStackTrace();
                }


            }

            dialog.cancel();
        }




    }


}
