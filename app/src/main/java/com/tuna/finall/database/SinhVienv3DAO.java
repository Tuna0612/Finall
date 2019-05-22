package com.tuna.finall.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tuna.finall.Loai3.SinhVienv3;

import java.util.ArrayList;
import java.util.List;

public class SinhVienv3DAO {
    private SQLiteDatabase db;
    private DatabaseManager databasemanager;

    public static String TABLE ="mytable";
    public static String NAME ="name";
    public static String ID ="id";
    public static String COMPANY ="company";
    public static String CITY ="city";
    public static String COUNTRY ="country";

    public static final String SQL_SINH_VIEN_v3 = "CREATE TABLE "+TABLE+"("+ID+" integer primary key autoincrement not null,"+NAME+ " Text, "+COMPANY+ " Text, "+CITY+ " Text, "+COUNTRY+ " Text);";
    public static final String TAG = "SinhVienDAO";

    public SinhVienv3DAO(Context context) {
        databasemanager = new DatabaseManager(context);
        db = databasemanager.getWritableDatabase();
    }

    public void insertdata(String name,String company ,String city,String country){
        ContentValues contentValues= new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(COMPANY, company);
        contentValues.put(CITY,city);
        contentValues.put(COUNTRY,country);
        db.insert(TABLE,null,contentValues);
    }

    public List<SinhVienv3> getdata(){
        // DataModel dataModel = new DataModel();
        List<SinhVienv3> data=new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        SinhVienv3 dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new SinhVienv3();
            String id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
            //Integer id = Integer.parseInt(ids);
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String country = cursor.getString(cursor.getColumnIndexOrThrow("country"));
            String city = cursor.getString(cursor.getColumnIndexOrThrow("city"));
            dataModel.setId(id);
            dataModel.setName(name);
            dataModel.setCity(city);
            dataModel.setCounty(country);
            stringBuffer.append(dataModel);
            // stringBuffer.append(dataModel);
            data.add(dataModel);
        }
        return data;
    }

    public boolean deleteitem(int id){
        db.execSQL("delete from "+TABLE+" where "+ID+" ="+id);

        return  true;

    }

}


