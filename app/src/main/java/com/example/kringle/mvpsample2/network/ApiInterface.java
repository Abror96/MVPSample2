package com.example.kringle.mvpsample2.network;

import com.example.kringle.mvpsample2.model.NoticeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("bins/1bsqcn/")
    Call<NoticeList> getNoticeData();
}
