package com.mirea.komintsev.mireaproject.ui.notes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.komintsev.mireaproject.R;
import com.mirea.komintsev.mireaproject.ui.notes.db.Notes;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.MyViewHolder>{
    private final Context context;
    private List<Notes> notesList;
    private final ItemClicked itemClicked;
    private RecyclerView recyclerView;

    public NotesListAdapter(Context context, ItemClicked itemClicked){
        this.context = context;
        this.itemClicked = itemClicked;
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

        Notes notes = notesList.get(position);

        holder.deleteNoteImage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Note Deleted", Toast.LENGTH_SHORT).show();
                itemClicked.deletedClicked(notes);
                notesList.remove(notes);
                notifyDataSetChanged();
            }
        });
    }

    public interface ItemClicked{
        void deletedClicked(Notes notes);
    }

    @Override
    public int getItemCount() {
        return this.notesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView tvTitle;
        TextView tvNote;
        ImageView deleteNoteImage;

        public MyViewHolder(View view){
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvNote = view.findViewById(R.id.tvNote);
            deleteNoteImage = view.findViewById(R.id.deleteNoteImage);
        }

    }

}
