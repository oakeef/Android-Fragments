package com.example.evan.assignment3;

/**
 * Created by Evan on 11/21/2016.
 */

public class ListAdapter extends RecyclerAdapter {

    private final ListFragment.animalSelectedInterface _Listener;

    public ListAdapter(ListFragment.animalSelectedInterface listener) {
        _Listener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onAnimalSelected(int index) {
            _Listener.onAnimalSelected(index);
    }

}
