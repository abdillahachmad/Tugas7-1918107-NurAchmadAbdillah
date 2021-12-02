package com.example.sqlite_sepatu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Sepatu> Sepatu;
    public CustomListAdapter(Activity activity, List<Sepatu>
            Sepatu) {
        this.activity = activity;
        this.Sepatu = Sepatu;
    }
    @Override
    public int getCount() {
        return Sepatu.size();
    }
    @Override
    public Object getItem(int location) {
        return Sepatu.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView ukuran = (TextView)
                convertView.findViewById(R.id.text_ukuran);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Sepatu m = Sepatu.get(position);
        nama.setText("Nama : "+ m.get_nama());
        ukuran.setText("Ukuran : "+ m.get_ukuran());
        return convertView;
    }
}

