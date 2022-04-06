package com.mirea.komintsev.mireaproject.ui.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mirea.komintsev.mireaproject.R;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Hero> heroes;

    public HeroAdapter(Context context, ArrayList<Hero> heroes) {
        this.context = context;
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int positioin, View containerView, ViewGroup viewGroup) {
        Hero hero = heroes.get(positioin);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_retrofit, null);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewLink = view.findViewById(R.id.textViewLink);
        ImageView imageViewHro = view.findViewById(R.id.imageViewHero);

        textViewName.setText(hero.getName());
        textViewLink.setText(hero.getImageurl());
        Glide.with(context).load(hero.getImageurl()).into(imageViewHro);
        return view;
    }
}
