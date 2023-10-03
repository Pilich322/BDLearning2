package com.example.bdlearning2.database;

public class DBConst {
    public static final String DATABASE_NAME = "flower.db";
    public static final int DATABASE_VERSION = 1;
    public static final String FLOWERS_TABLE_NAME = "Flowers";
    public static final String FLOWERS_TYPE = "type";
    public static final String FLOWERS_COLOR = "color";
    public static final String FLOWERS_PRICE = "price";
    public static final String FLOWERS_MARKET_ID = "marketId";
    public static final String FLOWERS_ID = "id";
    public static final String MARKET_TABLE_NAME = "Market";
    public static final String MARKET_ID = "id";
    public static final String MARKET_ADDRESS = "address";
    public static final String CREATE_MARKET_TABLE = "Create table if not exists " +
            "" + MARKET_TABLE_NAME+ " ( "+MARKET_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + MARKET_ADDRESS + " text);";
    public static final String DELETE_MARKET_TABLE = "DROP table if exists " + MARKET_TABLE_NAME;
    public static final String DELETE_FLOWER_TABLE = "DROP table if exists " + FLOWERS_TABLE_NAME;
    public static final String CREATE_FLOWER_TABLE = "Create table if not exists " +
            ""+FLOWERS_TABLE_NAME +" ( " + FLOWERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ""+FLOWERS_TYPE + " text, " + FLOWERS_COLOR + " text, " +
            "" + FLOWERS_PRICE + " Integer, "+ FLOWERS_MARKET_ID + " Integer, " +
            "FOREIGN KEY (" +FLOWERS_MARKET_ID+") REFERENCES "+MARKET_TABLE_NAME+  " ("+MARKET_ID+"));";
}