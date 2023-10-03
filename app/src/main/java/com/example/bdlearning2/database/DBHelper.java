package com.example.bdlearning2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, DBConst.DATABASE_NAME,null,DBConst.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConst.CREATE_MARKET_TABLE);
        db.execSQL(DBConst.CREATE_FLOWER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBConst.DELETE_FLOWER_TABLE);
        db.execSQL(DBConst.DELETE_MARKET_TABLE);
        onCreate(db);
    }
}
