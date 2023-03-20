package com.example.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private TextView t_compMenu;
    private TextView t_entrees;
    private TextView t_plats;
    private TextView t_desserts;
    private Spinner s_entrees;
    private Spinner s_plats;
    private Spinner s_desserts;
    private TextView t_quantite;
    private EditText i_quantite;
    private Spinner s_quantite;
    private Button b_ajouter;
    private TextView t_recapitulatif;
    private EditText i_remarques;
    private Button b_enregistrer;
    private Button b_annuler;

    private Button b_parametre;

    private Button b_gest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Modele.initPlats();
        Modele.initEntrees();
        Modele.initDesserts();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t_compMenu = findViewById(R.id.t_compMenu);
        t_entrees = findViewById(R.id.t_entrees);
        t_desserts = findViewById(R.id.t_desserts);
        t_quantite = findViewById(R.id.t_quantite);
        i_quantite = findViewById(R.id.i_quantite);
        s_quantite = findViewById(R.id.s_quantite);
        b_ajouter = findViewById(R.id.b_ajouter);
        t_recapitulatif = findViewById(R.id.t_recapitulatif);
        i_remarques = findViewById(R.id.i_remarques);
        b_enregistrer = findViewById(R.id.b_enregistrer);
        b_annuler = findViewById(R.id.b_annuler);



        i_quantite.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i_quantite.getText().toString().equals("")){
                    s_quantite.setEnabled(true);
                }

                else
                {
                    s_quantite.setEnabled(false);
                }
                return false;
            }
        });



        s_quantite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            i_quantite.setText(s_quantite.getSelectedItem().toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
           i_quantite.setText("Ca sera jamais affiché");
        }

});
        b_parametre = findViewById(R.id.b_parametre);

        b_parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent(getApplicationContext(),ParametrageActivity.class);
                startActivity(unIntent);
            }
        });


        Spinner s_plats = findViewById(R.id.s_plats);
        ArrayAdapter<String> adaptateurPlats = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for(int i=0; i<Modele.lesPlats.size(); i++){
            adaptateurPlats.add(Modele.lesPlats.get(i));
        }
        s_plats.setAdapter(adaptateurPlats);



        Spinner s_entrees = findViewById(R.id.s_entrees);
        ArrayAdapter<String> adaptateurEntrees = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for(int i=0; i<Modele.lesEntrees.size(); i++){
            adaptateurEntrees.add(Modele.lesEntrees.get(i));
        }
        s_entrees.setAdapter(adaptateurEntrees);

        Spinner s_desserts = findViewById(R.id.s_desserts);
        ArrayAdapter<String> adaptateurDesserts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for(int i=0; i<Modele.lesDesserts.size(); i++){
            adaptateurDesserts.add(Modele.lesDesserts.get(i));
        }
        s_desserts.setAdapter(adaptateurDesserts);

        b_gest = findViewById(R.id.b_gest);

        b_gest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent(getApplicationContext(),GestPlats.class);
                startActivity(unIntent);
            }
        });

    }




}