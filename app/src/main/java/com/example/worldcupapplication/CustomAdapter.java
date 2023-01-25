package com.example.worldcupapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<CountryModelClass> {
    private ArrayList<CountryModelClass> countryArrayList;
    Context context;

    public CustomAdapter(ArrayList<CountryModelClass> data, Context context){
        super(context, R.layout.item_list_layout, data);
        this.countryArrayList = data;
        this.context = context;
    }

    //View Lookup Cache
    private  static class ViewHolder{
        TextView txtCountry;
        TextView txtCupWins;
        ImageView flagImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        //Get the data item for this position
        CountryModelClass dataModel = getItem(position);

        //Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        final View result;
        if(convertView == null){
            viewHolder = new ViewHolder();

            //Layout Inflater is a class used to instantiate Layout XML file into its corresponding
            //view object which can be used in java programs
            //There are two ways tp create UI in android i)Static  ii)Dynamic of Programmatically

            //Inflating means reading the XML file that describes the layout or GUI Element.and to
            //create the actual object that correspond to it and thus making the object visible
            //within an android app.
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            viewHolder.txtCountry = (TextView) convertView.findViewById(R.id.countryName);
            viewHolder.txtCupWins = (TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.flagImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //Get the data form the model class
        viewHolder.txtCountry.setText(dataModel.getCountry_name());
        viewHolder.txtCupWins.setText(dataModel.getCup_win_count());
        viewHolder.flagImg.setImageResource(dataModel.getFlag_img());

        return convertView;
    }
}

