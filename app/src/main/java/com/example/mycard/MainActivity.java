 package com.example.mycard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer md=MediaPlayer.create(this, R.raw.oyungiris );
        md.start();
        md.setLooping(true);

        Button bt=findViewById(R.id.button);

        final EditText et =findViewById(R.id.editText);


        //edittexteki kullanici adını alıp 2.activiteye gönderecegiz.


        bt.setOnClickListener(new View.OnClickListener() {
            //Başla butonununu id sini aldık . click listener dinleyicisiyle on click oldugunda işlem yaptıracagız..
            @Override
            public void onClick(View v) {
                if (et.getText().length()==0 || et.getText().length()>=25)
                {
                    Toast.makeText(MainActivity.this, "Lütfen Geçerli Bir Kullanıcı Adı Giriniz", Toast.LENGTH_LONG).show();
                    et.setText("");
                    return;
                }
                Intent i =new Intent(MainActivity.this, activity2oyunEkrani.class);

                //bu activiyeden diğer aktiviteye geçisini saglıyoruz intent sınıfıyla
                i.putExtra("mesaj",  et.getText().toString());
                md.stop();
                //putExtra diyerek edittextten aldıgımız ismi getText metoduyla okuyup namesini verip texti gönderiyoruz.
                startActivity(i);
                //start activityede intent nesnesini atıp onclick oldugunda 2. activiteyi acıyoruz..
            }
        });

    }
}
