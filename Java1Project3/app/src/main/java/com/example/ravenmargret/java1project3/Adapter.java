//Created by Brenna Pavlinchak on 2/15/15

package com.example.ravenmargret.java1project3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Map;

public class Adapter extends BaseAdapter
{
    Context mContext;
    private static final int ID_CONSTANT = 0x1000000;

    public Adapter(Context d, ArrayList objects)
    {
        mContext = d;
    }

    @Override
    public int getCount()
    {
        if(mObjects != null)
        {
            return mObjects.size();
        }

        else
        {
            return 0;
        }
    }

    @Override
    public Object getItem(int position)
    {
        if(mObjects != null && position < mObjects.size() && position >= 0)
        {
            int count = 0;
            String key = "";

            for(Map.Entry<String, Dogs> entry: mObjects.entrySet())
            {
                if(count == position)
                {
                    key = entry.getKey();
                }
                count++;
            }

            count = 0;

            return mObjects.get(key);
        }

        else
        {
            return null;
        }
    }


    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return convertView;
    }


}
