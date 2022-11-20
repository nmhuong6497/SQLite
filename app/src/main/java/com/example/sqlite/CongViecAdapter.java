package com.example.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CongViecAdapter extends RecyclerView.Adapter<CongViecAdapter.CongViecViewHolder> {

    List<CongViec> congViecs;

    public CongViecAdapter(List<CongViec> congViecs) {
        this.congViecs = congViecs;
    }

    @NonNull
    @Override
    public CongViecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_cong_viec, parent, false);
        return new CongViecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CongViecViewHolder holder, int position) {
        holder.bind(congViecs.get(position));
    }

    @Override
    public int getItemCount() {
        return congViecs.size();
    }

    class CongViecViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public CongViecViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bind(CongViec congViec) {
            tvName.setText(congViec.getName());
        }
    }
}
