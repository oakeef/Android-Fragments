package com.example.evan.assignment3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Evan on 11/25/2016.
 */

//created this class as a generic adapter as to not repeat code.
//made it abstract so that it can be a parent class to other adapters
public abstract class RecyclerAdapter extends RecyclerView.Adapter {
    
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return new ListViewHolder(view);
    }

    //this abstract method is to get the LayoutId since other adapters will do it differently
    protected abstract int getLayoutId();

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
            onAnimalSelected(_Index);
        }
    }

    //this abstract method is the onClick
    protected abstract void onAnimalSelected(int index);
}

