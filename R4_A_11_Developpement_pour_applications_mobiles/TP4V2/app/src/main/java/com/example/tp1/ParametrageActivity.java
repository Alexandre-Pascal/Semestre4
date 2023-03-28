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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class ParametrageActivity extends AppCompatActivity {

    private EditText i_nomElement;
    private RadioButton rb_entree;
    private RadioButton rb_plat;
    private RadioButton rb_dessert;
    private Button b_ajouterAListe;

    private Button b_supprimerDeListe;

    private Spinner s_entrees;

    private Spinner s_plats;

    private Spinner s_desserts;

    private EditText i_elementSelectionne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrage);

        b_ajouterAListe = findViewById(R.id.b_ajouterAListe);
        i_nomElement = findViewById(R.id.i_nomElement);
        rb_entree = findViewById(R.id.rb_entree);
        rb_plat = findViewById(R.id.rb_plat);
        rb_dessert = findViewById(R.id.rb_dessert);
        b_supprimerDeListe = findViewById(R.id.b_supprimerDeListe);
        s_entrees = findViewById(R.id.s_entrees);
        s_plats = findViewById(R.id.s_plats);
        s_desserts = findViewById(R.id.s_desserts);
        i_elementSelectionne = findViewById(R.id.i_elementSelectionne);

        b_ajouterAListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ch = i_nomElement.getText().toString();
                String type = "";

                if (rb_entree.isChecked()) {
                    type = "Entree : ";
                    Log.d("Test", type + ch);
                } else if (rb_plat.isChecked()) {
                    type = "Plat : ";
                    Log.d("Test", type + ch);
                } else {
                    type = "Dessert : ";
                    Log.d("Test", type + ch);
                }
            }
        });

        b_supprimerDeListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code de supprimer
                if (s_entrees.getSelectedItem().toString().equals("Aucun") && s_plats.getSelectedItem().toString().equals("Aucun") && !s_desserts.getSelectedItem().toString().equals("Aucun") ) {
                    String msg = s_desserts.getSelectedItem().toString() + " a la position " + s_desserts.getSelectedItemPosition() + " de la liste de desserts";
                    Log.d("L'élément à supr est ",msg);
                }

                else if (s_plats.getSelectedItem().toString().equals("Aucun") && s_desserts.getSelectedItem().toString().equals("Aucun") && !s_entrees.getSelectedItem().toString().equals("Aucun")) {
                    String msg = s_entrees.getSelectedItem().toString() + " a la position " + + s_entrees.getSelectedItemPosition() + " de la liste d'entrées";
                    Log.d("L'élément à supr est ", msg);
                }

                else if (s_entrees.getSelectedItem().toString().equals("Aucun") && s_desserts.getSelectedItem().toString().equals("Aucun") && !s_plats.getSelectedItem().toString().equals("Aucun")) {
                    String msg = s_plats.getSelectedItem().toString() + " a la position " + s_plats.getSelectedItemPosition() + " de la liste de plats";
                    Log.d("L'élément à supr est ", msg);
                }

                else if (s_entrees.getSelectedItem().toString().equals("Aucun") && s_desserts.getSelectedItem().toString().equals("Aucun") && s_plats.getSelectedItem().toString().equals("Aucun")) {
                    Log.d("Information ", "Aucun élément sélectionné" );
                }
            }
        });

        s_entrees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!s_entrees.getSelectedItem().toString().equals("Aucun")) {
                    s_plats.setSelection(0);
                    s_desserts.setSelection(0);
                    i_elementSelectionne.setText(s_entrees.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        s_plats.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!s_plats.getSelectedItem().toString().equals("Aucun")) {
                    s_entrees.setSelection(0);
                    s_desserts.setSelection(0);
                    i_elementSelectionne.setText(s_plats.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        s_desserts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!s_desserts.getSelectedItem().toString().equals("Aucun")) {
                    s_entrees.setSelection(0);
                    s_plats.setSelection(0);
                    i_elementSelectionne.setText(s_desserts.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


    }
}