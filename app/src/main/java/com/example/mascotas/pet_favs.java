package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class pet_favs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_favs);
        Toolbar toolbar=(Toolbar) this.findViewById(R.id.toolbarPetFav);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView petListView=(RecyclerView) findViewById(R.id.rcvFavs);
        LinearLayoutManager ll=new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        petListView.setLayoutManager(ll);
        Adaptador adaptador=new Adaptador(Datos.favs);
        petListView.setAdapter(adaptador);
    }
}