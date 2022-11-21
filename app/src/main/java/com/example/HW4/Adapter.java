package com.example.HW4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HW4.databinding.ItemtextBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private final ArrayList<Text> list;
    private final OnClickListener onClickListener;

    public Adapter(ArrayList<Text> list, OnClickListener onClickListener) {
        this.list = list;
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemtextBinding.inflate((LayoutInflater.from(parent.getContext())), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

private ItemtextBinding binding;


        public ViewHolder(@NonNull ItemtextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Text text) {
            binding.text.setText(text.getText());
            binding.text.setOnClickListener(v -> onClickListener.onClick(text));

        }
    }
}
