package com.quiz.firebase.firebase;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CorrectAnswer extends AppCompatActivity {

    int questionID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);


        TextView questionField, responseField, questionIDField;
        Intent intent = getIntent();

        questionField = (TextView) findViewById(R.id.question1);
        responseField = (TextView) findViewById(R.id.response);


        String recupQuestion = intent.getStringExtra("question");
        String recupAnswer = intent.getStringExtra("correctResponse");
        questionID = getIntent().getIntExtra("questionID",0);

        questionField.setText(recupQuestion);
        responseField.setText(recupAnswer);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){
                switch (questionID) {
                    case 1:
                        Intent intentQuestion1 = new Intent(CorrectAnswer.this, Question2.class);
                        startActivity(intentQuestion1);
                        break;
                    case 2:
                        Intent intentQuestion2 = new Intent(CorrectAnswer.this, Question3.class);
                        startActivity(intentQuestion2);
                        break;
                    case 3:
                        Intent intentQuestion3 = new Intent(CorrectAnswer.this, Question4.class);
                        startActivity(intentQuestion3);
                        break;
                    case 4:
                        Intent intentQuestion4 = new Intent(CorrectAnswer.this, Question5.class);
                        startActivity(intentQuestion4);
                        break;
                    case 5:
                        Intent intentQuestion5 = new Intent(CorrectAnswer.this, Question6.class);
                        startActivity(intentQuestion5);
                        break;
                    case 6:
                        Intent intentQuestion6 = new Intent(CorrectAnswer.this, Roulette.class);
                        startActivity(intentQuestion6);
                        break;
                    default:
                        break;
                }
                finish();
            }
        }, 5000);


    }

    protected void onDestroy(){
        super.onDestroy();
    }
}
