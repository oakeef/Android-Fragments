package com.example.evan.assignment3;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Evan on 11/23/2016.
 */

public class ViewImageFragment extends Fragment {

    public static final String KEY_ANIMAL_INDEX = "animal_index";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int index = getArguments().getInt(KEY_ANIMAL_INDEX);
        ImageView image = new ImageView(getActivity());
        image.setImageResource(ImageList.resourceIds[index]);
        return image;

    }


    @Override
    public void onStop(){
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));

    }

}
