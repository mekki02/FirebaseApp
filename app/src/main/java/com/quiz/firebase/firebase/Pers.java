package com.quiz.firebase.firebase;

/**
 * Created by Mekki on 03/03/2019.
 */

public class Pers {

    String persId;
    String persNom;
    String persPrenom;
    String persEmail;

    public Pers(){

    }

    public Pers(String persId, String persNom, String persPrenom, String persEmail){
        this.persId = persId;
        this.persNom = persNom;
        this.persPrenom = persPrenom;
        this.persEmail = persEmail;
    }

    public String getPersPrenom() {
        return persPrenom;
    }

    public String getPersEmail() {
        return persEmail;
    }

    public String getPersId() {
        return persId;
    }

    public String getPersNom() {
        return persNom;
    }
}
