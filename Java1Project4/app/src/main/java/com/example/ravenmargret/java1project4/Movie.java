//Created Brenna Pavlinchak 2/25/2015

package com.example.ravenmargret.java1project4;

import android.nfc.Tag;
import android.util.Log;
import org.json.JSONObject;

import org.json.JSONObject;

public class Movie
{
        String mMovieTitle;

    public Movie(String mMovieTitle)
    {
        this.mMovieTitle = mMovieTitle;
    }

    public String getmMovieTitle()
    {
        return mMovieTitle;
    }

    public void setmMovieTitle(String mMovieTitle)
    {
        this.mMovieTitle = mMovieTitle;
    }

    @Override
    public String toString()
    {
        return mMovieTitle;
    }
}
