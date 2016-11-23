package com.example.evan.assignment3;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Evan on 11/21/2016.
 */

public class ListAdapter extends RecyclerView.Adapter {

    private final ListFragment.animalSelectedInterface _Listener;

    public ListAdapter(ListFragment.animalSelectedInterface listener) {
        _Listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount(){
        return ImageList.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView _TextView;
        private ImageView _ImageView;
        private int _Index;

        public ListViewHolder(View itemView){
            super(itemView);
            _TextView = (TextView) itemView.findViewById(R.id.itemText);
            _ImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }
        public void bindView(int position){

            _Index = position;
            _TextView.setText(ImageList.names[position]);
            _ImageView.setImageResource(ImageList.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
            _Listener.onAnimalSelected(_Index);
        }
    }
}
