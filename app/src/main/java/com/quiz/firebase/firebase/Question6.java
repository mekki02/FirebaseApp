package com.quiz.firebase.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Question6 extends AppCompatActivity {

    EditText response;
    TextView questionField;
    Button valider;
    String question = "De mon compte de fée je suis sortie,\n Et j'y retourne aujourd'hui,\n Parfait comme je suis,\n" +
            "J'élimine les levures comme\n par la magie";
    String correctResponse = "Itrazol";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);

        questionField = (TextView) findViewById(R.id.question6);
        questionField.setText(question);

        valider = (Button) findViewById(R.id.valider6);
        response = (EditText) findViewById(R.id.response6);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String responseString = response.getText().toString();
                if (check(responseString)){
                    Toast.makeText(Question6.this,"Réponse Correcte",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Question6.this,CorrectAnswer.class);
                    intent.putExtra("question",question);
                    intent.putExtra("correctResponse",correctResponse);
                    intent.putExtra("questionID",6);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(Question6.this,WrongAnswer.class);
                    intent.putExtra("question",question);
                    intent.putExtra("reponse",responseString);
                    intent.putExtra("reponseCorrecte",correctResponse);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean check(String response) {
        if(response.equals(correctResponse)) {
            return true;
        } else {
            return false;
        }
    }
}
