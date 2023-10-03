package com.example.bdlearning2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.bdlearning2.data.Flower;
import com.example.bdlearning2.data.FlowersMarket;
import com.example.bdlearning2.database.DBManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBManager dbManager = new DBManager(this);
        dbManager.openDB();
//        dbManager.insertMarket(new FlowersMarket("ул. Пушкина д.7"));
//        dbManager.insertMarket(new FlowersMarket("ул. Пушкина д.8"));
//        dbManager.insertMarket(new FlowersMarket("ул. Пушкина д.9"));
//        dbManager.insertMarket(new FlowersMarket("ул. Пушкина д.10"));
//       dbManager.insertFlower(new Flower("Роза","Красная",220,1));
//        dbManager.insertFlower(new Flower("Роза","Желтая",220,1));
//        dbManager.insertFlower(new Flower("Роза","Белая",220,2));
//        dbManager.insertFlower(new Flower("Роза","Синяя",220,2));
//        dbManager.insertFlower(new Flower("Роза","Оранжевая",220,3));
//        dbManager.insertFlower(new Flower("Роза","Фиолетовая",220,3));
//        dbManager.insertFlower(new Flower("Роза","Зеленая",220,4));
//        dbManager.insertFlower(new Flower("Роза","Коричневая",220,4));
//        List<Flower> flowers = dbManager.getAllFlower();
//        for (Flower flower : flowers){
//            Log.d("FLOWERS",flower.getType());
//        }
        dbManager.closeDB();
    }
}