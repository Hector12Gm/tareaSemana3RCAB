package com.example.mascotas.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotas.R;
import com.example.mascotas.adapters.Adaptador;
import com.example.mascotas.pojo.Pet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link feed_app#newInstance} factory method to
 * create an instance of this fragment.
 */
public class feed_app extends Fragment {


    private Activity activity;

    public  feed_app(Activity activity){
        this.activity = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feed_app, container, false);
        ArrayList<Pet> mascotas=new ArrayList<Pet>();
        mascotas.add(new Pet("Mascota 1",3,R.drawable.a1));
        mascotas.add(new Pet("Mascota 2",1,R.drawable.a2));
        mascotas.add(new Pet("Mascota 3",5,R.drawable.a3));
        mascotas.add(new Pet("Mascota 4",12,R.drawable.a4));
        mascotas.add(new Pet("Mascota 5",12,R.drawable.a5));
        mascotas.add(new Pet("Mascota 6",12,R.drawable.a6));

       RecyclerView petListView=(RecyclerView) v.findViewById(R.id.petListView);
        LinearLayoutManager ll=new LinearLayoutManager(v.getContext());
        // GridLayoutManager gr=new GridLayoutManager(this,2);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        petListView.setLayoutManager(ll);
        Adaptador adaptador=new Adaptador(mascotas,activity);
        petListView.setAdapter(adaptador);

        return v;
    }
}