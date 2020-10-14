package com.example.nomasacidentes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class ListAdapter extends ArrayAdapter<ListMejoras> {
    private List<ListMejoras> mejorasList;
    private Context mContext;
    private int rMejora;

    public ListAdapter(@NonNull Context context, int resource, @NonNull ListMejoras[] objects) {
        super(context, resource, objects);
        this.mejorasList = Arrays.asList(objects);
        this.mContext = context;
        this.rMejora = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;


        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.vista_list, null);

            ListMejoras modelo= mejorasList.get(position);

            return view;
        }


        return super.getView(position, convertView, parent);


    }
}
