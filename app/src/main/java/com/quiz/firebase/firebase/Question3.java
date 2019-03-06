package com.quiz.firebase.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    EditText response;
    TextView questionField;
    Button valider;
    String question = "Dur comme le fer,\n Je pousse de la chair,\n Saint je suis claire,\n Mais je vire de couleur,\n Quand il m'arrive malheur";
    String correctResponse = "L'ongle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        questionField = (TextView) findViewById(R.id.question3);
        questionField.setText(question);

        valider = (Button) findViewById(R.id.valider3);
        response = (EditText) findViewById(R.id.response3);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String responseString = response.getText().toString();
                if (check(responseString)){
                    Toast.makeText(Question3.this,"Réponse Correcte",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Question3.this,CorrectAnswer.class);
                    intent.putExtra("question",question);
                    intent.putExtra("correctResponse",correctResponse);
                    intent.putExtra("questionID",3);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(Question3.this,WrongAnswer.class);
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
