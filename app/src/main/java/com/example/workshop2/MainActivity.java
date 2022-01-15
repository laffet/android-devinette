package com.example.workshop2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int n1, nbrEssais, essai;
    public Random r=new Random();

    public TextView nresultat, nhistorique;
    public String histo,mes;
    public EditText nedittext;
    public Button btn_np,btn_valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nresultat=(TextView) findViewById(R.id.view_resultat);
        nhistorique=(TextView) findViewById(R.id.view_historique);
        nedittext=(EditText) findViewById(R.id.edit_essai);
        btn_np=(Button) findViewById(R.id.button_nouvelle_partie);
        btn_valider=(Button) findViewById(R.id.button_valider);

        //effacer ancien resultat

        mes="";
        nresultat.setText(mes);
        nbrEssais=0;
        histo="";
        nhistorique.setText(histo);
    }


    public void nouvelle_partie(View view) {
        n1=r.nextInt(1000);
        mes="";
        nresultat.setText(mes);
        nbrEssais=0;
        histo="";
        nhistorique.setText(histo);
    }

    public void verifier_si_egal(View view){
        essai=Integer.parseInt(nedittext.getText().toString());
        if(essai>n1){
            mes="Donner un nombre plus petit";
            nbrEssais++;
            histo=histo+"\n"+essai;
            nedittext.setText("");
        }else if(essai<n1){
            mes="Donner un nombre plus grand";
            nbrEssais++;
            histo=histo+"\n"+essai;
            nedittext.setText("");

        }else {
            mes="Bravo c'est gagne apres"+nbrEssais+"essais";
            nedittext.setText("");
        }

        nresultat.setText(mes);
        nhistorique.setText(histo);
    }
}