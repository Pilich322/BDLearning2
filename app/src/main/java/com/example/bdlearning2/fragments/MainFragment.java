package com.example.bdlearning2.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bdlearning2.R;
import com.example.bdlearning2.adapters.FlowersAdapter;
import com.example.bdlearning2.adapters.MenuAdapter;
import com.example.bdlearning2.data.Flower;
import com.example.bdlearning2.data.FlowersMarket;
import com.example.bdlearning2.database.DBConst;
import com.example.bdlearning2.database.DBManager;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    List<Flower> flowersSearch = new ArrayList<>();
    FlowersAdapter flowersAdapter;
    List<Flower> allFlowers = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DBManager dbManager = new DBManager(getContext());
        dbManager.openDB();
        allFlowers = dbManager.getAllFlower();
        List<Flower> flowers = dbManager.getAllFlower();
        RecyclerView menu = view.findViewById(R.id.recyclerViewMenu);
        @SuppressLint("NotifyDataSetChanged") MenuAdapter.OnSearchClickListener onSearchClickListener = (market, position) -> {
            flowers.clear();
            flowers.addAll(allFlowers);
            for(Flower flower : flowers){
                if(market.getId() == flower.getMarketId()){
                    if(flowersSearch.contains(flower))
                        continue;
                    flowersSearch.add(flower);
                    Log.e("FL",flower.getType() + flower.getColor());
                }
            }
            flowers.clear();
            flowers.addAll(flowersSearch);
            flowersAdapter.notifyDataSetChanged();
        };
        MenuAdapter menuAdapter = new MenuAdapter(dbManager.getAllMarkets(),getContext(),onSearchClickListener);
        menu.setAdapter(menuAdapter);

        flowersAdapter = new FlowersAdapter(flowers,getContext());
        RecyclerView flowersRec = view.findViewById(R.id.recyclerViewFlower);
        flowersRec.setAdapter(flowersAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}