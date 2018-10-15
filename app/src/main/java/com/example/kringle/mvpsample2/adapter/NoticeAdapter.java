package com.example.kringle.mvpsample2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kringle.mvpsample2.R;
import com.example.kringle.mvpsample2.model.Notice;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.EmployeeViewHolder> {

    private ArrayList<Notice> dataList;

    public NoticeAdapter(ArrayList<Notice> dataList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, final int position) {
        holder.tvNoticeTitle.setText(dataList.get(position).getTitle());
        holder.tvNoticeBrief.setText(dataList.get(position).getBrief());
        holder.tvNoticeFilePath.setText(dataList.get(position).getFileSource());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView tvNoticeTitle, tvNoticeBrief, tvNoticeFilePath;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNoticeTitle = itemView.findViewById(R.id.txt_notice_title);
            tvNoticeBrief = itemView.findViewById(R.id.txt_notice_brief);
            tvNoticeFilePath = itemView.findViewById(R.id.txt_notice_file_path);
        }
    }
}