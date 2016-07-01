package com.ivanebernal.photoshow;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ivan on 21/06/16.
 */
public class PhotoViewAdapter extends RecyclerView.Adapter<PhotoViewAdapter.PhotoViewHolder> {
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{
        private TextView mNameTextView;
        private TextView mDescriptionTextView;
        private ImageView mImageView;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.photo_holder);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.photo_description);
            mNameTextView = (TextView) itemView.findViewById(R.id.photo_author_name);
        }

        public void setData(Bitmap image, String name, String  description){
            mImageView.setImageBitmap(image);
            mDescriptionTextView.setText(description);
            mNameTextView.setText(name);
        }
    }
}
