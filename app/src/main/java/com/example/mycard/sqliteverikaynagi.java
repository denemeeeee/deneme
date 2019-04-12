package com.example.mycard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class sqliteverikaynagi {
    SQLiteDatabase db;
    sqlite bdb;


    public sqliteverikaynagi(Context c) {
        bdb = new sqlite(c);
    }

    public void ac() {
        db = bdb.getWritableDatabase();


    }

    public void kapat() {
        bdb.close();
    }

    public void kullaniciOlustur(kullaniciClass k) {

        ContentValues val = new ContentValues();
        val.put("kullaniciadi", k.getKullaniciAdi());
        val.put("puan", k.getPuan());

        db.insert("kullanici", null, val);

    }

    String icerik = "";
    String idc = "";
    String adc = "";
    String puanc = "";
    String[] idarray = {"id"};
    String[] adarray = {"kullaniciadi"};
    String[] puanarray = {"puan"};

    public String idListele() {
        Cursor cid = db.query("kullanici", idarray, null, null, null, null, null);
        int iRow = cid.getColumnIndex("id");
        for (cid.moveToFirst(); !cid.isAfterLast(); cid.moveToNext()) {
            idc += cid.getString(iRow) + "\n";
        }
        return idc;
    }

    public String adListele() {
        Cursor cadc = db.query("kullanici", adarray, null, null, null, null, null);
        int userName = cadc.getColumnIndex("kullaniciadi");
        for (cadc.moveToFirst(); !cadc.isAfterLast(); cadc.moveToNext()) {
            adc += cadc.getString(userName) + "\n";
        }
        return adc;
    }

    public String puanListele() {
        Cursor cpuan = db.query("kullanici", puanarray, null, null, null, null, null);
        int gol = cpuan.getColumnIndex("puan");
        for (cpuan.moveToFirst(); !cpuan.isAfterLast(); cpuan.moveToNext()) {
            puanc += cpuan.getString(gol) + "\n";

        }
        return puanc;
    }

    /*public String listele()
    {
        String [] allColumns =new String[] {"id", "PERSONEL_KADI","PERSONEL_SOYAD"};
        Cursor c=db.query("kullanici", allColumns,null,null,null,null,null);
        int iRow=c.getColumnIndex("id");
        int userName=c.getColumnIndex("PERSONEL_KADI");
        int gol=c.getColumnIndex("PERSONEL_SOYAD");

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {


            icerik+="id"+c.getString(iRow)+"\t\t\t\t Adı:"+c.getString(userName)+"\t\t\tPuan:"+c.getString(gol)+"\n";
        }
        return  icerik;
}
        /*String [] kolonlar = {"id","kullaniciadi", "puan"}; //buraya puanı ekle
        List<kullaniciClass> liste= new ArrayList<kullaniciClass>();
        Cursor c=db.query("kullanici", kolonlar, null, null, null, null,null);
        c.moveToFirst();



        while(!c.isAfterLast())
        {
            String nick=c.getString(0);

            icerik +=nick;
c.moveToNext();

        }
        return icerik;*/
    }

