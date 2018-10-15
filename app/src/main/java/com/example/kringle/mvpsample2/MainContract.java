package com.example.kringle.mvpsample2;

import com.example.kringle.mvpsample2.model.Notice;

import java.util.ArrayList;

public interface MainContract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(ArrayList<Notice> noticeList);
            void onFailure(Throwable throwable);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }

    interface View {

        void setDataToRecyclerView(ArrayList<Notice> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();

        void requestDataFromServer();

    }

}
