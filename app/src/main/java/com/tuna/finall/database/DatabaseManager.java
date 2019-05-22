package com.tuna.finall.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SinhVienManager";
    public static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SinhVienv1Dao.SQL_SINH_VIEN_v1);
        db.execSQL(SinhVienv2DAO.SQL_SINH_VIEN_v2);
        db.execSQL(SinhVienv3DAO.SQL_SINH_VIEN_v3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + SinhVienv1Dao.TABLE_NAME);
        db.execSQL("Drop table if exists " + SinhVienv2DAO.TABLE_NAME);
        db.execSQL("Drop table if exists " + SinhVienv3DAO.TABLE);
    }
}
