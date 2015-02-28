//Created Brenna Pavlinchak 2/25/2015

package com.example.ravenmargret.java1project4;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
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
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
{
    final String TAG = "API TEST";

    ArrayList<Movie> movies = new ArrayList<Movie>();

    ListView movieList;
    TextView enterMovie;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //My API KEY m7yan8vjttevv849nkhyr3wp
        //or
        //tvvcmnd7pfnt68u3achn5k86
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;


        movieList = (ListView) findViewById(R.id.listView);

        Button searchButton = (Button)findViewById(R.id.searchButton);

        enterMovie = (EditText) findViewById(R.id.enterMovie);

        searchButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                String movie = enterMovie.getText().toString();
                try
                {
                    ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//Check network class

                    NetworkInfo info = manager.getActiveNetworkInfo();
                    if(info !=null && info.isConnected())
                    {
                        movies.clear();
                        MyTask myTask = new MyTask();
                        myTask.execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=m7yan8vjttevv849nkhyr3wp&q="+ enterMovie +"&page_limit=20");
                    }
                }
                catch(Exception e)
                {
                    Log.e(TAG, "Invalid query for movie: " + movie);
                }
            }
        });

    }



    private class MyTask extends AsyncTask<String, Void, String>
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
        protected String doInBackground(String... params)
        {
            String result = "";

            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream is = connection.getInputStream();

                result = IOUtils.toString(is);
                is.close();

            } catch (MalformedURLException e)
            {
                e.printStackTrace();
                Toast toast = Toast.makeText(MainActivity.this, "Could not find the movie try again", Toast.LENGTH_SHORT);
                toast.show();
            } catch (IOException e)
            {
                e.printStackTrace();
                Toast toast = Toast.makeText(MainActivity.this, "Could not find movie try again", Toast.LENGTH_SHORT);
                toast.show();
            }

            return result;
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);

            Log.e("JSON DATA", s);
                try {

                    JSONArray mainJSON = new JSONArray(s);
                    JSONArray childrenArray = mainJSON.getJSONArray(0);


                    for (int i = 0; i < childrenArray.length(); i++)
                    {
                        JSONObject childrenObject = childrenArray.getJSONObject(i);
                        String title;

                        if (childrenObject.has("title"))
                        {
                            title = childrenObject.getString("title");
                            Log.i("E:", title);
                        }
                        else
                        {
                            title = "N/A";
                        }

                        movies.add(new Movie(title));
                    }

                }
                catch (JSONException e)
                {
                    Toast toast = Toast.makeText(MainActivity.this, "Something Happened", Toast.LENGTH_SHORT);
                    toast.show();

                }

                CustomAdapter adaptor = new CustomAdapter(mContext, movies);
                movieList.setAdapter(adaptor);
                dialog.cancel();

            }

        }

}