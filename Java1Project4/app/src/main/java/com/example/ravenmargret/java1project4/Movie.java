//Created Brenna Pavlinchak 2/25/2015

package com.example.ravenmargret.java1project4;

public class Movie
{
        private  String title; //All the private variables


        public Movie(String mTitle)
        {
            title = mTitle;

        }


        public String getTitle() {return title;}


        @Override
        public String toString()
        {
            return "Title: " + title;
        }
}

