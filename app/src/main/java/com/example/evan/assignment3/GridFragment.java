package com.example.evan.assignment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.evan.assignment3.R.id.RecyclerView;

/**
 * Created by Evan on 11/25/2016.
 */

public class GridFragment extends Fragment {
    public interface animalSelectedInterface{

        void onGridAnimalSelected(int index);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        animalSelectedInterface listener = (animalSelectedInterface) getActivity();

        //create View that grabs the fragment_List layout from the inflater
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        //create a RecyclerView object and cast it as a RecyclerView.
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);

        //replace listAdapter from ListFragment to gridAdapter
        GridAdapter gridAdapter = new GridAdapter(listener);
        recyclerView.setAdapter(gridAdapter);

        //had to learn a lot about dp and how android deals with display sizes and pixels to get this part
        //found a good tutorial that explained how dp is calculated and helped me bigtime with this.
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int numColumns = (int) (dpWidth / 200);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
