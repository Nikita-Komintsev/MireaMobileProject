package com.mirea.komintsev.mireaproject.ui.notes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.komintsev.mireaproject.R;
import com.mirea.komintsev.mireaproject.ui.notes.db.Notes;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.MyViewHolder>{
    private Context context;
    private List<Notes> notesList;

    public NotesListAdapter(Context context){
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setNotesList(List<Notes> notesList){
        this.notesList = notesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(this.notesList.get(position).title);
        holder.tvNote.setText(this.notesList.get(position).description);
    }

    @Override
    public int getItemCount() {
        return this.notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvNote;
        public MyViewHolder(View view){
            super(view);
            tvTitle =  view.findViewById(R.id.tvTitle);
            tvNote=  view.findViewById(R.id.tvNote);
        }
    }
}
