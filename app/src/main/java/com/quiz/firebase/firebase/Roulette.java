package com.quiz.firebase.firebase;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Roulette extends AppCompatActivity {

    Button b_roll;

    ImageView image1, image2, image3;

    Random r;
    int img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        r = new Random();

        b_roll = (Button) findViewById(R.id.b_roll);
        b_roll.setBackgroundResource(R.drawable.btnplay);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);

        image1.setBackgroundResource(R.drawable.logobas1);
        image2.setBackgroundResource(R.drawable.logobas2);
        image3.setBackgroundResource(R.drawable.logobas1);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_roll.setBackgroundResource(R.drawable.btnplay);
                //Animate the first image
                image1.setBackgroundResource(R.drawable.anim);
                final AnimationDrawable image1anim = (AnimationDrawable) image1.getBackground();
                image1anim.start();

                //Animate the second image
                image2.setBackgroundResource(R.drawable.anim);
                final AnimationDrawable image2anim = (AnimationDrawable) image2.getBackground();
                image2anim.start();

                //Animate the third image
                image3.setBackgroundResource(R.drawable.anim);
                final AnimationDrawable image3anim = (AnimationDrawable) image3.getBackground();
                image3anim.start();

                //Stop the animation and apply the images
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        image1anim.stop();
                        image2anim.stop();
                        image3anim.stop();

                        setImages();
                        getScore();
                    }
                },2000);
            }
        });

    }

    public void setImages(){
        //Randomize the images
        img1 = r.nextInt(2) + 1;
        img2 = r.nextInt(2) + 1;
        img3 = r.nextInt(2) + 1;

        //set first image
        switch (img1){
            case 1:
                image1.setBackgroundResource(R.drawable.logobas1);
                break;
            case 2:
                image1.setBackgroundResource(R.drawable.logobas2);
                break;
        }

        //set second image
        switch (img2){
            case 1:
                image2.setBackgroundResource(R.drawable.logobas1);
                break;
            case 2:
                image2.setBackgroundResource(R.drawable.logobas2);
                break;
        }

        //set third image
        switch (img3){
            case 1:
                image3.setBackgroundResource(R.drawable.logobas1);
                break;
            case 2:
                image3.setBackgroundResource(R.drawable.logobas2);
                break;
        }
    }

    public void getScore(){
        if(img1 == img2 && img2 == img3){
            Toast.makeText(Roulette.this,"Vous avez Gagné !",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,WonRoulette.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(Roulette.this,"Vous avez Perdu !",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,LostRoulette.class);
            startActivity(intent);
            finish();
        }
    }
}
