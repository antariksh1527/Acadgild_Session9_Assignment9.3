package com.tech.gigabyte.customlistview;

/**
 * Created by GIGABYTE on 5/4/2017.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//implementing an Activity
public class ListViewAdapter extends BaseAdapter
{
    private Activity context;
    private String title[];
    private String description[];

    ListViewAdapter(Activity context, String[] title, String[] description) {
        super();
        this.context = context;
        this.title = title;
        this.description = description;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return title.length;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    private class ViewHolder {
        TextView txtViewTitle;
        TextView txtViewDescription;
    }

    //ArrayAdapter for our list of persons that we want to display
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        //Logic for Placing Data to view/layout
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.listitem_row, null);
            holder = new ViewHolder();
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.tv1);
            holder.txtViewDescription = (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtViewTitle.setText(title[position]);
        holder.txtViewDescription.setText(description[position]);

        return convertView;
    }

}