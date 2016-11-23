package com.example.evan.assignment3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.evan.assignment3.R.id.listRecyclerView;

/**
 * Created by Evan on 11/21/2016.
 */

public class ListFragment extends Fragment{

    public interface animalSelectedInterface{

        void onAnimalSelected(int index);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        animalSelectedInterface listener = (animalSelectedInterface) getActivity();

        //create View that grabs the fragment_List layout from the inflater
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //create a RecyclerView object and cast it as a RecyclerView.
        RecyclerView recyclerView = (RecyclerView) view.findViewById(listRecyclerView);

        //create a ListAdapter object to add to the recyclerView
        ListAdapter listAdapter = new ListAdapter(listener);

        //use the setAdapter method to set the listAdapter created above as the adapter for this object
        recyclerView.setAdapter(listAdapter);

        //create a LayoutManager object to add to the recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        //set the recyclerView LayoutManager to the one just created.
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
