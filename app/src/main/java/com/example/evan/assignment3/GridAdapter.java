package com.example.evan.assignment3;

/**
 * Created by Evan on 11/25/2016.
 */

public class GridAdapter extends RecyclerAdapter {

    private final GridFragment.animalSelectedInterface _Listener;

    public GridAdapter(GridFragment.animalSelectedInterface listener) {
        _Listener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onAnimalSelected(int index) {
        _Listener.onGridAnimalSelected(index);
    }

}