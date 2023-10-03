package com.example.bdlearning2.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdlearning2.R;
import com.example.bdlearning2.data.Flower;

import java.util.List;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.ViewHolder> {

    List<Flower> flowers;
    LayoutInflater layoutInflater;
    public FlowersAdapter(List<Flower> flowers,Context context){
        layoutInflater = LayoutInflater.from(context);
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public FlowersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.flower_item,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FlowersAdapter.ViewHolder holder, int position) {
        Flower flower = flowers.get(position);
        holder.color.setText("Цвет: " +flower.getColor());
        holder.type.setText(flower.getType());
        holder.price.setText("Цена: " +flower.getPrice() + " руб.");
        holder.address.setText(flower.getMarketId()+" ");
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView price,color,type,address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.textViewPrice);
            color = itemView.findViewById(R.id.textViewColor);
            type = itemView.findViewById(R.id.textViewType);
            address = itemView.findViewById(R.id.textViewAddres);
        }
    }
}
