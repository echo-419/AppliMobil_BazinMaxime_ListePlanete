package com.example.maxba.liste_android;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {

    private final Context context;
    private final Resources res;
    private final int viewRes;
    private final ArrayList<AndroidVersion> AndroidVersionList;

    public AndroidAdapter(Context context, int textViewResourceId, ArrayList<AndroidVersion> versions){
        super(context,textViewResourceId,versions);
        this.AndroidVersionList=versions;
        this.context=context;
        this.res=context.getResources();
        this.viewRes=textViewResourceId;
    }


    static class ViewHolder { TextView title; TextView description; ImageView img;}

    @Override //Il faut implémenter getView ici
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;

        if (view == null) { LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
        view = layoutInflater.inflate(viewRes, parent, false);
        holder = new ViewHolder();
        holder.title= (TextView) view.findViewById(R.id.TV_nom);
        holder.description = (TextView) view.findViewById(R.id.TV_info);
        holder.img=(ImageView) view.findViewById(R.id.ImgPlanete);

        ;
        view.setTag(holder);
        } else {
            holder= (ViewHolder) view.getTag();
        } 
        final AndroidVersion androidVersion = AndroidVersionList.get(position);
        if (androidVersion != null) {

            final String versionName = String.format( androidVersion.getVersionName());
            holder.title.setText(versionName);
            final String versionNumber = String.format( androidVersion.getVersionNumber());
            holder.description.setText(versionNumber);
            switch (position){
                case 0:holder.img.setBackgroundResource(R.drawable.mercure);break;
                case 1:holder.img.setBackgroundResource(R.drawable.venus);break;
                case 2:holder.img.setBackgroundResource(R.drawable.mars);break;
                case 3:holder.img.setBackgroundResource(R.drawable.jupiter);break;
                case 4:holder.img.setBackgroundResource(R.drawable.saturne);break;
                case 5:holder.img.setBackgroundResource(R.drawable.uranus);break;
                case 6:holder.img.setBackgroundResource(R.drawable.neptune);break; }



            }
            return view;
    }
    public int getCount() { return AndroidVersionList.size(); }

    }




