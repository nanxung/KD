package com.kd.kd.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.kd.kd.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment{

    static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 10;//记录的条数
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private static int[] image;
    private static ArrayList<String> titlelist;

    public static RecyclerViewFragment newInstance(int [] image,ArrayList<String> titlelist) {
        RecyclerViewFragment.image=image;
        RecyclerViewFragment.titlelist=titlelist;
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager;

        if (GRID_LAYOUT) {
            layoutManager = new GridLayoutManager(getActivity(), 2);
        } else {
            layoutManager = new LinearLayoutManager(getActivity());
        }
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

        mAdapter = new TestRecyclerViewAdapter(image,titlelist);

        //mAdapter = new RecyclerViewMaterialAdapter();
        mRecyclerView.setAdapter(mAdapter);
//        View cardview = LayoutInflater.from(getContext())
//                .inflate(R.layout.list_item_card_small,null, false);
//        for (int i = 0; i < ITEM_COUNT; ++i) {
//            TextView t=new TextView(getContext());
//            t.setText("nihao");
//            mContentItems.add(t);
//        }
            mAdapter.notifyDataSetChanged();
       // }
    }
}
