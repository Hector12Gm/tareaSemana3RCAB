package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView petListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///Agregar el toolbar
        Toolbar miAction=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miAction);
        ImageButton btn=(ImageButton)miAction.findViewById(R.id.imageBtnStar);
        ((TextView) findViewById(R.id.tvCountFav)).setText(Integer.toString(Datos.favs.size()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,pet_favs.class);
                startActivity(intent);
            }
        });

        ArrayList<Pet> mascotas=new ArrayList<Pet>();
        mascotas.add(new Pet("Mascota 1",3,R.drawable.a1));
        mascotas.add(new Pet("Mascota 2",1,R.drawable.a2));
        mascotas.add(new Pet("Mascota 3",5,R.drawable.a3));
        mascotas.add(new Pet("Mascota 4",12,R.drawable.a4));
        mascotas.add(new Pet("Mascota 5",12,R.drawable.a5));
        mascotas.add(new Pet("Mascota 6",12,R.drawable.a6));

        petListView=(RecyclerView) findViewById(R.id.petListView);
        LinearLayoutManager ll=new LinearLayoutManager(this);
       // GridLayoutManager gr=new GridLayoutManager(this,2);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        petListView.setLayoutManager(ll);
        Adaptador adaptador=new Adaptador(mascotas,this);
        petListView.setAdapter(adaptador);


    }


}