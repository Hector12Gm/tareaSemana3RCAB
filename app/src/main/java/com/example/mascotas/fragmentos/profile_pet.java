package com.example.mascotas.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotas.R;
import com.example.mascotas.adapters.AdapatorProfile;
import com.example.mascotas.adapters.Adaptador;
import com.example.mascotas.pojo.Pet;

import java.util.ArrayList;


public class profile_pet extends Fragment {

    RecyclerView rcvProfile;

    public  profile_pet(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fra gment
        View v = inflater.inflate(R.layout.fragment_profile_pet, container, false);


        rcvProfile = ( RecyclerView ) v.findViewById(R.id.rcvProfile);

        ArrayList<Pet> mascotas=new ArrayList<Pet>();
        mascotas.add(new Pet("Mascota 1",3,R.drawable.a1));
        mascotas.add(new Pet("Mascota 2",1,R.drawable.a2));
        mascotas.add(new Pet("Mascota 3",5,R.drawable.a3));
        mascotas.add(new Pet("Mascota 4",12,R.drawable.a4));
        mascotas.add(new Pet("Mascota 5",12,R.drawable.a5));
        mascotas.add(new Pet("Mascota 6",12,R.drawable.a6));


        //LinearLayoutManager ll=new LinearLayoutManager(v.getContext());
        GridLayoutManager gr=new GridLayoutManager(v.getContext(),3);

        rcvProfile.setLayoutManager(gr);
        AdapatorProfile adaptador = new AdapatorProfile(mascotas);
        rcvProfile.setAdapter(adaptador);


        return v;
    }
}