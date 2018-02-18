package com.alexschacher.dietapp.activityViewFoods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.alexschacher.dietapp.R;
import com.alexschacher.dietapp.database.Food;

class ListAdapterViewFoods extends ArrayAdapter<Food> {

    public ListAdapterViewFoods(Context context, Food[] foods) {
        super(context, R.layout.row_view_foods, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.row_view_foods, parent, false);

        Food food = getItem(position);
        TextView foodName = (TextView) customView.findViewById(R.id.foodName);
        TextView calories = (TextView) customView.findViewById(R.id.calories);
        TextView portionSize = (TextView) customView.findViewById(R.id.portionSize);
        TextView portionType = (TextView) customView.findViewById(R.id.portionType);

        foodName.setText(food.getName());
        calories.setText(food.getCalories() + " Cal");
        portionSize.setText(food.getPortionSize() + "");
        portionType.setText(" " + food.getPortionType().toString());
        return customView;
    }
}
