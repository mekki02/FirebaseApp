package com.quiz.firebase.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    EditText response;
    TextView questionField;
    Button valider;
    String question = "Dans l'armée des fils d'Hannibal,\n Je suis Le commandant de 46 soldats,\n Je gagne toujours mes combats:\n" +
            "Dans le vaste ou à l'étroit et quel que\n soit l'endroit\n, Sans moi un champignon peut\n devenir roi";
    String correctResponse = "TERCYD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        questionField = (TextView) findViewById(R.id.question5);
        questionField.setText(question);

        valider = (Button) findViewById(R.id.valider5);
        response = (EditText) findViewById(R.id.response5);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String responseString = response.getText().toString();
                if (check(responseString)){
                    Toast.makeText(Question5.this,"Réponse Correcte",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Question5.this,CorrectAnswer.class);
                    intent.putExtra("question",question);
                    intent.putExtra("correctResponse",correctResponse);
                    intent.putExtra("questionID",5);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent1 = new Intent(Question5.this,WrongAnswer.class);
                    intent1.putExtra("question",question);
                    intent1.putExtra("reponse",responseString);
                    intent1.putExtra("reponseCorrecte",correctResponse);
                    intent1.putExtra("wrong",5);
                    startActivity(intent1);
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
