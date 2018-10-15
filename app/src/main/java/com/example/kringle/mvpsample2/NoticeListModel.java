package com.example.kringle.mvpsample2;

import android.util.Log;

import com.example.kringle.mvpsample2.model.NoticeList;
import com.example.kringle.mvpsample2.network.ApiClient;
import com.example.kringle.mvpsample2.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeListModel implements MainContract.Model {

    private final String TAG = "NoticeListModel";

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {
        ApiInterface apiService =
                ApiClient.getInstance().create(ApiInterface.class);

        Call<NoticeList> call = apiService.getNoticeData();

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onFinished(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }

}
