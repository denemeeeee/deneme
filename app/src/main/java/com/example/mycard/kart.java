package com.example.mycard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.widget.Button;
//kart sınıfını oluşturduk
public class kart extends android.support.v7.widget.AppCompatButton {
    boolean durum = false; // acikmi kapali mi diye durum degiskeni olusturduk ve false atadık.


    boolean cevrilebilir = true; // kartın cevrilebilir olup olmadıgını gormek icin degisken olusturduk ve true atadık.
    Drawable arka; // drawable nesenesi arka yüz
    Drawable on; //drawable nesnesi ön yüz

    int arkaPlanId;
    int onPlanId =0;
    @SuppressLint("RestrictedApi")
    public kart(Context context, int id) // yapıcı context ve kart tanımlandıgında id vermek icin id parametresi alıyor..
    {   super(context);


        setId(id); // kart tanımlandıgında gelen parametre id sini kartın id sine veriyor.


        arkaPlanId=R.drawable.kendikartim;
//        arkaPlanId = R.drawable;
        // türk bayragı resmini alıp arka plan id ye atadık.
        if (id % 8 == 0) {
            onPlanId = R.drawable.r1;
        }
        if (id % 8 == 1) {
            onPlanId = R.drawable.r2;

        }
        if (id % 8 == 2) {
            onPlanId = R.drawable.r3;

        }
        if (id % 8 == 3) {
            onPlanId = R.drawable.r4;

        }
        if (id % 8 == 4) {
            onPlanId = R.drawable.r5;

        }
        if (id % 8 == 5) {
            onPlanId = R.drawable.r6;

        }
        if (id % 8 == 6) {
            onPlanId = R.drawable.r7;

        }
        if (id % 8 == 7) {
            onPlanId = R.drawable.r8;

        }


        arka = AppCompatDrawableManager.get().getDrawable(context, arkaPlanId);
        on = AppCompatDrawableManager.get().getDrawable(context, onPlanId);

        setBackground(arka);
        //kartların yüzünü arka yaptık yani türk bayragı.
    }

        public void Cevir() // Çevir metodumuz var kart sınıfında
        {
            if (!cevrilebilir) return; // eğer cevrilebilir false ise geri dön true ise döndürebil

            if (!durum ) // durum false yani aciklik false ise resmin ön yüzünü cevir ve durumu true yap
            {
                setBackground(on);
                durum=true;

            }
            else { // eğer true  yani acik ise resmin arka yüzünü cevir ve acıklıgı false yap
                setBackground(arka);
                durum = false;
            }

        }






}
