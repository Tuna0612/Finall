package com.tuna.finall.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.tuna.finall.Loai1.SinhVienv1;

import java.util.ArrayList;
import java.util.List;

public class SinhVienv1Dao {
    private SQLiteDatabase db;
    private DatabaseManager databasemanager;
    public static final String TABLE_NAME = "SinhVienv1";

    public static final String SQL_SINH_VIEN_v1 = "CREATE TABLE IF NOT EXISTS SinhVienv1(maSV text primary key, tenSV text, quequan text);";
    public static final String TAG = "SinhVienDAO";

    public SinhVienv1Dao(Context context) {
        databasemanager = new DatabaseManager(context);
        db = databasemanager.getWritableDatabase();
    }

    public int insertSV(SinhVienv1 sv) {
        ContentValues values = new ContentValues();
        values.put("maSV", sv.getmMaSV());
        values.put("tenSV", sv.getmName());
        values.put("quequan", sv.getmQueQuan());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public int updateSinhVien(String maSV, String tenSV, String QueQuan) {
        ContentValues values = new ContentValues();
        values.put("maSV", maSV);
        values.put("tenSV", tenSV);
        values.put("quequan", QueQuan);
        int result = db.update(TABLE_NAME, values, "maSV=?", new String[]{maSV});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteSinhVien(String maSV) {
        int result = db.delete(TABLE_NAME, "maSV=?", new String[]{maSV});
        if (result == 0)
            return -1;
        return 1;
    }

    public List<SinhVienv1> getAllSinhVien() {
        List<SinhVienv1> dsSV = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            SinhVienv1 ee = new SinhVienv1();
            ee.setmMaSV(c.getString(0));
            ee.setmName(c.getString(1));
            ee.setmQueQuan(c.getString(2));
            dsSV.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsSV;
    }
}
