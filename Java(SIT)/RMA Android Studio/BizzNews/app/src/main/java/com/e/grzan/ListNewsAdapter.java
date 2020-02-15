package com.e.grzan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

//class for setting and adapting view in MainActivity class

class ListNewsAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public ListNewsAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
        this.activity = activity;
        this.data =data;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ListNewsViewHolder holderOfApiVariables = null;
        if (convertView == null) {
            holderOfApiVariables = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.list_row, parent, false);
            holderOfApiVariables.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            holderOfApiVariables.author = (TextView) convertView.findViewById(R.id.author);
            holderOfApiVariables.title = (TextView) convertView.findViewById(R.id.title);
            holderOfApiVariables.sdetails = (TextView) convertView.findViewById(R.id.sdetails);
            holderOfApiVariables.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holderOfApiVariables);
        } else {
            holderOfApiVariables = (ListNewsViewHolder) convertView.getTag();
        }
        holderOfApiVariables.galleryImage.setId(position);
        holderOfApiVariables.author.setId(position);
        holderOfApiVariables.title.setId(position);
        holderOfApiVariables.sdetails.setId(position);
        holderOfApiVariables.time.setId(position);

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try{
            holderOfApiVariables.author.setText(song.get(MainActivity.API_AUTHOR));
            holderOfApiVariables.title.setText(song.get(MainActivity.API_TITLE));
            holderOfApiVariables.time.setText(song.get(MainActivity.API_PUBLISHEDAT));
            holderOfApiVariables.sdetails.setText(song.get(MainActivity.API_DESCRIPTION));

            if(song.get(MainActivity.API_URLTOIMAGE).toString().length() < 5)
            {
                holderOfApiVariables.galleryImage.setVisibility(View.GONE);
            }else{
                Picasso.get()
                        .load(song.get(MainActivity.API_URLTOIMAGE))
                        .resize(300, 200)
                        .centerCrop()
                        .into(holderOfApiVariables.galleryImage);
            }
        }catch(Exception e) {}
        return convertView;
    }
}

class ListNewsViewHolder {
    ImageView galleryImage;
    TextView author, title, sdetails, time;
}