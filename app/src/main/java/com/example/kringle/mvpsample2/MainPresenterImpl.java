package com.example.kringle.mvpsample2;

import com.example.kringle.mvpsample2.model.Notice;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.Presenter, MainContract.Model.OnFinishedListener {

    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenterImpl(MainContract.View view, MainContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void requestDataFromServer() {
        model.getNoticeArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<Notice> noticeList) {
        if (view != null) {
            view.setDataToRecyclerView(noticeList);
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        view.onResponseFailure(throwable);
    }
}
