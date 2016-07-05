package com.ivanebernal.photoshow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivanebernal.photoshow.Models.Datum;
import com.ivanebernal.photoshow.Models.UserRecentMedia;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 21/06/16.
 */
public class PhotoViewAdapter extends RecyclerView.Adapter<PhotoViewAdapter.PhotoViewHolder> {
    private List<String> urls = new ArrayList<>();
    private List<String> captions = new ArrayList<>();
    private Context context;
    private UserRecentMedia userMedia;

    public PhotoViewAdapter(UserRecentMedia userMedia, Context context){
        this.userMedia = userMedia;
        this.context = context;
        for(Datum datum : userMedia.getData()){
            urls.add(datum.getImages().getThumbnail().getUrl());
            captions.add(datum.getCaption().getText());
        }
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new PhotoViewHolder(inflater.inflate(R.layout.photo_holder_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, final int position) {
        holder.setData(urls.get(position), captions.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhotoDetailActivity.class);
                intent.putExtra("URL", urls.get(position));
                intent.putExtra("CAPTION", captions.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return urls.size();
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

        public void setData(String url, String caption){
            Picasso.with(context).load(url).into(mImageView);
//            mDescriptionTextView.setText(description);
            mNameTextView.setText(caption);
        }
    }
}
