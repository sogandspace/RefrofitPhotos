package com.example.refrofitphotos.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.refrofitphotos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private ImageView mIvBigImage;
    private TextView mTvSecondTitle, mTvSecondMore;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mIvBigImage = view.findViewById(R.id.ivImageSec);
        mTvSecondTitle = view.findViewById(R.id.tvTitle);
        mTvSecondMore = view.findViewById(R.id.tvMore);

        Intent intent = getActivity().getIntent();
        String url = intent.getStringExtra(FirstFragment.KEY_URL);
        String title = intent.getStringExtra(FirstFragment.KEY_TITLE);

        Glide.with(this).load(url).into(mIvBigImage);
        mTvSecondTitle.setText(title);

        mTvSecondMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvSecondTitle.setEllipsize(null);
                mTvSecondTitle.setMaxLines(Integer.MAX_VALUE);
                mTvSecondMore.setVisibility(View.GONE);
            }
        });

        return view;

    }

}
