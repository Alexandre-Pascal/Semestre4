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


import java.util.ArrayList;

public class GestPlats extends AppCompatActivity {

    private Button b_suppr;

    private Button b_add;

    private EditText i_add;

    public static ArrayList<CheckBox> lstChk = new ArrayList<CheckBox>();

    private LinearLayout ll_listeCheckbox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gest_plats);

        b_suppr = findViewById(R.id.b_suppr);

        b_add = findViewById(R.id.b_add);

        //i_add = findViewById(R.id.i_add);


        ll_listeCheckbox = findViewById(R.id.ll_listeCheckbox);

        affPlats();

        b_suppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i = Modele.lesPlats.size() - 1; i > 0; i--){
                    if(lstChk.get(i).isChecked()){
                        Modele.lesPlats.remove(i);
                    }
                }
                affPlats();
            }
        });
    }

    public void affPlats(){
        ll_listeCheckbox.removeAllViews();
        lstChk.clear();
        for(int i=0;i<Modele.lesPlats.size();i++) {
            LinearLayout unlayout = new LinearLayout(GestPlats.this);
            unlayout.setOrientation(LinearLayout.HORIZONTAL);
            CheckBox unchk = new CheckBox(this);
            unchk.setText(Modele.lesPlats.get(i));
            lstChk.add(unchk);
            unlayout.addView(unchk);
            ll_listeCheckbox.addView(unlayout);
        }
    }


}
