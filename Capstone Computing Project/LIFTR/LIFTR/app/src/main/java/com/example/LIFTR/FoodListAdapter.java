package com.example.LIFTR;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class FoodListAdapter extends ArrayAdapter<Food> {

    private static final String TAG = "FoodListAdapter";
    private Context aContext;
    private int aResource;
    private int lastPos = -1;
    Button gotoAddFood;

    static class ViewHolder {
        TextView name;
        TextView cal;
        TextView protein;
        TextView carbs;
        TextView fat;
        TextView servingType;
        TextView servingSize;
    }

    public FoodListAdapter(Context context, int resource, ArrayList<Food> objects) {
        super(context, resource, objects);
        aContext = context;
        aResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String name = getItem(position).getName();
        int cal = getItem(position).getCal();
        double protein = getItem(position).getProtein();
        double carbs = getItem(position).getCarbs();
        double fat = getItem(position).getFat();
        String servingType = getItem(position).getServingType();
        int servingSize = getItem(position).getServingSize();

        Food foodList = new Food(name, cal, protein, carbs, fat, servingType, servingSize);
        final View res;
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(aContext);
            convertView = inflater.inflate(aResource, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.foodname);
            holder.cal = (TextView) convertView.findViewById(R.id.calories);
            holder.protein = (TextView) convertView.findViewById(R.id.protein);
            holder.carbs = (TextView) convertView.findViewById(R.id.carbs);
            holder.fat = (TextView) convertView.findViewById(R.id.fat);
            holder.servingType = (TextView) convertView.findViewById(R.id.servingType);
            holder.servingSize = (TextView) convertView.findViewById(R.id.servingSize);

            res = convertView;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
            res = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(aContext,
                (position > lastPos) ? R.anim.loading_down_anim : R.anim.loading_up_anim);
        res.startAnimation(animation);
        lastPos = position;

        holder.name.setText(foodList.getName());
        holder.cal.setText(String.valueOf(foodList.getCal()));
        holder.protein.setText(String.valueOf(foodList.getProtein()));
        holder.carbs.setText(String.valueOf(foodList.getCarbs()));
        holder.fat.setText(String.valueOf(foodList.getFat()));
        holder.servingType.setText(foodList.getServingType());
        holder.servingSize.setText(String.valueOf(foodList.getServingSize()));

        return convertView;
    }
}
