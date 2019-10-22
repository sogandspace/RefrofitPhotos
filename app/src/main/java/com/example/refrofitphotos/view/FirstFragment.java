package com.example.refrofitphotos.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.refrofitphotos.model.Photo;
import com.example.refrofitphotos.R;
import com.example.refrofitphotos.viewModel.MyViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements OnClickedItem {

    public static String KEY_URL = "key_my_url";
    public static String KEY_TITLE = "key_my_title";

    private RecyclerView mRecyclerView;
    private PhotoAdapter mPhotoAdapter;
    private OnClickedItem mClickedItem;
    private MyViewModel mMyViewModel;
    private ProgressBar mProgressBar;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mRecyclerView = view.findViewById(R.id.rvList);
        mProgressBar = view.findViewById(R.id.pg);

        mMyViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        setUpRecyclerAdapter();

        mMyViewModel.getRecieveData().observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                mPhotoAdapter.setData(photos);
            }
        });

        mMyViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mRecyclerView.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);
//                textView.setText(s);
            }
        });
        return view;
    }

    public void setUpRecyclerAdapter() {
        mPhotoAdapter = new PhotoAdapter(this);
        mRecyclerView.setAdapter(mPhotoAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mMyViewModel.requestData();
    }

    @Override
    public void onClicked(Photo data) {
        Intent intent = new Intent(getActivity(), SecondFragment.class);
        intent.putExtra(KEY_TITLE, data.getTitle());
        intent.putExtra(KEY_URL, data.getThumbnailUrl());
        startActivity(intent);
    }
}
