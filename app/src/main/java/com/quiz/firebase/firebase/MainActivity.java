package com.quiz.firebase.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText nom, prenom, email;
    Button valider;
    String stringNom, stringPrenom, stringEmail;

    DatabaseReference databasePersonnes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasePersonnes = FirebaseDatabase.getInstance().getReference("personnes");

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        email = (EditText) findViewById(R.id.email);

        valider = (Button) findViewById(R.id.validate);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPersonne();
                Intent intent = new Intent(MainActivity.this, Question1.class);
                startActivity(intent);
            }
        });
    }

    private void addPersonne(){
        String persNom = nom.getText().toString().trim();
        String persPrenom = prenom.getText().toString().trim();
        String persEmail = email.getText().toString();

        if(!TextUtils.isEmpty(persNom)){
            String id = databasePersonnes.push().getKey();
            Pers personne = new Pers(id,persNom,persPrenom,persEmail);
            databasePersonnes.child(id).setValue(personne);
            Toast.makeText(MainActivity.this,"Ajouté avec succès",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(MainActivity.this,"Entrer le Nom",Toast.LENGTH_LONG).show();
        }
    }
}
