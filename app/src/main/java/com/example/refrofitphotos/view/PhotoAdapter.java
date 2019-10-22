package com.example.refrofitphotos.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.refrofitphotos.R;
import com.example.refrofitphotos.model.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<Photo> mData;
    private OnClickedItem mOnClicked;

    public PhotoAdapter (OnClickedItem onClicked){
        mOnClicked = onClicked;
    }

    public void setData(List<Photo> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoAdapter.PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first, parent
                , false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.PhotoViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;
        private ImageView mIvSmallImage;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvTitle = itemView.findViewById(R.id.tvTitle);
            mIvSmallImage = itemView.findViewById(R.id.ivImageFirst);
        }


        public void bind(Photo photo) {
            mTvTitle.setText(photo.getTitle());
            Glide.with(mIvSmallImage.getContext()).load(photo.getThumbnailUrl()).into(mIvSmallImage);
        }
    }
}
