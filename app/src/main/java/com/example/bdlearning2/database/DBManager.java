package com.example.bdlearning2.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bdlearning2.data.Flower;
import com.example.bdlearning2.data.FlowersMarket;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DBManager(Context context){
        dbHelper = new DBHelper(context);
    }

    public void insertMarket(FlowersMarket market){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.MARKET_ADDRESS,market.getAddress());
        database.insert(DBConst.MARKET_TABLE_NAME,null,cv);
    }

    public void insertFlower(Flower flower){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.FLOWERS_COLOR,flower.getColor());
        cv.put(DBConst.FLOWERS_TYPE,flower.getType());
        cv.put(DBConst.FLOWERS_PRICE,flower.getPrice());
        cv.put(DBConst.FLOWERS_MARKET_ID,flower.getMarketId());
        database.insert(DBConst.FLOWERS_TABLE_NAME,null,cv);
    }

    @SuppressLint("Range")
    public List<Flower> getAllFlower(){
        List<Flower> flowers = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * From " +DBConst.FLOWERS_TABLE_NAME,null);
        while (cursor.moveToNext()){
            Flower flower = new Flower();
            flower.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_ID))));
            flower.setPrice(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_PRICE))));
            flower.setMarketId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_MARKET_ID))));
            flower.setColor(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_COLOR)));
            flower.setType(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_TYPE)));
            flowers.add(flower);
        }
        cursor.close();
        return flowers;
    }

    @SuppressLint("Range")
    public List<Flower> getAllFlowerInAddress(String[] address){
        List<Flower> flowers = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * From " +DBConst.FLOWERS_TABLE_NAME +" Where " + DBConst.FLOWERS_MARKET_ID + " in (?)" ,address);
        while (cursor.moveToNext()){
            Flower flower = new Flower();
            flower.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_ID))));
            flower.setPrice(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_PRICE))));
            flower.setMarketId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_MARKET_ID))));
            flower.setColor(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_COLOR)));
            flower.setType(cursor.getString(cursor.getColumnIndex(DBConst.FLOWERS_TYPE)));
            flowers.add(flower);
        }
        cursor.close();
        return flowers;
    }
    @SuppressLint("Range")
    public List<FlowersMarket> getAllMarkets(){
        List<FlowersMarket> markets = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * From " +DBConst.MARKET_TABLE_NAME,null);
        while (cursor.moveToNext()){
            FlowersMarket market = new FlowersMarket();
            market.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBConst.MARKET_ID))));
            market.setAddress(cursor.getString(cursor.getColumnIndex(DBConst.MARKET_ADDRESS)));
            markets.add(market);
        }
        cursor.close();
        return markets;
    }


    public void openDB(){
        database = dbHelper.getWritableDatabase();
    }
    public void closeDB(){
        dbHelper.close();
    }


}
