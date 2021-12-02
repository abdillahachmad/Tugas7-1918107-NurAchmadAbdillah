package com.example.sqlite_sepatu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_catalog";
    private static final String tb_sepatu = "tb_sepatu";
    private static final String tb_sepatu_id = "id";
    private static final String tb_sepatu_nama = "nama";
    private static final String tb_sepatu_ukuran = "ukuran";
    private static final String CREATE_TABLE_SEPATU = "CREATE TABLE " +
    tb_sepatu +"("
            + tb_sepatu_id + " INTEGER PRIMARY KEY ,"
            + tb_sepatu_nama + " TEXT ,"
            + tb_sepatu_ukuran + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SEPATU);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateSepatu(Sepatu data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_sepatu_id, data.get_id());
        values.put(tb_sepatu_nama, data.get_nama());
        values.put(tb_sepatu_ukuran, data.get_ukuran());
        db.insert(tb_sepatu, null, values);
        db.close();
    }
    public List<Sepatu> ReadSepatu() {
        List<Sepatu> listSpt = new ArrayList<Sepatu>();
        String selectQuery = "SELECT * FROM " + tb_sepatu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Sepatu data = new Sepatu();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_ukuran(cursor.getString(2));
                listSpt.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listSpt;
    }
    public int UpdateSepatu (Sepatu data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_sepatu_nama, data.get_nama());
        values.put(tb_sepatu_ukuran, data.get_ukuran());
        return db.update(tb_sepatu, values, tb_sepatu_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteSepatu(Sepatu data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_sepatu,tb_sepatu_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
