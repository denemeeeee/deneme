package com.example.mycard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {

    public sqlite(Context c)
    {
        super(c, "kullanici ", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql=" create table  kullanici  (id integer primary key autoincrement , kullaniciadi string , puan integer )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("drop table kullanici");
         onCreate(db);
    }
}
