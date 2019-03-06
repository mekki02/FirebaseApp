package com.quiz.firebase.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WrongAnswer extends AppCompatActivity {

    TextView questionField,responseField,correctAnswerField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);

        String recupQuestion = getIntent().getStringExtra("question");
        String recupAnswer = getIntent().getStringExtra("reponse");
        String recupCorrectAnswer = getIntent().getStringExtra("reponseCorrecte");

        questionField = (TextView) findViewById(R.id.question1);
        responseField = (TextView) findViewById(R.id.response);
        correctAnswerField = (TextView) findViewById(R.id.correctAnswer);

        questionField.setText(recupQuestion);
        responseField.setText(recupAnswer);
        correctAnswerField.setText(recupCorrectAnswer);

    }
}
