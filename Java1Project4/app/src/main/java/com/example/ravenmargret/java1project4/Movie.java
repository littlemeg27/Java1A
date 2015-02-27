//Created Brenna Pavlinchak 2/25/2015

package com.example.ravenmargret.java1project4;

import android.nfc.Tag;
import android.util.Log;
import org.json.JSONObject;

import org.json.JSONObject;

public class Movie
{
        final String TAG = "MOVIE CLASS";

        private String mMovieTitle;

        public Movie(){}

        public Movie(String movieTitle)
        {
           mMovieTitle = movieTitle;
        }


        public Movie(JSONObject movieInfo)
        {
            try
            {
                mMovieTitle = movieInfo.getString("title");
            }
            catch(Exception e)
            {
                Log.e(TAG, "Error updating display");
            }
        }

        public String getString() {
        return mMovieTitle;
    }

        public void setMovieTitle(String mMovieTitle) {
        this.mMovieTitle = mMovieTitle;
    }

}

