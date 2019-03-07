package com.quiz.firebase.firebase;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WrongAnswer extends AppCompatActivity {

    TextView questionField,responseField,correctAnswerField;
    int wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);

        String recupQuestion = getIntent().getStringExtra("question");
        String recupAnswer = getIntent().getStringExtra("reponse");
        String recupCorrectAnswer = getIntent().getStringExtra("reponseCorrecte");
        wrong = getIntent().getIntExtra("wrong",0);

        questionField = (TextView) findViewById(R.id.question1);
        responseField = (TextView) findViewById(R.id.response);
        correctAnswerField = (TextView) findViewById(R.id.correctAnswer);

        questionField.setText(recupQuestion);
        responseField.setText(recupAnswer);
        correctAnswerField.setText(recupCorrectAnswer);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (wrong) {
                    case 1:
                        Intent intent1 = new Intent(WrongAnswer.this,Question2.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(WrongAnswer.this,Question3.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(WrongAnswer.this,Question4.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(WrongAnswer.this,Question5.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(WrongAnswer.this,Question6.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(WrongAnswer.this,Roulette.class);
                        startActivity(intent6);
                        break;
                }
                finish();
            }
        },5000);

    }
}
