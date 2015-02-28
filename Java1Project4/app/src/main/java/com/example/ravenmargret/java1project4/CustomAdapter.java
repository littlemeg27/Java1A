package com.example.ravenmargret.java1project4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter
{


    Context mContext;
    ArrayList<Movie> mCustomClass;



    private static final int ID_CONSTANT = 0x01000000;

    public CustomAdapter(Context mContext, ArrayList<Movie> mCustomClass)
    {
        this.mContext = mContext;
        this.mCustomClass = mCustomClass;
    }


    @Override
    public int getCount()
    {
        if (mCustomClass != null)
        {
            return mCustomClass.size();
        }
        else
        {
            return 0;
        }
    }

    @Override
    public Movie getItem(int position)
    {

        if (mCustomClass != null && position <mCustomClass.size() && position >= 0)
        {
            return mCustomClass.get(position);
        }
        else
        {
            return null;
        }

    }

    @Override
    public long getItemId(int position)
    {
        if (mCustomClass != null)
        {
            return ID_CONSTANT + position;

        }
        else
        {
            return 0;
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if (convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.customlayout, parent, false );
        }

        Movie item = getItem(position);

        ((TextView) convertView.findViewById(R.id.theTexView)).setText(item.toString());

        return convertView;



    }
}
