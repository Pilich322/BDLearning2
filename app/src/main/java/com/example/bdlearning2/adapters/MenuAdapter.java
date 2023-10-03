package com.example.bdlearning2.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdlearning2.R;
import com.example.bdlearning2.data.FlowersMarket;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private final OnSearchClickListener onSearchClickListener;
    public interface OnSearchClickListener {
        void onCSearchClick(FlowersMarket market, int position);
    }
    List<FlowersMarket> markets;
    Context context;
    public MenuAdapter(List<FlowersMarket> markets,Context context,OnSearchClickListener onSearchClickListener){
        this.markets = markets;
        this.context = context;
        this.onSearchClickListener = onSearchClickListener;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.menu_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        FlowersMarket market = markets.get(position);
        holder.button.setText(market.getAddress());
        holder.button.setOnClickListener(view -> {
            onSearchClickListener.onCSearchClick(market,position);
            if(holder.button.isSelected())
                holder.button.setSelected(false);
            else
                holder.button.setSelected(true);
        });
    }

    @Override
    public int getItemCount() {
        return markets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.menuButton);
        }
    }
}
