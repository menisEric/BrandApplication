package com.ericmenis.brandapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ericmenis.brandapplication.Models.Brands;
import com.ericmenis.brandapplication.R;

import java.util.List;

public class BrandAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Brands> list;

    public BrandAdapter(Context context, int layout, List<Brands> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder vh;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.name = (TextView) convertView.findViewById(R.id.textViewName);
            vh.icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            vh.origin = (TextView) convertView.findViewById(R.id.textViewOrigin);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }

        Brands currentBrands = (Brands) getItem(position);
        vh.name.setText(currentBrands.getName());
        vh.origin.setText(currentBrands.getOrigin());
        vh.icon.setImageResource(currentBrands.getIcon());

        return convertView;
    }

    static class ViewHolder{
        private TextView name;
        private ImageView icon;
        private TextView origin;
    }
}
