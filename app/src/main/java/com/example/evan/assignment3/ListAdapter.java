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

        private TextView mTextView;
        private ImageView mImageView;

        public ListViewHolder(View itemView){
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }
        public void bindView(int position){

            mTextView.setText(ImageList.names[position]);
            mImageView.setImageResource(ImageList.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
