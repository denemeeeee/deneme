package com.example.mycard;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ImageView ey=findViewById(R.id.acilis);
        Animation eyanimasyon= AnimationUtils.loadAnimation(this, R.anim.acilis);
        //ey.startAnimation(eyanimasyon);

        Thread myThread=new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(5000);
                    Intent i=new Intent(splashScreen.this, MainActivity.class);
                    finish();
                    startActivity(i);

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();








       /* Thread zamanlama=new Thread()
        {
            public void run()
            {
                try{
                    sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        zamanlama.start();*/


    }
}
