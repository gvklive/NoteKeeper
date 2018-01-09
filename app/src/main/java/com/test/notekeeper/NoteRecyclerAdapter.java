package com.test.notekeeper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author Ganesh Kaple
 * @since 09-01-2018
 */

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    private final List<NoteInfo> noteInfos;
    public NoteRecyclerAdapter(Context context, List<NoteInfo> noteInfos) {
        this.context = context;
        inflater = LayoutInflater.from(context);

        this.noteInfos = noteInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_note_list,parent,false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NoteInfo noteInfo= noteInfos.get(position);
        holder.textViewText.setText(noteInfo.getTitle());
        holder.textCourse.setText(noteInfo.getCourse().getTitle());
    }

    @Override
    public int getItemCount() {
        return noteInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView textViewText;
        public final TextView textCourse;

        public ViewHolder(View itemView) {
            super(itemView);
            textCourse = itemView.findViewById(R.id.text_note_title);
            textViewText = itemView.findViewById(R.id.text_note_text);
        }
    }
}