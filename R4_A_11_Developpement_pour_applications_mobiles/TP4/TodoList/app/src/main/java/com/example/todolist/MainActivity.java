package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll_tache;
    private Button b_nouvelle_categorie;
    private Spinner s_categorie;
    private TextView et_tache;
    private Button b_ajouter_tache;
    private Button b_tachefaite;
    private CategorieDAO uneCategorieDAO;
    private TacheDAO uneTacheDAO;
    private ArrayList<Tache> lstTaches;
    private ArrayList<Categorie> lstCategories;
    private ArrayList<CheckBox> lstChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_tache = findViewById(R.id.ll_taches);
        s_categorie = findViewById(R.id.s_categorie);
        et_tache = findViewById(R.id.et_tache);
        b_ajouter_tache = findViewById(R.id.b_ajouter_tache);
        b_tachefaite = findViewById(R.id.b_tachefaite);
        lstChk = new ArrayList<CheckBox>();

        uneCategorieDAO = new CategorieDAO(this);
        Log.d("testLog",uneCategorieDAO.getCategories().toString());
        Log.d("testLog",uneCategorieDAO.getCategorie(1).toString());
        Log.d("testLog",uneCategorieDAO.getCategorie(2).toString());

        uneTacheDAO = new TacheDAO(this);
        Log.d("testLog",uneTacheDAO.getTaches().toString());
        Log.d("testLog",uneTacheDAO.getTache(1).toString());
        Log.d("testLog",uneTacheDAO.getTache(2).toString());
        Log.d("testLog",uneTacheDAO.getTache(3).toString());

        Log.d("testLog",uneTacheDAO.getTachesByCategorie("Culture").toString());
        lstTaches = uneTacheDAO.getTaches();
        affTaches();

        b_nouvelle_categorie = findViewById(R.id.b_nouvelle_categorie);
        b_nouvelle_categorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent(getApplicationContext(),NouvelleCategorieActivity.class);
                startActivity(unIntent);
            }
        });

        lstCategories = uneCategorieDAO.getCategories();
        ArrayAdapter<String> adapteurCategorie = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        for(int i=0;i<uneCategorieDAO.getCategories().size();i++){
            adapteurCategorie.add(lstCategories.get(i).getNomC());
        }
        s_categorie.setAdapter(adapteurCategorie);

        b_ajouter_tache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long idC;
                String libelleT;
                idC = lstCategories.get(s_categorie.getSelectedItemPosition()).getIdC();
                Log.d("testLog","Spinner : "+s_categorie.getSelectedItem());
                libelleT = et_tache.getText().toString();
                Tache nouvelleTache = new Tache(libelleT,idC);
                uneTacheDAO.addTache(nouvelleTache);
                //recharge lstTache
                lstTaches = uneTacheDAO.getTaches();
                affTaches();
                et_tache.setText("");
            }
        });

        b_tachefaite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                faireTache();
            }
        });
    }

    private void affTaches(){
        ll_tache.removeAllViews();
        lstChk.clear();
        for(int i=0;i<lstTaches.size();i++) {
            LinearLayout unlayout = new LinearLayout(MainActivity.this);
            unlayout.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox unchk = new CheckBox(this);
            unchk.setText(lstTaches.get(i).getLibelleT());
            lstChk.add(unchk);
            TextView unTextView = new TextView(this);
            unTextView.setText(uneCategorieDAO.getCategorie(lstTaches.get(i).getIdC()).getNomC());
            unTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            unTextView.setGravity(Gravity.RIGHT);
            unTextView.setPadding(20,0,20,0);
            unlayout.addView(unchk);
            unlayout.addView(unTextView);
            ll_tache.addView(unlayout);
        }
    }

    private void faireTache(){
        for(int i=lstChk.size()-1;i>=0;i--) {
            if(lstChk.get(i).isChecked()){
                Log.d("testLog",lstTaches.get(i).getLibelleT());
                uneTacheDAO.delTache(lstTaches.get(i));

            }
        }
        //recharge lstTache
        lstTaches = uneTacheDAO.getTaches();
        affTaches();
    }
}