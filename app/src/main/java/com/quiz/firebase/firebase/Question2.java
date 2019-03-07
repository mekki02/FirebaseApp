package com.quiz.firebase.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    EditText response;
    TextView questionField;
    Button valider;
    String question = "Sensible à l'eau et à l'air,\n Je couvre et je suis couvert.";
    String correctResponse = "La peau";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        questionField = (TextView) findViewById(R.id.question2);
        questionField.setText(question);

        valider = (Button) findViewById(R.id.valider2);
        response = (EditText) findViewById(R.id.response2);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String responseString = response.getText().toString();
                if (check(responseString)){
                    Toast.makeText(Question2.this,"Réponse Correcte",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Question2.this,CorrectAnswer.class);
                    intent.putExtra("question",question);
                    intent.putExtra("correctResponse",correctResponse);
                    intent.putExtra("questionID",2);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent1 = new Intent(Question2.this,WrongAnswer.class);
                    intent1.putExtra("question",question);
                    intent1.putExtra("reponse",responseString);
                    intent1.putExtra("reponseCorrecte",correctResponse);
                    intent1.putExtra("wrong",2);
                    startActivity(intent1);
                    finish();
                }
            }
        });
    }
    private boolean check(String response) {
        if(response.toLowerCase().equals(correctResponse.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
