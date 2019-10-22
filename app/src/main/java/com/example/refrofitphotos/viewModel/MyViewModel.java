package com.example.refrofitphotos.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.refrofitphotos.model.MyCallback;
import com.example.refrofitphotos.model.Photo;
import com.example.refrofitphotos.model.Repo;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private static String TAG = "sogand";
    private MutableLiveData<List<Photo>> mRecieveData;
    private MutableLiveData<String> mFailureData;
    private Repo mRepo;

    public MyViewModel(@NonNull Application application) {
        super(application);
        mRecieveData = new MutableLiveData<>();
        mFailureData = new MutableLiveData<>();
        mRepo = Repo.getInstance();
    }

    public void requestData() {
        mRepo.getPhotos(new MyCallback<List<Photo>>() {
            @Override
            public void onSuccessful(List<Photo> data) {
                Log.i(TAG, "receive data viewModel ");
                mRecieveData.setValue(data);
            }

            @Override
            public void onError(String msg) {
                Log.i(TAG, "dont receive data viewModel ");
                mFailureData.setValue(msg);

            }
        });
    }

    public LiveData<List<Photo>> getPhotos(){
        return mRecieveData;
    }

    public LiveData<String> getError(){
        return mFailureData;
    }

    public MutableLiveData<List<Photo>> getRecieveData() {
        Log.i(TAG, "receive data viewMode2 ");
        return mRecieveData;
    }
}