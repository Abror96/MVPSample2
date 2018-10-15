package com.example.kringle.mvpsample2;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.kringle.mvpsample2.adapter.NoticeAdapter;
import com.example.kringle.mvpsample2.model.Notice;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView recyclerView;
    private MainContract.Presenter presenter;
    public SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init recyclerview
        initRecyclerViewAndSwipeRefresh();

        // init presenter
        presenter = new MainPresenterImpl(this, new NoticeListModel());
        presenter.requestDataFromServer();
    }

    private void initRecyclerViewAndSwipeRefresh() {
        recyclerView = findViewById(R.id.recycler_view_employee_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        swipeContainer = findViewById(R.id.swipe_container);

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.pullToRefresh();
            }
        });
    }

    @Override
    public void setDataToRecyclerView(ArrayList<Notice> noticeArrayList) {
        NoticeAdapter adapter = new NoticeAdapter(noticeArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong... Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void setSwipeRefreshLayout() {
        swipeContainer.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
