package com.kd.kd.main;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kd.kd.Load;
import com.kd.kd.R;

import java.util.ArrayList;

public class TestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int[] contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
   private int position=-1;
    private ArrayList<String>titlelist;

    public TestRecyclerViewAdapter(int[] contents,ArrayList<String>titlelist) {
        this.titlelist=titlelist;
        this.contents = contents;

    }

    @Override
    public int getItemViewType(int position) {
        this.position=position;
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.length;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                ImageView i1=(ImageView)view.findViewById(R.id.Lageimage);
                i1.setImageResource(contents[position]);
                TextView title=(TextView)view.findViewById(R.id.title);
                title.setText(titlelist.get(position));
                return new RecyclerView.ViewHolder(view) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
    }
}