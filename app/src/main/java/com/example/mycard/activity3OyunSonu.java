package com.example.mycard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class activity3OyunSonu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_oyun_sonu);
        MediaPlayer md=MediaPlayer.create(this, R.raw.alkis);
        md.start();
        Bundle bd=getIntent().getExtras();
        int skor=bd.getInt("puan",0);
        String adi=bd.getString("mesajial");
        //TextView tv=findViewById(R.id .textviewOyunSonu);
        //tv.setText("Tebrikler!! " +adi+ " \n" +skor+" puan alarak oyunu tamamladınız. ");
        final sqliteverikaynagi db=new sqliteverikaynagi(this);
        db.ac();
        kullaniciClass k=new kullaniciClass(adi, skor);
        db.kullaniciOlustur(k);
        final  TextView tv6=findViewById(R.id.textView6);
        final TextView tv7=findViewById(R.id.textView7);
        final TextView tv8=findViewById(R.id.textView8);
        tv6.setText(db.idListele());
        tv7.setText(db.adListele());
        tv8.setText(db.puanListele());


        /*final TextView tvv=findViewById(R.id.textView5);
        tvv.setText(yaz);*/
        Button b=findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.bdb.onUpgrade(db.db,1,2);
                tv6.setText("");
                tv7.setText("");
                tv8.setText("");
            }
        });
        Button bt=findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


           moveTaskToBack(true);         }
        });





        }

    }

