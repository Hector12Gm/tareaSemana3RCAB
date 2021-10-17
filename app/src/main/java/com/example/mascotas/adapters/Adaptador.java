package com.example.mascotas.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.pojo.Datos;
import com.example.mascotas.pojo.Pet;
import com.example.mascotas.R;

import java.util.ArrayList;


public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewAntigua> {


    private ArrayList<Pet> mascotas;
    private Activity main;
    private boolean like=true;
    public  Adaptador(ArrayList<Pet> mascotas, Activity main){
        this.mascotas=mascotas;
        this.main=main;
    }

    public  Adaptador(ArrayList<Pet> mascotas){
        this.mascotas=mascotas;

    }
    @NonNull
    @Override
    public ViewAntigua onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pet,parent,false);
        return  new ViewAntigua(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewAntigua holder, int position) {
        holder.nombrePet.setText( mascotas.get(position).getNombre());
        holder.likesPet.setText(Integer.toString( mascotas.get(position).getLikes()) );
        holder.imgPet.setImageResource(mascotas.get(position).getImg());
        if(like) {
            holder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mascotas.get(position).like();
                    holder.likesPet.setText(Integer.toString(mascotas.get(position).getLikes()));
                    Datos.favs.add(mascotas.get(position));
                    ((TextView) main.findViewById(R.id.tvCountFav)).setText(Integer.toString(Datos.favs.size()));

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.mascotas.size();
    }

    public static  class  ViewAntigua extends RecyclerView.ViewHolder{

        private final TextView nombrePet;
        private final  TextView likesPet;
        private final ImageButton imgBtnLike;
        private  final ImageView imgPet;

        public ViewAntigua(@NonNull View itemView) {
            super(itemView);
            nombrePet = (TextView) itemView.findViewById(R.id.tvPetnameP);
            likesPet = (TextView)  itemView.findViewById(R.id.tvLikesPetItemP);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.imgBtnBoneLike);
            imgPet = (ImageView) itemView.findViewById(R.id.imgPetP);

        }
    }
}
