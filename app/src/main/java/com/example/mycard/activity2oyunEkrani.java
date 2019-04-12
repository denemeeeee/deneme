package com.example.mycard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity2oyunEkrani extends AppCompatActivity {
    int sonKart=-1;
    int skor=0;
    int tiklanilanSayi;
    int puan=120;
    String al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2oyun_ekrani);
        // klasik acilis fonksiyonları
        Intent i = getIntent(); // ana main den gelen bir text vardı onu getintent ile okuyup i nesnesine atadık.
        al = i.getStringExtra("mesaj"); // i.getstringextra ve name parametresi ile gelen stringi aldık

        final TextView tv4 = findViewById(R.id.textView4); // bu activity deki textview ı bulup id sini aldık.
        tv4.setText("Hadi! "+al+" kartları bul.."); // ve textview a çektiğimiz extrayı yazdık..
       // final Animation animTranslate=  AnimationUtils.loadAnimation(this, R.anim.actions);

        Intent s=new Intent(activity2oyunEkrani.this, activity3OyunSonu.class);
        s.putExtra("mesaj1", al);



        android.support.v7.widget.GridLayout grid = (android.support.v7.widget.GridLayout) findViewById(R.id.gl);
        //Gridlayoutu import ettik. Yukarıdaki gibi uzun cast işlemini yaptık ve activitydeki gridlayotu bulup idsini aldık.
        final kart kartlar[] = new kart[16]; // kart sınıfı tipinde 16 boyutlu kartlar dizisi oluşturduk..
         for (int j = 0; j < 16; j++) { //donguyu actık 0 dan başlatarak..

            kartlar[j] = new kart(this, j+1); //oluşturduğumuz kartlar dizisinin 0. indexine kart sınıfına gonderdik.

            kartlar[j].setOnClickListener(new View.OnClickListener() { //burada kartları dinlemek için for dongusu içerisinde
                //onclicklisteneri her kart için oluşturuyoruz.
                @Override
                public void onClick(View v) {
                    MediaPlayer md= (MediaPlayer) MediaPlayer.create(activity2oyunEkrani.this, R.raw.karttiklama );
                    md.start();
                    tiklanilanSayi++;
                    TextView tv=findViewById(R.id.textView3);
                    tv.setText(" "+tiklanilanSayi);
                    final kart k= (kart)v;

                    k.Cevir(); // kartın on yuzunu cevirdik.
                    if (sonKart>=0) {
                        //son kart 0 dan büyükse id sini yakalayıp k2 nesnesine attık.
                        final kart k2 = (kart) findViewById(sonKart);
                        if (k2.onPlanId==k.onPlanId && k2.getId() != k.getId()) // son kart ve bizim tıklanan kartımızın resimid lerini
                            //karşılaştırdık . ve kendi idlerinin farklı olması şartıyla
                        {

                           // k.startAnimation(animTranslate);
                            //k2.startAnimation(animTranslate);
                                //TODO animasyon koymaya calıstım olmadı
                            ;
                           // sonKart=0;
                            //butonlar farklı ama resimler aynıysa
                            k2.cevrilebilir=false; // ilk kartı çevirilemez yap
                            k.cevrilebilir=false; // son seçtğimiz kartıda çevrilemez yap
                            skor++; // skorunu arttır
                            tv4.setText(" "+(8-skor)+" çift kaldı. ");
                            if (skor==8)
                            {
                                tv4.setText("Tebrikler başardın..)");
                                Intent i=new Intent(activity2oyunEkrani.this, activity3OyunSonu.class);

                                i.putExtra("puan",puan-tiklanilanSayi);
                                i.putExtra("mesajial", al);
                                startActivity(i);

                                //oyun bitti
                            }
                            sonKart=-1;
                        }
                            else // seçilen kartların resimleri aynı degisle
                            {
                                Handler hn=new Handler();
                                hn.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                k.Cevir(); // kartın arkasını cevir
                                k2.Cevir(); // ''

                                    }
                                },500);
                                sonKart=-1; // son kartı 0 a eşitle
                            }
                    }
                        else // son kart 0 dan buyuk veya eşit degilse
                        {
                            sonKart=k.getId();  //tıklanılan kartın id sini son karta at
                        }
                }
            });
        }
//shuffle
        for (int j=0; j<16; j++)
        {
            int rg= (int) (Math.random()*16);
            kart k=kartlar[rg];
            kartlar[rg]=kartlar[j];
            kartlar[j]=k;
        }
      /*
        }*/
        for (int l = 0; l < 16; l++) {

            grid.addView(kartlar[l]); // buradada ekranımızdaki gridlayoutumuza kartları ekledik.
        }
    }
}
