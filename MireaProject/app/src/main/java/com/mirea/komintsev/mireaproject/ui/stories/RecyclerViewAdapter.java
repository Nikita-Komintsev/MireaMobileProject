package com.mirea.komintsev.mireaproject.ui.stories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.komintsev.mireaproject.BuildConfig;
import com.mirea.komintsev.mireaproject.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private List<Stories> stories;
    private Context context;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter( Context context, List<Stories> data) {
        this.stories = data;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_stories, parent, false);
        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Stories stories = this.stories.get(position);
        //int imageResID = getDrawableResIdByName(stories.getPhoto());
        //holder.photo.setImageResource(imageResID);
        holder.text.setText(stories.getText());
    }

    private int getDrawableResIdByName(String photo) {
        String pkgName = BuildConfig.APPLICATION_ID;
        int resId = context.getResources().getIdentifier(photo, "drawable", pkgName);
        return resId;
    }

    @Override
    public int getItemCount() {
        return this.stories.size();
    }
}
